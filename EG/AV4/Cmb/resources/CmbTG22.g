tree grammar CmbTG22;


options{
	tokenVocab=Cmb;
	ASTLabelType = CommonTree;
}


@header {
	package language;
	
	import parsing.*;
}



@members {
	private Tabela ids = new Tabela();
	
	/*public Tabela getTabela() {
		return this.ids;
	}*/
	
}



programa returns [Tabela tab]	
	:  ^(PROGRAMA funcao[""]+
	
	{
		$programa.tab = this.ids;
	}
	)
	;

funcao [String contexto] 
	:  ^(FUNCAO cabecalho[$funcao.contexto] corpo_funcao[$cabecalho.o_contexto])
	;
	
cabecalho [String i_contexto] returns [String o_contexto]
	:  ^(CAEBECALHO tipo ID 
	{
		Simbolo s = new Simbolo();
		s.setId($ID.text);
		s.setTipo($tipo.nome);
		if(s.getTipo().equals("void")){
			s.setClasse("PROC");
		}
		else {
			s.setClasse("FUNC");
		}
		s.setTamanho(ids.getSimbolos().get(new Pair<String, String>($tipo.nome, "")).getTamanho());
		s.setLinha($ID.line);
		s.setColuna($ID.pos);
		//s.setEndMCode();
		
	} 
	(arg=argumentos[$ID.text] 
	{
		s.setParams($arg.lista_args);
	}
	)?
	
	{
		ids.addSimbolo($cabecalho.i_contexto, s);
		$cabecalho.o_contexto = $ID.text;
	}
	)
	;

argumentos[String scope] returns [ArrayList<String> lista_args]
@init{
	ArrayList<String> args = new ArrayList<String>();
}	
	:  ^(ARGUMENTOS (declaracao[$argumentos.scope, true]
	{
		args.add($declaracao.idvar);
	}
	)+ 
	{
		$argumentos.lista_args = args;
	}
	)
	;
	
	

corpo_funcao [String contexto]
	: ^(CORPO declaracoes[$corpo_funcao.contexto] statements)
	;

declaracoes [String contexto]
	: ^(DECLARACOES declaracao[$declaracoes.contexto, false]+)
	;
	
declaracao [String scope, boolean is_argumento] returns [String idvar]
	: ^(DECLARACAO tipo ID
	{
		Simbolo s = new Simbolo();
		s.setId($ID.text);
		s.setTipo($tipo.nome);
		if($declaracao.is_argumento){
			s.setClasse("PARAM");
		}
		else {
			s.setClasse("VAR");
		}
		s.setTamanho(ids.getSimbolos().get(new Pair<String, String>($tipo.nome, "")).getTamanho());
		s.setLinha($ID.line);
		s.setColuna($ID.pos);
		
		ids.addSimbolo($declaracao.scope, s);
		
		$declaracao.idvar = $ID.text;
	}
	)
	
	;
	
tipo returns [String nome]
	:	TD_INT		{$tipo.nome = "int" ;} 	
	|	TD_BOOL	 	{$tipo.nome = "bool" ;} 	
	|	TD_STRING	{$tipo.nome = "string" ;} 	
	|	TD_VAZIO	{$tipo.nome = "void" ;} 	
	;
	
statements
	: ^(STATEMENTS statement+)
	;
	

statement
	:	 atribuicao
	|	 read
	|	write 
	|	ifs 
	|	whiles 
	|	invocacao 
	|	retorna 
	;
	
retorna
	:  ^(RETURN expr)
	;

invocacao
	:  ^(INVOCACAO ID args?)
	;

args
	:  ^(ARGS expr+)
	;

atribuicao
	: ^('=' ID expr)
	;

write
	: ^(WRITE expr)
	;
	
read
	: ^(READ ID)
	;
	
	
ifs
	: ^(IF expr bloco (bloco)?)
	;
	
whiles
	: ^(WHILE expr bloco)
	;

bloco
	:	statements
//		|	^(STATEMENTS statement)
	;
	
expr
	: ^('||' expr expr)
	| ^('&&' expr expr)
	| ^('==' expr expr)
	| ^('-' expr expr) 
	| ^('+' expr expr)
	| ^('*' expr expr)
	| ^('/' expr expr) 
	| ^('%' expr expr)
	| ^('>' expr expr)
	| ^('<' expr expr)
	| ^('<=' expr expr)
	| ^('>=' expr expr)
	| ^('!=' expr expr)
	| ^('!' expr)
	| factor
	;

factor
	:	ID 
	| constante
	| invocacao
	;
	
constante
	:	STRING
	|	INT
	|	TRUE
	|	FALSE
	;
