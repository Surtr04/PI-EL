// $ANTLR 3.4 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g 2012-11-16 18:02:58




import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class ficha5Parser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "' EXISTENCIAS '", "'('", "')'", "','", "'-'", "'ALFA'", "'BGUM'", "'CDROM'", "'EMPRESTADO'", "'ESTANTE'", "'LIVRO'", "'LOCAL '", "'OUTRO'", "'PERMANENTE'", "'[ REGISTO '", "']'"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int ESC_SEQ=4;
    public static final int EXPONENT=5;
    public static final int FLOAT=6;
    public static final int HEX_DIGIT=7;
    public static final int ID=8;
    public static final int INT=9;
    public static final int OCTAL_ESC=10;
    public static final int STRING=11;
    public static final int UNICODE_ESC=12;
    public static final int WS=13;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "local", "titulo", "autor", "referencia", "registos", 
    "descricao", "existencias", "editora", "dataDev", "codigoBarras", "estado", 
    "registo", "catalogo", "autores", "tipo", "ano", "estados", "mes", "disponib", 
    "dia", "biblioteca"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public ficha5Parser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public ficha5Parser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public ficha5Parser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return ficha5Parser.tokenNames; }
    public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g"; }


    	int numRegistos = 0;
    	int numLivros = 0;
    	String refReg = null;
    	
    	int reservados = 0;
    	int permanentes = 0;
    	int estante = 0;



    // $ANTLR start "biblioteca"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:22:1: biblioteca : registos ;
    public final void biblioteca() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "biblioteca");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(22, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:28:2: ( registos )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:28:4: registos
            {
            dbg.location(28,4);
            pushFollow(FOLLOW_registos_in_biblioteca43);
            registos();

            state._fsp--;


            }


            System.out.println ("Livros Reservados: " + reservados);
            System.out.println ("Livros Permanentes: " + permanentes);
            System.out.println ("Livros em Estante: " + estante);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(29, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "biblioteca");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "biblioteca"



    // $ANTLR start "registos"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:31:1: registos : registo ( ',' registo )* ;
    public final void registos() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registos");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:32:2: ( registo ( ',' registo )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:32:4: registo ( ',' registo )*
            {
            dbg.location(32,4);
            pushFollow(FOLLOW_registo_in_registos56);
            registo();

            state._fsp--;

            dbg.location(32,11);
            numRegistos++;
            dbg.location(32,28);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:32:28: ( ',' registo )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:32:29: ',' registo
            	    {
            	    dbg.location(32,29);
            	    match(input,17,FOLLOW_17_in_registos60); 
            	    dbg.location(32,33);
            	    pushFollow(FOLLOW_registo_in_registos62);
            	    registo();

            	    state._fsp--;

            	    dbg.location(32,40);
            	    numRegistos++;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(33, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "registos");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "registos"



    // $ANTLR start "registo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:35:1: registo : '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' ;
    public final void registo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(35, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:41:2: ( '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:41:4: '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']'
            {
            dbg.location(41,4);
            match(input,28,FOLLOW_28_in_registo81); 
            dbg.location(41,17);
            pushFollow(FOLLOW_descricao_in_registo83);
            descricao();

            state._fsp--;

            dbg.location(41,27);
            match(input,14,FOLLOW_14_in_registo85); 
            dbg.location(41,43);
            pushFollow(FOLLOW_existencias_in_registo87);
            existencias();

            state._fsp--;

            dbg.location(41,55);
            match(input,29,FOLLOW_29_in_registo89); 

            }


            	System.out.println(refReg + ": " + numLivros);
            	numLivros = 0;
            	refReg = null;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(42, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "registo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "registo"



    // $ANTLR start "descricao"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:44:1: descricao : referencia tipo titulo '(' autores ')' editora ano catalogo ;
    public final void descricao() throws RecognitionException {
        ficha5Parser.referencia_return referencia1 =null;


        try { dbg.enterRule(getGrammarFileName(), "descricao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:45:2: ( referencia tipo titulo '(' autores ')' editora ano catalogo )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:45:4: referencia tipo titulo '(' autores ')' editora ano catalogo
            {
            dbg.location(45,4);
            pushFollow(FOLLOW_referencia_in_descricao101);
            referencia1=referencia();

            state._fsp--;

            dbg.location(45,15);
            refReg = (referencia1!=null?input.toString(referencia1.start,referencia1.stop):null);
            dbg.location(45,44);
            pushFollow(FOLLOW_tipo_in_descricao105);
            tipo();

            state._fsp--;

            dbg.location(45,49);
            pushFollow(FOLLOW_titulo_in_descricao107);
            titulo();

            state._fsp--;

            dbg.location(45,56);
            match(input,15,FOLLOW_15_in_descricao109); 
            dbg.location(45,60);
            pushFollow(FOLLOW_autores_in_descricao111);
            autores();

            state._fsp--;

            dbg.location(45,68);
            match(input,16,FOLLOW_16_in_descricao113); 
            dbg.location(45,72);
            pushFollow(FOLLOW_editora_in_descricao115);
            editora();

            state._fsp--;

            dbg.location(45,80);
            pushFollow(FOLLOW_ano_in_descricao117);
            ano();

            state._fsp--;

            dbg.location(45,84);
            pushFollow(FOLLOW_catalogo_in_descricao119);
            catalogo();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(46, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "descricao");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "descricao"



    // $ANTLR start "autores"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:48:1: autores : autor ( ',' autor )* ;
    public final void autores() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autores");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(48, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:49:2: ( autor ( ',' autor )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:49:4: autor ( ',' autor )*
            {
            dbg.location(49,4);
            pushFollow(FOLLOW_autor_in_autores131);
            autor();

            state._fsp--;

            dbg.location(49,10);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:49:10: ( ',' autor )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:49:11: ',' autor
            	    {
            	    dbg.location(49,11);
            	    match(input,17,FOLLOW_17_in_autores134); 
            	    dbg.location(49,15);
            	    pushFollow(FOLLOW_autor_in_autores136);
            	    autor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(50, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "autores");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "autores"


    public static class referencia_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "referencia"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:52:1: referencia : ID ;
    public final ficha5Parser.referencia_return referencia() throws RecognitionException {
        ficha5Parser.referencia_return retval = new ficha5Parser.referencia_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "referencia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:53:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:53:4: ID
            {
            dbg.location(53,4);
            match(input,ID,FOLLOW_ID_in_referencia150); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(54, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "referencia");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "referencia"



    // $ANTLR start "tipo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:56:1: tipo : ( 'LIVRO' | 'CDROM' | 'OUTRO' );
    public final void tipo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "tipo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:56:5: ( 'LIVRO' | 'CDROM' | 'OUTRO' )
            int alt3=3;
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            switch ( input.LA(1) ) {
            case 24:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 26:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:56:7: 'LIVRO'
                    {
                    dbg.location(56,7);
                    match(input,24,FOLLOW_24_in_tipo160); 
                    dbg.location(56,15);
                    numLivros++;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:57:4: 'CDROM'
                    {
                    dbg.location(57,4);
                    match(input,21,FOLLOW_21_in_tipo167); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:58:4: 'OUTRO'
                    {
                    dbg.location(58,4);
                    match(input,26,FOLLOW_26_in_tipo172); 

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
        dbg.location(59, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "tipo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "tipo"



    // $ANTLR start "titulo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:61:1: titulo : STRING ;
    public final void titulo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "titulo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(61, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:62:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:62:4: STRING
            {
            dbg.location(62,4);
            match(input,STRING,FOLLOW_STRING_in_titulo183); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(63, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "titulo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "titulo"



    // $ANTLR start "autor"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:65:1: autor : STRING ;
    public final void autor() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:66:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:66:4: STRING
            {
            dbg.location(66,4);
            match(input,STRING,FOLLOW_STRING_in_autor194); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(67, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "autor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "autor"



    // $ANTLR start "editora"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:69:1: editora : STRING ;
    public final void editora() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "editora");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(69, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:70:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:70:4: STRING
            {
            dbg.location(70,4);
            match(input,STRING,FOLLOW_STRING_in_editora205); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(71, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "editora");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "editora"



    // $ANTLR start "ano"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:73:1: ano : INT ;
    public final void ano() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "ano");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(73, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:73:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:73:8: INT
            {
            dbg.location(73,8);
            match(input,INT,FOLLOW_INT_in_ano217); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(74, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ano");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "ano"



    // $ANTLR start "catalogo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:75:1: catalogo : ( 'BGUM' | 'ALFA' | 'OUTRO' );
    public final void catalogo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "catalogo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:76:2: ( 'BGUM' | 'ALFA' | 'OUTRO' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:
            {
            dbg.location(76,2);
            if ( (input.LA(1) >= 19 && input.LA(1) <= 20)||input.LA(1)==26 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(79, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "catalogo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "catalogo"



    // $ANTLR start "existencias"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:81:1: existencias : 'LOCAL ' local '(' estados ')' ;
    public final void existencias() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "existencias");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:82:2: ( 'LOCAL ' local '(' estados ')' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:82:4: 'LOCAL ' local '(' estados ')'
            {
            dbg.location(82,4);
            match(input,25,FOLLOW_25_in_existencias248); 
            dbg.location(82,13);
            pushFollow(FOLLOW_local_in_existencias250);
            local();

            state._fsp--;

            dbg.location(82,19);
            match(input,15,FOLLOW_15_in_existencias252); 
            dbg.location(82,23);
            pushFollow(FOLLOW_estados_in_existencias254);
            estados();

            state._fsp--;

            dbg.location(82,31);
            match(input,16,FOLLOW_16_in_existencias256); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(83, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "existencias");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "existencias"



    // $ANTLR start "local"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:85:1: local : STRING ;
    public final void local() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "local");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(85, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:86:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:86:4: STRING
            {
            dbg.location(86,4);
            match(input,STRING,FOLLOW_STRING_in_local268); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(87, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "local");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "local"



    // $ANTLR start "estados"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:89:1: estados : estado ( ',' estado )* ;
    public final void estados() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estados");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(89, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:90:2: ( estado ( ',' estado )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:90:4: estado ( ',' estado )*
            {
            dbg.location(90,4);
            pushFollow(FOLLOW_estado_in_estados280);
            estado();

            state._fsp--;

            dbg.location(90,11);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:90:11: ( ',' estado )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4, decisionCanBacktrack[4]);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:90:12: ',' estado
            	    {
            	    dbg.location(90,12);
            	    match(input,17,FOLLOW_17_in_estados283); 
            	    dbg.location(90,16);
            	    pushFollow(FOLLOW_estado_in_estados285);
            	    estado();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(91, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "estados");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "estados"



    // $ANTLR start "estado"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:93:1: estado : codigoBarras disponib ;
    public final void estado() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estado");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(93, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:94:2: ( codigoBarras disponib )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:94:4: codigoBarras disponib
            {
            dbg.location(94,4);
            pushFollow(FOLLOW_codigoBarras_in_estado298);
            codigoBarras();

            state._fsp--;

            dbg.location(94,17);
            pushFollow(FOLLOW_disponib_in_estado300);
            disponib();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(95, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "estado");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "estado"



    // $ANTLR start "codigoBarras"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:97:1: codigoBarras : ID ;
    public final void codigoBarras() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "codigoBarras");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(97, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:98:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:98:4: ID
            {
            dbg.location(98,4);
            match(input,ID,FOLLOW_ID_in_codigoBarras312); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(99, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "codigoBarras");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "codigoBarras"



    // $ANTLR start "disponib"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:100:1: disponib : ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev );
    public final void disponib() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "disponib");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(100, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:2: ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev )
            int alt5=3;
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            switch ( input.LA(1) ) {
            case 23:
                {
                alt5=1;
                }
                break;
            case 27:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:4: 'ESTANTE'
                    {
                    dbg.location(101,4);
                    match(input,23,FOLLOW_23_in_disponib322); 
                    dbg.location(101,14);
                    estante++;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:102:4: 'PERMANENTE'
                    {
                    dbg.location(102,4);
                    match(input,27,FOLLOW_27_in_disponib329); 
                    dbg.location(102,16);
                    permanentes++;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:103:4: 'EMPRESTADO' dataDev
                    {
                    dbg.location(103,4);
                    match(input,22,FOLLOW_22_in_disponib335); 
                    dbg.location(103,17);
                    reservados++;
                    dbg.location(103,32);
                    pushFollow(FOLLOW_dataDev_in_disponib338);
                    dataDev();

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
        	// do for sure before leaving
        }
        dbg.location(104, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "disponib");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "disponib"



    // $ANTLR start "dataDev"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:106:1: dataDev : ano '-' mes '-' dia ;
    public final void dataDev() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dataDev");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(106, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:107:2: ( ano '-' mes '-' dia )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:107:4: ano '-' mes '-' dia
            {
            dbg.location(107,4);
            pushFollow(FOLLOW_ano_in_dataDev350);
            ano();

            state._fsp--;

            dbg.location(107,8);
            match(input,18,FOLLOW_18_in_dataDev352); 
            dbg.location(107,12);
            pushFollow(FOLLOW_mes_in_dataDev354);
            mes();

            state._fsp--;

            dbg.location(107,16);
            match(input,18,FOLLOW_18_in_dataDev356); 
            dbg.location(107,20);
            pushFollow(FOLLOW_dia_in_dataDev358);
            dia();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(108, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dataDev");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "dataDev"



    // $ANTLR start "mes"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:109:1: mes : INT ;
    public final void mes() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "mes");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(109, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:109:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:109:7: INT
            {
            dbg.location(109,7);
            match(input,INT,FOLLOW_INT_in_mes367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(109, 9);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mes");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "mes"



    // $ANTLR start "dia"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:110:1: dia : INT ;
    public final void dia() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(110, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:110:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:110:7: INT
            {
            dbg.location(110,7);
            match(input,INT,FOLLOW_INT_in_dia374); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(110, 9);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dia");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "dia"

    // Delegated rules


 

    public static final BitSet FOLLOW_registos_in_biblioteca43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_registo_in_registos56 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_registos60 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_registo_in_registos62 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_28_in_registo81 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_descricao_in_registo83 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_registo85 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_existencias_in_registo87 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_registo89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencia_in_descricao101 = new BitSet(new long[]{0x0000000005200000L});
    public static final BitSet FOLLOW_tipo_in_descricao105 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_titulo_in_descricao107 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_descricao109 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autores_in_descricao111 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_descricao113 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_editora_in_descricao115 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ano_in_descricao117 = new BitSet(new long[]{0x0000000004180000L});
    public static final BitSet FOLLOW_catalogo_in_descricao119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_autor_in_autores131 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_autores134 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autor_in_autores136 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_referencia150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_tipo160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_tipo167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_tipo172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_titulo183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_autor194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_editora205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_ano217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_existencias248 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_local_in_existencias250 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_existencias252 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estados_in_existencias254 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_existencias256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_local268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estado_in_estados280 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_estados283 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estado_in_estados285 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_codigoBarras_in_estado298 = new BitSet(new long[]{0x0000000008C00000L});
    public static final BitSet FOLLOW_disponib_in_estado300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_codigoBarras312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_disponib322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_disponib329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_disponib335 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dataDev_in_disponib338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ano_in_dataDev350 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev352 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_mes_in_dataDev354 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev356 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dia_in_dataDev358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_mes367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_dia374 = new BitSet(new long[]{0x0000000000000002L});

}