grammar CV_p1;

options{
	language=Java;
	k=1;
}


cv 	:	info form*
	;
	
info returns [String valor]
	: '@info {' name nationalities contacts birthdate gender natlang web '}'
	{
		$info.valor= '{info:{"name":' + $name.valor + 
					 ',"nationalities":' + $nationalities.valor + 
					 ',"contacts":' + $contacts.valor +  
 					 ',"birthdate":' + $birthdate.valor +  
 					 ',"gender":' + $gender.valor + 
 					 ',"natlang":' + $natlang.valor + 
 					 ',"web":' + $web.valor + 
					 + '}}'
	}
	;
	
nationalities returns [String valor]
	:	'Nationalities: [' a=STRING {$nationalities.valor='['+a.text;} (',' b=STRING {$nationalities.valor+=','+b.text;})? ']' {$nationalities.valor+=']';}
	;
name returns [String valor]
	:	'Name: ' STRING
	{$name.valor=$STRING.text; }
	;

contacts returns [String valor]
	:	'PersonalContacts: [' a=contact{$contacts.valor='{"'+a.tipo+'":'+a.valor;} (',' b=contact{$contacts.valor+=',"'+a.tipo+'":'+a.valor})* ']';
	

contact returns [String tipo, String valor]
	:	'Phone:' STRING {$contact.tipo='p'; $contact.valor=$STRING.text;}
	|	'Fax:' STRING {$contact.tipo='f'; $contact.valor=$STRING.text;}
	|	'Email:'ID'@'ID'.'ID {$contact.tipo='e'; $contact.valor=$ID.text + "@" + $ID.text + "." + $ID.text;}
	;	
	
birthdate returns [String valor]
	:	'Birthdate: ' data {$birthdate.valor = $data.valor}
	;
	
data returns [String valor]
	:	d=INT '/' m=INT '/' y=INT {$data.valor = d.text+"/"+m.text+"/"+y.text;}
	;

gender returns [String valor]
	:	'Gender: ' ('M' {$gender.valor='m';} | 'F'{$gender.valor='f';})
	;

natlang returns [String valor]
	:	'NativeLang: [' a=STRING {$natlang.valor='['+a.text;} (',' b=STRING {$natlang.valor+=','+b.text;})? ']' {$natlang.valor+=']';}
	;
	
web	returns [String valor]
	:	'Web: http' {$web.valor='http';} ('s' {$web.valor+='s';})? '://' a=ID{$web.valor+='://'+a.text;} ('.'b=ID{$web.valor+='.'+b.text;})+;

form returns [String valor]
	:	'@form {' begin end institutions degree result '}'
	;
	
begin
	:	'Begin: ' data;
	
end	:	'End: ' data;

degree
	:	'Degree: ' degreeType STRING;

degreeType
	:	('BSc'|'MSc'|'Phd');	
	
result
	:	'Result: ' (INT|STRING);

institutions
	:	'[' institution (',' institution)* ']'
	|	institution;
	
institution
	:	name address country type;
	
address
	:	'Address: ' STRING;

country
	:	'Country: ' COUNTRY;

type:	'Type: ' STRING;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;
   
fragment
COUNTRY
	:	(('A'..'Z')('a'..'z')*)+;

INT :	'0'..'9'+
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
