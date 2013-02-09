grammar AV3;

@header{
	import java.lang.Math;
}

@members{
	private final int NORTE = 0;
	private final int SUL = 1;
	private final int ESTE = 2;
	private final int OESTE = 3;
	public static int MX;
	public static int MY;
	class MaxMin{
		public int max;
		public int min;
		public MaxMin(int a, int b){
			if (a > b) {this.max = a; this.min = b;}
			else {this.max = b; this.min = a;}
		}
	}
	class EstadoRobot{
		public int x;
		public int y;
		public int dir;
		public EstadoRobot(int a, int b, int c){
			this.x = this.parseVal(a, AV3Parser.MX);
			this.y = this.parseVal(b, AV3Parser.MY);
			this.dir=c;
		}
		public String toString(){return "(" + this.x + "," + this.y + ") - " + this.dir;}
		private int parseVal(int p, int max){
			if (p >= max)
				return max-1;
			else if (p < 0)
				return 0;

			return p;
		}
	}

	public ArrayList<ArrayList<Boolean>> startCampo(int largura, int altura){
		int i, j;
		ArrayList<ArrayList<Boolean>> ls = new ArrayList<ArrayList<Boolean>>();
		ArrayList<Boolean> aux;
		for(i = 0; i<altura; i++){
			aux = new ArrayList<Boolean>();
			for(j = 0; j<largura; j++)
				aux.add(false);
			ls.add(aux);
		}
		return ls;
	}
	public Boolean relocate(ArrayList<ArrayList<Boolean>> campo, ArrayList<EstadoRobot> caminho, int tam, int dir, Boolean ligado){
		EstadoRobot defs = caminho.get(0);
		EstadoRobot actual = caminho.get(caminho.size()-1);
		EstadoRobot novo;
		ArrayList<Boolean> linha;

		int vx = 0, vy = 0;
		MaxMin nx, ny;
		switch(dir){
			case NORTE: vy = -tam; break;
			case SUL: vy = tam; break;
			case ESTE: vx = tam; break;
			case OESTE: vx = -tam; break;
		}
		vx += actual.x;
		vy += actual.y;
		novo = new EstadoRobot(vx, vy, dir);
		
		System.out.println("Moving from ("+actual.x+","+actual.y+") to ("+novo.x+","+novo.y+")");
		if (ligado){
			System.out.println("On and cleaning!");
			nx = new MaxMin(actual.x, novo.x);
			ny = new MaxMin(actual.y, novo.y);
			for(int i = ny.min; i <= ny.max ; i++){
				linha = campo.get(i);
				for (int j = nx.min; j <= nx.max; j++)
					linha.set(j, true);
			}
		}
		caminho.add(novo);
		
		return (novo.x == vx && novo.y == vy);
	}
}

limpeza
	:	cabecalho ordens[$cabecalho.campo, $cabecalho.caminho]	
	{
		System.out.println("Field");
		System.out.println($cabecalho.campo.toString());
		System.out.println("Path");
		System.out.println($cabecalho.caminho.toString());
	}
	;

cabecalho returns [ArrayList<ArrayList<Boolean>> campo, ArrayList<EstadoRobot> caminho]
	:	
		{ int largura = 10; int altura = 10;
 		  int x = 0; int y = 0; int dir = this.SUL;}
		(tamanho {largura = $tamanho.largura; altura = $tamanho.altura;})?
		{$cabecalho.campo = this.startCampo(largura, altura);}
		(inicio {x = $inicio.x; y = $inicio.y; dir = $inicio.dir;})?
		{$cabecalho.caminho = new ArrayList<EstadoRobot>(); 
		AV3Parser.MX = largura; AV3Parser.MY = altura;
		$cabecalho.caminho.add(new EstadoRobot(x, y, dir));}
	;

ordens [ArrayList<ArrayList<Boolean>> in_campo, ArrayList<EstadoRobot> in_caminho] returns [Boolean ligado]
	:	{$ordens.ligado = false;} 'ORDENS{' a=ordem[$ordens.in_campo, $ordens.in_caminho, $ordens.ligado] (',' b=ordem[$ordens.in_campo, $ordens.in_caminho, $a.out_ligado] {a = b;})* '}' {$ordens.ligado = $a.out_ligado;}
	;

ordem [ArrayList<ArrayList<Boolean>> in_campo, ArrayList<EstadoRobot> in_caminho, Boolean in_ligado] returns [Boolean out_ligado]
	:	'(' INT ',' posicao ')' 
	{
		if (!this.relocate($ordem.in_campo, $ordem.in_caminho, Integer.parseInt($INT.text), $posicao.dir, $ordem.in_ligado)) System.out.println("Warning: Trying to move outside of field (line: "+ $INT.line + ", position: "+$INT.pos+")");
		$ordem.out_ligado = $ordem.in_ligado;
	}
	|	'LIGAR' {$ordem.out_ligado = true;}
	|	'DESLIGAR' {$ordem.out_ligado = false;}
	;

tamanho returns [int largura, int altura]
	:	'TAM{' a=INT 'x' b=INT '}' {$tamanho.largura = Integer.parseInt($a.text); $tamanho.altura = Integer.parseInt($b.text);}
	;
	
inicio returns [int x, int y, int dir]
	:	'INI{' a=INT ',' b=INT ',' c=posicao '}' {$inicio.y=Integer.parseInt($a.text); $inicio.y=Integer.parseInt($b.text); $inicio.dir = $c.dir;}
	;

posicao returns [int dir]
	:	'NORTE' {$posicao.dir = this.NORTE;}
	|	'SUL' {$posicao.dir = this.SUL;}
	|	'ESTE' {$posicao.dir = this.ESTE;}
	|	'OESTE' {$posicao.dir = this.OESTE;}
	;
	

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
