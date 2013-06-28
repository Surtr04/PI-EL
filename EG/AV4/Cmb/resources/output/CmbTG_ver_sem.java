// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g 2013-05-27 10:47:10

	package language;
	import parsing.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CmbTG_ver_sem extends TreeParser {
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


        public CmbTG_ver_sem(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public CmbTG_ver_sem(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CmbTG_ver_sem.tokenNames; }
    public String getGrammarFileName() { return "/Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g"; }


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



    // $ANTLR start "programa"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:34:1: programa[Tabela ids] : ^( PROGRAMA ( funcao )+ ) ;
    public final void programa(Tabela ids) throws RecognitionException {

        	this.global_ids = ids;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:38:2: ( ^( PROGRAMA ( funcao )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:38:5: ^( PROGRAMA ( funcao )+ )
            {
            match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa56); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:38:16: ( funcao )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:38:16: funcao
            	    {
            	    pushFollow(FOLLOW_funcao_in_programa58);
            	    funcao();

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
    // $ANTLR end "programa"


    // $ANTLR start "funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:41:1: funcao : ^( FUNCAO cabecalho corpo_funcao[$cabecalho.nome] ) ;
    public final void funcao() throws RecognitionException {
        String cabecalho1 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:42:2: ( ^( FUNCAO cabecalho corpo_funcao[$cabecalho.nome] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:42:5: ^( FUNCAO cabecalho corpo_funcao[$cabecalho.nome] )
            {
            match(input,FUNCAO,FOLLOW_FUNCAO_in_funcao74); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_cabecalho_in_funcao76);
            cabecalho1=cabecalho();

            state._fsp--;

            pushFollow(FOLLOW_corpo_funcao_in_funcao78);
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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:45:1: cabecalho returns [String nome] : ^( CAEBECALHO tipo ID ( argumentos[$ID.text] )? ) ;
    public final String cabecalho() throws RecognitionException {
        String nome = null;

        CommonTree ID2=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:46:2: ( ^( CAEBECALHO tipo ID ( argumentos[$ID.text] )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:46:5: ^( CAEBECALHO tipo ID ( argumentos[$ID.text] )? )
            {
            match(input,CAEBECALHO,FOLLOW_CAEBECALHO_in_cabecalho98); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_cabecalho100);
            tipo();

            state._fsp--;

            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_cabecalho102); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:46:26: ( argumentos[$ID.text] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ARGUMENTOS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:46:26: argumentos[$ID.text]
                    {
                    pushFollow(FOLLOW_argumentos_in_cabecalho104);
                    argumentos((ID2!=null?ID2.getText():null));

                    state._fsp--;


                    }
                    break;

            }


            		nome = (ID2!=null?ID2.getText():null);
            	

            match(input, Token.UP, null); 

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
    // $ANTLR end "cabecalho"


    // $ANTLR start "argumentos"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:53:1: argumentos[String ctx] : ^( ARGUMENTOS ( declaracao[$argumentos.ctx] )+ ) ;
    public final void argumentos(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:54:2: ( ^( ARGUMENTOS ( declaracao[$argumentos.ctx] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:54:5: ^( ARGUMENTOS ( declaracao[$argumentos.ctx] )+ )
            {
            match(input,ARGUMENTOS,FOLLOW_ARGUMENTOS_in_argumentos127); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:54:18: ( declaracao[$argumentos.ctx] )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:54:18: declaracao[$argumentos.ctx]
            	    {
            	    pushFollow(FOLLOW_declaracao_in_argumentos129);
            	    declaracao(ctx);

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
        }
        return ;
    }
    // $ANTLR end "argumentos"


    // $ANTLR start "corpo_funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:57:1: corpo_funcao[String ctx] : ^( CORPO declaracoes[$corpo_funcao.ctx] statements[$corpo_funcao.ctx] ) ;
    public final void corpo_funcao(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:58:2: ( ^( CORPO declaracoes[$corpo_funcao.ctx] statements[$corpo_funcao.ctx] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:58:4: ^( CORPO declaracoes[$corpo_funcao.ctx] statements[$corpo_funcao.ctx] )
            {
            match(input,CORPO,FOLLOW_CORPO_in_corpo_funcao146); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_declaracoes_in_corpo_funcao148);
            declaracoes(ctx);

            state._fsp--;

            pushFollow(FOLLOW_statements_in_corpo_funcao151);
            statements(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:61:1: declaracoes[String ctx] : ^( DECLARACOES ( declaracao[$declaracoes.ctx] )+ ) ;
    public final void declaracoes(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:62:2: ( ^( DECLARACOES ( declaracao[$declaracoes.ctx] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:62:4: ^( DECLARACOES ( declaracao[$declaracoes.ctx] )+ )
            {
            match(input,DECLARACOES,FOLLOW_DECLARACOES_in_declaracoes167); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:62:18: ( declaracao[$declaracoes.ctx] )+
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
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:62:18: declaracao[$declaracoes.ctx]
            	    {
            	    pushFollow(FOLLOW_declaracao_in_declaracoes169);
            	    declaracao(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:66:1: declaracao[String ctx] : ^( DECLARACAO tipo ID ) ;
    public final void declaracao(String ctx) throws RecognitionException {
        CommonTree ID3=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:67:2: ( ^( DECLARACAO tipo ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:67:4: ^( DECLARACAO tipo ID )
            {
            match(input,DECLARACAO,FOLLOW_DECLARACAO_in_declaracao189); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tipo_in_declaracao191);
            tipo();

            state._fsp--;

            ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_declaracao193); 

            		if(! this.global_ids.contains(new Pair<String, String>((ID3!=null?ID3.getText():null), ctx), (ID3!=null?ID3.getLine():0), (ID3!=null?ID3.getCharPositionInLine():0))){
            			emitErrorMessage("ERROR");
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
    // $ANTLR end "declaracao"


    // $ANTLR start "tipo"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:76:1: tipo : ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO );
    public final void tipo() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:77:2: ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:
            {
            if ( (input.LA(1)>=TD_INT && input.LA(1)<=TD_VAZIO) ) {
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
    // $ANTLR end "tipo"


    // $ANTLR start "statements"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:83:1: statements[String ctx] : ^( STATEMENTS ( statement[$statements.ctx] )+ ) ;
    public final void statements(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:84:2: ( ^( STATEMENTS ( statement[$statements.ctx] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:84:4: ^( STATEMENTS ( statement[$statements.ctx] )+ )
            {
            match(input,STATEMENTS,FOLLOW_STATEMENTS_in_statements244); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:84:17: ( statement[$statements.ctx] )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==INVOCACAO||LA5_0==RETURN||(LA5_0>=WRITE && LA5_0<=IF)||LA5_0==WHILE||LA5_0==44) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:84:17: statement[$statements.ctx]
            	    {
            	    pushFollow(FOLLOW_statement_in_statements246);
            	    statement(ctx);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:88:1: statement[String ctx] : ( atribuicao[$statement.ctx] | read | write[$statement.ctx] | ifs[$statement.ctx] | whiles[$statement.ctx] | invocacao[$statement.ctx] | retorna[$statement.ctx] );
    public final void statement(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:89:2: ( atribuicao[$statement.ctx] | read | write[$statement.ctx] | ifs[$statement.ctx] | whiles[$statement.ctx] | invocacao[$statement.ctx] | retorna[$statement.ctx] )
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
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:89:4: atribuicao[$statement.ctx]
                    {
                    pushFollow(FOLLOW_atribuicao_in_statement264);
                    atribuicao(ctx);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:90:4: read
                    {
                    pushFollow(FOLLOW_read_in_statement271);
                    read();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:91:4: write[$statement.ctx]
                    {
                    pushFollow(FOLLOW_write_in_statement276);
                    write(ctx);

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:92:4: ifs[$statement.ctx]
                    {
                    pushFollow(FOLLOW_ifs_in_statement283);
                    ifs(ctx);

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:93:4: whiles[$statement.ctx]
                    {
                    pushFollow(FOLLOW_whiles_in_statement290);
                    whiles(ctx);

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:94:4: invocacao[$statement.ctx]
                    {
                    pushFollow(FOLLOW_invocacao_in_statement297);
                    invocacao(ctx);

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:95:4: retorna[$statement.ctx]
                    {
                    pushFollow(FOLLOW_retorna_in_statement304);
                    retorna(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:98:1: retorna[String ctx] : ^( RETURN expr[$retorna.ctx] ) ;
    public final void retorna(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:99:2: ( ^( RETURN expr[$retorna.ctx] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:99:5: ^( RETURN expr[$retorna.ctx] )
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorna322); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_retorna324);
            expr(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:102:1: invocacao[String ctx] returns [String tipo] : ^( INVOCACAO ID ( args[$invocacao.ctx] )? ) ;
    public final String invocacao(String ctx) throws RecognitionException {
        String tipo = null;

        CommonTree ID4=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:103:2: ( ^( INVOCACAO ID ( args[$invocacao.ctx] )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:103:5: ^( INVOCACAO ID ( args[$invocacao.ctx] )? )
            {
            match(input,INVOCACAO,FOLLOW_INVOCACAO_in_invocacao345); 

            match(input, Token.DOWN, null); 
            ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_invocacao347); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:103:20: ( args[$invocacao.ctx] )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ARGS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:103:20: args[$invocacao.ctx]
                    {
                    pushFollow(FOLLOW_args_in_invocacao349);
                    args(ctx);

                    state._fsp--;


                    }
                    break;

            }


            		Pair<String, String> p = new Pair<String, String>((ID4!=null?ID4.getText():null), "");
            		if(global_ids.contains(p)){
            			tipo = global_ids.getType(p);	
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
        return tipo;
    }
    // $ANTLR end "invocacao"


    // $ANTLR start "args"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:113:1: args[String ctx] : ^( ARGS ( expr[$args.ctx] )+ ) ;
    public final void args(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:114:2: ( ^( ARGS ( expr[$args.ctx] )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:114:5: ^( ARGS ( expr[$args.ctx] )+ )
            {
            match(input,ARGS,FOLLOW_ARGS_in_args373); 

            match(input, Token.DOWN, null); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:114:12: ( expr[$args.ctx] )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==INVOCACAO||LA8_0==ID||(LA8_0>=STRING && LA8_0<=FALSE)||(LA8_0>=45 && LA8_0<=58)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:114:12: expr[$args.ctx]
            	    {
            	    pushFollow(FOLLOW_expr_in_args375);
            	    expr(ctx);

            	    state._fsp--;


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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:117:1: atribuicao[String ctx] : ^( '=' ID expr[$atribuicao.ctx] ) ;
    public final void atribuicao(String ctx) throws RecognitionException {
        CommonTree ID5=null;
        String expr6 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:118:2: ( ^( '=' ID expr[$atribuicao.ctx] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:118:4: ^( '=' ID expr[$atribuicao.ctx] )
            {
            match(input,44,FOLLOW_44_in_atribuicao392); 

            match(input, Token.DOWN, null); 
            ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_atribuicao394); 
            pushFollow(FOLLOW_expr_in_atribuicao396);
            expr6=expr(ctx);

            state._fsp--;


            		Pair<String, String> p = new Pair<String, String>((ID5!=null?ID5.getText():null), ctx) ;
            		if(global_ids.contains(p)){
            			String tipo_var = global_ids.getType(p);
            			if(! tipo_var.equals(expr6))  {
            				emitErrorMessage("Error " + (ID5!=null?ID5.getLine():0) + ":" + (ID5!=null?ID5.getCharPositionInLine():0) + " Expecting " + 
            							tipo_var + ", found " + expr6 ) ;
            			}
            		}
            		else {
            			emitErrorMessage("Error " + (ID5!=null?ID5.getLine():0) + ":" + (ID5!=null?ID5.getCharPositionInLine():0) + " Variable " 
            						+ (ID5!=null?ID5.getText():null) + "not in scope!") ;
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
    // $ANTLR end "atribuicao"


    // $ANTLR start "write"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:136:1: write[String ctx] : ^( WRITE expr[$write.ctx] ) ;
    public final void write(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:137:2: ( ^( WRITE expr[$write.ctx] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:137:4: ^( WRITE expr[$write.ctx] )
            {
            match(input,WRITE,FOLLOW_WRITE_in_write417); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_write419);
            expr(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:140:1: read : ^( READ ID ) ;
    public final void read() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:141:2: ( ^( READ ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:141:4: ^( READ ID )
            {
            match(input,READ,FOLLOW_READ_in_read434); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_read436); 

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:145:1: ifs[String ctx] : ^( IF expr[$ifs.ctx] bloco[$ifs.ctx] ( bloco[$ifs.ctx] )? ) ;
    public final void ifs(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:146:2: ( ^( IF expr[$ifs.ctx] bloco[$ifs.ctx] ( bloco[$ifs.ctx] )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:146:4: ^( IF expr[$ifs.ctx] bloco[$ifs.ctx] ( bloco[$ifs.ctx] )? )
            {
            match(input,IF,FOLLOW_IF_in_ifs454); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_ifs456);
            expr(ctx);

            state._fsp--;

            pushFollow(FOLLOW_bloco_in_ifs459);
            bloco(ctx);

            state._fsp--;

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:146:40: ( bloco[$ifs.ctx] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==STATEMENTS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:146:41: bloco[$ifs.ctx]
                    {
                    pushFollow(FOLLOW_bloco_in_ifs463);
                    bloco(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:149:1: whiles[String ctx] : ^( WHILE expr[$whiles.ctx] bloco[$whiles.ctx] ) ;
    public final void whiles(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:150:2: ( ^( WHILE expr[$whiles.ctx] bloco[$whiles.ctx] ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:150:4: ^( WHILE expr[$whiles.ctx] bloco[$whiles.ctx] )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whiles482); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_whiles484);
            expr(ctx);

            state._fsp--;

            pushFollow(FOLLOW_bloco_in_whiles487);
            bloco(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:153:1: bloco[String ctx] : statements[$bloco.ctx] ;
    public final void bloco(String ctx) throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:154:2: ( statements[$bloco.ctx] )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:154:4: statements[$bloco.ctx]
            {
            pushFollow(FOLLOW_statements_in_bloco502);
            statements(ctx);

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
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:158:1: expr[String ctx] returns [String tipo] : ( ^( '||' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '&&' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '==' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '-' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '+' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '*' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '/' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '%' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '>' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '<' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '<=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '>=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '!=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '!' e1= expr[_ctx] ) | factor[_ctx] );
    public final String expr(String ctx) throws RecognitionException {
        String tipo = null;

        String e1 = null;

        String e2 = null;

        String factor7 = null;



        	String _ctx = ctx;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:162:2: ( ^( '||' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '&&' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '==' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '-' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '+' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '*' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '/' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '%' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '>' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '<' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '<=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '>=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '!=' e1= expr[_ctx] e2= expr[_ctx] ) | ^( '!' e1= expr[_ctx] ) | factor[_ctx] )
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
            case 56:
                {
                alt10=3;
                }
                break;
            case 45:
                {
                alt10=4;
                }
                break;
            case 46:
                {
                alt10=5;
                }
                break;
            case 47:
                {
                alt10=6;
                }
                break;
            case 48:
                {
                alt10=7;
                }
                break;
            case 49:
                {
                alt10=8;
                }
                break;
            case 52:
                {
                alt10=9;
                }
                break;
            case 53:
                {
                alt10=10;
                }
                break;
            case 55:
                {
                alt10=11;
                }
                break;
            case 54:
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
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:162:4: ^( '||' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,50,FOLLOW_50_in_expr528); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr532);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr537);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:163:4: ^( '&&' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,51,FOLLOW_51_in_expr548); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr552);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr557);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:164:4: ^( '==' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,56,FOLLOW_56_in_expr568); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr572);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr577);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:165:4: ^( '-' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,45,FOLLOW_45_in_expr588); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr592);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr597);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "int" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:166:4: ^( '+' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,46,FOLLOW_46_in_expr610); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr614);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr619);
                    e2=expr(_ctx);

                    state._fsp--;


                    		if(e1.equals("int") && e2.equals("int")) {
                    			tipo = e1;		
                    		}
                    		else {
                    			tipo = "string" ;
                    		}
                    	

                    match(input, Token.UP, null); 

                    }
                    break;
                case 6 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:176:4: ^( '*' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,47,FOLLOW_47_in_expr634); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr638);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr643);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "int" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 7 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:177:4: ^( '/' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,48,FOLLOW_48_in_expr655); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr659);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr664);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "int" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 8 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:178:4: ^( '%' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,49,FOLLOW_49_in_expr676); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr680);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr685);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "int" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 9 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:179:4: ^( '>' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,52,FOLLOW_52_in_expr697); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr701);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr706);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:180:4: ^( '<' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,53,FOLLOW_53_in_expr718); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr722);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr727);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:181:4: ^( '<=' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,55,FOLLOW_55_in_expr739); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr743);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr748);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:182:4: ^( '>=' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,54,FOLLOW_54_in_expr759); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr763);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr768);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:183:4: ^( '!=' e1= expr[_ctx] e2= expr[_ctx] )
                    {
                    match(input,57,FOLLOW_57_in_expr779); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr783);
                    e1=expr(_ctx);

                    state._fsp--;

                    pushFollow(FOLLOW_expr_in_expr788);
                    e2=expr(_ctx);

                    state._fsp--;

                    tipo = "bool" ;

                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:184:4: ^( '!' e1= expr[_ctx] )
                    {
                    match(input,58,FOLLOW_58_in_expr799); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr803);
                    e1=expr(_ctx);

                    state._fsp--;


                    		if(e1.equals("bool")){
                    			tipo = e1;
                    		}
                    		else {
                    			tipo = "void" ;
                    			emitErrorMessage("Error: L:C Expecting bool, found " + e1); 
                    		}
                    	

                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:195:4: factor[_ctx]
                    {
                    pushFollow(FOLLOW_factor_in_expr820);
                    factor7=factor(_ctx);

                    state._fsp--;

                    tipo = factor7; 

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
        return tipo;
    }
    // $ANTLR end "expr"


    // $ANTLR start "factor"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:198:1: factor[String ctx] returns [String tipo] : ( ID | constante | invocacao[$factor.ctx] );
    public final String factor(String ctx) throws RecognitionException {
        String tipo = null;

        CommonTree ID8=null;
        String constante9 = null;

        String invocacao10 = null;


        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:199:2: ( ID | constante | invocacao[$factor.ctx] )
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
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:199:4: ID
                    {
                    ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_factor841); 

                    		Pair p = new Pair<String, String>((ID8!=null?ID8.getText():null), ctx);
                    		if(global_ids.contains(p)){
                    			tipo = global_ids.getType(p);
                    		}
                    		else {
                    			tipo = "void" ;
                    		}
                    	
                    	

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:210:4: constante
                    {
                    pushFollow(FOLLOW_constante_in_factor852);
                    constante9=constante();

                    state._fsp--;

                    tipo = constante9; 

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:211:4: invocacao[$factor.ctx]
                    {
                    pushFollow(FOLLOW_invocacao_in_factor859);
                    invocacao10=invocacao(ctx);

                    state._fsp--;

                     tipo = invocacao10; 

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
        return tipo;
    }
    // $ANTLR end "factor"


    // $ANTLR start "constante"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:214:1: constante returns [String tipo] : ( STRING | INT | TRUE | FALSE );
    public final String constante() throws RecognitionException {
        String tipo = null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:215:2: ( STRING | INT | TRUE | FALSE )
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
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:215:4: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_constante878); 
                    tipo = "string"; 

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:216:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_constante886); 
                    tipo = "int"; 

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:217:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_constante894); 
                    tipo = "bool"; 

                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22_29/cmb_lang/Cmb/resources/CmbTG_ver_sem.g:218:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_constante901); 
                    tipo = "bool"; 

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
        return tipo;
    }
    // $ANTLR end "constante"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMA_in_programa56 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funcao_in_programa58 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_FUNCAO_in_funcao74 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cabecalho_in_funcao76 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_corpo_funcao_in_funcao78 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAEBECALHO_in_cabecalho98 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_cabecalho100 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_cabecalho102 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_argumentos_in_cabecalho104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTOS_in_argumentos127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_argumentos129 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_CORPO_in_corpo_funcao146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracoes_in_corpo_funcao148 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_statements_in_corpo_funcao151 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLARACOES_in_declaracoes167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaracao_in_declaracoes169 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_DECLARACAO_in_declaracao189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_in_declaracao191 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_declaracao193 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_tipo0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENTS_in_statements244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statements246 = new BitSet(new long[]{0x0000100005C14008L});
    public static final BitSet FOLLOW_atribuicao_in_statement264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_statement276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifs_in_statement283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whiles_in_statement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_statement297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorna_in_statement304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorna322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_retorna324 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INVOCACAO_in_invocacao345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_invocacao347 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_args_in_invocacao349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_args373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_args375 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_44_in_atribuicao392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atribuicao394 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_atribuicao396 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WRITE_in_write417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_write419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_read436 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifs454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_ifs456 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_ifs459 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_bloco_in_ifs463 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whiles482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_whiles484 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bloco_in_whiles487 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statements_in_bloco502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expr528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr532 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_51_in_expr548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr552 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_expr568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr572 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expr588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr592 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_expr610 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr614 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr619 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_47_in_expr634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr638 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_expr655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr659 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr664 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_49_in_expr676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr680 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_expr697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr701 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_expr718 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr722 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_expr739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr743 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr748 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_expr759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr763 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_expr779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr783 = new BitSet(new long[]{0x07FFE00078024008L});
    public static final BitSet FOLLOW_expr_in_expr788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_expr799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr803 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_factor_in_expr820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_factor841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constante_in_factor852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_factor859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constante878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_constante886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_constante894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_constante901 = new BitSet(new long[]{0x0000000000000002L});

}