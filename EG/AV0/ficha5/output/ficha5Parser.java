// $ANTLR 3.4 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g 2012-11-16 18:48:28

	import java.util.TreeSet;


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
    "invalidRule", "estado", "tipo", "catalogo", "codigoBarras", "editora", 
    "ano", "registo", "existencias", "autores", "local", "biblioteca", "registos", 
    "autor", "estados", "descricao", "dia", "dataDev", "referencia", "disponib", 
    "mes", "titulo"
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
    	
    	Boolean isBook = false;
    	
    	TreeSet<String> bookNames = new TreeSet<String>();
    	TreeSet<String> refs = new TreeSet<String>();



    // $ANTLR start "biblioteca"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:27:1: biblioteca : registos ;
    public final void biblioteca() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "biblioteca");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:39:2: ( registos )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:39:4: registos
            {
            dbg.location(39,4);
            pushFollow(FOLLOW_registos_in_biblioteca43);
            registos();

            state._fsp--;


            }


            System.out.println ("Livros Reservados: " + reservados);
            System.out.println ("Livros Permanentes: " + permanentes);
            System.out.println ("Livros em Estante: " + estante);

            System.out.println("=== Livros ===");
            for (String s : bookNames) {
            	System.out.println(s);
            }


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(40, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:42:1: registos : registo ( ',' registo )* ;
    public final void registos() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registos");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:43:2: ( registo ( ',' registo )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:43:4: registo ( ',' registo )*
            {
            dbg.location(43,4);
            pushFollow(FOLLOW_registo_in_registos56);
            registo();

            state._fsp--;

            dbg.location(43,11);
            numRegistos++;
            dbg.location(43,28);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:43:28: ( ',' registo )*
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:43:29: ',' registo
            	    {
            	    dbg.location(43,29);
            	    match(input,17,FOLLOW_17_in_registos60); 
            	    dbg.location(43,33);
            	    pushFollow(FOLLOW_registo_in_registos62);
            	    registo();

            	    state._fsp--;

            	    dbg.location(43,40);
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
        dbg.location(44, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:46:1: registo : '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' ;
    public final void registo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "registo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(46, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:52:2: ( '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:52:4: '[ REGISTO ' descricao ' EXISTENCIAS ' existencias ']'
            {
            dbg.location(52,4);
            match(input,28,FOLLOW_28_in_registo81); 
            dbg.location(52,17);
            pushFollow(FOLLOW_descricao_in_registo83);
            descricao();

            state._fsp--;

            dbg.location(52,27);
            match(input,14,FOLLOW_14_in_registo85); 
            dbg.location(52,43);
            pushFollow(FOLLOW_existencias_in_registo87);
            existencias();

            state._fsp--;

            dbg.location(52,55);
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
        dbg.location(53, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:55:1: descricao : referencia tipo titulo '(' autores ')' editora ano catalogo ;
    public final void descricao() throws RecognitionException {
        ficha5Parser.referencia_return referencia1 =null;

        ficha5Parser.titulo_return titulo2 =null;


        try { dbg.enterRule(getGrammarFileName(), "descricao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(55, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:56:2: ( referencia tipo titulo '(' autores ')' editora ano catalogo )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:56:4: referencia tipo titulo '(' autores ')' editora ano catalogo
            {
            dbg.location(56,4);
            pushFollow(FOLLOW_referencia_in_descricao101);
            referencia1=referencia();

            state._fsp--;

            dbg.location(56,15);
            refReg = (referencia1!=null?input.toString(referencia1.start,referencia1.stop):null); if(!refs.add((referencia1!=null?input.toString(referencia1.start,referencia1.stop):null))){System.out.println("Referencia ja existente: " + (referencia1!=null?input.toString(referencia1.start,referencia1.stop):null));} 
            dbg.location(56,146);
            pushFollow(FOLLOW_tipo_in_descricao105);
            tipo();

            state._fsp--;

            dbg.location(56,151);
            pushFollow(FOLLOW_titulo_in_descricao107);
            titulo2=titulo();

            state._fsp--;

            dbg.location(56,158);
            if(isBook) {bookNames.add((titulo2!=null?input.toString(titulo2.start,titulo2.stop):null));isBook = false;}
            dbg.location(56,217);
            match(input,15,FOLLOW_15_in_descricao111); 
            dbg.location(56,221);
            pushFollow(FOLLOW_autores_in_descricao113);
            autores();

            state._fsp--;

            dbg.location(56,229);
            match(input,16,FOLLOW_16_in_descricao115); 
            dbg.location(56,233);
            pushFollow(FOLLOW_editora_in_descricao117);
            editora();

            state._fsp--;

            dbg.location(56,241);
            pushFollow(FOLLOW_ano_in_descricao119);
            ano();

            state._fsp--;

            dbg.location(56,245);
            pushFollow(FOLLOW_catalogo_in_descricao121);
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
        dbg.location(57, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:59:1: autores : autor ( ',' autor )* ;
    public final void autores() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autores");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:60:2: ( autor ( ',' autor )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:60:4: autor ( ',' autor )*
            {
            dbg.location(60,4);
            pushFollow(FOLLOW_autor_in_autores133);
            autor();

            state._fsp--;

            dbg.location(60,10);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:60:10: ( ',' autor )*
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:60:11: ',' autor
            	    {
            	    dbg.location(60,11);
            	    match(input,17,FOLLOW_17_in_autores136); 
            	    dbg.location(60,15);
            	    pushFollow(FOLLOW_autor_in_autores138);
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
        dbg.location(61, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:63:1: referencia : ID ;
    public final ficha5Parser.referencia_return referencia() throws RecognitionException {
        ficha5Parser.referencia_return retval = new ficha5Parser.referencia_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "referencia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(63, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:64:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:64:4: ID
            {
            dbg.location(64,4);
            match(input,ID,FOLLOW_ID_in_referencia152); 

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
        dbg.location(65, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:67:1: tipo : ( 'LIVRO' | 'CDROM' | 'OUTRO' );
    public final void tipo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "tipo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:67:5: ( 'LIVRO' | 'CDROM' | 'OUTRO' )
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

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:67:7: 'LIVRO'
                    {
                    dbg.location(67,7);
                    match(input,24,FOLLOW_24_in_tipo162); 
                    dbg.location(67,15);
                    numLivros++; isBook = true;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:68:4: 'CDROM'
                    {
                    dbg.location(68,4);
                    match(input,21,FOLLOW_21_in_tipo169); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:69:4: 'OUTRO'
                    {
                    dbg.location(69,4);
                    match(input,26,FOLLOW_26_in_tipo174); 

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
        dbg.location(70, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "tipo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "tipo"


    public static class titulo_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "titulo"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:72:1: titulo : STRING ;
    public final ficha5Parser.titulo_return titulo() throws RecognitionException {
        ficha5Parser.titulo_return retval = new ficha5Parser.titulo_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "titulo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:73:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:73:4: STRING
            {
            dbg.location(73,4);
            match(input,STRING,FOLLOW_STRING_in_titulo185); 

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
        dbg.location(74, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "titulo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "titulo"



    // $ANTLR start "autor"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:76:1: autor : STRING ;
    public final void autor() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "autor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(76, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:77:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:77:4: STRING
            {
            dbg.location(77,4);
            match(input,STRING,FOLLOW_STRING_in_autor196); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(78, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:80:1: editora : STRING ;
    public final void editora() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "editora");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:81:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:81:4: STRING
            {
            dbg.location(81,4);
            match(input,STRING,FOLLOW_STRING_in_editora207); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(82, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:84:1: ano : INT ;
    public final void ano() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "ano");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(84, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:84:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:84:8: INT
            {
            dbg.location(84,8);
            match(input,INT,FOLLOW_INT_in_ano219); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(85, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:86:1: catalogo : ( 'BGUM' | 'ALFA' | 'OUTRO' );
    public final void catalogo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "catalogo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:87:2: ( 'BGUM' | 'ALFA' | 'OUTRO' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:
            {
            dbg.location(87,2);
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
        dbg.location(90, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:92:1: existencias : 'LOCAL ' local '(' estados ')' ;
    public final void existencias() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "existencias");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(92, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:93:2: ( 'LOCAL ' local '(' estados ')' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:93:4: 'LOCAL ' local '(' estados ')'
            {
            dbg.location(93,4);
            match(input,25,FOLLOW_25_in_existencias250); 
            dbg.location(93,13);
            pushFollow(FOLLOW_local_in_existencias252);
            local();

            state._fsp--;

            dbg.location(93,19);
            match(input,15,FOLLOW_15_in_existencias254); 
            dbg.location(93,23);
            pushFollow(FOLLOW_estados_in_existencias256);
            estados();

            state._fsp--;

            dbg.location(93,31);
            match(input,16,FOLLOW_16_in_existencias258); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(94, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:96:1: local : STRING ;
    public final void local() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "local");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(96, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:97:2: ( STRING )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:97:4: STRING
            {
            dbg.location(97,4);
            match(input,STRING,FOLLOW_STRING_in_local270); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(98, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:100:1: estados : estado ( ',' estado )* ;
    public final void estados() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estados");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(100, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:2: ( estado ( ',' estado )* )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:4: estado ( ',' estado )*
            {
            dbg.location(101,4);
            pushFollow(FOLLOW_estado_in_estados282);
            estado();

            state._fsp--;

            dbg.location(101,11);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:11: ( ',' estado )*
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:101:12: ',' estado
            	    {
            	    dbg.location(101,12);
            	    match(input,17,FOLLOW_17_in_estados285); 
            	    dbg.location(101,16);
            	    pushFollow(FOLLOW_estado_in_estados287);
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
        dbg.location(102, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:104:1: estado : codigoBarras disponib ;
    public final void estado() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "estado");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(104, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:105:2: ( codigoBarras disponib )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:105:4: codigoBarras disponib
            {
            dbg.location(105,4);
            pushFollow(FOLLOW_codigoBarras_in_estado300);
            codigoBarras();

            state._fsp--;

            dbg.location(105,17);
            pushFollow(FOLLOW_disponib_in_estado302);
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
        dbg.location(106, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:108:1: codigoBarras : ID ;
    public final void codigoBarras() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "codigoBarras");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(108, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:109:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:109:4: ID
            {
            dbg.location(109,4);
            match(input,ID,FOLLOW_ID_in_codigoBarras314); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(110, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:111:1: disponib : ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev );
    public final void disponib() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "disponib");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(111, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:112:2: ( 'ESTANTE' | 'PERMANENTE' | 'EMPRESTADO' dataDev )
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

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:112:4: 'ESTANTE'
                    {
                    dbg.location(112,4);
                    match(input,23,FOLLOW_23_in_disponib324); 
                    dbg.location(112,14);
                    estante++;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:113:4: 'PERMANENTE'
                    {
                    dbg.location(113,4);
                    match(input,27,FOLLOW_27_in_disponib331); 
                    dbg.location(113,16);
                    permanentes++;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:114:4: 'EMPRESTADO' dataDev
                    {
                    dbg.location(114,4);
                    match(input,22,FOLLOW_22_in_disponib337); 
                    dbg.location(114,17);
                    reservados++;
                    dbg.location(114,32);
                    pushFollow(FOLLOW_dataDev_in_disponib340);
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
        dbg.location(115, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:117:1: dataDev : ano '-' mes '-' dia ;
    public final void dataDev() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dataDev");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(117, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:118:2: ( ano '-' mes '-' dia )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:118:4: ano '-' mes '-' dia
            {
            dbg.location(118,4);
            pushFollow(FOLLOW_ano_in_dataDev352);
            ano();

            state._fsp--;

            dbg.location(118,8);
            match(input,18,FOLLOW_18_in_dataDev354); 
            dbg.location(118,12);
            pushFollow(FOLLOW_mes_in_dataDev356);
            mes();

            state._fsp--;

            dbg.location(118,16);
            match(input,18,FOLLOW_18_in_dataDev358); 
            dbg.location(118,20);
            pushFollow(FOLLOW_dia_in_dataDev360);
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
        dbg.location(119, 1);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:120:1: mes : INT ;
    public final void mes() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "mes");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(120, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:120:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:120:7: INT
            {
            dbg.location(120,7);
            match(input,INT,FOLLOW_INT_in_mes369); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(120, 9);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:121:1: dia : INT ;
    public final void dia() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dia");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(121, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:121:5: ( INT )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/ficha5.g:121:7: INT
            {
            dbg.location(121,7);
            match(input,INT,FOLLOW_INT_in_dia376); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(121, 9);

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
    public static final BitSet FOLLOW_15_in_descricao111 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autores_in_descricao113 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_descricao115 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_editora_in_descricao117 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ano_in_descricao119 = new BitSet(new long[]{0x0000000004180000L});
    public static final BitSet FOLLOW_catalogo_in_descricao121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_autor_in_autores133 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_autores136 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_autor_in_autores138 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ID_in_referencia152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_tipo162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_tipo169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_tipo174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_titulo185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_autor196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_editora207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_ano219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_existencias250 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_local_in_existencias252 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_existencias254 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estados_in_existencias256 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_existencias258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_local270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estado_in_estados282 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_estados285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_estado_in_estados287 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_codigoBarras_in_estado300 = new BitSet(new long[]{0x0000000008C00000L});
    public static final BitSet FOLLOW_disponib_in_estado302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_codigoBarras314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_disponib324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_disponib331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_disponib337 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dataDev_in_disponib340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ano_in_dataDev352 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev354 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_mes_in_dataDev356 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_dataDev358 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dia_in_dataDev360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_mes369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_dia376 = new BitSet(new long[]{0x0000000000000002L});

}