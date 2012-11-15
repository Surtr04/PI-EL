// $ANTLR 3.4 /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g 2012-11-15 18:32:28

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
    "invalidRule", "estado", "tipo", "referencia", "catalogo", "titulo", 
    "registos", "local", "disponib", "editora", "existencias", "estados", 
    "descricao", "autores", "autor", "ano", "dia", "mes", "codigoBarras", 
    "biblioteca", "registo", "dataDev"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false
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
    public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g"; }



    // $ANTLR start "biblioteca"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:7:1: biblioteca : registos ;
    public final void biblioteca() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "biblioteca");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(7, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:8:2: ( registos )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:8:4: registos
            {
            dbg.location(8,4);
            pushFollow(FOLLOW_registos_in_biblioteca23);
            registos();

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
        dbg.location(9, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:11:1: registos : registo ( ',' registo )* ;
    public final void registos() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registos");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(11, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:12:2: ( registo ( ',' registo )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:12:4: registo ( ',' registo )*
            {
            dbg.location(12,4);
            pushFollow(FOLLOW_registo_in_registos36);
            registo();

            state._fsp--;

            dbg.location(12,12);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:12:12: ( ',' registo )*
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:12:13: ',' registo
            	    {
            	    dbg.location(12,13);
            	    match(input,17,FOLLOW_17_in_registos39); 
            	    dbg.location(12,17);
            	    pushFollow(FOLLOW_registo_in_registos41);
            	    registo();

            	    state._fsp--;


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
        dbg.location(13, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:15:1: registo : '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' ;
    public final void registo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:16:2: ( '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:16:4: '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']'
            {
            dbg.location(16,4);
            match(input,28,FOLLOW_28_in_registo54); 
            dbg.location(16,17);
            pushFollow(FOLLOW_descricao_in_registo56);
            descricao();

            state._fsp--;

            dbg.location(16,27);
            match(input,14,FOLLOW_14_in_registo58); 
            dbg.location(16,43);
            pushFollow(FOLLOW_existencias_in_registo60);
            existencias();

            state._fsp--;

            dbg.location(16,55);
            match(input,29,FOLLOW_29_in_registo62); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(17, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:19:1: descricao : referencia tipo titulo '(' autores ')' editora ano catalogo ;
    public final void descricao() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "descricao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:20:2: ( referencia tipo titulo '(' autores ')' editora ano catalogo )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:20:4: referencia tipo titulo '(' autores ')' editora ano catalogo
            {
            dbg.location(20,4);
            pushFollow(FOLLOW_referencia_in_descricao74);
            referencia();

            state._fsp--;

            dbg.location(20,15);
            pushFollow(FOLLOW_tipo_in_descricao76);
            tipo();

            state._fsp--;

            dbg.location(20,20);
            pushFollow(FOLLOW_titulo_in_descricao78);
            titulo();

            state._fsp--;

            dbg.location(20,27);
            match(input,15,FOLLOW_15_in_descricao80); 
            dbg.location(20,31);
            pushFollow(FOLLOW_autores_in_descricao82);
            autores();

            state._fsp--;

            dbg.location(20,39);
            match(input,16,FOLLOW_16_in_descricao84); 
            dbg.location(20,43);
            pushFollow(FOLLOW_editora_in_descricao86);
            editora();

            state._fsp--;

            dbg.location(20,51);
            pushFollow(FOLLOW_ano_in_descricao88);
            ano();

            state._fsp--;

            dbg.location(20,55);
            pushFollow(FOLLOW_catalogo_in_descricao90);
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
        dbg.location(21, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:23:1: autores : autor ( ',' autor )* ;
    public final void autores() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autores");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(23, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:24:2: ( autor ( ',' autor )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:24:4: autor ( ',' autor )*
            {
            dbg.location(24,4);
            pushFollow(FOLLOW_autor_in_autores102);
            autor();

            state._fsp--;

            dbg.location(24,10);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:24:10: ( ',' autor )*
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:24:11: ',' autor
            	    {
            	    dbg.location(24,11);
            	    match(input,17,FOLLOW_17_in_autores105); 
            	    dbg.location(24,15);
            	    pushFollow(FOLLOW_autor_in_autores107);
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
        dbg.location(25, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "autores");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "autores"



    // $ANTLR start "referencia"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:27:1: referencia : ID ;
    public final void referencia() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "referencia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:28:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:28:4: ID
            {
            dbg.location(28,4);
            match(input,ID,FOLLOW_ID_in_referencia121); 

            }

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
            dbg.exitRule(getGrammarFileName(), "referencia");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "referencia"



    // $ANTLR start "tipo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:31:1: tipo : ( 'LIVRO' | 'CDROM' | 'OUTRO' );
    public final void tipo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "tipo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:31:5: ( 'LIVRO' | 'CDROM' | 'OUTRO' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:
            {
            dbg.location(31,5);
            if ( input.LA(1)==21||input.LA(1)==24||input.LA(1)==26 ) {
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
        dbg.location(34, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:36:1: titulo : STRING ;
    public final void titulo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "titulo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:37:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:37:4: STRING
            {
            dbg.location(37,4);
            match(input,STRING,FOLLOW_STRING_in_titulo152); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(38, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:40:1: autor : STRING ;
    public final void autor() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:41:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:41:4: STRING
            {
            dbg.location(41,4);
            match(input,STRING,FOLLOW_STRING_in_autor163); 

            }

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
            dbg.exitRule(getGrammarFileName(), "autor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "autor"



    // $ANTLR start "editora"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:44:1: editora : STRING ;
    public final void editora() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "editora");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:45:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:45:4: STRING
            {
            dbg.location(45,4);
            match(input,STRING,FOLLOW_STRING_in_editora174); 

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
            dbg.exitRule(getGrammarFileName(), "editora");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "editora"



    // $ANTLR start "ano"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:48:1: ano : INT ;
    public final void ano() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "ano");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(48, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:48:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:48:8: INT
            {
            dbg.location(48,8);
            match(input,INT,FOLLOW_INT_in_ano186); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(49, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:50:1: catalogo : ( 'BGUM' | 'ALFA' | 'OUTRO' );
    public final void catalogo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "catalogo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:51:2: ( 'BGUM' | 'ALFA' | 'OUTRO' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:
            {
            dbg.location(51,2);
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
        dbg.location(54, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:56:1: existencias : 'LOCAL ' local '(' estados ')' ;
    public final void existencias() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "existencias");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:57:2: ( 'LOCAL ' local '(' estados ')' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:57:4: 'LOCAL ' local '(' estados ')'
            {
            dbg.location(57,4);
            match(input,25,FOLLOW_25_in_existencias217); 
            dbg.location(57,13);
            pushFollow(FOLLOW_local_in_existencias219);
            local();

            state._fsp--;

            dbg.location(57,19);
            match(input,15,FOLLOW_15_in_existencias221); 
            dbg.location(57,23);
            pushFollow(FOLLOW_estados_in_existencias223);
            estados();

            state._fsp--;

            dbg.location(57,31);
            match(input,16,FOLLOW_16_in_existencias225); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(58, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:60:1: local : STRING ;
    public final void local() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "local");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(60, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:61:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:61:4: STRING
            {
            dbg.location(61,4);
            match(input,STRING,FOLLOW_STRING_in_local237); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(62, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:64:1: estados : estado ( ',' estado )* ;
    public final void estados() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estados");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(64, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:65:2: ( estado ( ',' estado )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:65:4: estado ( ',' estado )*
            {
            dbg.location(65,4);
            pushFollow(FOLLOW_estado_in_estados249);
            estado();

            state._fsp--;

            dbg.location(65,11);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:65:11: ( ',' estado )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:65:12: ',' estado
            	    {
            	    dbg.location(65,12);
            	    match(input,17,FOLLOW_17_in_estados252); 
            	    dbg.location(65,16);
            	    pushFollow(FOLLOW_estado_in_estados254);
            	    estado();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(66, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:68:1: estado : codigoBarras disponib ;
    public final void estado() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estado");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:69:2: ( codigoBarras disponib )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:69:4: codigoBarras disponib
            {
            dbg.location(69,4);
            pushFollow(FOLLOW_codigoBarras_in_estado267);
            codigoBarras();

            state._fsp--;

            dbg.location(69,17);
            pushFollow(FOLLOW_disponib_in_estado269);
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
        dbg.location(70, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:72:1: codigoBarras : ID ;
    public final void codigoBarras() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "codigoBarras");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:73:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:73:4: ID
            {
            dbg.location(73,4);
            match(input,ID,FOLLOW_ID_in_codigoBarras281); 

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
            dbg.exitRule(getGrammarFileName(), "codigoBarras");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "codigoBarras"



    // $ANTLR start "disponib"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:75:1: disponib : ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev );
    public final void disponib() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "disponib");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:76:2: ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev )
            int alt4=3;
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            switch ( input.LA(1) ) {
            case 23:
                {
                alt4=1;
                }
                break;
            case 27:
                {
                alt4=2;
                }
                break;
            case 22:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:76:4: 'ESTANTE'
                    {
                    dbg.location(76,4);
                    match(input,23,FOLLOW_23_in_disponib291); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:77:4: 'PERMANENTE'
                    {
                    dbg.location(77,4);
                    match(input,27,FOLLOW_27_in_disponib296); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:78:4: 'EMPRESTADO' dataDev
                    {
                    dbg.location(78,4);
                    match(input,22,FOLLOW_22_in_disponib301); 
                    dbg.location(78,17);
                    pushFollow(FOLLOW_dataDev_in_disponib303);
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
        dbg.location(79, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:81:1: dataDev : ano '-' mes '-' dia ;
    public final void dataDev() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dataDev");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:82:2: ( ano '-' mes '-' dia )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:82:4: ano '-' mes '-' dia
            {
            dbg.location(82,4);
            pushFollow(FOLLOW_ano_in_dataDev315);
            ano();

            state._fsp--;

            dbg.location(82,8);
            match(input,18,FOLLOW_18_in_dataDev317); 
            dbg.location(82,12);
            pushFollow(FOLLOW_mes_in_dataDev319);
            mes();

            state._fsp--;

            dbg.location(82,16);
            match(input,18,FOLLOW_18_in_dataDev321); 
            dbg.location(82,20);
            pushFollow(FOLLOW_dia_in_dataDev323);
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
        dbg.location(83, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:84:1: mes : INT ;
    public final void mes() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "mes");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(84, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:84:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:84:7: INT
            {
            dbg.location(84,7);
            match(input,INT,FOLLOW_INT_in_mes332); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(84, 9);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:85:1: dia : INT ;
    public final void dia() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(85, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:85:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/ficha5.g:85:7: INT
            {
            dbg.location(85,7);
            match(input,INT,FOLLOW_INT_in_dia339); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(85, 9);

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


 

    public static final BitSet FOLLOW_registos_in_biblioteca23 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_registo_in_registos36 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_registos39 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_registo_in_registos41 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_28_in_registo54 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_descricao_in_registo56 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_registo58 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_existencias_in_registo60 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_registo62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencia_in_descricao74 = new BitSet(new long[]{0x0000000005200000L});
    public static final BitSet FOLLOW_tipo_in_descricao76 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_titulo_in_descricao78 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_descricao80 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autores_in_descricao82 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_descricao84 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_editora_in_descricao86 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ano_in_descricao88 = new BitSet(new long[]{0x0000000004180000L});
    public static final BitSet FOLLOW_catalogo_in_descricao90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_autor_in_autores102 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_autores105 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autor_in_autores107 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_referencia121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_titulo152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_autor163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_editora174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_ano186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_existencias217 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_local_in_existencias219 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_existencias221 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estados_in_existencias223 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_existencias225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_local237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estado_in_estados249 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_estados252 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estado_in_estados254 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_codigoBarras_in_estado267 = new BitSet(new long[]{0x0000000008C00000L});
    public static final BitSet FOLLOW_disponib_in_estado269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_codigoBarras281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_disponib291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_disponib296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_disponib301 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dataDev_in_disponib303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ano_in_dataDev315 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev317 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_mes_in_dataDev319 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev321 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dia_in_dataDev323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_mes332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_dia339 = new BitSet(new long[]{0x0000000000000002L});

}