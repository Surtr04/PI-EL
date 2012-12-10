grammar CV_p1;

options{
	language=Java;
	k=1;
}


cv 	:	info form*
	;
	
info:	'@info {' name nationalities contacts birthdate gender natlang web '}'
	;
	
nationalities
	:	'Nationalities: [' STRING (',' STRING)? ']';
name
	:	'Name: ' STRING;

contacts
	:	'Contacts: [' contact (',' contact)* ']';
	

contact
	:	'Phone:' STRING
	|	'Fax:' STRING
	|	'Email:'ID'@'ID'.'ID;	
	
birthdate
	:	'Birthdate: ' data;
	
data:	INT '/' INT '/' INT;

gender
	:	'Gender: ' ('M' | 'F');

natlang
	:	'NativeLang: [' STRING (',' STRING)? ']';
	
web	:	'Web: ' ('http'|'https')'://'ID('.'ID)+;

form:	'@form {' begin end institutions degree result '}'
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
	:	'Country: ' STRING;

type:	'Type: ' COUNTRY;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;
    
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
