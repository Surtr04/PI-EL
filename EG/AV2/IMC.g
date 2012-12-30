grammar IMC;

options{
	language=Java;
}

@header{
	import java.util.HashSet;
	import imc.IMC;
}

@members{
	HashSet<String> states;
	int  elems = 0;
}

imc	
	@init{
		states = new HashSet<String>();
	}
	:	
	INITIAL_STATE a=state[""]+ FINAL_STATE b=state[""]+ TRANSITION_STATE transitions+;

transitions
	:	st=state[""] {
	
		if (!states.add($st.actual_st)) {
			System.out.println("ERROR (multiple definitions of state " + $st.actual_st + "): " + "line -> " + $st.line + " column -> " + $st.pos);
		}					
	}
	  (ac=action|mt=markovian_trans) {
	  	if(mt == false) {
		  	if($ac.action_value.equals("tau")) {
				System.out.println("Warning (source is unstable state): " + "line -> " + $st.line + " column -> " + $st.pos);
			}
		}
	  }
	   transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st]+;

transition_def [boolean isM, boolean isA,String root_state]
	:	'*' a=state[root_state]  trans_prob_rate [isM,isA]
	;

trans_prob_rate [boolean isM,boolean isA]
	:	(a=FLOAT|b=INT)
	{
		float r;
		if(b == null) { r = Float.parseFloat($a.text);} else { r = Float.parseFloat($b.text);}

		if (isA && (r != 0 && r != 1))		
			System.out.println("Warning (probabilistic transition): line -> " + $a.line  + " column -> " + $a.pos);
		
		if(isM && r == 0 && a == null) 
			System.out.println("ERROR (0 rate markovian transition ): line -> " + $b.line  + " column -> " + $b.pos); 
			
		if(isM && r == 0 && b == null) 
			System.out.println("ERROR (0 rate markovian transition ): line -> " + $a.line  + " column -> " + $a.pos); 				
		
		}																		
	;

state [String st] returns [String actual_st, int line, int pos]
	:	st2=ID
	{
		$state.actual_st = $st2.text;
		$state.line = $st2.line;
		$state.pos = $st2.pos;
						
		if(st.equals($state.actual_st)) {
			System.out.println("Warning (markovian loop): line -> " + $st2.line  + " column -> " + $st2.pos);
		}
	}
	;
	
markovian_trans returns [boolean isMarkovian]
	:	'!' {$markovian_trans.isMarkovian = true;};
	
action returns [boolean isAction, String action_value]
	:	a=ID {$action.isAction = true; $action.action_value = $a.text;};

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
