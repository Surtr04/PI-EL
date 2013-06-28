tree grammar CmbTG_CFG;

options{
	tokenVocab=Cmb;
	ASTLabelType = CommonTree;
}


@header{
	package language;
 
	import java.util.LinkedHashMap;
	import java.util.LinkedList;
	import java.util.HashSet;
	import graphs.*;
	import graphs.cfg.*;
	import parsing.*;
}

@members {
	public LinkedHashMap<String, CFG> cfgs;
	
	private void updateGraph(String ctx, Node n, String label, LinkedList<Node> srcs, LinkedList<Pair<String, String>> vars) {
		CFG cfg = this.cfgs.get(ctx);
		if(vars == null) {
			cfg.updateGraph(n, label, srcs, new LinkedList<Pair<String, String>>());
		}
		else {
			cfg.updateGraph(n, label, srcs, vars);
		}
		
	}
}


programa returns [LinkedHashMap<String, CFG> t]
@init{
	this.cfgs = new LinkedHashMap<String, CFG>();
}
	: 	^(PROGRAMA funcao[""]+ ) {$programa.t = this.cfgs;}
	;

funcao [String ctx]
	:  ^(FUNCAO cabecalho corpo_funcao[$cabecalho.ctx])
	;
	
cabecalho returns [String ctx]
	:  ^(CAEBECALHO tipo ID argumentos?
	{
		$cabecalho.ctx = $ID.text;
	}
	)
	;

argumentos
	:  ^(ARGUMENTOS declaracao+)
	;

corpo_funcao [String ctx] 
scope{
	String contexto;
}
@init{
	this.cfgs.put($corpo_funcao.ctx, new CFG());
	$corpo_funcao::contexto = $corpo_funcao.ctx;
}
	: ^(CORPO declaracoes statements[$corpo_funcao.ctx, new LinkedList<Node>(), ""]
	{
		this.cfgs.get($corpo_funcao.ctx).wrapCFG($statements.o_src, $statements.o_label);
	}
	) 
	;

declaracoes
	: ^(DECLARACOES declaracao+)
	;
	
declaracao
	:	^(DECLARACAO tipo ID)
	;
	
tipo
	:	TD_INT		
	|	TD_BOOL	
	|	TD_STRING
	|	TD_VAZIO
	;
	
statements[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label]
	:	 ^(STATEMENTS s1=statement[$statements.ctx, $statements.i_src, $statements.i_label ] 
	(s2=statement[$statements.ctx, $s1.o_src, $s1.o_label] 
	{
		s1 = s2;
	})*
	{
		$statements.o_src = $s1.o_src;
		$statements.o_label = $s1.o_label;
	}
	)
	;
	

statement[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label]
scope{
	HashSet<String> vars;
}
@init{
	$statement::vars = new HashSet<String>();
}
	:	atribuicao[$statement.ctx, $statement.i_src, $statement.i_label]	{$statement.o_src = $atribuicao.o_src; $statement.o_label = "";}
	|	read[$statement.ctx, $statement.i_src, $statement.i_label]		{$statement.o_src = $read.o_src; $statement.o_label = "";}
	|	write[$statement.ctx, $statement.i_src, $statement.i_label]		{$statement.o_src = $write.o_src; $statement.o_label = "";}
	|	ifs[$statement.ctx, $statement.i_src, $statement.i_label]		{$statement.o_src = $ifs.o_src; $statement.o_label = "";}
	|	whiles[$statement.ctx, $statement.i_src, $statement.i_label]		{$statement.o_src = $whiles.o_src; $statement.o_label = $whiles.o_label;}
	|	invocacao[$statement.ctx, $statement.i_src, $statement.i_label, true]	{$statement.o_src = $invocacao.o_src; $statement.o_label = "";}
	|	retorna[$statement.ctx, $statement.i_src, $statement.i_label]		{$statement.o_src = $retorna.o_src; $statement.o_label = "";}
	;
	
	
	
retorna [String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
	:  ^(RETURN expr
	{
		Node n  = new Node("return " + $expr.str, TipoNode.RETURN);
		this.updateGraph($retorna.ctx, n, $retorna.label, $retorna.i_src, null);
		this.cfgs.get($retorna.ctx).addRefs(n, $statement::vars);
		$retorna.o_src = new LinkedList<Node>();
		$retorna.o_src.add(n);
	}
	)
	;



invocacao [String ctx, LinkedList<Node> i_src, String label, boolean create] returns [LinkedList<Node> o_src, String str]
	:  ^(INVOCACAO ID args[$invocacao.ctx]? 
	{
		String inv_text = $ID.text + "( " + ($args.str == null ? "" : $args.str) + " )" ;
		if(create) {
			Node n  = new Node(inv_text, TipoNode.INVOCACAO);
			this.updateGraph($invocacao.ctx, n, $invocacao.label, $invocacao.i_src, null);
			this.cfgs.get($invocacao.ctx).addRefs(n, $statement::vars);
			$invocacao.o_src = new LinkedList<Node>();
			$invocacao.o_src.add(n);
		}	
		$invocacao.str = inv_text;
		
	}
	)
	;

args[String ctx] returns [String str]
@init{
	String text = "";
}
	:  ^(ARGS (expr
	{
		text += $expr.str + ", ";	
	}
	)+
	{
		$args.str = text.substring(0,text.length()-2);
	}
	)
	;

atribuicao[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
	:	 ^('=' ID expr
	{
		
		Node n = new Node($ID.text + " = " + $expr.str, TipoNode.ATRIBUICAO);
		this.updateGraph($atribuicao.ctx, n, $atribuicao.label, $atribuicao.i_src, null);
		this.cfgs.get($atribuicao.ctx).addRefs(n, $statement::vars);
		this.cfgs.get($atribuicao.ctx).addDef(n, $ID.text);
		$atribuicao.o_src = new LinkedList<Node>();
		$atribuicao.o_src.add(n);
	}
	)
	;

write[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
	: ^(WRITE expr
	{
		Node n  = new Node("write(" + $expr.str +")", TipoNode.WRITE);
		this.updateGraph($write.ctx, n, $write.label, $write.i_src, null);
		this.cfgs.get($write.ctx).addRefs(n, $statement::vars);
		$write.o_src = new LinkedList<Node>();
		$write.o_src.add(n);
	}
	)
	;
	
read[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
	: ^(READ ID
	{
		
		Node n  = new Node("read(" + $ID.text +")", TipoNode.READ);
		this.updateGraph($read.ctx, n, $read.label, $read.i_src, null);
		this.cfgs.get($read.ctx).addDef(n, $ID.text);
		$read.o_src = new LinkedList<Node>();
		$read.o_src.add(n);
	}
	)
	;
	
	
ifs[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
@init{
	LinkedList<Node> srcs = new LinkedList<Node>();
}
	:	^(IF expr
	{
		Node n = new Node($expr.str, TipoNode.IF, "if (" + $expr.str + ")");
		this.updateGraph($ifs.ctx, n, $ifs.label, $ifs.i_src, null);
		this.cfgs.get($ifs.ctx).addRefs(n, $statement::vars);
		LinkedList<Node> l_src = new LinkedList<Node>();
		l_src.add(n);
	}
	b1=bloco[$ifs.ctx, l_src, "true"] (b2=bloco[$ifs.ctx, l_src, "false"]
	{
		srcs.addAll($b2.o_src);
	}
	)?
	{
		srcs.addAll($b1.o_src);
		if($b2.o_src == null){
			srcs.add(n);
		}
		for(Node no : srcs)
			no.setIfEnds(true);
		$ifs.o_src = srcs;
	}
	)
	;
	
whiles[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label]
	:	^(WHILE expr
	{
		Node n = new Node($expr.str, TipoNode.WHILE, "while (" + $expr.str + ")");
		this.updateGraph($whiles.ctx, n, $whiles.i_label, $whiles.i_src, null);
		this.cfgs.get($whiles.ctx).addRefs(n, $statement::vars);
		LinkedList<Node> l_src = new LinkedList<Node>();
		l_src.add(n);
	} 
	bloco[$whiles.ctx, l_src, "true"]
	{
		this.updateGraph($whiles.ctx, n, "", $bloco.o_src, null);
		/*for(Node no : l_src)
			no.setIfEnds(true);*/
		$whiles.o_src = l_src;
		$whiles.o_label = "false";
	}
	)
	;



bloco[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src]
	:	statements[$bloco.ctx, $bloco.i_src, $bloco.label]
	{
		$bloco.o_src = $statements.o_src;
	}
	;
	
	
	
expr returns [String str]
	:	^('||' e1=expr e2=expr {$expr.str = $e1.str + " || " + $e2.str ; })
	|	^('&&' e1=expr e2=expr {$expr.str = $e1.str + " && " + $e2.str ; })
	|	^('+' e1=expr e2=expr {$expr.str = $e1.str + " + " + $e2.str ; })
	|	^('-' e1=expr e2=expr {$expr.str = $e1.str + " - " + $e2.str ; })
	|	^('*' e1=expr e2=expr {$expr.str = $e1.str + " * " + $e2.str ; })
	|	^('/' e1=expr e2=expr {$expr.str = $e1.str + " / " + $e2.str ; })
	|	^('%' e1=expr e2=expr {$expr.str = $e1.str + " mod " + $e2.str ; })
	|	^('>' e1=expr e2=expr {$expr.str = $e1.str + " > " + $e2.str ; })
	|	^('<' e1=expr e2=expr {$expr.str = $e1.str + " < " + $e2.str ; })
	|	^('>=' e1=expr e2=expr {$expr.str = $e1.str + " >= " + $e2.str ; })
	| 	^('<=' e1=expr e2=expr {$expr.str = $e1.str + " <= " + $e2.str ; })
	|	^('==' e1=expr e2=expr {$expr.str = $e1.str + " == " + $e2.str ; })
	|	^('!=' e1=expr e2=expr {$expr.str = $e1.str + " != " + $e2.str ; })
	|	^('!' e1=expr {$expr.str = "! " + $e1.str ;} )
	|	factor {$expr.str = $factor.str ;}
	;
	
factor returns [String str]
	:	ID {$factor.str = $ID.text; $statement::vars.add($ID.text); }
	| constante {$factor.str = $factor.str = $constante.str; }
	| invocacao["", null, "", false] {$factor.str = $invocacao.str ; }
	;
	
constante returns [String str]
	:	STRING {$constante.str = $STRING.text.replaceAll("\"", "\\\""); }
	|	INT {$constante.str = $INT.text; }
	|	TRUE {$constante.str = $TRUE.text; }
	|	FALSE {$constante.str = $FALSE.text; }
	;
	