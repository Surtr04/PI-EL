// $ANTLR 3.4 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g 2012-12-16 03:57:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class IMCLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int CHAR=4;
    public static final int ESC_SEQ=5;
    public static final int EXPONENT=6;
    public static final int FINAL_STATE=7;
    public static final int FLOAT=8;
    public static final int HEX_DIGIT=9;
    public static final int ID=10;
    public static final int INITIAL_STATE=11;
    public static final int INT=12;
    public static final int OCTAL_ESC=13;
    public static final int STRING=14;
    public static final int TRANSITION_STATE=15;
    public static final int UNICODE_ESC=16;
    public static final int WS=17;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public IMCLexer() {} 
    public IMCLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public IMCLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:2:7: ( '!' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:2:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:7: ( '*' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "INITIAL_STATE"
    public final void mINITIAL_STATE() throws RecognitionException {
        try {
            int _type = INITIAL_STATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:25:2: ( '#INITIALS' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:25:4: '#INITIALS'
            {
            match("#INITIALS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INITIAL_STATE"

    // $ANTLR start "FINAL_STATE"
    public final void mFINAL_STATE() throws RecognitionException {
        try {
            int _type = FINAL_STATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:28:2: ( '#GOALS' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:28:4: '#GOALS'
            {
            match("#GOALS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FINAL_STATE"

    // $ANTLR start "TRANSITION_STATE"
    public final void mTRANSITION_STATE() throws RecognitionException {
        try {
            int _type = TRANSITION_STATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:31:2: ( '#TRANSITIONS' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:31:4: '#TRANSITIONS'
            {
            match("#TRANSITIONS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRANSITION_STATE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:34:5: ( ( '#' | 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:34:7: ( '#' | 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( input.LA(1)=='#'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:34:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:37:5: ( ( '0' .. '9' )+ )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:37:7: ( '0' .. '9' )+
            {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:37:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:9: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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


                    match('.'); 

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:25: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:37: ( EXPONENT )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='E'||LA5_0=='e') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:37: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:13: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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


                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:25: ( EXPONENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:43:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:43:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:46:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:46:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:54:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:54:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:54:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\\') ) {
                    alt10=1;
                }
                else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:54:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:54:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:57:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:57:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:57:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\\') ) {
                alt11=1;
            }
            else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:57:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:57:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:62:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:62:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:62:22: ( '+' | '-' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='+'||LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:62:33: ( '0' .. '9' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:65:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:69:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\\') ) {
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
                    alt14=1;
                    }
                    break;
                case 'u':
                    {
                    alt14=2;
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
                    alt14=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:69:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:70:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:71:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:76:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                int LA15_1 = input.LA(2);

                if ( ((LA15_1 >= '0' && LA15_1 <= '3')) ) {
                    int LA15_2 = input.LA(3);

                    if ( ((LA15_2 >= '0' && LA15_2 <= '7')) ) {
                        int LA15_4 = input.LA(4);

                        if ( ((LA15_4 >= '0' && LA15_4 <= '7')) ) {
                            alt15=1;
                        }
                        else {
                            alt15=2;
                        }
                    }
                    else {
                        alt15=3;
                    }
                }
                else if ( ((LA15_1 >= '4' && LA15_1 <= '7')) ) {
                    int LA15_3 = input.LA(3);

                    if ( ((LA15_3 >= '0' && LA15_3 <= '7')) ) {
                        alt15=2;
                    }
                    else {
                        alt15=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:76:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:77:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:78:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:83:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:83:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:8: ( T__18 | T__19 | INITIAL_STATE | FINAL_STATE | TRANSITION_STATE | ID | INT | FLOAT | WS | STRING | CHAR )
        int alt16=11;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:10: T__18
                {
                mT__18(); 


                }
                break;
            case 2 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:16: T__19
                {
                mT__19(); 


                }
                break;
            case 3 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:22: INITIAL_STATE
                {
                mINITIAL_STATE(); 


                }
                break;
            case 4 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:36: FINAL_STATE
                {
                mFINAL_STATE(); 


                }
                break;
            case 5 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:48: TRANSITION_STATE
                {
                mTRANSITION_STATE(); 


                }
                break;
            case 6 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:65: ID
                {
                mID(); 


                }
                break;
            case 7 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:68: INT
                {
                mINT(); 


                }
                break;
            case 8 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:72: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 9 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:78: WS
                {
                mWS(); 


                }
                break;
            case 10 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:81: STRING
                {
                mSTRING(); 


                }
                break;
            case 11 :
                // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:1:88: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA9_eotS =
        "\5\uffff";
    static final String DFA9_eofS =
        "\5\uffff";
    static final String DFA9_minS =
        "\2\56\3\uffff";
    static final String DFA9_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA9_specialS =
        "\5\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "40:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA16_eotS =
        "\3\uffff\1\4\1\uffff\1\15\4\uffff\3\4\1\uffff\12\4\1\33\2\4\1\uffff"+
        "\3\4\1\41\1\4\1\uffff\2\4\1\45\1\uffff";
    static final String DFA16_eofS =
        "\46\uffff";
    static final String DFA16_minS =
        "\1\11\2\uffff\1\107\1\uffff\1\56\4\uffff\1\116\1\117\1\122\1\uffff"+
        "\1\111\2\101\1\124\1\114\1\116\1\111\2\123\1\101\1\60\1\111\1\114"+
        "\1\uffff\1\124\1\123\1\111\1\60\1\117\1\uffff\1\116\1\123\1\60\1"+
        "\uffff";
    static final String DFA16_maxS =
        "\1\172\2\uffff\1\124\1\uffff\1\145\4\uffff\1\116\1\117\1\122\1\uffff"+
        "\1\111\2\101\1\124\1\114\1\116\1\111\2\123\1\101\1\172\1\111\1\114"+
        "\1\uffff\1\124\1\123\1\111\1\172\1\117\1\uffff\1\116\1\123\1\172"+
        "\1\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\uffff\1\10\1\11\1\12\1\13\3\uffff"+
        "\1\7\15\uffff\1\4\5\uffff\1\3\3\uffff\1\5";
    static final String DFA16_specialS =
        "\46\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\7\2\uffff\1\7\22\uffff\1\7\1\1\1\10\1\3\3\uffff\1\11\2\uffff"+
            "\1\2\3\uffff\1\6\1\uffff\12\5\7\uffff\32\4\4\uffff\1\4\1\uffff"+
            "\32\4",
            "",
            "",
            "\1\13\1\uffff\1\12\12\uffff\1\14",
            "",
            "\1\6\1\uffff\12\5\13\uffff\1\6\37\uffff\1\6",
            "",
            "",
            "",
            "",
            "\1\16",
            "\1\17",
            "\1\20",
            "",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\12\4\7\uffff\32\4\4\uffff\1\4\1\uffff\32\4",
            "\1\34",
            "\1\35",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\12\4\7\uffff\32\4\4\uffff\1\4\1\uffff\32\4",
            "\1\42",
            "",
            "\1\43",
            "\1\44",
            "\12\4\7\uffff\32\4\4\uffff\1\4\1\uffff\32\4",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__18 | T__19 | INITIAL_STATE | FINAL_STATE | TRANSITION_STATE | ID | INT | FLOAT | WS | STRING | CHAR );";
        }
    }
 

}