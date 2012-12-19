grammar IMC;

imc	:	
	INITIAL_STATE a=state[""]+ FINAL_STATE b=state[""]+ TRANSITION_STATE transitions+;

transitions
	:	st=state[""] (action|markovian_trans)  transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st]+;

transition_def [boolean isM, boolean isA,String root_state]
	:	'*' a=state[root_state]  trans_prob_rate [isM,isA]?
	;

trans_prob_rate [boolean isM,boolean isA]
	:	(a=FLOAT|b=INT)
	{
		float r;
		if(b == null) { r = Float.parseFloat($a.text);} else { r = Float.parseFloat($b.text);}

		if(r != 0 && r != 1) {
			if (isA) 
				{		
					System.out.println("Warning (probabilistic transition): line -> " + $a.line  + " column -> " + $a.pos);
				}
			}
		}	
	;

state [String st] returns [String actual_st]
	:	st2=ID
	{
		$state.actual_st = $st2.text;
		if(st.equals(actual_st)) {
			System.out.println("Warning (markovian loop): line -> " + $st2.line  + " column -> " + $st2.pos);
		}
	}
	;
	
markovian_trans returns [boolean isMarkovian]
	:	'!' {$markovian_trans.isMarkovian = true;};
	
action returns [boolean isAction]
	:	ID {$action.isAction = true;};

INITIAL_STATE
	:	'#INITIALS';
	
FINAL_STATE
	:	'#GOALS';
	
TRANSITION_STATE
	:	'#TRANSITIONS';


ID  :	('#'|'a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'('|')')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
