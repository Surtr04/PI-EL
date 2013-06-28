// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g 2013-04-22 12:01:44

	package language;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class CmbParser extends Parser {
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
    // delegators


        public CmbParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CmbParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CmbParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g"; }


    public static class programa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "programa"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:36:1: programa : ( funcao )+ -> ^( PROGRAMA ( funcao )+ ) ;
    public final CmbParser.programa_return programa() throws RecognitionException {
        CmbParser.programa_return retval = new CmbParser.programa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.funcao_return funcao1 = null;


        RewriteRuleSubtreeStream stream_funcao=new RewriteRuleSubtreeStream(adaptor,"rule funcao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:37:2: ( ( funcao )+ -> ^( PROGRAMA ( funcao )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:37:4: ( funcao )+
            {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:37:4: ( funcao )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=TD_INT && LA1_0<=TD_VAZIO)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:0:0: funcao
            	    {
            	    pushFollow(FOLLOW_funcao_in_programa107);
            	    funcao1=funcao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_funcao.add(funcao1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: funcao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 38:2: -> ^( PROGRAMA ( funcao )+ )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:38:5: ^( PROGRAMA ( funcao )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAMA, "PROGRAMA"), root_1);

                if ( !(stream_funcao.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_funcao.hasNext() ) {
                    adaptor.addChild(root_1, stream_funcao.nextTree());

                }
                stream_funcao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "programa"

    public static class funcao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:41:1: funcao : cabecalho '{' corpo_funcao '}' -> ^( FUNCAO cabecalho corpo_funcao ) ;
    public final CmbParser.funcao_return funcao() throws RecognitionException {
        CmbParser.funcao_return retval = new CmbParser.funcao_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal3=null;
        Token char_literal5=null;
        CmbParser.cabecalho_return cabecalho2 = null;

        CmbParser.corpo_funcao_return corpo_funcao4 = null;


        Object char_literal3_tree=null;
        Object char_literal5_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_cabecalho=new RewriteRuleSubtreeStream(adaptor,"rule cabecalho");
        RewriteRuleSubtreeStream stream_corpo_funcao=new RewriteRuleSubtreeStream(adaptor,"rule corpo_funcao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:42:2: ( cabecalho '{' corpo_funcao '}' -> ^( FUNCAO cabecalho corpo_funcao ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:42:4: cabecalho '{' corpo_funcao '}'
            {
            pushFollow(FOLLOW_cabecalho_in_funcao129);
            cabecalho2=cabecalho();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cabecalho.add(cabecalho2.getTree());
            char_literal3=(Token)match(input,38,FOLLOW_38_in_funcao131); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(char_literal3);

            pushFollow(FOLLOW_corpo_funcao_in_funcao133);
            corpo_funcao4=corpo_funcao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_corpo_funcao.add(corpo_funcao4.getTree());
            char_literal5=(Token)match(input,39,FOLLOW_39_in_funcao135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(char_literal5);



            // AST REWRITE
            // elements: cabecalho, corpo_funcao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 43:2: -> ^( FUNCAO cabecalho corpo_funcao )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:43:5: ^( FUNCAO cabecalho corpo_funcao )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCAO, "FUNCAO"), root_1);

                adaptor.addChild(root_1, stream_cabecalho.nextTree());
                adaptor.addChild(root_1, stream_corpo_funcao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funcao"

    public static class cabecalho_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cabecalho"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:46:1: cabecalho : tipo ID '(' ( argumentos )? ')' -> ^( CAEBECALHO tipo ID ( argumentos )? ) ;
    public final CmbParser.cabecalho_return cabecalho() throws RecognitionException {
        CmbParser.cabecalho_return retval = new CmbParser.cabecalho_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID7=null;
        Token char_literal8=null;
        Token char_literal10=null;
        CmbParser.tipo_return tipo6 = null;

        CmbParser.argumentos_return argumentos9 = null;


        Object ID7_tree=null;
        Object char_literal8_tree=null;
        Object char_literal10_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_argumentos=new RewriteRuleSubtreeStream(adaptor,"rule argumentos");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:47:2: ( tipo ID '(' ( argumentos )? ')' -> ^( CAEBECALHO tipo ID ( argumentos )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:47:4: tipo ID '(' ( argumentos )? ')'
            {
            pushFollow(FOLLOW_tipo_in_cabecalho158);
            tipo6=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo6.getTree());
            ID7=(Token)match(input,ID,FOLLOW_ID_in_cabecalho160); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID7);

            char_literal8=(Token)match(input,40,FOLLOW_40_in_cabecalho162); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal8);

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:47:16: ( argumentos )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=TD_INT && LA2_0<=TD_VAZIO)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:0:0: argumentos
                    {
                    pushFollow(FOLLOW_argumentos_in_cabecalho164);
                    argumentos9=argumentos();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argumentos.add(argumentos9.getTree());

                    }
                    break;

            }

            char_literal10=(Token)match(input,41,FOLLOW_41_in_cabecalho167); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal10);



            // AST REWRITE
            // elements: ID, tipo, argumentos
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 48:2: -> ^( CAEBECALHO tipo ID ( argumentos )? )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:48:5: ^( CAEBECALHO tipo ID ( argumentos )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAEBECALHO, "CAEBECALHO"), root_1);

                adaptor.addChild(root_1, stream_tipo.nextTree());
                adaptor.addChild(root_1, stream_ID.nextNode());
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:48:26: ( argumentos )?
                if ( stream_argumentos.hasNext() ) {
                    adaptor.addChild(root_1, stream_argumentos.nextTree());

                }
                stream_argumentos.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cabecalho"

    public static class argumentos_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argumentos"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:51:1: argumentos : declaracao ( ',' declaracao )* -> ^( ARGUMENTOS ( declaracao )+ ) ;
    public final CmbParser.argumentos_return argumentos() throws RecognitionException {
        CmbParser.argumentos_return retval = new CmbParser.argumentos_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal12=null;
        CmbParser.declaracao_return declaracao11 = null;

        CmbParser.declaracao_return declaracao13 = null;


        Object char_literal12_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleSubtreeStream stream_declaracao=new RewriteRuleSubtreeStream(adaptor,"rule declaracao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:52:2: ( declaracao ( ',' declaracao )* -> ^( ARGUMENTOS ( declaracao )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:52:4: declaracao ( ',' declaracao )*
            {
            pushFollow(FOLLOW_declaracao_in_argumentos192);
            declaracao11=declaracao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declaracao.add(declaracao11.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:52:15: ( ',' declaracao )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==42) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:52:16: ',' declaracao
            	    {
            	    char_literal12=(Token)match(input,42,FOLLOW_42_in_argumentos195); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_42.add(char_literal12);

            	    pushFollow(FOLLOW_declaracao_in_argumentos197);
            	    declaracao13=declaracao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_declaracao.add(declaracao13.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);



            // AST REWRITE
            // elements: declaracao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 53:2: -> ^( ARGUMENTOS ( declaracao )+ )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:53:5: ^( ARGUMENTOS ( declaracao )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTOS, "ARGUMENTOS"), root_1);

                if ( !(stream_declaracao.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_declaracao.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaracao.nextTree());

                }
                stream_declaracao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argumentos"

    public static class corpo_funcao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "corpo_funcao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:56:1: corpo_funcao : declaracoes statements -> ^( CORPO declaracoes statements ) ;
    public final CmbParser.corpo_funcao_return corpo_funcao() throws RecognitionException {
        CmbParser.corpo_funcao_return retval = new CmbParser.corpo_funcao_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.declaracoes_return declaracoes14 = null;

        CmbParser.statements_return statements15 = null;


        RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
        RewriteRuleSubtreeStream stream_declaracoes=new RewriteRuleSubtreeStream(adaptor,"rule declaracoes");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:57:2: ( declaracoes statements -> ^( CORPO declaracoes statements ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:57:4: declaracoes statements
            {
            pushFollow(FOLLOW_declaracoes_in_corpo_funcao220);
            declaracoes14=declaracoes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declaracoes.add(declaracoes14.getTree());
            pushFollow(FOLLOW_statements_in_corpo_funcao222);
            statements15=statements();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statements.add(statements15.getTree());


            // AST REWRITE
            // elements: statements, declaracoes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 58:2: -> ^( CORPO declaracoes statements )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:58:5: ^( CORPO declaracoes statements )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CORPO, "CORPO"), root_1);

                adaptor.addChild(root_1, stream_declaracoes.nextTree());
                adaptor.addChild(root_1, stream_statements.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "corpo_funcao"

    public static class declaracoes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracoes"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:61:1: declaracoes : ( declaracao ';' )+ -> ^( DECLARACOES ( declaracao )+ ) ;
    public final CmbParser.declaracoes_return declaracoes() throws RecognitionException {
        CmbParser.declaracoes_return retval = new CmbParser.declaracoes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal17=null;
        CmbParser.declaracao_return declaracao16 = null;


        Object char_literal17_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleSubtreeStream stream_declaracao=new RewriteRuleSubtreeStream(adaptor,"rule declaracao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:62:2: ( ( declaracao ';' )+ -> ^( DECLARACOES ( declaracao )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:62:4: ( declaracao ';' )+
            {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:62:4: ( declaracao ';' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TD_INT && LA4_0<=TD_VAZIO)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:62:5: declaracao ';'
            	    {
            	    pushFollow(FOLLOW_declaracao_in_declaracoes245);
            	    declaracao16=declaracao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_declaracao.add(declaracao16.getTree());
            	    char_literal17=(Token)match(input,43,FOLLOW_43_in_declaracoes247); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_43.add(char_literal17);


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);



            // AST REWRITE
            // elements: declaracao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 63:2: -> ^( DECLARACOES ( declaracao )+ )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:63:5: ^( DECLARACOES ( declaracao )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARACOES, "DECLARACOES"), root_1);

                if ( !(stream_declaracao.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_declaracao.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaracao.nextTree());

                }
                stream_declaracao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracoes"

    public static class declaracao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:66:1: declaracao : tipo ID -> ^( DECLARACAO tipo ID ) ;
    public final CmbParser.declaracao_return declaracao() throws RecognitionException {
        CmbParser.declaracao_return retval = new CmbParser.declaracao_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID19=null;
        CmbParser.tipo_return tipo18 = null;


        Object ID19_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:67:2: ( tipo ID -> ^( DECLARACAO tipo ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:67:4: tipo ID
            {
            pushFollow(FOLLOW_tipo_in_declaracao271);
            tipo18=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo18.getTree());
            ID19=(Token)match(input,ID,FOLLOW_ID_in_declaracao273); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID19);



            // AST REWRITE
            // elements: ID, tipo
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 68:2: -> ^( DECLARACAO tipo ID )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:68:5: ^( DECLARACAO tipo ID )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARACAO, "DECLARACAO"), root_1);

                adaptor.addChild(root_1, stream_tipo.nextTree());
                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracao"

    public static class tipo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tipo"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:71:1: tipo : ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO );
    public final CmbParser.tipo_return tipo() throws RecognitionException {
        CmbParser.tipo_return retval = new CmbParser.tipo_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set20=null;

        Object set20_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:72:2: ( TD_INT | TD_BOOL | TD_STRING | TD_VAZIO )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            {
            root_0 = (Object)adaptor.nil();

            set20=(Token)input.LT(1);
            if ( (input.LA(1)>=TD_INT && input.LA(1)<=TD_VAZIO) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set20));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tipo"

    public static class statements_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statements"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:78:1: statements : ( statement )+ -> ^( STATEMENTS ( statement )+ ) ;
    public final CmbParser.statements_return statements() throws RecognitionException {
        CmbParser.statements_return retval = new CmbParser.statements_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.statement_return statement21 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:79:2: ( ( statement )+ -> ^( STATEMENTS ( statement )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:79:4: ( statement )+
            {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:79:4: ( statement )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RETURN && LA5_0<=ID)||(LA5_0>=WRITE && LA5_0<=IF)||LA5_0==WHILE) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statements328);
            	    statement21=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement21.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 80:2: -> ^( STATEMENTS ( statement )+ )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:80:5: ^( STATEMENTS ( statement )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_1);

                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statements"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:84:1: statement : ( atribuicao ';' -> atribuicao | read ';' -> read | write ';' -> write | ifs -> ifs | whiles -> whiles | invocacao ';' -> invocacao | retorna ';' -> retorna );
    public final CmbParser.statement_return statement() throws RecognitionException {
        CmbParser.statement_return retval = new CmbParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token char_literal25=null;
        Token char_literal27=null;
        Token char_literal31=null;
        Token char_literal33=null;
        CmbParser.atribuicao_return atribuicao22 = null;

        CmbParser.read_return read24 = null;

        CmbParser.write_return write26 = null;

        CmbParser.ifs_return ifs28 = null;

        CmbParser.whiles_return whiles29 = null;

        CmbParser.invocacao_return invocacao30 = null;

        CmbParser.retorna_return retorna32 = null;


        Object char_literal23_tree=null;
        Object char_literal25_tree=null;
        Object char_literal27_tree=null;
        Object char_literal31_tree=null;
        Object char_literal33_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleSubtreeStream stream_atribuicao=new RewriteRuleSubtreeStream(adaptor,"rule atribuicao");
        RewriteRuleSubtreeStream stream_write=new RewriteRuleSubtreeStream(adaptor,"rule write");
        RewriteRuleSubtreeStream stream_retorna=new RewriteRuleSubtreeStream(adaptor,"rule retorna");
        RewriteRuleSubtreeStream stream_read=new RewriteRuleSubtreeStream(adaptor,"rule read");
        RewriteRuleSubtreeStream stream_whiles=new RewriteRuleSubtreeStream(adaptor,"rule whiles");
        RewriteRuleSubtreeStream stream_ifs=new RewriteRuleSubtreeStream(adaptor,"rule ifs");
        RewriteRuleSubtreeStream stream_invocacao=new RewriteRuleSubtreeStream(adaptor,"rule invocacao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:85:2: ( atribuicao ';' -> atribuicao | read ';' -> read | write ';' -> write | ifs -> ifs | whiles -> whiles | invocacao ';' -> invocacao | retorna ';' -> retorna )
            int alt6=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==44) ) {
                    alt6=1;
                }
                else if ( (LA6_1==40) ) {
                    alt6=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
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
            case RETURN:
                {
                alt6=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:85:4: atribuicao ';'
                    {
                    pushFollow(FOLLOW_atribuicao_in_statement352);
                    atribuicao22=atribuicao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atribuicao.add(atribuicao22.getTree());
                    char_literal23=(Token)match(input,43,FOLLOW_43_in_statement354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal23);



                    // AST REWRITE
                    // elements: atribuicao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:20: -> atribuicao
                    {
                        adaptor.addChild(root_0, stream_atribuicao.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:86:4: read ';'
                    {
                    pushFollow(FOLLOW_read_in_statement364);
                    read24=read();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_read.add(read24.getTree());
                    char_literal25=(Token)match(input,43,FOLLOW_43_in_statement366); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal25);



                    // AST REWRITE
                    // elements: read
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 86:14: -> read
                    {
                        adaptor.addChild(root_0, stream_read.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:87:4: write ';'
                    {
                    pushFollow(FOLLOW_write_in_statement376);
                    write26=write();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_write.add(write26.getTree());
                    char_literal27=(Token)match(input,43,FOLLOW_43_in_statement378); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal27);



                    // AST REWRITE
                    // elements: write
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 87:15: -> write
                    {
                        adaptor.addChild(root_0, stream_write.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:88:4: ifs
                    {
                    pushFollow(FOLLOW_ifs_in_statement388);
                    ifs28=ifs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ifs.add(ifs28.getTree());


                    // AST REWRITE
                    // elements: ifs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 88:10: -> ifs
                    {
                        adaptor.addChild(root_0, stream_ifs.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:89:4: whiles
                    {
                    pushFollow(FOLLOW_whiles_in_statement399);
                    whiles29=whiles();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_whiles.add(whiles29.getTree());


                    // AST REWRITE
                    // elements: whiles
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 89:13: -> whiles
                    {
                        adaptor.addChild(root_0, stream_whiles.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:90:4: invocacao ';'
                    {
                    pushFollow(FOLLOW_invocacao_in_statement410);
                    invocacao30=invocacao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_invocacao.add(invocacao30.getTree());
                    char_literal31=(Token)match(input,43,FOLLOW_43_in_statement412); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal31);



                    // AST REWRITE
                    // elements: invocacao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 90:18: -> invocacao
                    {
                        adaptor.addChild(root_0, stream_invocacao.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:91:4: retorna ';'
                    {
                    pushFollow(FOLLOW_retorna_in_statement421);
                    retorna32=retorna();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_retorna.add(retorna32.getTree());
                    char_literal33=(Token)match(input,43,FOLLOW_43_in_statement423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal33);



                    // AST REWRITE
                    // elements: retorna
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 91:16: -> retorna
                    {
                        adaptor.addChild(root_0, stream_retorna.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class retorna_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "retorna"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:94:1: retorna : RETURN expr -> ^( RETURN expr ) ;
    public final CmbParser.retorna_return retorna() throws RecognitionException {
        CmbParser.retorna_return retval = new CmbParser.retorna_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RETURN34=null;
        CmbParser.expr_return expr35 = null;


        Object RETURN34_tree=null;
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:95:2: ( RETURN expr -> ^( RETURN expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:95:4: RETURN expr
            {
            RETURN34=(Token)match(input,RETURN,FOLLOW_RETURN_in_retorna439); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RETURN.add(RETURN34);

            pushFollow(FOLLOW_expr_in_retorna441);
            expr35=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr35.getTree());


            // AST REWRITE
            // elements: RETURN, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 96:2: -> ^( RETURN expr )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:96:5: ^( RETURN expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "retorna"

    public static class invocacao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "invocacao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:99:1: invocacao : ID '(' ( args )? ')' -> ^( INVOCACAO ID ( args )? ) ;
    public final CmbParser.invocacao_return invocacao() throws RecognitionException {
        CmbParser.invocacao_return retval = new CmbParser.invocacao_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID36=null;
        Token char_literal37=null;
        Token char_literal39=null;
        CmbParser.args_return args38 = null;


        Object ID36_tree=null;
        Object char_literal37_tree=null;
        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_args=new RewriteRuleSubtreeStream(adaptor,"rule args");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:100:2: ( ID '(' ( args )? ')' -> ^( INVOCACAO ID ( args )? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:100:4: ID '(' ( args )? ')'
            {
            ID36=(Token)match(input,ID,FOLLOW_ID_in_invocacao461); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID36);

            char_literal37=(Token)match(input,40,FOLLOW_40_in_invocacao463); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal37);

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:100:11: ( args )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ID||(LA7_0>=STRING && LA7_0<=FALSE)||LA7_0==45||LA7_0==58) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:0:0: args
                    {
                    pushFollow(FOLLOW_args_in_invocacao465);
                    args38=args();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_args.add(args38.getTree());

                    }
                    break;

            }

            char_literal39=(Token)match(input,41,FOLLOW_41_in_invocacao468); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal39);



            // AST REWRITE
            // elements: ID, args
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 101:2: -> ^( INVOCACAO ID ( args )? )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:101:5: ^( INVOCACAO ID ( args )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INVOCACAO, "INVOCACAO"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:101:20: ( args )?
                if ( stream_args.hasNext() ) {
                    adaptor.addChild(root_1, stream_args.nextTree());

                }
                stream_args.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "invocacao"

    public static class args_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "args"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:104:1: args : expr ( ',' expr )* -> ^( ARGS ( expr )+ ) ;
    public final CmbParser.args_return args() throws RecognitionException {
        CmbParser.args_return retval = new CmbParser.args_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal41=null;
        CmbParser.expr_return expr40 = null;

        CmbParser.expr_return expr42 = null;


        Object char_literal41_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:105:2: ( expr ( ',' expr )* -> ^( ARGS ( expr )+ ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:105:4: expr ( ',' expr )*
            {
            pushFollow(FOLLOW_expr_in_args491);
            expr40=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr40.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:105:9: ( ',' expr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==42) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:105:11: ',' expr
            	    {
            	    char_literal41=(Token)match(input,42,FOLLOW_42_in_args495); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_42.add(char_literal41);

            	    pushFollow(FOLLOW_expr_in_args497);
            	    expr42=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expr.add(expr42.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 106:2: -> ^( ARGS ( expr )+ )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:106:5: ^( ARGS ( expr )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_1);

                if ( !(stream_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "args"

    public static class atribuicao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atribuicao"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:109:1: atribuicao : ID '=' expr -> ^( '=' ID expr ) ;
    public final CmbParser.atribuicao_return atribuicao() throws RecognitionException {
        CmbParser.atribuicao_return retval = new CmbParser.atribuicao_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID43=null;
        Token char_literal44=null;
        CmbParser.expr_return expr45 = null;


        Object ID43_tree=null;
        Object char_literal44_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:110:2: ( ID '=' expr -> ^( '=' ID expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:110:4: ID '=' expr
            {
            ID43=(Token)match(input,ID,FOLLOW_ID_in_atribuicao521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID43);

            char_literal44=(Token)match(input,44,FOLLOW_44_in_atribuicao523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal44);

            pushFollow(FOLLOW_expr_in_atribuicao525);
            expr45=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());


            // AST REWRITE
            // elements: ID, expr, 44
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 111:2: -> ^( '=' ID expr )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:111:5: ^( '=' ID expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_44.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atribuicao"

    public static class write_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "write"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:114:1: write : WRITE '(' expr ')' -> ^( WRITE expr ) ;
    public final CmbParser.write_return write() throws RecognitionException {
        CmbParser.write_return retval = new CmbParser.write_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WRITE46=null;
        Token char_literal47=null;
        Token char_literal49=null;
        CmbParser.expr_return expr48 = null;


        Object WRITE46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal49_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_WRITE=new RewriteRuleTokenStream(adaptor,"token WRITE");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:115:2: ( WRITE '(' expr ')' -> ^( WRITE expr ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:115:4: WRITE '(' expr ')'
            {
            WRITE46=(Token)match(input,WRITE,FOLLOW_WRITE_in_write547); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WRITE.add(WRITE46);

            char_literal47=(Token)match(input,40,FOLLOW_40_in_write549); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal47);

            pushFollow(FOLLOW_expr_in_write551);
            expr48=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr48.getTree());
            char_literal49=(Token)match(input,41,FOLLOW_41_in_write553); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal49);



            // AST REWRITE
            // elements: WRITE, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 116:2: -> ^( WRITE expr )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:116:5: ^( WRITE expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WRITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "write"

    public static class read_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "read"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:119:1: read : READ '(' ID ')' -> ^( READ ID ) ;
    public final CmbParser.read_return read() throws RecognitionException {
        CmbParser.read_return retval = new CmbParser.read_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token READ50=null;
        Token char_literal51=null;
        Token ID52=null;
        Token char_literal53=null;

        Object READ50_tree=null;
        Object char_literal51_tree=null;
        Object ID52_tree=null;
        Object char_literal53_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_READ=new RewriteRuleTokenStream(adaptor,"token READ");

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:120:2: ( READ '(' ID ')' -> ^( READ ID ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:120:4: READ '(' ID ')'
            {
            READ50=(Token)match(input,READ,FOLLOW_READ_in_read575); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_READ.add(READ50);

            char_literal51=(Token)match(input,40,FOLLOW_40_in_read577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal51);

            ID52=(Token)match(input,ID,FOLLOW_ID_in_read579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID52);

            char_literal53=(Token)match(input,41,FOLLOW_41_in_read581); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal53);



            // AST REWRITE
            // elements: READ, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 121:2: -> ^( READ ID )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:121:5: ^( READ ID )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_READ.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "read"

    public static class ifs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifs"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:125:1: ifs : IF '(' expr ')' b1= bloco ( ELSE b2= bloco )? -> ^( IF expr $b1 ( $b2)? ) ;
    public final CmbParser.ifs_return ifs() throws RecognitionException {
        CmbParser.ifs_return retval = new CmbParser.ifs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IF54=null;
        Token char_literal55=null;
        Token char_literal57=null;
        Token ELSE58=null;
        CmbParser.bloco_return b1 = null;

        CmbParser.bloco_return b2 = null;

        CmbParser.expr_return expr56 = null;


        Object IF54_tree=null;
        Object char_literal55_tree=null;
        Object char_literal57_tree=null;
        Object ELSE58_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_bloco=new RewriteRuleSubtreeStream(adaptor,"rule bloco");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:2: ( IF '(' expr ')' b1= bloco ( ELSE b2= bloco )? -> ^( IF expr $b1 ( $b2)? ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:4: IF '(' expr ')' b1= bloco ( ELSE b2= bloco )?
            {
            IF54=(Token)match(input,IF,FOLLOW_IF_in_ifs604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IF.add(IF54);

            char_literal55=(Token)match(input,40,FOLLOW_40_in_ifs606); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal55);

            pushFollow(FOLLOW_expr_in_ifs608);
            expr56=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr56.getTree());
            char_literal57=(Token)match(input,41,FOLLOW_41_in_ifs610); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal57);

            pushFollow(FOLLOW_bloco_in_ifs614);
            b1=bloco();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bloco.add(b1.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:29: ( ELSE b2= bloco )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                int LA9_1 = input.LA(2);

                if ( (synpred17_Cmb()) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:30: ELSE b2= bloco
                    {
                    ELSE58=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifs617); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELSE.add(ELSE58);

                    pushFollow(FOLLOW_bloco_in_ifs621);
                    b2=bloco();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bloco.add(b2.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IF, expr, b2, b1
            // token labels: 
            // rule labels: retval, b1, b2
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_b1=new RewriteRuleSubtreeStream(adaptor,"rule b1",b1!=null?b1.tree:null);
            RewriteRuleSubtreeStream stream_b2=new RewriteRuleSubtreeStream(adaptor,"rule b2",b2!=null?b2.tree:null);

            root_0 = (Object)adaptor.nil();
            // 127:2: -> ^( IF expr $b1 ( $b2)? )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:127:5: ^( IF expr $b1 ( $b2)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_b1.nextTree());
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:127:19: ( $b2)?
                if ( stream_b2.hasNext() ) {
                    adaptor.addChild(root_1, stream_b2.nextTree());

                }
                stream_b2.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifs"

    public static class whiles_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whiles"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:130:1: whiles : WHILE '(' expr ')' bloco -> ^( WHILE expr bloco ) ;
    public final CmbParser.whiles_return whiles() throws RecognitionException {
        CmbParser.whiles_return retval = new CmbParser.whiles_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHILE59=null;
        Token char_literal60=null;
        Token char_literal62=null;
        CmbParser.expr_return expr61 = null;

        CmbParser.bloco_return bloco63 = null;


        Object WHILE59_tree=null;
        Object char_literal60_tree=null;
        Object char_literal62_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_bloco=new RewriteRuleSubtreeStream(adaptor,"rule bloco");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:131:2: ( WHILE '(' expr ')' bloco -> ^( WHILE expr bloco ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:131:4: WHILE '(' expr ')' bloco
            {
            WHILE59=(Token)match(input,WHILE,FOLLOW_WHILE_in_whiles653); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE59);

            char_literal60=(Token)match(input,40,FOLLOW_40_in_whiles655); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal60);

            pushFollow(FOLLOW_expr_in_whiles657);
            expr61=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr61.getTree());
            char_literal62=(Token)match(input,41,FOLLOW_41_in_whiles659); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal62);

            pushFollow(FOLLOW_bloco_in_whiles661);
            bloco63=bloco();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bloco.add(bloco63.getTree());


            // AST REWRITE
            // elements: bloco, expr, WHILE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 132:2: -> ^( WHILE expr bloco )
            {
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:132:5: ^( WHILE expr bloco )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_bloco.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whiles"

    public static class bloco_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bloco"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:135:1: bloco : ( '{' statements '}' -> statements | statement -> ^( STATEMENTS statement ) );
    public final CmbParser.bloco_return bloco() throws RecognitionException {
        CmbParser.bloco_return retval = new CmbParser.bloco_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal64=null;
        Token char_literal66=null;
        CmbParser.statements_return statements65 = null;

        CmbParser.statement_return statement67 = null;


        Object char_literal64_tree=null;
        Object char_literal66_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:136:2: ( '{' statements '}' -> statements | statement -> ^( STATEMENTS statement ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==38) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=RETURN && LA10_0<=ID)||(LA10_0>=WRITE && LA10_0<=IF)||LA10_0==WHILE) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:136:4: '{' statements '}'
                    {
                    char_literal64=(Token)match(input,38,FOLLOW_38_in_bloco683); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal64);

                    pushFollow(FOLLOW_statements_in_bloco685);
                    statements65=statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statements.add(statements65.getTree());
                    char_literal66=(Token)match(input,39,FOLLOW_39_in_bloco687); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal66);



                    // AST REWRITE
                    // elements: statements
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 136:25: -> statements
                    {
                        adaptor.addChild(root_0, stream_statements.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:137:4: statement
                    {
                    pushFollow(FOLLOW_statement_in_bloco699);
                    statement67=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement67.getTree());


                    // AST REWRITE
                    // elements: statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 137:17: -> ^( STATEMENTS statement )
                    {
                        // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:137:21: ^( STATEMENTS statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_1);

                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bloco"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:140:1: expr : orExpr -> orExpr ;
    public final CmbParser.expr_return expr() throws RecognitionException {
        CmbParser.expr_return retval = new CmbParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.orExpr_return orExpr68 = null;


        RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:141:2: ( orExpr -> orExpr )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:141:4: orExpr
            {
            pushFollow(FOLLOW_orExpr_in_expr723);
            orExpr68=orExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orExpr.add(orExpr68.getTree());


            // AST REWRITE
            // elements: orExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 142:2: -> orExpr
            {
                adaptor.addChild(root_0, stream_orExpr.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:145:1: orExpr : andExpr ( opOr andExpr )* ;
    public final CmbParser.orExpr_return orExpr() throws RecognitionException {
        CmbParser.orExpr_return retval = new CmbParser.orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.andExpr_return andExpr69 = null;

        CmbParser.opOr_return opOr70 = null;

        CmbParser.andExpr_return andExpr71 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:146:2: ( andExpr ( opOr andExpr )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:146:4: andExpr ( opOr andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr741);
            andExpr69=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr69.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:146:12: ( opOr andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==50) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:146:13: opOr andExpr
            	    {
            	    pushFollow(FOLLOW_opOr_in_orExpr744);
            	    opOr70=opOr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opOr70.getTree(), root_0);
            	    pushFollow(FOLLOW_andExpr_in_orExpr747);
            	    andExpr71=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr71.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:149:1: andExpr : equalityExpr ( opAnd equalityExpr )* ;
    public final CmbParser.andExpr_return andExpr() throws RecognitionException {
        CmbParser.andExpr_return retval = new CmbParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.equalityExpr_return equalityExpr72 = null;

        CmbParser.opAnd_return opAnd73 = null;

        CmbParser.equalityExpr_return equalityExpr74 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:150:2: ( equalityExpr ( opAnd equalityExpr )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:150:4: equalityExpr ( opAnd equalityExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpr_in_andExpr762);
            equalityExpr72=equalityExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpr72.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:150:16: ( opAnd equalityExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==51) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:150:17: opAnd equalityExpr
            	    {
            	    pushFollow(FOLLOW_opAnd_in_andExpr764);
            	    opAnd73=opAnd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opAnd73.getTree(), root_0);
            	    pushFollow(FOLLOW_equalityExpr_in_andExpr767);
            	    equalityExpr74=equalityExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpr74.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class equalityExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:153:1: equalityExpr : additiveExpr ( opRel additiveExpr )* ;
    public final CmbParser.equalityExpr_return equalityExpr() throws RecognitionException {
        CmbParser.equalityExpr_return retval = new CmbParser.equalityExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.additiveExpr_return additiveExpr75 = null;

        CmbParser.opRel_return opRel76 = null;

        CmbParser.additiveExpr_return additiveExpr77 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:154:2: ( additiveExpr ( opRel additiveExpr )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:154:4: additiveExpr ( opRel additiveExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additiveExpr_in_equalityExpr782);
            additiveExpr75=additiveExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpr75.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:154:17: ( opRel additiveExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=52 && LA13_0<=57)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:154:18: opRel additiveExpr
            	    {
            	    pushFollow(FOLLOW_opRel_in_equalityExpr785);
            	    opRel76=opRel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opRel76.getTree(), root_0);
            	    pushFollow(FOLLOW_additiveExpr_in_equalityExpr788);
            	    additiveExpr77=additiveExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpr77.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpr"

    public static class additiveExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:158:1: additiveExpr : multiplicativeExpr ( opAdd multiplicativeExpr )* ;
    public final CmbParser.additiveExpr_return additiveExpr() throws RecognitionException {
        CmbParser.additiveExpr_return retval = new CmbParser.additiveExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.multiplicativeExpr_return multiplicativeExpr78 = null;

        CmbParser.opAdd_return opAdd79 = null;

        CmbParser.multiplicativeExpr_return multiplicativeExpr80 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:159:2: ( multiplicativeExpr ( opAdd multiplicativeExpr )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:159:4: multiplicativeExpr ( opAdd multiplicativeExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr803);
            multiplicativeExpr78=multiplicativeExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpr78.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:159:23: ( opAdd multiplicativeExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=45 && LA14_0<=46)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:159:24: opAdd multiplicativeExpr
            	    {
            	    pushFollow(FOLLOW_opAdd_in_additiveExpr806);
            	    opAdd79=opAdd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opAdd79.getTree(), root_0);
            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr809);
            	    multiplicativeExpr80=multiplicativeExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpr80.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "additiveExpr"

    public static class multiplicativeExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:162:1: multiplicativeExpr : notExpr ( opMul notExpr )* ;
    public final CmbParser.multiplicativeExpr_return multiplicativeExpr() throws RecognitionException {
        CmbParser.multiplicativeExpr_return retval = new CmbParser.multiplicativeExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.notExpr_return notExpr81 = null;

        CmbParser.opMul_return opMul82 = null;

        CmbParser.notExpr_return notExpr83 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:163:2: ( notExpr ( opMul notExpr )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:163:4: notExpr ( opMul notExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_notExpr_in_multiplicativeExpr824);
            notExpr81=notExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, notExpr81.getTree());
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:163:12: ( opMul notExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=47 && LA15_0<=49)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:163:13: opMul notExpr
            	    {
            	    pushFollow(FOLLOW_opMul_in_multiplicativeExpr827);
            	    opMul82=opMul();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opMul82.getTree(), root_0);
            	    pushFollow(FOLLOW_notExpr_in_multiplicativeExpr830);
            	    notExpr83=notExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, notExpr83.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpr"

    public static class notExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:166:1: notExpr : ( opNot )? negationExpr ;
    public final CmbParser.notExpr_return notExpr() throws RecognitionException {
        CmbParser.notExpr_return retval = new CmbParser.notExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        CmbParser.opNot_return opNot84 = null;

        CmbParser.negationExpr_return negationExpr85 = null;



        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:167:2: ( ( opNot )? negationExpr )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:167:4: ( opNot )? negationExpr
            {
            root_0 = (Object)adaptor.nil();

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:167:4: ( opNot )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==58) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:167:5: opNot
                    {
                    pushFollow(FOLLOW_opNot_in_notExpr846);
                    opNot84=opNot();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(opNot84.getTree(), root_0);

                    }
                    break;

            }

            pushFollow(FOLLOW_negationExpr_in_notExpr851);
            negationExpr85=negationExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, negationExpr85.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notExpr"

    public static class negationExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "negationExpr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:170:1: negationExpr : ( '-' )? factor ;
    public final CmbParser.negationExpr_return negationExpr() throws RecognitionException {
        CmbParser.negationExpr_return retval = new CmbParser.negationExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal86=null;
        CmbParser.factor_return factor87 = null;


        Object char_literal86_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:171:2: ( ( '-' )? factor )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:171:4: ( '-' )? factor
            {
            root_0 = (Object)adaptor.nil();

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:171:4: ( '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==45) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:171:5: '-'
                    {
                    char_literal86=(Token)match(input,45,FOLLOW_45_in_negationExpr863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (Object)adaptor.create(char_literal86);
                    root_0 = (Object)adaptor.becomeRoot(char_literal86_tree, root_0);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_factor_in_negationExpr868);
            factor87=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, factor87.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "negationExpr"

    public static class opAdd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opAdd"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:175:1: opAdd : ( '+' | '-' );
    public final CmbParser.opAdd_return opAdd() throws RecognitionException {
        CmbParser.opAdd_return retval = new CmbParser.opAdd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set88=null;

        Object set88_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:176:2: ( '+' | '-' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            {
            root_0 = (Object)adaptor.nil();

            set88=(Token)input.LT(1);
            if ( (input.LA(1)>=45 && input.LA(1)<=46) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set88));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opAdd"

    public static class opMul_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opMul"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:180:1: opMul : ( '*' | '/' | '%' );
    public final CmbParser.opMul_return opMul() throws RecognitionException {
        CmbParser.opMul_return retval = new CmbParser.opMul_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set89=null;

        Object set89_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:181:2: ( '*' | '/' | '%' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            {
            root_0 = (Object)adaptor.nil();

            set89=(Token)input.LT(1);
            if ( (input.LA(1)>=47 && input.LA(1)<=49) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set89));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opMul"

    public static class opOr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opOr"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:186:1: opOr : '||' ;
    public final CmbParser.opOr_return opOr() throws RecognitionException {
        CmbParser.opOr_return retval = new CmbParser.opOr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal90=null;

        Object string_literal90_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:186:5: ( '||' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:186:7: '||'
            {
            root_0 = (Object)adaptor.nil();

            string_literal90=(Token)match(input,50,FOLLOW_50_in_opOr926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal90_tree = (Object)adaptor.create(string_literal90);
            adaptor.addChild(root_0, string_literal90_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opOr"

    public static class opAnd_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opAnd"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:189:1: opAnd : '&&' ;
    public final CmbParser.opAnd_return opAnd() throws RecognitionException {
        CmbParser.opAnd_return retval = new CmbParser.opAnd_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal91=null;

        Object string_literal91_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:190:2: ( '&&' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:190:4: '&&'
            {
            root_0 = (Object)adaptor.nil();

            string_literal91=(Token)match(input,51,FOLLOW_51_in_opAnd940); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal91_tree = (Object)adaptor.create(string_literal91);
            adaptor.addChild(root_0, string_literal91_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opAnd"

    public static class opRel_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opRel"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:193:1: opRel : ( '>' | '<' | '>=' | '<=' | '==' | '!=' );
    public final CmbParser.opRel_return opRel() throws RecognitionException {
        CmbParser.opRel_return retval = new CmbParser.opRel_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set92=null;

        Object set92_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:194:2: ( '>' | '<' | '>=' | '<=' | '==' | '!=' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            {
            root_0 = (Object)adaptor.nil();

            set92=(Token)input.LT(1);
            if ( (input.LA(1)>=52 && input.LA(1)<=57) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set92));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opRel"

    public static class opNot_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "opNot"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:202:1: opNot : '!' ;
    public final CmbParser.opNot_return opNot() throws RecognitionException {
        CmbParser.opNot_return retval = new CmbParser.opNot_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal93=null;

        Object char_literal93_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:203:2: ( '!' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:203:4: '!'
            {
            root_0 = (Object)adaptor.nil();

            char_literal93=(Token)match(input,58,FOLLOW_58_in_opNot1003); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (Object)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "opNot"

    public static class factor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:206:1: factor : ( ID | constante -> constante | invocacao -> invocacao );
    public final CmbParser.factor_return factor() throws RecognitionException {
        CmbParser.factor_return retval = new CmbParser.factor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID94=null;
        CmbParser.constante_return constante95 = null;

        CmbParser.invocacao_return invocacao96 = null;


        Object ID94_tree=null;
        RewriteRuleSubtreeStream stream_constante=new RewriteRuleSubtreeStream(adaptor,"rule constante");
        RewriteRuleSubtreeStream stream_invocacao=new RewriteRuleSubtreeStream(adaptor,"rule invocacao");
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:207:2: ( ID | constante -> constante | invocacao -> invocacao )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==40) ) {
                    alt18=3;
                }
                else if ( (LA18_1==EOF||(LA18_1>=41 && LA18_1<=43)||(LA18_1>=45 && LA18_1<=57)) ) {
                    alt18=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA18_0>=STRING && LA18_0<=FALSE)) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:207:4: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    ID94=(Token)match(input,ID,FOLLOW_ID_in_factor1016); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID94_tree = (Object)adaptor.create(ID94);
                    adaptor.addChild(root_0, ID94_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:208:4: constante
                    {
                    pushFollow(FOLLOW_constante_in_factor1022);
                    constante95=constante();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constante.add(constante95.getTree());


                    // AST REWRITE
                    // elements: constante
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 208:15: -> constante
                    {
                        adaptor.addChild(root_0, stream_constante.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:209:4: invocacao
                    {
                    pushFollow(FOLLOW_invocacao_in_factor1033);
                    invocacao96=invocacao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_invocacao.add(invocacao96.getTree());


                    // AST REWRITE
                    // elements: invocacao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 209:15: -> invocacao
                    {
                        adaptor.addChild(root_0, stream_invocacao.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class constante_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constante"
    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:212:1: constante : ( STRING | INT | TRUE | FALSE );
    public final CmbParser.constante_return constante() throws RecognitionException {
        CmbParser.constante_return retval = new CmbParser.constante_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set97=null;

        Object set97_tree=null;

        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:213:2: ( STRING | INT | TRUE | FALSE )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            {
            root_0 = (Object)adaptor.nil();

            set97=(Token)input.LT(1);
            if ( (input.LA(1)>=STRING && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set97));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constante"

    // $ANTLR start synpred17_Cmb
    public final void synpred17_Cmb_fragment() throws RecognitionException {   
        CmbParser.bloco_return b2 = null;


        // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:30: ( ELSE b2= bloco )
        // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:126:30: ELSE b2= bloco
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred17_Cmb617); if (state.failed) return ;
        pushFollow(FOLLOW_bloco_in_synpred17_Cmb621);
        b2=bloco();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_Cmb

    // Delegated rules

    public final boolean synpred17_Cmb() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Cmb_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_funcao_in_programa107 = new BitSet(new long[]{0x00000000003C0002L});
    public static final BitSet FOLLOW_cabecalho_in_funcao129 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_funcao131 = new BitSet(new long[]{0x00000000003E0000L});
    public static final BitSet FOLLOW_corpo_funcao_in_funcao133 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_funcao135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_cabecalho158 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_cabecalho160 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_cabecalho162 = new BitSet(new long[]{0x00000200003E0000L});
    public static final BitSet FOLLOW_argumentos_in_cabecalho164 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_cabecalho167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracao_in_argumentos192 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_argumentos195 = new BitSet(new long[]{0x00000000003E0000L});
    public static final BitSet FOLLOW_declaracao_in_argumentos197 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_declaracoes_in_corpo_funcao220 = new BitSet(new long[]{0x0000000005C30000L});
    public static final BitSet FOLLOW_statements_in_corpo_funcao222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracao_in_declaracoes245 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_declaracoes247 = new BitSet(new long[]{0x00000000003E0002L});
    public static final BitSet FOLLOW_tipo_in_declaracao271 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_declaracao273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tipo0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statements328 = new BitSet(new long[]{0x0000000005C30002L});
    public static final BitSet FOLLOW_atribuicao_in_statement352 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement364 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_statement376 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifs_in_statement388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whiles_in_statement399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_statement410 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorna_in_statement421 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorna439 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_retorna441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_invocacao461 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_invocacao463 = new BitSet(new long[]{0x0400220078020000L});
    public static final BitSet FOLLOW_args_in_invocacao465 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_invocacao468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_args491 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_args495 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_args497 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ID_in_atribuicao521 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_atribuicao523 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_atribuicao525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_write547 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_write549 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_write551 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_write553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_read575 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_read577 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_read579 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_read581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifs604 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ifs606 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_ifs608 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ifs610 = new BitSet(new long[]{0x0000004005C30000L});
    public static final BitSet FOLLOW_bloco_in_ifs614 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ELSE_in_ifs617 = new BitSet(new long[]{0x0000004005C30000L});
    public static final BitSet FOLLOW_bloco_in_ifs621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whiles653 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_whiles655 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_expr_in_whiles657 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_whiles659 = new BitSet(new long[]{0x0000004005C30000L});
    public static final BitSet FOLLOW_bloco_in_whiles661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_bloco683 = new BitSet(new long[]{0x0000000005C30000L});
    public static final BitSet FOLLOW_statements_in_bloco685 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_bloco687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_bloco699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expr723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr741 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_opOr_in_orExpr744 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr747 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr762 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_opAnd_in_andExpr764 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr767 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_additiveExpr_in_equalityExpr782 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_opRel_in_equalityExpr785 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_additiveExpr_in_equalityExpr788 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr803 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_opAdd_in_additiveExpr806 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr809 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_notExpr_in_multiplicativeExpr824 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_opMul_in_multiplicativeExpr827 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_notExpr_in_multiplicativeExpr830 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_opNot_in_notExpr846 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_negationExpr_in_notExpr851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_negationExpr863 = new BitSet(new long[]{0x0400200078020000L});
    public static final BitSet FOLLOW_factor_in_negationExpr868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_opAdd0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_opMul0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_opOr926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_opAnd940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_opRel0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_opNot1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_factor1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constante_in_factor1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacao_in_factor1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constante0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred17_Cmb617 = new BitSet(new long[]{0x0000004005C30000L});
    public static final BitSet FOLLOW_bloco_in_synpred17_Cmb621 = new BitSet(new long[]{0x0000000000000002L});

}