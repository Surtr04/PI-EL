// $ANTLR 3.4 C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g 2013-06-27 21:38:29

	package language;
 
	import java.util.LinkedHashMap;
	import java.util.LinkedList;
	import java.util.HashSet;
	import graphs.*;
	import graphs.cfg.*;
	import parsing.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CmbTG_CFG extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMA", "DECLARACOES", "DECLARACAO", "STATEMENTS", "ATRIBUICAO", "THEN", "CORPO", "FUNCAO", "CAEBECALHO", "ARGUMENTOS", "INVOCACAO", "ARGS", "RETURN", "ID", "TD_INT", "TD_BOOL", "TD_STRING", "TD_VAZIO", "WRITE", "READ", "IF", "ELSE", "WHILE", "STRING", "INT", "TRUE", "FALSE", "COMMENT", "WS", "ESC_SEQ", "CHAR", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'{'", "'}'", "'('", "')'", "','", "';'", "'='", "'-'", "'+'", "'*'", "'/'", "'%'", "'||'", "'&&'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'!'"
    };

    public static final int EOF=-1;
    public static final int WHILE=26;
    public static final int OCTAL_ESC=37;
    public static final int CHAR=34;
    public static final int ID=17;
    public static final int IF=24;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int ESC_SEQ=33;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int THEN=9;
    public static final int T__53=53;
    public static final int DECLARACOES=5;
    public static final int T__54=54;
    public static final int ARGUMENTOS=13;
    public static final int RETURN=16;
    public static final int ARGS=15;
    public static final int COMMENT=31;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int INVOCACAO=14;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int FUNCAO=11;
    public static final int UNICODE_ESC=36;
    public static final int ELSE=25;
    public static final int HEX_DIGIT=35;
    public static final int CAEBECALHO=12;
    public static final int INT=28;
    public static final int TD_STRING=20;
    public static final int TRUE=29;
    public static final int TD_VAZIO=21;
    public static final int WRITE=22;
    public static final int WS=32;
    public static final int DECLARACAO=6;
    public static final int ATRIBUICAO=8;
    public static final int CORPO=10;
    public static final int TD_INT=18;
    public static final int READ=23;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int PROGRAMA=4;
    public static final int STATEMENTS=7;
    public static final int FALSE=30;
    public static final int STRING=27;
    public static final int TD_BOOL=19;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public CmbTG_CFG(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public CmbTG_CFG(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CmbTG_CFG.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g"; }


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



    // $ANTLR start "programa"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:36:1: programa returns [LinkedHashMap<String, CFG> t] : ^( PROGRAMA ( funcao[\"\"] )+ ) ;
    public final LinkedHashMap<String, CFG> programa() throws RecognitionException {
        LinkedHashMap<String, CFG> t = null;



        	this.cfgs = new LinkedHashMap<String, CFG>();

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:40:2: ( ^( PROGRAMA ( funcao[\"\"] )+ ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:40:5: ^( PROGRAMA ( funcao[\"\"] )+ )
            {
            match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa55); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:40:16: ( funcao[\"\"] )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCAO) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:40:16: funcao[\"\"]
            	    {
            	    pushFollow(FOLLOW_funcao_in_programa57);
            	    funcao("");

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input, Token.UP, null); 


            t = this.cfgs;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return t;
    }
    // $ANTLR end "programa"



    // $ANTLR start "funcao"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:43:1: funcao[String ctx] : ^( FUNCAO cabecalho corpo_funcao[$cabecalho.ctx] ) ;
    public final void funcao(String ctx) throws RecognitionException {
        String cabecalho1 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:44:2: ( ^( FUNCAO cabecalho corpo_funcao[$cabecalho.ctx] ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:44:5: ^( FUNCAO cabecalho corpo_funcao[$cabecalho.ctx] )
            {
            match(input,FUNCAO,FOLLOW_FUNCAO_in_funcao78); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_cabecalho_in_funcao80);
            cabecalho1=cabecalho();

            state._fsp--;


            pushFollow(FOLLOW_corpo_funcao_in_funcao82);
            corpo_funcao(cabecalho1);

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "funcao"



    // $ANTLR start "cabecalho"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:47:1: cabecalho returns [String ctx] : ^( CAEBECALHO tipo ID ( argumentos )? ) ;
    public final String cabecalho() throws RecognitionException {
        String ctx = null;


        CommonTree ID2=null;

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:48:2: ( ^( CAEBECALHO tipo ID ( argumentos )? ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:48:5: ^( CAEBECALHO tipo ID ( argumentos )? )
            {
            match(input,CAEBECALHO,FOLLOW_CAEBECALHO_in_cabecalho102); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_cabecalho104);
            tipo();

            state._fsp--;


            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_cabecalho106); 

            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:48:26: ( argumentos )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARGUMENTOS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:48:26: argumentos
                    {
                    pushFollow(FOLLOW_argumentos_in_cabecalho108);
                    argumentos();

                    state._fsp--;


                    }
                    break;

            }



            		ctx = (ID2!=null?ID2.getText():null);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ctx;
    }
    // $ANTLR end "cabecalho"



    // $ANTLR start "argumentos"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:55:1: argumentos : ^( ARGUMENTOS ( declaracao )+ ) ;
    public final void argumentos() throws RecognitionException {
        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:56:2: ( ^( ARGUMENTOS ( declaracao )+ ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:56:5: ^( ARGUMENTOS ( declaracao )+ )
            {
            match(input,ARGUMENTOS,FOLLOW_ARGUMENTOS_in_argumentos128); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:56:18: ( declaracao )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DECLARACAO) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:56:18: declaracao
            	    {
            	    pushFollow(FOLLOW_declaracao_in_argumentos130);
            	    declaracao();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "argumentos"


    protected static class corpo_funcao_scope {
        String contexto;
    }
    protected Stack corpo_funcao_stack = new Stack();



    // $ANTLR start "corpo_funcao"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:59:1: corpo_funcao[String ctx] : ^( CORPO declaracoes statements[$corpo_funcao.ctx, new LinkedList<Node>(), \"\"] ) ;
    public final void corpo_funcao(String ctx) throws RecognitionException {
        corpo_funcao_stack.push(new corpo_funcao_scope());
        CmbTG_CFG.statements_return statements3 =null;



        	this.cfgs.put(ctx, new CFG());
        	((corpo_funcao_scope)corpo_funcao_stack.peek()).contexto = ctx;

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:67:2: ( ^( CORPO declaracoes statements[$corpo_funcao.ctx, new LinkedList<Node>(), \"\"] ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:67:4: ^( CORPO declaracoes statements[$corpo_funcao.ctx, new LinkedList<Node>(), \"\"] )
            {
            match(input,CORPO,FOLLOW_CORPO_in_corpo_funcao154); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_declaracoes_in_corpo_funcao156);
            declaracoes();

            state._fsp--;


            pushFollow(FOLLOW_statements_in_corpo_funcao158);
            statements3=statements(ctx, new LinkedList<Node>(), "");

            state._fsp--;



            		this.cfgs.get(ctx).wrapCFG((statements3!=null?statements3.o_src:null), (statements3!=null?statements3.o_label:null));
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            corpo_funcao_stack.pop();
        }
        return ;
    }
    // $ANTLR end "corpo_funcao"



    // $ANTLR start "declaracoes"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:74:1: declaracoes : ^( DECLARACOES ( declaracao )+ ) ;
    public final void declaracoes() throws RecognitionException {
        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:75:2: ( ^( DECLARACOES ( declaracao )+ ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:75:4: ^( DECLARACOES ( declaracao )+ )
            {
            match(input,DECLARACOES,FOLLOW_DECLARACOES_in_declaracoes178); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:75:18: ( declaracao )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DECLARACAO) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:75:18: declaracao
            	    {
            	    pushFollow(FOLLOW_declaracao_in_declaracoes180);
            	    declaracao();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaracoes"



    // $ANTLR start "declaracao"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:78:1: declaracao : ^( DECLARACAO tipo ID ) ;
    public final void declaracao() throws RecognitionException {
        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:79:2: ( ^( DECLARACAO tipo ID ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:79:4: ^( DECLARACAO tipo ID )
            {
            match(input,DECLARACAO,FOLLOW_DECLARACAO_in_declaracao195); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_declaracao197);
            tipo();

            state._fsp--;


            match(input,ID,FOLLOW_ID_in_declaracao199); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaracao"



    // $ANTLR start "tipo"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:82:1: tipo : ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO );
    public final void tipo() throws RecognitionException {
        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:83:2: ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:
            {
            if ( (input.LA(1) >= TD_INT && input.LA(1) <= TD_VAZIO) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tipo"


    public static class statements_return extends TreeRuleReturnScope {
        public LinkedList<Node> o_src;
        public String o_label;
    };


    // $ANTLR start "statements"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:89:1: statements[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label] : ^( STATEMENTS s1= statement[$statements.ctx, $statements.i_src, $statements.i_label ] (s2= statement[$statements.ctx, $s1.o_src, $s1.o_label] )* ) ;
    public final CmbTG_CFG.statements_return statements(String ctx, LinkedList<Node> i_src, String i_label) throws RecognitionException {
        CmbTG_CFG.statements_return retval = new CmbTG_CFG.statements_return();
        retval.start = input.LT(1);


        CmbTG_CFG.statement_return s1 =null;

        CmbTG_CFG.statement_return s2 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:90:2: ( ^( STATEMENTS s1= statement[$statements.ctx, $statements.i_src, $statements.i_label ] (s2= statement[$statements.ctx, $s1.o_src, $s1.o_label] )* ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:90:5: ^( STATEMENTS s1= statement[$statements.ctx, $statements.i_src, $statements.i_label ] (s2= statement[$statements.ctx, $s1.o_src, $s1.o_label] )* )
            {
            match(input,STATEMENTS,FOLLOW_STATEMENTS_in_statements249); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_in_statements253);
            s1=statement(ctx, i_src, i_label);

            state._fsp--;


            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:91:2: (s2= statement[$statements.ctx, $s1.o_src, $s1.o_label] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==INVOCACAO||LA5_0==RETURN||(LA5_0 >= WRITE && LA5_0 <= IF)||LA5_0==WHILE||LA5_0==44) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:91:3: s2= statement[$statements.ctx, $s1.o_src, $s1.o_label]
            	    {
            	    pushFollow(FOLLOW_statement_in_statements261);
            	    s2=statement(ctx, (s1!=null?s1.o_src:null), (s1!=null?s1.o_label:null));

            	    state._fsp--;



            	    		s1 = s2;
            	    	

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            		retval.o_src = (s1!=null?s1.o_src:null);
            		retval.o_label = (s1!=null?s1.o_label:null);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statements"


    protected static class statement_scope {
        HashSet<String> vars;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        public LinkedList<Node> o_src;
        public String o_label;
    };


    // $ANTLR start "statement"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:103:1: statement[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label] : ( atribuicao[$statement.ctx, $statement.i_src, $statement.i_label] | read[$statement.ctx, $statement.i_src, $statement.i_label] | write[$statement.ctx, $statement.i_src, $statement.i_label] | ifs[$statement.ctx, $statement.i_src, $statement.i_label] | whiles[$statement.ctx, $statement.i_src, $statement.i_label] | invocacao[$statement.ctx, $statement.i_src, $statement.i_label, true] | retorna[$statement.ctx, $statement.i_src, $statement.i_label] );
    public final CmbTG_CFG.statement_return statement(String ctx, LinkedList<Node> i_src, String i_label) throws RecognitionException {
        statement_stack.push(new statement_scope());
        CmbTG_CFG.statement_return retval = new CmbTG_CFG.statement_return();
        retval.start = input.LT(1);


        LinkedList<Node> atribuicao4 =null;

        LinkedList<Node> read5 =null;

        LinkedList<Node> write6 =null;

        LinkedList<Node> ifs7 =null;

        CmbTG_CFG.whiles_return whiles8 =null;

        CmbTG_CFG.invocacao_return invocacao9 =null;

        LinkedList<Node> retorna10 =null;



        	((statement_scope)statement_stack.peek()).vars = new HashSet<String>();

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:110:2: ( atribuicao[$statement.ctx, $statement.i_src, $statement.i_label] | read[$statement.ctx, $statement.i_src, $statement.i_label] | write[$statement.ctx, $statement.i_src, $statement.i_label] | ifs[$statement.ctx, $statement.i_src, $statement.i_label] | whiles[$statement.ctx, $statement.i_src, $statement.i_label] | invocacao[$statement.ctx, $statement.i_src, $statement.i_label, true] | retorna[$statement.ctx, $statement.i_src, $statement.i_label] )
            int alt6=7;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt6=1;
                }
                break;
            case READ:
                {
                alt6=2;
                }
                break;
            case WRITE:
                {
                alt6=3;
                }
                break;
            case IF:
                {
                alt6=4;
                }
                break;
            case WHILE:
                {
                alt6=5;
                }
                break;
            case INVOCACAO:
                {
                alt6=6;
                }
                break;
            case RETURN:
                {
                alt6=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:110:4: atribuicao[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_atribuicao_in_statement299);
                    atribuicao4=atribuicao(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = atribuicao4; retval.o_label = "";

                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:111:4: read[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_read_in_statement307);
                    read5=read(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = read5; retval.o_label = "";

                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:112:4: write[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_write_in_statement316);
                    write6=write(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = write6; retval.o_label = "";

                    }
                    break;
                case 4 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:113:4: ifs[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_ifs_in_statement325);
                    ifs7=ifs(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = ifs7; retval.o_label = "";

                    }
                    break;
                case 5 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:114:4: whiles[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_whiles_in_statement334);
                    whiles8=whiles(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = (whiles8!=null?whiles8.o_src:null); retval.o_label = (whiles8!=null?whiles8.o_label:null);

                    }
                    break;
                case 6 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:115:4: invocacao[$statement.ctx, $statement.i_src, $statement.i_label, true]
                    {
                    pushFollow(FOLLOW_invocacao_in_statement343);
                    invocacao9=invocacao(ctx, i_src, i_label, true);

                    state._fsp--;


                    retval.o_src = (invocacao9!=null?invocacao9.o_src:null); retval.o_label = "";

                    }
                    break;
                case 7 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:116:4: retorna[$statement.ctx, $statement.i_src, $statement.i_label]
                    {
                    pushFollow(FOLLOW_retorna_in_statement351);
                    retorna10=retorna(ctx, i_src, i_label);

                    state._fsp--;


                    retval.o_src = retorna10; retval.o_label = "";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"



    // $ANTLR start "retorna"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:121:1: retorna[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : ^( RETURN expr ) ;
    public final LinkedList<Node> retorna(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        String expr11 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:122:2: ( ^( RETURN expr ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:122:5: ^( RETURN expr )
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorna379); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_retorna381);
            expr11=expr();

            state._fsp--;



            		Node n  = new Node("return " + expr11, TipoNode.RETURN);
            		this.updateGraph(ctx, n, label, i_src, null);
            		this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            		o_src = new LinkedList<Node>();
            		o_src.add(n);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "retorna"


    public static class invocacao_return extends TreeRuleReturnScope {
        public LinkedList<Node> o_src;
        public String str;
    };


    // $ANTLR start "invocacao"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:135:1: invocacao[String ctx, LinkedList<Node> i_src, String label, boolean create] returns [LinkedList<Node> o_src, String str] : ^( INVOCACAO ID ( args[$invocacao.ctx] )? ) ;
    public final CmbTG_CFG.invocacao_return invocacao(String ctx, LinkedList<Node> i_src, String label, boolean create) throws RecognitionException {
        CmbTG_CFG.invocacao_return retval = new CmbTG_CFG.invocacao_return();
        retval.start = input.LT(1);


        CommonTree ID12=null;
        String args13 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:136:2: ( ^( INVOCACAO ID ( args[$invocacao.ctx] )? ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:136:5: ^( INVOCACAO ID ( args[$invocacao.ctx] )? )
            {
            match(input,INVOCACAO,FOLLOW_INVOCACAO_in_invocacao408); 

            match(input, Token.DOWN, null); 
            ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_invocacao410); 

            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:136:20: ( args[$invocacao.ctx] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ARGS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:136:20: args[$invocacao.ctx]
                    {
                    pushFollow(FOLLOW_args_in_invocacao412);
                    args13=args(ctx);

                    state._fsp--;


                    }
                    break;

            }



            		String inv_text = (ID12!=null?ID12.getText():null) + "( " + (args13 == null ? "" : args13) + " )" ;
            		if(create) {
            			Node n  = new Node(inv_text, TipoNode.INVOCACAO);
            			this.updateGraph(ctx, n, label, i_src, null);
            			this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            			retval.o_src = new LinkedList<Node>();
            			retval.o_src.add(n);
            		}	
            		retval.str = inv_text;
            		
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "invocacao"



    // $ANTLR start "args"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:152:1: args[String ctx] returns [String str] : ^( ARGS ( expr )+ ) ;
    public final String args(String ctx) throws RecognitionException {
        String str = null;


        String expr14 =null;



        	String text = "";

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:156:2: ( ^( ARGS ( expr )+ ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:156:5: ^( ARGS ( expr )+ )
            {
            match(input,ARGS,FOLLOW_ARGS_in_args443); 

            match(input, Token.DOWN, null); 
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:156:12: ( expr )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==INVOCACAO||LA8_0==ID||(LA8_0 >= STRING && LA8_0 <= FALSE)||(LA8_0 >= 45 && LA8_0 <= 58)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:156:13: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_args446);
            	    expr14=expr();

            	    state._fsp--;



            	    		text += expr14 + ", ";	
            	    	

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);



            		str = text.substring(0,text.length()-2);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return str;
    }
    // $ANTLR end "args"



    // $ANTLR start "atribuicao"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:167:1: atribuicao[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : ^( '=' ID expr ) ;
    public final LinkedList<Node> atribuicao(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        CommonTree ID15=null;
        String expr16 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:168:2: ( ^( '=' ID expr ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:168:5: ^( '=' ID expr )
            {
            match(input,44,FOLLOW_44_in_atribuicao477); 

            match(input, Token.DOWN, null); 
            ID15=(CommonTree)match(input,ID,FOLLOW_ID_in_atribuicao479); 

            pushFollow(FOLLOW_expr_in_atribuicao481);
            expr16=expr();

            state._fsp--;



            		
            		Node n = new Node((ID15!=null?ID15.getText():null) + " = " + expr16, TipoNode.ATRIBUICAO);
            		this.updateGraph(ctx, n, label, i_src, null);
            		this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            		this.cfgs.get(ctx).addDef(n, (ID15!=null?ID15.getText():null));
            		o_src = new LinkedList<Node>();
            		o_src.add(n);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "atribuicao"



    // $ANTLR start "write"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:181:1: write[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : ^( WRITE expr ) ;
    public final LinkedList<Node> write(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        String expr17 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:182:2: ( ^( WRITE expr ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:182:4: ^( WRITE expr )
            {
            match(input,WRITE,FOLLOW_WRITE_in_write504); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_write506);
            expr17=expr();

            state._fsp--;



            		Node n  = new Node("write(" + expr17 +")", TipoNode.WRITE);
            		this.updateGraph(ctx, n, label, i_src, null);
            		this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            		o_src = new LinkedList<Node>();
            		o_src.add(n);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "write"



    // $ANTLR start "read"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:193:1: read[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : ^( READ ID ) ;
    public final LinkedList<Node> read(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        CommonTree ID18=null;

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:194:2: ( ^( READ ID ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:194:4: ^( READ ID )
            {
            match(input,READ,FOLLOW_READ_in_read530); 

            match(input, Token.DOWN, null); 
            ID18=(CommonTree)match(input,ID,FOLLOW_ID_in_read532); 


            		
            		Node n  = new Node("read(" + (ID18!=null?ID18.getText():null) +")", TipoNode.READ);
            		this.updateGraph(ctx, n, label, i_src, null);
            		this.cfgs.get(ctx).addDef(n, (ID18!=null?ID18.getText():null));
            		o_src = new LinkedList<Node>();
            		o_src.add(n);
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "read"



    // $ANTLR start "ifs"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:207:1: ifs[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : ^( IF expr b1= bloco[$ifs.ctx, l_src, \"true\"] (b2= bloco[$ifs.ctx, l_src, \"false\"] )? ) ;
    public final LinkedList<Node> ifs(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        LinkedList<Node> b1 =null;

        LinkedList<Node> b2 =null;

        String expr19 =null;



        	LinkedList<Node> srcs = new LinkedList<Node>();

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:211:2: ( ^( IF expr b1= bloco[$ifs.ctx, l_src, \"true\"] (b2= bloco[$ifs.ctx, l_src, \"false\"] )? ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:211:4: ^( IF expr b1= bloco[$ifs.ctx, l_src, \"true\"] (b2= bloco[$ifs.ctx, l_src, \"false\"] )? )
            {
            match(input,IF,FOLLOW_IF_in_ifs562); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifs564);
            expr19=expr();

            state._fsp--;



            		Node n = new Node(expr19, TipoNode.IF, "if (" + expr19 + ")");
            		this.updateGraph(ctx, n, label, i_src, null);
            		this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            		LinkedList<Node> l_src = new LinkedList<Node>();
            		l_src.add(n);
            	

            pushFollow(FOLLOW_bloco_in_ifs572);
            b1=bloco(ctx, l_src, "true");

            state._fsp--;


            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:219:36: (b2= bloco[$ifs.ctx, l_src, \"false\"] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==STATEMENTS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:219:37: b2= bloco[$ifs.ctx, l_src, \"false\"]
                    {
                    pushFollow(FOLLOW_bloco_in_ifs578);
                    b2=bloco(ctx, l_src, "false");

                    state._fsp--;



                    		srcs.addAll(b2);
                    	

                    }
                    break;

            }



            		srcs.addAll(b1);
            		if(b2 == null){
            			srcs.add(n);
            		}
            		for(Node no : srcs)
            			no.setIfEnds(true);
            		o_src = srcs;
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "ifs"


    public static class whiles_return extends TreeRuleReturnScope {
        public LinkedList<Node> o_src;
        public String o_label;
    };


    // $ANTLR start "whiles"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:236:1: whiles[String ctx, LinkedList<Node> i_src, String i_label] returns [LinkedList<Node> o_src, String o_label] : ^( WHILE expr bloco[$whiles.ctx, l_src, \"true\"] ) ;
    public final CmbTG_CFG.whiles_return whiles(String ctx, LinkedList<Node> i_src, String i_label) throws RecognitionException {
        CmbTG_CFG.whiles_return retval = new CmbTG_CFG.whiles_return();
        retval.start = input.LT(1);


        String expr20 =null;

        LinkedList<Node> bloco21 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:237:2: ( ^( WHILE expr bloco[$whiles.ctx, l_src, \"true\"] ) )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:237:4: ^( WHILE expr bloco[$whiles.ctx, l_src, \"true\"] )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whiles610); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_whiles612);
            expr20=expr();

            state._fsp--;



            		Node n = new Node(expr20, TipoNode.WHILE, "while (" + expr20 + ")");
            		this.updateGraph(ctx, n, i_label, i_src, null);
            		this.cfgs.get(ctx).addRefs(n, ((statement_scope)statement_stack.peek()).vars);
            		LinkedList<Node> l_src = new LinkedList<Node>();
            		l_src.add(n);
            	

            pushFollow(FOLLOW_bloco_in_whiles619);
            bloco21=bloco(ctx, l_src, "true");

            state._fsp--;



            		this.updateGraph(ctx, n, "", bloco21, null);
            		/*for(Node no : l_src)
            			no.setIfEnds(true);*/
            		retval.o_src = l_src;
            		retval.o_label = "false";
            	

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whiles"



    // $ANTLR start "bloco"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:258:1: bloco[String ctx, LinkedList<Node> i_src, String label] returns [LinkedList<Node> o_src] : statements[$bloco.ctx, $bloco.i_src, $bloco.label] ;
    public final LinkedList<Node> bloco(String ctx, LinkedList<Node> i_src, String label) throws RecognitionException {
        LinkedList<Node> o_src = null;


        CmbTG_CFG.statements_return statements22 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:259:2: ( statements[$bloco.ctx, $bloco.i_src, $bloco.label] )
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:259:4: statements[$bloco.ctx, $bloco.i_src, $bloco.label]
            {
            pushFollow(FOLLOW_statements_in_bloco644);
            statements22=statements(ctx, i_src, label);

            state._fsp--;



            		o_src = (statements22!=null?statements22.o_src:null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o_src;
    }
    // $ANTLR end "bloco"



    // $ANTLR start "expr"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:267:1: expr returns [String str] : ( ^( '||' e1= expr e2= expr ) | ^( '&&' e1= expr e2= expr ) | ^( '+' e1= expr e2= expr ) | ^( '-' e1= expr e2= expr ) | ^( '*' e1= expr e2= expr ) | ^( '/' e1= expr e2= expr ) | ^( '%' e1= expr e2= expr ) | ^( '>' e1= expr e2= expr ) | ^( '<' e1= expr e2= expr ) | ^( '>=' e1= expr e2= expr ) | ^( '<=' e1= expr e2= expr ) | ^( '==' e1= expr e2= expr ) | ^( '!=' e1= expr e2= expr ) | ^( '!' e1= expr ) | factor );
    public final String expr() throws RecognitionException {
        String str = null;


        String e1 =null;

        String e2 =null;

        String factor23 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:268:2: ( ^( '||' e1= expr e2= expr ) | ^( '&&' e1= expr e2= expr ) | ^( '+' e1= expr e2= expr ) | ^( '-' e1= expr e2= expr ) | ^( '*' e1= expr e2= expr ) | ^( '/' e1= expr e2= expr ) | ^( '%' e1= expr e2= expr ) | ^( '>' e1= expr e2= expr ) | ^( '<' e1= expr e2= expr ) | ^( '>=' e1= expr e2= expr ) | ^( '<=' e1= expr e2= expr ) | ^( '==' e1= expr e2= expr ) | ^( '!=' e1= expr e2= expr ) | ^( '!' e1= expr ) | factor )
            int alt10=15;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt10=1;
                }
                break;
            case 51:
                {
                alt10=2;
                }
                break;
            case 46:
                {
                alt10=3;
                }
                break;
            case 45:
                {
                alt10=4;
                }
                break;
            case 47:
                {
                alt10=5;
                }
                break;
            case 48:
                {
                alt10=6;
                }
                break;
            case 49:
                {
                alt10=7;
                }
                break;
            case 52:
                {
                alt10=8;
                }
                break;
            case 53:
                {
                alt10=9;
                }
                break;
            case 54:
                {
                alt10=10;
                }
                break;
            case 55:
                {
                alt10=11;
                }
                break;
            case 56:
                {
                alt10=12;
                }
                break;
            case 57:
                {
                alt10=13;
                }
                break;
            case 58:
                {
                alt10=14;
                }
                break;
            case INVOCACAO:
            case ID:
            case STRING:
            case INT:
            case TRUE:
            case FALSE:
                {
                alt10=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:268:4: ^( '||' e1= expr e2= expr )
                    {
                    match(input,50,FOLLOW_50_in_expr669); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr673);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr677);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " || " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:269:4: ^( '&&' e1= expr e2= expr )
                    {
                    match(input,51,FOLLOW_51_in_expr686); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr690);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr694);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " && " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:270:4: ^( '+' e1= expr e2= expr )
                    {
                    match(input,46,FOLLOW_46_in_expr703); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr707);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr711);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " + " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:271:4: ^( '-' e1= expr e2= expr )
                    {
                    match(input,45,FOLLOW_45_in_expr720); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr724);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr728);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " - " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:272:4: ^( '*' e1= expr e2= expr )
                    {
                    match(input,47,FOLLOW_47_in_expr737); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr741);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr745);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " * " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:273:4: ^( '/' e1= expr e2= expr )
                    {
                    match(input,48,FOLLOW_48_in_expr754); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr758);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr762);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " / " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:274:4: ^( '%' e1= expr e2= expr )
                    {
                    match(input,49,FOLLOW_49_in_expr771); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr775);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr779);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " mod " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:275:4: ^( '>' e1= expr e2= expr )
                    {
                    match(input,52,FOLLOW_52_in_expr788); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr792);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr796);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " > " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:276:4: ^( '<' e1= expr e2= expr )
                    {
                    match(input,53,FOLLOW_53_in_expr805); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr809);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr813);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " < " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:277:4: ^( '>=' e1= expr e2= expr )
                    {
                    match(input,54,FOLLOW_54_in_expr822); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr826);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr830);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " >= " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 11 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:278:5: ^( '<=' e1= expr e2= expr )
                    {
                    match(input,55,FOLLOW_55_in_expr840); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr844);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr848);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " <= " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 12 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:279:4: ^( '==' e1= expr e2= expr )
                    {
                    match(input,56,FOLLOW_56_in_expr857); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr861);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr865);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " == " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 13 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:280:4: ^( '!=' e1= expr e2= expr )
                    {
                    match(input,57,FOLLOW_57_in_expr874); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr878);
                    e1=expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr882);
                    e2=expr();

                    state._fsp--;


                    str = e1 + " != " + e2 ; 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 14 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:281:4: ^( '!' e1= expr )
                    {
                    match(input,58,FOLLOW_58_in_expr891); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr895);
                    e1=expr();

                    state._fsp--;


                    str = "! " + e1 ;

                    match(input, Token.UP, null); 


                    }
                    break;
                case 15 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:282:4: factor
                    {
                    pushFollow(FOLLOW_factor_in_expr904);
                    factor23=factor();

                    state._fsp--;


                    str = factor23 ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return str;
    }
    // $ANTLR end "expr"



    // $ANTLR start "factor"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:285:1: factor returns [String str] : ( ID | constante | invocacao[\"\", null, \"\", false] );
    public final String factor() throws RecognitionException {
        String str = null;


        CommonTree ID24=null;
        String constante25 =null;

        CmbTG_CFG.invocacao_return invocacao26 =null;


        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:286:2: ( ID | constante | invocacao[\"\", null, \"\", false] )
            int alt11=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt11=1;
                }
                break;
            case STRING:
            case INT:
            case TRUE:
            case FALSE:
                {
                alt11=2;
                }
                break;
            case INVOCACAO:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:286:4: ID
                    {
                    ID24=(CommonTree)match(input,ID,FOLLOW_ID_in_factor922); 

                    str = (ID24!=null?ID24.getText():null); ((statement_scope)statement_stack.peek()).vars.add((ID24!=null?ID24.getText():null)); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:287:4: constante
                    {
                    pushFollow(FOLLOW_constante_in_factor929);
                    constante25=constante();

                    state._fsp--;


                    str = str = constante25; 

                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:288:4: invocacao[\"\", null, \"\", false]
                    {
                    pushFollow(FOLLOW_invocacao_in_factor936);
                    invocacao26=invocacao("", null, "", false);

                    state._fsp--;


                    str = (invocacao26!=null?invocacao26.str:null) ; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return str;
    }
    // $ANTLR end "factor"



    // $ANTLR start "constante"
    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:291:1: constante returns [String str] : ( STRING | INT | TRUE | FALSE );
    public final String constante() throws RecognitionException {
        String str = null;


        CommonTree STRING27=null;
        CommonTree INT28=null;
        CommonTree TRUE29=null;
        CommonTree FALSE30=null;

        try {
            // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:292:2: ( STRING | INT | TRUE | FALSE )
            int alt12=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt12=1;
                }
                break;
            case INT:
                {
                alt12=2;
                }
                break;
            case TRUE:
                {
                alt12=3;
                }
                break;
            case FALSE:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:292:4: STRING
                    {
                    STRING27=(CommonTree)match(input,STRING,FOLLOW_STRING_in_constante955); 

                    str = (STRING27!=null?STRING27.getText():null).replaceAll("\"", "\\\""); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:293:4: INT
                    {
                    INT28=(CommonTree)match(input,INT,FOLLOW_INT_in_constante962); 

                    str = (INT28!=null?INT28.getText():null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:294:4: TRUE
                    {
                    TRUE29=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_constante969); 

                    str = (TRUE29!=null?TRUE29.getText():null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\António\\eclipse_workspace\\Cmb\\resources\\CmbTG_CFG.g:295:4: FALSE
                    {
                    FALSE30=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_constante976); 

                    str = (FALSE30!=null?FALSE30.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return str;
    }
    // $ANTLR end "constante"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMA_in_programa55 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funcao_in_programa57 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_FUNCAO_in_funcao78 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cabecalho_in_funcao80 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_corpo_funcao_in_funcao82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAEBECALHO_in_cabecalho102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_cabecalho104 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_cabecalho106 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_argumentos_in_cabecalho108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTOS_in_argumentos128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_argumentos130 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_CORPO_in_corpo_funcao154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracoes_in_corpo_funcao156 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_statements_in_corpo_funcao158 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLARACOES_in_declaracoes178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_declaracoes180 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_DECLARACAO_in_declaracao195 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_declaracao197 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_declaracao199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STATEMENTS_in_statements249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statements253 = new BitSet(new long[]{0x0000100005C14008L});
    public static final BitSet FOLLOW_statement_in_statements261 = new BitSet(new long[]{0x0000100005C14008L});
    public static final BitSet FOLLOW_atribuicao_in_statement299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_statement316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifs_in_statement325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whiles_in_statement334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_statement343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorna_in_statement351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorna379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_retorna381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOCACAO_in_invocacao408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocacao410 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_args_in_invocacao412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_args443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_args446 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_44_in_atribuicao477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atribuicao479 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_atribuicao481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WRITE_in_write504 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_write506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_read532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifs562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifs564 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_ifs572 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_bloco_in_ifs578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whiles610 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_whiles612 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_whiles619 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statements_in_bloco644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expr669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr673 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_51_in_expr686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr690 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr694 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_expr703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr707 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expr720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr724 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_47_in_expr737 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr741 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_expr754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr758 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr762 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_49_in_expr771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr775 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_expr788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr792 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_expr805 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr809 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr813 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_expr822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr826 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr830 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_expr840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr844 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr848 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_expr857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr861 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr865 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_expr874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr878 = new BitSet(new long[]{0x07FFE00078024000L});
    public static final BitSet FOLLOW_expr_in_expr882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_expr891 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_factor_in_expr904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_factor922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constante_in_factor929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_factor936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constante955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_constante962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_constante969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_constante976 = new BitSet(new long[]{0x0000000000000002L});

}