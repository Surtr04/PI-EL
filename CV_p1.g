grammar CV_p1;

options{
	language=Java;
	k=1;
}


cv 	:	info form*
	;
	
info:	'@info {' name email nationalitys contacts birthdate gender nativel web '}'
	;
	
nationalitys
	:	'Nationalitys: [' STRING (',' STRING)? ']';
name
	:	'Name: ' STRING;
email
	:	'Email: ' STRING;
contacts
	:	'Contacts: [' STRING (',' STRING)* ']';
birthdate
	:	'Birthdate: ' data;
	
data:	INT '/' INT '/' INT;

gender
	:	'Gender: ' ('M' | 'F');

nativel
	:	'NativeLang: [' STRING (',' STRING)? ']';
	
web	:	'Web: ' STRING;

form:	'@form {' begin end institutions title result '}'
	;
	
begin
	:	'Begin: ' data;
	
end	:	'End: ' data;

title
	:	'Title: ' STRING;
	
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
	:	'Country: ' STRING;

type:	'Type: ' STRING;
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

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
