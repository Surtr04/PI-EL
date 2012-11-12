grammar ficha3;

options{
	language=Java;
	k=1;
}

@header{
import java.util.HashMap;
import java.util.Map;
	
}

@members{
	class Artigos{
		public String codigo;
		public String designacao;
		public Double preco;
		public Double stock;
		public Artigos(String c, String d, Double p, Double s){this.codigo = c; this.designacao = d; this.preco = p; this.stock = s;}
	}
	
	private HashMap<String,ArrayList<Double>> _totais;
	private HashMap<String,Artigos> _artigos;
	private String _fct;
}

facturas
@init{this._totais = new HashMap<String, ArrayList<Double>>(); this._artigos = new HashMap<String,Artigos>();}
@after{
    int i;
    Double soma;
    for (Map.Entry<String, ArrayList<Double>> entry : this._totais.entrySet()) { 
    	System.out.println("Factura " + entry.getKey()); 
    	i = 0; 
    	soma = 0.0;
    	for(Double d : entry.getValue()){
    		i++;
    		soma += d;
    		System.out.println("\tLinha " + i + ": " + d.toString());
    	}
    	System.out.println("Total factura: " + soma);
    	System.out.println("----------------------");
    }
    System.out.println("");
    System.out.println("==============================");
    System.out.println("");
    for (Artigos a : this._artigos.values()){
    	System.out.println("Artigo " + a.codigo);
    	System.out.println("\tDesignacao: " + a.designacao);
    	System.out.println("\tPreço: " + a.preco);
    	System.out.println("\tStock: " + a.stock);
    	System.out.println("----------------------");
    }
}
	: descs+ '---' factura (';' factura)* '.'
	;

descs
	: 	codartigo designacao pvu stock {
		String c = $codartigo.text;
		String d = $designacao.text;
		Double p = Double.parseDouble($pvu.text);
		Double s = Double.parseDouble($stock.text);
		this._artigos.put(c, new Artigos(c, d, p, s));
		}
	;

factura
	:	cabec corpo
	;
	
cabec
	:	idfact {this._fct = $idfact.text; this._totais.put(this._fct, new ArrayList<Double>());} ide idr
	;
	
corpo
	:	linha+
	;
	
	
linha
	:	'(' codartigo ',' quantidade ')'  {
			Double qt = Double.parseDouble($quantidade.text);
			Artigos ag = this._artigos.get($codartigo.text);
			this._totais.get(this._fct).add(ag.preco * qt);
			ag.stock -= qt;
		}
	;
	
codartigo
	:	ID;

designacao
	:	STR;
	
pvu	:	FLOAT;

stock
	:	FLOAT;

quantidade
	:	FLOAT;

	
idfact
	:	numfact
	;
	
numfact
	:	ID
	;
	

ide	:	nome nif morada nib
	;
nome:	STR;
nif	:	STR;
morada
	:	STR;
nib	:	STR;	
idr	:	nome nif morada
	;
	

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT?
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;


WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STR
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
