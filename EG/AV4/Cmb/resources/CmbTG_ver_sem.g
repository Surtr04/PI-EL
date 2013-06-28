tree grammar CmbTG_ver_sem;


options{
	tokenVocab=Cmb;
	ASTLabelType = CommonTree;
}

@header {
	package language;
	import parsing.*;
}


@members {
	private Tabela global_ids;
	private ArrayList<String> errors = new ArrayList<String>();
	
	public Tabela getGlobal_ids(){
		return global_ids;
	}
	
	@Override
	public void emitErrorMessage(String msg) {
		this.errors.add(msg);
	}
	
	public ArrayList<String> getErrors(){
		return this.errors;
	}
}


programa [Tabela ids]
@init{
	this.global_ids = $programa.ids;
}	
	:  ^(PROGRAMA funcao+ )
	;

funcao
	:  ^(FUNCAO cabecalho corpo_funcao[$cabecalho.nome])
	;
	
cabecalho returns [String nome]
	:  ^(CAEBECALHO tipo ID argumentos[$ID.text]?
	{
		$cabecalho.nome = $ID.text;
	}
	)
	;

argumentos [String ctx]
	:  ^(ARGUMENTOS declaracao[$argumentos.ctx]+)
	;

corpo_funcao [String ctx]
	: ^(CORPO declaracoes[$corpo_funcao.ctx] statements[$corpo_funcao.ctx])
	;

declaracoes [String ctx]
	: ^(DECLARACOES declaracao[$declaracoes.ctx]+)
	;
	
	
declaracao [String ctx]
	: ^(DECLARACAO tipo ID
	{
		if(! this.global_ids.contains(new Pair<String, String>($ID.text, $declaracao.ctx), $ID.line, $ID.pos)){
			emitErrorMessage("ERROR");
		}	
	}
	)
	;
	
tipo
	:	TD_INT		
	|	TD_BOOL	
	|	TD_STRING
	|	TD_VAZIO
	;
	
statements [String ctx]
	: ^(STATEMENTS statement[$statements.ctx]+)
	;
	

statement [String ctx]
	:	atribuicao [$statement.ctx]
	|	read
	|	write [$statement.ctx]
	|	ifs [$statement.ctx]
	|	whiles [$statement.ctx]
	|	invocacao [$statement.ctx]
	|	retorna [$statement.ctx]
	;
	
retorna [String ctx]
	:  ^(RETURN expr[$retorna.ctx])
	;

invocacao [String ctx] returns [String tipo]
	:  ^(INVOCACAO ID args[$invocacao.ctx]?
	{
		Pair<String, String> p = new Pair<String, String>($ID.text, "");
		if(global_ids.contains(p)){
			$invocacao.tipo = global_ids.getType(p);	
		}
	}
	) // -> tabela
	;

args [String ctx]
	:  ^(ARGS expr[$args.ctx]+)
	;

atribuicao [String ctx]
	: ^('=' ID expr[$atribuicao.ctx]
	{
		Pair<String, String> p = new Pair<String, String>($ID.text, $atribuicao.ctx) ;
		if(global_ids.contains(p)){
			String tipo_var = global_ids.getType(p);
			if(! tipo_var.equals($expr.tipo))  {
				emitErrorMessage("Error " + $ID.line + ":" + $ID.pos + " Expecting " + 
							tipo_var + ", found " + $expr.tipo ) ;
			}
		}
		else {
			emitErrorMessage("Error " + $ID.line + ":" + $ID.pos + " Variable " 
						+ $ID.text + "not in scope!") ;
		}
	}
	)
	;

write [String ctx]
	: ^(WRITE expr[$write.ctx])
	;
	
read
	: ^(READ ID)
	;
	
	
ifs [String ctx]
	: ^(IF expr[$ifs.ctx] bloco[$ifs.ctx] (bloco[$ifs.ctx])?)
	;
	
whiles [String ctx]
	: ^(WHILE expr[$whiles.ctx] bloco[$whiles.ctx])
	;

bloco [String ctx]
	:	statements[$bloco.ctx]
//		|	^(STATEMENTS statement)
	;
	
expr [String ctx] returns [String tipo]
@init {
	String _ctx = $expr.ctx;
}
	: ^('||' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) // bool bool -> bool
	| ^('&&' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) // bool bool -> bool
	| ^('==' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) // todos\void todos\void -> bool
	| ^('-' e1=expr[_ctx] e2=expr[_ctx]  {$expr.tipo = "int" ;})  //int int -> int
	| ^('+' e1=expr[_ctx] e2=expr[_ctx]
	{
		if($e1.tipo.equals("int") && $e2.tipo.equals("int")) {
			$expr.tipo = $e1.tipo;		
		}
		else {
			$expr.tipo = "string" ;
		}
	}
	)  //int int | string string |  -> int | string
	| ^('*' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "int" ;})  //int int -> int
	| ^('/' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "int" ;})  //int int -> int
	| ^('%' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "int" ;})  //int int -> int
	| ^('>' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;})  //int int -> bool
	| ^('<' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;})  //int int -> bool
	| ^('<=' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) //int int -> bool
	| ^('>=' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) //int int .> bool
	| ^('!=' e1=expr[_ctx] e2=expr[_ctx] {$expr.tipo = "bool" ;}) //todos\void todos\void -> bool
	| ^('!' e1=expr[_ctx]
	{
		if($e1.tipo.equals("bool")){
			$expr.tipo = $e1.tipo;
		}
		else {
			$expr.tipo = "void" ;
			emitErrorMessage("Error: L:C Expecting bool, found " + $e1.tipo); 
		}
	}
	)	    //bool -> bool
	| factor[_ctx] {$expr.tipo = $factor.tipo; } // -> todos
	;

factor [String ctx] returns [String tipo]
	:	ID  
	{
		Pair p = new Pair<String, String>($ID.text, $factor.ctx);
		if(global_ids.contains(p)){
			$factor.tipo = global_ids.getType(p);
		}
		else {
			$factor.tipo = "void" ;
		}
	
	} // -> tabela
	| constante {$factor.tipo = $constante.tipo; }// -> todos
	| invocacao[$factor.ctx] { $factor.tipo = $invocacao.tipo; }//
	;
	
constante returns [String tipo]
	:	STRING 	{$constante.tipo = "string"; }// -> string
	|	INT	{$constante.tipo = "int"; } // -> int
	|	TRUE	{$constante.tipo = "bool"; }// -> bool
	|	FALSE	{$constante.tipo = "bool"; }// -> bool
	;
