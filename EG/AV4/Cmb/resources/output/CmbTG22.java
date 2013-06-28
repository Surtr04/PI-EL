// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g 2013-04-29 12:39:26

	package language;
	
	import parsing.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CmbTG22 extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMA", "DECLARACOES", "DECLARACAO", "STATEMENTS", "ATRIBUICAO", "THEN", "CORPO", "FUNCAO", "CAEBECALHO", "ARGUMENTOS", "INVOCACAO", "ARGS", "RETURN", "ID", "TD_INT", "TD_BOOL", "TD_STRING", "TD_VAZIO", "WRITE", "READ", "IF", "ELSE", "WHILE", "STRING", "INT", "TRUE", "FALSE", "COMMENT", "WS", "ESC_SEQ", "CHAR", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'{'", "'}'", "'('", "')'", "','", "';'", "'='", "'-'", "'+'", "'*'", "'/'", "'%'", "'||'", "'&&'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'!'"
    };
    public static final int WHILE=26;
    public static final int OCTAL_ESC=37;
    public static final int CHAR=34;
    public static final int ID=17;
    public static final int EOF=-1;
    public static final int IF=24;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int ESC_SEQ=33;
    public static final int THEN=9;
    public static final int T__52=52;
    public static final int DECLARACOES=5;
    public static final int T__53=53;
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
    public static final int WRITE=22;
    public static final int TD_VAZIO=21;
    public static final int WS=32;
    public static final int CORPO=10;
    public static final int ATRIBUICAO=8;
    public static final int DECLARACAO=6;
    public static final int TD_INT=18;
    public static final int T__38=38;
    public static final int READ=23;
    public static final int T__39=39;
    public static final int PROGRAMA=4;
    public static final int STATEMENTS=7;
    public static final int FALSE=30;
    public static final int STRING=27;
    public static final int TD_BOOL=19;

    // delegates
    // delegators


        public CmbTG22(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public CmbTG22(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CmbTG22.tokenNames; }
    public String getGrammarFileName() { return "/Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g"; }


    	private Tabela ids = new Tabela();
    	
    	/*public Tabela getTabela() {
    		return this.ids;
    	}*/
    	



    // $ANTLR start "programa"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:29:1: programa returns [Tabela tab] : ^( PROGRAMA ( funcao[\"\"] )+ ) ;
    public final Tabela programa() throws RecognitionException {
        Tabela tab = null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:30:2: ( ^( PROGRAMA ( funcao[\"\"] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:30:5: ^( PROGRAMA ( funcao[\"\"] )+ )
            {
            match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa57); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:30:16: ( funcao[\"\"] )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:30:16: funcao[\"\"]
            	    {
            	    pushFollow(FOLLOW_funcao_in_programa59);
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


            		tab = this.ids;
            	

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tab;
    }
    // $ANTLR end "programa"


    // $ANTLR start "funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:38:1: funcao[String contexto] : ^( FUNCAO cabecalho[$funcao.contexto] corpo_funcao[$cabecalho.o_contexto] ) ;
    public final void funcao(String contexto) throws RecognitionException {
        String cabecalho1 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:39:2: ( ^( FUNCAO cabecalho[$funcao.contexto] corpo_funcao[$cabecalho.o_contexto] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:39:5: ^( FUNCAO cabecalho[$funcao.contexto] corpo_funcao[$cabecalho.o_contexto] )
            {
            match(input,FUNCAO,FOLLOW_FUNCAO_in_funcao85); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_cabecalho_in_funcao87);
            cabecalho1=cabecalho(contexto);

            state._fsp--;

            pushFollow(FOLLOW_corpo_funcao_in_funcao90);
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
        }
        return ;
    }
    // $ANTLR end "funcao"


    // $ANTLR start "cabecalho"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:42:1: cabecalho[String i_contexto] returns [String o_contexto] : ^( CAEBECALHO tipo ID (arg= argumentos[$ID.text] )? ) ;
    public final String cabecalho(String i_contexto) throws RecognitionException {
        String o_contexto = null;

        CommonTree ID2=null;
        ArrayList<String> arg = null;

        String tipo3 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:43:2: ( ^( CAEBECALHO tipo ID (arg= argumentos[$ID.text] )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:43:5: ^( CAEBECALHO tipo ID (arg= argumentos[$ID.text] )? )
            {
            match(input,CAEBECALHO,FOLLOW_CAEBECALHO_in_cabecalho112); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_cabecalho114);
            tipo3=tipo();

            state._fsp--;

            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_cabecalho116); 

            		Simbolo s = new Simbolo();
            		s.setId((ID2!=null?ID2.getText():null));
            		s.setTipo(tipo3);
            		if(s.getTipo().equals("void")){
            			s.setClasse("PROC");
            		}
            		else {
            			s.setClasse("FUNC");
            		}
            		s.setTamanho(ids.getSimbolos().get(new Pair<String, String>(tipo3, "")).getTamanho());
            		s.setLinha((ID2!=null?ID2.getLine():0));
            		s.setColuna((ID2!=null?ID2.getCharPositionInLine():0));
            		//s.setEndMCode();
            		
            	
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:60:2: (arg= argumentos[$ID.text] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARGUMENTOS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:60:3: arg= argumentos[$ID.text]
                    {
                    pushFollow(FOLLOW_argumentos_in_cabecalho127);
                    arg=argumentos((ID2!=null?ID2.getText():null));

                    state._fsp--;


                    		s.setParams(arg);
                    	

                    }
                    break;

            }


            		ids.addSimbolo(i_contexto, s);
            		o_contexto = (ID2!=null?ID2.getText():null);
            	

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return o_contexto;
    }
    // $ANTLR end "cabecalho"


    // $ANTLR start "argumentos"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:73:1: argumentos[String scope] returns [ArrayList<String> lista_args] : ^( ARGUMENTOS ( declaracao[$argumentos.scope, true] )+ ) ;
    public final ArrayList<String> argumentos(String scope) throws RecognitionException {
        ArrayList<String> lista_args = null;

        String declaracao4 = null;



        	ArrayList<String> args = new ArrayList<String>();

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:77:2: ( ^( ARGUMENTOS ( declaracao[$argumentos.scope, true] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:77:5: ^( ARGUMENTOS ( declaracao[$argumentos.scope, true] )+ )
            {
            match(input,ARGUMENTOS,FOLLOW_ARGUMENTOS_in_argumentos167); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:77:18: ( declaracao[$argumentos.scope, true] )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:77:19: declaracao[$argumentos.scope, true]
            	    {
            	    pushFollow(FOLLOW_declaracao_in_argumentos170);
            	    declaracao4=declaracao(scope, true);

            	    state._fsp--;


            	    		args.add(declaracao4);
            	    	

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


            		lista_args = args;
            	

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return lista_args;
    }
    // $ANTLR end "argumentos"


    // $ANTLR start "corpo_funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:90:1: corpo_funcao[String contexto] : ^( CORPO declaracoes[$corpo_funcao.contexto] statements ) ;
    public final void corpo_funcao(String contexto) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:91:2: ( ^( CORPO declaracoes[$corpo_funcao.contexto] statements ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:91:4: ^( CORPO declaracoes[$corpo_funcao.contexto] statements )
            {
            match(input,CORPO,FOLLOW_CORPO_in_corpo_funcao203); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_declaracoes_in_corpo_funcao205);
            declaracoes(contexto);

            state._fsp--;

            pushFollow(FOLLOW_statements_in_corpo_funcao208);
            statements();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "corpo_funcao"


    // $ANTLR start "declaracoes"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:94:1: declaracoes[String contexto] : ^( DECLARACOES ( declaracao[$declaracoes.contexto, false] )+ ) ;
    public final void declaracoes(String contexto) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:95:2: ( ^( DECLARACOES ( declaracao[$declaracoes.contexto, false] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:95:4: ^( DECLARACOES ( declaracao[$declaracoes.contexto, false] )+ )
            {
            match(input,DECLARACOES,FOLLOW_DECLARACOES_in_declaracoes223); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:95:18: ( declaracao[$declaracoes.contexto, false] )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:95:18: declaracao[$declaracoes.contexto, false]
            	    {
            	    pushFollow(FOLLOW_declaracao_in_declaracoes225);
            	    declaracao(contexto, false);

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
        }
        return ;
    }
    // $ANTLR end "declaracoes"


    // $ANTLR start "declaracao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:98:1: declaracao[String scope, boolean is_argumento] returns [String idvar] : ^( DECLARACAO tipo ID ) ;
    public final String declaracao(String scope, boolean is_argumento) throws RecognitionException {
        String idvar = null;

        CommonTree ID5=null;
        String tipo6 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:99:2: ( ^( DECLARACAO tipo ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:99:4: ^( DECLARACAO tipo ID )
            {
            match(input,DECLARACAO,FOLLOW_DECLARACAO_in_declaracao247); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_declaracao249);
            tipo6=tipo();

            state._fsp--;

            ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_declaracao251); 

            		Simbolo s = new Simbolo();
            		s.setId((ID5!=null?ID5.getText():null));
            		s.setTipo(tipo6);
            		if(is_argumento){
            			s.setClasse("PARAM");
            		}
            		else {
            			s.setClasse("VAR");
            		}
            		s.setTamanho(ids.getSimbolos().get(new Pair<String, String>(tipo6, "")).getTamanho());
            		s.setLinha((ID5!=null?ID5.getLine():0));
            		s.setColuna((ID5!=null?ID5.getCharPositionInLine():0));
            		
            		ids.addSimbolo(scope, s);
            		
            		idvar = (ID5!=null?ID5.getText():null);
            	

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return idvar;
    }
    // $ANTLR end "declaracao"


    // $ANTLR start "tipo"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:122:1: tipo returns [String nome] : ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO );
    public final String tipo() throws RecognitionException {
        String nome = null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:123:2: ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO )
            int alt5=4;
            switch ( input.LA(1) ) {
            case TD_INT:
                {
                alt5=1;
                }
                break;
            case TD_BOOL:
                {
                alt5=2;
                }
                break;
            case TD_STRING:
                {
                alt5=3;
                }
                break;
            case TD_VAZIO:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:123:4: TD_INT
                    {
                    match(input,TD_INT,FOLLOW_TD_INT_in_tipo275); 
                    nome = "int" ;

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:124:4: TD_BOOL
                    {
                    match(input,TD_BOOL,FOLLOW_TD_BOOL_in_tipo285); 
                    nome = "bool" ;

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:125:4: TD_STRING
                    {
                    match(input,TD_STRING,FOLLOW_TD_STRING_in_tipo296); 
                    nome = "string" ;

                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:126:4: TD_VAZIO
                    {
                    match(input,TD_VAZIO,FOLLOW_TD_VAZIO_in_tipo305); 
                    nome = "void" ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return nome;
    }
    // $ANTLR end "tipo"


    // $ANTLR start "statements"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:129:1: statements : ^( STATEMENTS ( statement )+ ) ;
    public final void statements() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:130:2: ( ^( STATEMENTS ( statement )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:130:4: ^( STATEMENTS ( statement )+ )
            {
            match(input,STATEMENTS,FOLLOW_STATEMENTS_in_statements322); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:130:17: ( statement )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==INVOCACAO||LA6_0==RETURN||(LA6_0>=WRITE && LA6_0<=IF)||LA6_0==WHILE||LA6_0==44) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:130:17: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statements324);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statements"


    // $ANTLR start "statement"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:134:1: statement : ( atribuicao | read | write | ifs | whiles | invocacao | retorna );
    public final void statement() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:135:2: ( atribuicao | read | write | ifs | whiles | invocacao | retorna )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt7=1;
                }
                break;
            case READ:
                {
                alt7=2;
                }
                break;
            case WRITE:
                {
                alt7=3;
                }
                break;
            case IF:
                {
                alt7=4;
                }
                break;
            case WHILE:
                {
                alt7=5;
                }
                break;
            case INVOCACAO:
                {
                alt7=6;
                }
                break;
            case RETURN:
                {
                alt7=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:135:5: atribuicao
                    {
                    pushFollow(FOLLOW_atribuicao_in_statement340);
                    atribuicao();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:136:5: read
                    {
                    pushFollow(FOLLOW_read_in_statement346);
                    read();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:137:4: write
                    {
                    pushFollow(FOLLOW_write_in_statement351);
                    write();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:138:4: ifs
                    {
                    pushFollow(FOLLOW_ifs_in_statement357);
                    ifs();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:139:4: whiles
                    {
                    pushFollow(FOLLOW_whiles_in_statement363);
                    whiles();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:140:4: invocacao
                    {
                    pushFollow(FOLLOW_invocacao_in_statement369);
                    invocacao();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:141:4: retorna
                    {
                    pushFollow(FOLLOW_retorna_in_statement375);
                    retorna();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "retorna"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:144:1: retorna : ^( RETURN expr ) ;
    public final void retorna() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:145:2: ( ^( RETURN expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:145:5: ^( RETURN expr )
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorna390); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_retorna392);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "retorna"


    // $ANTLR start "invocacao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:148:1: invocacao : ^( INVOCACAO ID ( args )? ) ;
    public final void invocacao() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:149:2: ( ^( INVOCACAO ID ( args )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:149:5: ^( INVOCACAO ID ( args )? )
            {
            match(input,INVOCACAO,FOLLOW_INVOCACAO_in_invocacao406); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_invocacao408); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:149:20: ( args )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ARGS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:149:20: args
                    {
                    pushFollow(FOLLOW_args_in_invocacao410);
                    args();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "invocacao"


    // $ANTLR start "args"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:152:1: args : ^( ARGS ( expr )+ ) ;
    public final void args() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:153:2: ( ^( ARGS ( expr )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:153:5: ^( ARGS ( expr )+ )
            {
            match(input,ARGS,FOLLOW_ARGS_in_args425); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:153:12: ( expr )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==INVOCACAO||LA9_0==ID||(LA9_0>=STRING && LA9_0<=FALSE)||(LA9_0>=45 && LA9_0<=58)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:153:12: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_args427);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "args"


    // $ANTLR start "atribuicao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:156:1: atribuicao : ^( '=' ID expr ) ;
    public final void atribuicao() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:157:2: ( ^( '=' ID expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:157:4: ^( '=' ID expr )
            {
            match(input,44,FOLLOW_44_in_atribuicao441); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_atribuicao443); 
            pushFollow(FOLLOW_expr_in_atribuicao445);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atribuicao"


    // $ANTLR start "write"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:160:1: write : ^( WRITE expr ) ;
    public final void write() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:161:2: ( ^( WRITE expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:161:4: ^( WRITE expr )
            {
            match(input,WRITE,FOLLOW_WRITE_in_write458); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_write460);
            expr();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "write"


    // $ANTLR start "read"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:164:1: read : ^( READ ID ) ;
    public final void read() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:165:2: ( ^( READ ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:165:4: ^( READ ID )
            {
            match(input,READ,FOLLOW_READ_in_read474); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_read476); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "read"


    // $ANTLR start "ifs"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:169:1: ifs : ^( IF expr bloco ( bloco )? ) ;
    public final void ifs() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:170:2: ( ^( IF expr bloco ( bloco )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:170:4: ^( IF expr bloco ( bloco )? )
            {
            match(input,IF,FOLLOW_IF_in_ifs492); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifs494);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_bloco_in_ifs496);
            bloco();

            state._fsp--;

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:170:20: ( bloco )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==STATEMENTS) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:170:21: bloco
                    {
                    pushFollow(FOLLOW_bloco_in_ifs499);
                    bloco();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ifs"


    // $ANTLR start "whiles"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:173:1: whiles : ^( WHILE expr bloco ) ;
    public final void whiles() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:174:2: ( ^( WHILE expr bloco ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:174:4: ^( WHILE expr bloco )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whiles515); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_whiles517);
            expr();

            state._fsp--;

            pushFollow(FOLLOW_bloco_in_whiles519);
            bloco();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "whiles"


    // $ANTLR start "bloco"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:177:1: bloco : statements ;
    public final void bloco() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:178:2: ( statements )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:178:4: statements
            {
            pushFollow(FOLLOW_statements_in_bloco531);
            statements();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bloco"


    // $ANTLR start "expr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:182:1: expr : ( ^( '||' expr expr ) | ^( '&&' expr expr ) | ^( '==' expr expr ) | ^( '-' expr expr ) | ^( '+' expr expr ) | ^( '*' expr expr ) | ^( '/' expr expr ) | ^( '%' expr expr ) | ^( '>' expr expr ) | ^( '<' expr expr ) | ^( '<=' expr expr ) | ^( '>=' expr expr ) | ^( '!=' expr expr ) | ^( '!' expr ) | factor );
    public final void expr() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:183:2: ( ^( '||' expr expr ) | ^( '&&' expr expr ) | ^( '==' expr expr ) | ^( '-' expr expr ) | ^( '+' expr expr ) | ^( '*' expr expr ) | ^( '/' expr expr ) | ^( '%' expr expr ) | ^( '>' expr expr ) | ^( '<' expr expr ) | ^( '<=' expr expr ) | ^( '>=' expr expr ) | ^( '!=' expr expr ) | ^( '!' expr ) | factor )
            int alt11=15;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt11=1;
                }
                break;
            case 51:
                {
                alt11=2;
                }
                break;
            case 56:
                {
                alt11=3;
                }
                break;
            case 45:
                {
                alt11=4;
                }
                break;
            case 46:
                {
                alt11=5;
                }
                break;
            case 47:
                {
                alt11=6;
                }
                break;
            case 48:
                {
                alt11=7;
                }
                break;
            case 49:
                {
                alt11=8;
                }
                break;
            case 52:
                {
                alt11=9;
                }
                break;
            case 53:
                {
                alt11=10;
                }
                break;
            case 55:
                {
                alt11=11;
                }
                break;
            case 54:
                {
                alt11=12;
                }
                break;
            case 57:
                {
                alt11=13;
                }
                break;
            case 58:
                {
                alt11=14;
                }
                break;
            case INVOCACAO:
            case ID:
            case STRING:
            case INT:
            case TRUE:
            case FALSE:
                {
                alt11=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:183:4: ^( '||' expr expr )
                    {
                    match(input,50,FOLLOW_50_in_expr545); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr547);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr549);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:184:4: ^( '&&' expr expr )
                    {
                    match(input,51,FOLLOW_51_in_expr556); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr558);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr560);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:185:4: ^( '==' expr expr )
                    {
                    match(input,56,FOLLOW_56_in_expr567); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr569);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr571);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:186:4: ^( '-' expr expr )
                    {
                    match(input,45,FOLLOW_45_in_expr578); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr580);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr582);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:187:4: ^( '+' expr expr )
                    {
                    match(input,46,FOLLOW_46_in_expr590); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr592);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr594);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:188:4: ^( '*' expr expr )
                    {
                    match(input,47,FOLLOW_47_in_expr601); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr603);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr605);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:189:4: ^( '/' expr expr )
                    {
                    match(input,48,FOLLOW_48_in_expr612); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr614);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr616);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:190:4: ^( '%' expr expr )
                    {
                    match(input,49,FOLLOW_49_in_expr624); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr626);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr628);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:191:4: ^( '>' expr expr )
                    {
                    match(input,52,FOLLOW_52_in_expr635); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr637);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr639);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:192:4: ^( '<' expr expr )
                    {
                    match(input,53,FOLLOW_53_in_expr646); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr648);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr650);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:193:4: ^( '<=' expr expr )
                    {
                    match(input,55,FOLLOW_55_in_expr657); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr659);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr661);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:194:4: ^( '>=' expr expr )
                    {
                    match(input,54,FOLLOW_54_in_expr668); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr670);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr672);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:195:4: ^( '!=' expr expr )
                    {
                    match(input,57,FOLLOW_57_in_expr679); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr681);
                    expr();

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr683);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:196:4: ^( '!' expr )
                    {
                    match(input,58,FOLLOW_58_in_expr690); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr692);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:197:4: factor
                    {
                    pushFollow(FOLLOW_factor_in_expr698);
                    factor();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"


    // $ANTLR start "factor"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:200:1: factor : ( ID | constante | invocacao );
    public final void factor() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:201:2: ( ID | constante | invocacao )
            int alt12=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt12=1;
                }
                break;
            case STRING:
            case INT:
            case TRUE:
            case FALSE:
                {
                alt12=2;
                }
                break;
            case INVOCACAO:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:201:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_factor709); 

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:202:4: constante
                    {
                    pushFollow(FOLLOW_constante_in_factor715);
                    constante();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:203:4: invocacao
                    {
                    pushFollow(FOLLOW_invocacao_in_factor720);
                    invocacao();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factor"


    // $ANTLR start "constante"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:206:1: constante : ( STRING | INT | TRUE | FALSE );
    public final void constante() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:207:2: ( STRING | INT | TRUE | FALSE )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/CmbTG22.g:
            {
            if ( (input.LA(1)>=STRING && input.LA(1)<=FALSE) ) {
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
        }
        return ;
    }
    // $ANTLR end "constante"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMA_in_programa57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funcao_in_programa59 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_FUNCAO_in_funcao85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cabecalho_in_funcao87 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_corpo_funcao_in_funcao90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAEBECALHO_in_cabecalho112 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_cabecalho114 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_cabecalho116 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_argumentos_in_cabecalho127 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTOS_in_argumentos167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_argumentos170 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_CORPO_in_corpo_funcao203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracoes_in_corpo_funcao205 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_statements_in_corpo_funcao208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLARACOES_in_declaracoes223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_declaracoes225 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_DECLARACAO_in_declaracao247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_declaracao249 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_declaracao251 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TD_INT_in_tipo275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TD_BOOL_in_tipo285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TD_STRING_in_tipo296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TD_VAZIO_in_tipo305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENTS_in_statements322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statements324 = new BitSet(new long[]{0x0000100005C14008L});
    public static final BitSet FOLLOW_atribuicao_in_statement340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_statement351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifs_in_statement357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whiles_in_statement363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_statement369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorna_in_statement375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorna390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_retorna392 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOCACAO_in_invocacao406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocacao408 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_args_in_invocacao410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_args425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_args427 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_44_in_atribuicao441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atribuicao443 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_atribuicao445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WRITE_in_write458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_write460 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_read476 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifs492 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifs494 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_ifs496 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_bloco_in_ifs499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whiles515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_whiles517 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_whiles519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statements_in_bloco531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expr545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr547 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_51_in_expr556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr558 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_expr567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr569 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expr578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr580 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_expr590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr592 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_47_in_expr601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr603 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_expr612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr614 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr616 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_49_in_expr624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr626 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr628 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_expr635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr637 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_expr646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr648 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_expr657 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr659 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr661 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_expr668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr670 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_expr679 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr681 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_expr690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_factor_in_expr698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_factor709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constante_in_factor715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_factor720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constante0 = new BitSet(new long[]{0x0000000000000002L});

}