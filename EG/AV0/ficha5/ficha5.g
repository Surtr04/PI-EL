grammar ficha5;

options{
	k=2;
	language=Java;
}

@header{
	import java.util.TreeSet;
}

@members{
	int numRegistos = 0;
	int numLivros = 0;
	String refReg = null;
	
	int reservados = 0;
	int permanentes = 0;
	int estante = 0;
	
	Boolean isBook = false;
	
	TreeSet<String> bookNames = new TreeSet<String>();
	TreeSet<String> refs = new TreeSet<String>();
}

biblioteca 
@after{
System.out.println ("Livros Reservados: " + reservados);
System.out.println ("Livros Permanentes: " + permanentes);
System.out.println ("Livros em Estante: " + estante);

System.out.println("=== Livros ===");
for (String s : bookNames) {
	System.out.println(s);
}

}
	:	registos
	;
	
registos 
	:	registo{numRegistos++;} (',' registo{numRegistos++;})*
	;

registo
@after {
	System.out.println(refReg + ": " + numLivros);
	numLivros = 0;
	refReg = null;
}
	:	'[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']'
	;
	
descricao
	:	referencia {refReg = $referencia.text; if(!refs.add($referencia.text)){System.out.println("Referencia ja existente: " + $referencia.text);} } tipo titulo {if(isBook) {bookNames.add($titulo.text);isBook = false;}} '(' autores ')' editora ano catalogo
	;
	
autores
	:	autor (',' autor)*
	;
	
referencia
	:	ID
	;
	
tipo:	'LIVRO' {numLivros++; isBook = true;}
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
	:	'ESTANTE' {estante++;}
	|	'PERMANENTE'{permanentes++;}
	|	'EMPRESTADO' {reservados++;}dataDev
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
