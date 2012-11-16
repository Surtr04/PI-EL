grammar ficha5;

options{
	k=2;
}

biblioteca 
	:	registos
	;
	
registos 
	:	registo (',' registo)*
	;

registo
	:	'[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']'
	;
	
descricao
	:	referencia tipo titulo '(' autores ')' editora ano catalogo
	;
	
autores
	:	autor (',' autor)*
	;
	
referencia
	:	ID
	;
	
tipo:	'LIVRO'
	|	'CDROM'
	|	'OUTRO'
	;

titulo
	:	STRING
	;

autor
	:	STRING
	;

editora
	:	STRING
	;
	
ano	: 	INT
	;
catalogo
	:	'BGUM'
	|	'ALFA'
	|	'OUTRO'
	;

existencias
	:	'LOCAL ' local '(' estados ')'
	;
	
local
	:	STRING
	;
	
estados
	:	estado (',' estado)*
	;

estado
	:	codigoBarras disponib
	;
	
codigoBarras
	:	ID
	;
disponib
	:	'ESTANTE'
	|	'PERMANENTE'
	|	'EMPRESTADO' dataDev
	;
	
dataDev
	:	ano '-' mes '-' dia
	;
mes	:	INT;
dia	:	INT;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
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
