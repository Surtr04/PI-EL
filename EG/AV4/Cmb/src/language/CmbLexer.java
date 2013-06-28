// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g 2013-04-22 12:01:44

	package language;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CmbLexer extends Lexer {
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

    public CmbLexer() {;} 
    public CmbLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CmbLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g"; }

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:7:7: ( '{' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:7:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:8:7: ( '}' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:8:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:9:7: ( '(' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:9:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:10:7: ( ')' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:10:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:11:7: ( ',' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:11:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:12:7: ( ';' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:13:7: ( '=' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:14:7: ( '-' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:14:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:15:7: ( '+' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:15:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:16:7: ( '*' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:16:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:17:7: ( '/' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:17:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:18:7: ( '%' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:18:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:19:7: ( '||' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:19:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:20:7: ( '&&' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:20:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:21:7: ( '>' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:21:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:22:7: ( '<' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:22:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:23:7: ( '>=' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:23:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:24:7: ( '<=' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:24:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:25:7: ( '==' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:25:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:26:7: ( '!=' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:26:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:27:7: ( '!' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:27:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:224:9: ( 'return' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:224:11: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:226:5: ( 'if' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:226:7: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:228:6: ( 'else' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:228:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "TD_INT"
    public final void mTD_INT() throws RecognitionException {
        try {
            int _type = TD_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:230:8: ( 'int' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:230:10: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TD_INT"

    // $ANTLR start "TD_BOOL"
    public final void mTD_BOOL() throws RecognitionException {
        try {
            int _type = TD_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:232:9: ( 'bool' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:232:11: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TD_BOOL"

    // $ANTLR start "TD_STRING"
    public final void mTD_STRING() throws RecognitionException {
        try {
            int _type = TD_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:234:11: ( 'string' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:234:13: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TD_STRING"

    // $ANTLR start "TD_VAZIO"
    public final void mTD_VAZIO() throws RecognitionException {
        try {
            int _type = TD_VAZIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:236:10: ( 'void' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:236:12: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TD_VAZIO"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:238:8: ( 'while' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:238:10: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:240:7: ( 'true' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:240:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:242:8: ( 'false' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:242:10: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:244:8: ( 'print' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:244:10: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:246:7: ( 'scan' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:246:9: 'scan'
            {
            match("scan"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:248:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:248:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:248:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:251:5: ( ( '0' .. '9' )+ )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:251:7: ( '0' .. '9' )+
            {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:251:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:251:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='/') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='/') ) {
                    alt6=1;
                }
                else if ( (LA6_1=='*') ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:14: (~ ( '\\n' | '\\r' ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:28: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:255:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:256:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:256:14: ( options {greedy=false; } : . )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='*') ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1=='/') ) {
                                alt5=2;
                            }
                            else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:256:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match("*/"); 

                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:259:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:259:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:267:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:267:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:267:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:267:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:267:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:270:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:270:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:270:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\\') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:270:15: ESC_SEQ
                    {
                    mESC_SEQ(); 

                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:270:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:274:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:274:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:278:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt9=1;
                    }
                    break;
                case 'u':
                    {
                    alt9=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt9=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:278:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:279:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:280:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\\') ) {
                int LA10_1 = input.LA(2);

                if ( ((LA10_1>='0' && LA10_1<='3')) ) {
                    int LA10_2 = input.LA(3);

                    if ( ((LA10_2>='0' && LA10_2<='7')) ) {
                        int LA10_4 = input.LA(4);

                        if ( ((LA10_4>='0' && LA10_4<='7')) ) {
                            alt10=1;
                        }
                        else {
                            alt10=2;}
                    }
                    else {
                        alt10=3;}
                }
                else if ( ((LA10_1>='4' && LA10_1<='7')) ) {
                    int LA10_3 = input.LA(3);

                    if ( ((LA10_3>='0' && LA10_3<='7')) ) {
                        alt10=2;
                    }
                    else {
                        alt10=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:14: ( '0' .. '3' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:25: ( '0' .. '7' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:36: ( '0' .. '7' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:285:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:286:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:286:14: ( '0' .. '7' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:286:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:286:25: ( '0' .. '7' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:286:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:287:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:287:14: ( '0' .. '7' )
                    // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:287:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:292:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:292:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:8: ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RETURN | IF | ELSE | TD_INT | TD_BOOL | TD_STRING | TD_VAZIO | WHILE | TRUE | FALSE | WRITE | READ | ID | INT | COMMENT | WS | STRING | CHAR )
        int alt11=39;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:10: T__38
                {
                mT__38(); 

                }
                break;
            case 2 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:16: T__39
                {
                mT__39(); 

                }
                break;
            case 3 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:22: T__40
                {
                mT__40(); 

                }
                break;
            case 4 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:28: T__41
                {
                mT__41(); 

                }
                break;
            case 5 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:34: T__42
                {
                mT__42(); 

                }
                break;
            case 6 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:40: T__43
                {
                mT__43(); 

                }
                break;
            case 7 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:46: T__44
                {
                mT__44(); 

                }
                break;
            case 8 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:52: T__45
                {
                mT__45(); 

                }
                break;
            case 9 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:58: T__46
                {
                mT__46(); 

                }
                break;
            case 10 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:64: T__47
                {
                mT__47(); 

                }
                break;
            case 11 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:70: T__48
                {
                mT__48(); 

                }
                break;
            case 12 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:76: T__49
                {
                mT__49(); 

                }
                break;
            case 13 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:82: T__50
                {
                mT__50(); 

                }
                break;
            case 14 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:88: T__51
                {
                mT__51(); 

                }
                break;
            case 15 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:94: T__52
                {
                mT__52(); 

                }
                break;
            case 16 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:100: T__53
                {
                mT__53(); 

                }
                break;
            case 17 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:106: T__54
                {
                mT__54(); 

                }
                break;
            case 18 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:112: T__55
                {
                mT__55(); 

                }
                break;
            case 19 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:118: T__56
                {
                mT__56(); 

                }
                break;
            case 20 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:124: T__57
                {
                mT__57(); 

                }
                break;
            case 21 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:130: T__58
                {
                mT__58(); 

                }
                break;
            case 22 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:136: RETURN
                {
                mRETURN(); 

                }
                break;
            case 23 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:143: IF
                {
                mIF(); 

                }
                break;
            case 24 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:146: ELSE
                {
                mELSE(); 

                }
                break;
            case 25 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:151: TD_INT
                {
                mTD_INT(); 

                }
                break;
            case 26 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:158: TD_BOOL
                {
                mTD_BOOL(); 

                }
                break;
            case 27 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:166: TD_STRING
                {
                mTD_STRING(); 

                }
                break;
            case 28 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:176: TD_VAZIO
                {
                mTD_VAZIO(); 

                }
                break;
            case 29 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:185: WHILE
                {
                mWHILE(); 

                }
                break;
            case 30 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:191: TRUE
                {
                mTRUE(); 

                }
                break;
            case 31 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:196: FALSE
                {
                mFALSE(); 

                }
                break;
            case 32 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:202: WRITE
                {
                mWRITE(); 

                }
                break;
            case 33 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:208: READ
                {
                mREAD(); 

                }
                break;
            case 34 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:213: ID
                {
                mID(); 

                }
                break;
            case 35 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:216: INT
                {
                mINT(); 

                }
                break;
            case 36 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:220: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 37 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:228: WS
                {
                mWS(); 

                }
                break;
            case 38 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:231: STRING
                {
                mSTRING(); 

                }
                break;
            case 39 :
                // /Users/nunooliveira/Documents/Nuno/Academic/Aulas/2012_2013_1_EG_MEI/2013_04_22/tabid/Cmb/resources/Cmb.g:1:238: CHAR
                {
                mCHAR(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\7\uffff\1\42\3\uffff\1\44\3\uffff\1\46\1\50\1\52\12\34\17\uffff"+
        "\1\34\1\70\13\34\1\uffff\1\104\12\34\1\uffff\1\117\1\120\1\34\1"+
        "\122\1\123\1\34\1\125\3\34\2\uffff\1\34\2\uffff\1\132\1\uffff\1"+
        "\133\1\134\1\135\1\136\5\uffff";
    static final String DFA11_eofS =
        "\137\uffff";
    static final String DFA11_minS =
        "\1\11\6\uffff\1\75\3\uffff\1\52\3\uffff\3\75\1\145\1\146\1\154\1"+
        "\157\1\143\1\157\1\150\1\162\1\141\1\162\17\uffff\1\164\1\60\1\164"+
        "\1\163\1\157\1\162\1\141\2\151\1\165\1\154\1\151\1\165\1\uffff\1"+
        "\60\1\145\1\154\1\151\1\156\1\144\1\154\1\145\1\163\1\156\1\162"+
        "\1\uffff\2\60\1\156\2\60\1\145\1\60\1\145\1\164\1\156\2\uffff\1"+
        "\147\2\uffff\1\60\1\uffff\4\60\5\uffff";
    static final String DFA11_maxS =
        "\1\175\6\uffff\1\75\3\uffff\1\57\3\uffff\3\75\1\145\1\156\1\154"+
        "\1\157\1\164\1\157\1\150\1\162\1\141\1\162\17\uffff\1\164\1\172"+
        "\1\164\1\163\1\157\1\162\1\141\2\151\1\165\1\154\1\151\1\165\1\uffff"+
        "\1\172\1\145\1\154\1\151\1\156\1\144\1\154\1\145\1\163\1\156\1\162"+
        "\1\uffff\2\172\1\156\2\172\1\145\1\172\1\145\1\164\1\156\2\uffff"+
        "\1\147\2\uffff\1\172\1\uffff\4\172\5\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\1\12\1\uffff"+
        "\1\14\1\15\1\16\15\uffff\1\42\1\43\1\45\1\46\1\47\1\23\1\7\1\44"+
        "\1\13\1\21\1\17\1\22\1\20\1\24\1\25\15\uffff\1\27\13\uffff\1\31"+
        "\12\uffff\1\30\1\32\1\uffff\1\41\1\34\1\uffff\1\36\4\uffff\1\35"+
        "\1\37\1\40\1\26\1\33";
    static final String DFA11_specialS =
        "\137\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\36\2\uffff\1\36\22\uffff\1\36\1\21\1\37\2\uffff\1\14\1\16"+
            "\1\40\1\3\1\4\1\12\1\11\1\5\1\10\1\uffff\1\13\12\35\1\uffff"+
            "\1\6\1\20\1\7\1\17\2\uffff\32\34\4\uffff\1\34\1\uffff\1\34\1"+
            "\25\2\34\1\24\1\32\2\34\1\23\6\34\1\33\1\34\1\22\1\26\1\31\1"+
            "\34\1\27\1\30\3\34\1\1\1\15\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41",
            "",
            "",
            "",
            "\1\43\4\uffff\1\43",
            "",
            "",
            "",
            "\1\45",
            "\1\47",
            "\1\51",
            "\1\53",
            "\1\54\7\uffff\1\55",
            "\1\56",
            "\1\57",
            "\1\61\20\uffff\1\60",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\67",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\121",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\124",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "",
            "\1\131",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | RETURN | IF | ELSE | TD_INT | TD_BOOL | TD_STRING | TD_VAZIO | WHILE | TRUE | FALSE | WRITE | READ | ID | INT | COMMENT | WS | STRING | CHAR );";
        }
    }
 

}