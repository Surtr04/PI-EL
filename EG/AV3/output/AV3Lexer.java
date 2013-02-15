// $ANTLR 3.5 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g 2013-02-15 18:52:56

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AV3Lexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public AV3Lexer() {} 
	public AV3Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public AV3Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g"; }

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:2:7: ( ':' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:2:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:3:7: ( ';' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:3:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:4:7: ( 'AREA:' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:4:9: 'AREA:'
			{
			match("AREA:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:5:7: ( 'DESLIGAR' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:5:9: 'DESLIGAR'
			{
			match("DESLIGAR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:6:7: ( 'ESTE' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:6:9: 'ESTE'
			{
			match("ESTE"); 

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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:7:7: ( 'LIGAR' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:7:9: 'LIGAR'
			{
			match("LIGAR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:8:7: ( 'MOVER' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:8:9: 'MOVER'
			{
			match("MOVER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:9:7: ( 'NORTE' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:9:9: 'NORTE'
			{
			match("NORTE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:10:7: ( 'OESTE' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:10:9: 'OESTE'
			{
			match("OESTE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:11:7: ( 'ORIGIN:' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:11:9: 'ORIGIN:'
			{
			match("ORIGIN:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:12:7: ( 'SUL' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:12:9: 'SUL'
			{
			match("SUL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:210:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:210:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:210:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
			}

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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:213:5: ( ( '-' )? ( '0' .. '9' )+ )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:213:7: ( '-' )? ( '0' .. '9' )+
			{
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:213:7: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:213:7: '-'
					{
					match('-'); 
					}
					break;

			}

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:213:11: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
			int alt10=3;
			alt10 = dfa10.predict(input);
			switch (alt10) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
					{
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:9: ( '0' .. '9' )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					match('.'); 
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:25: ( '0' .. '9' )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
							break loop5;
						}
					}

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:37: ( EXPONENT )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='E'||LA6_0=='e') ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:217:37: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:218:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
					{
					match('.'); 
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:218:13: ( '0' .. '9' )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:218:25: ( EXPONENT )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0=='E'||LA8_0=='e') ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:218:25: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 3 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:219:9: ( '0' .. '9' )+ EXPONENT
					{
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:219:9: ( '0' .. '9' )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:222:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:222:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:230:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:230:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:230:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:230:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:230:24: ~ ( '\\\\' | '\"' )
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
					break loop11;
				}
			}

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

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:235:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:235:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:235:22: ( '+' | '-' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='+'||LA12_0=='-') ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:235:33: ( '0' .. '9' )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:238:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:
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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:242:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
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
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:242:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:243:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:244:9: OCTAL_ESC
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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:249:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:249:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:250:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:251:9: '\\\\' ( '0' .. '7' )
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
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:256:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:256:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | ID | INT | FLOAT | WS | STRING )
		int alt16=16;
		alt16 = dfa16.predict(input);
		switch (alt16) {
			case 1 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:10: T__14
				{
				mT__14(); 

				}
				break;
			case 2 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:16: T__15
				{
				mT__15(); 

				}
				break;
			case 3 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:22: T__16
				{
				mT__16(); 

				}
				break;
			case 4 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:28: T__17
				{
				mT__17(); 

				}
				break;
			case 5 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:34: T__18
				{
				mT__18(); 

				}
				break;
			case 6 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:40: T__19
				{
				mT__19(); 

				}
				break;
			case 7 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:46: T__20
				{
				mT__20(); 

				}
				break;
			case 8 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:52: T__21
				{
				mT__21(); 

				}
				break;
			case 9 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:58: T__22
				{
				mT__22(); 

				}
				break;
			case 10 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:64: T__23
				{
				mT__23(); 

				}
				break;
			case 11 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:70: T__24
				{
				mT__24(); 

				}
				break;
			case 12 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:76: ID
				{
				mID(); 

				}
				break;
			case 13 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:79: INT
				{
				mINT(); 

				}
				break;
			case 14 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:83: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 15 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:89: WS
				{
				mWS(); 

				}
				break;
			case 16 :
				// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:1:92: STRING
				{
				mSTRING(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	protected DFA16 dfa16 = new DFA16(this);
	static final String DFA10_eotS =
		"\5\uffff";
	static final String DFA10_eofS =
		"\5\uffff";
	static final String DFA10_minS =
		"\2\56\3\uffff";
	static final String DFA10_maxS =
		"\1\71\1\145\3\uffff";
	static final String DFA10_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA10_specialS =
		"\5\uffff}>";
	static final String[] DFA10_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
			"",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "216:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
		}
	}

	static final String DFA16_eotS =
		"\3\uffff\10\13\2\uffff\1\14\3\uffff\21\13\1\53\2\13\1\56\5\13\2\uffff"+
		"\1\13\1\uffff\1\65\1\66\1\67\1\70\2\13\4\uffff\2\13\1\uffff\1\75\1\uffff";
	static final String DFA16_eofS =
		"\76\uffff";
	static final String DFA16_minS =
		"\1\11\2\uffff\1\122\1\105\1\123\1\111\2\117\1\105\1\125\2\uffff\1\56\3"+
		"\uffff\1\105\1\123\1\124\1\107\1\126\1\122\1\123\1\111\1\114\1\101\1\114"+
		"\1\105\1\101\1\105\2\124\1\107\1\60\1\72\1\111\1\60\2\122\2\105\1\111"+
		"\2\uffff\1\107\1\uffff\4\60\1\116\1\101\4\uffff\1\72\1\122\1\uffff\1\60"+
		"\1\uffff";
	static final String DFA16_maxS =
		"\1\172\2\uffff\1\122\1\105\1\123\1\111\2\117\1\122\1\125\2\uffff\1\145"+
		"\3\uffff\1\105\1\123\1\124\1\107\1\126\1\122\1\123\1\111\1\114\1\101\1"+
		"\114\1\105\1\101\1\105\2\124\1\107\1\172\1\72\1\111\1\172\2\122\2\105"+
		"\1\111\2\uffff\1\107\1\uffff\4\172\1\116\1\101\4\uffff\1\72\1\122\1\uffff"+
		"\1\172\1\uffff";
	static final String DFA16_acceptS =
		"\1\uffff\1\1\1\2\10\uffff\1\14\1\15\1\uffff\1\16\1\17\1\20\32\uffff\1"+
		"\13\1\3\1\uffff\1\5\6\uffff\1\6\1\7\1\10\1\11\2\uffff\1\12\1\uffff\1\4";
	static final String DFA16_specialS =
		"\76\uffff}>";
	static final String[] DFA16_transitionS = {
			"\2\17\2\uffff\1\17\22\uffff\1\17\1\uffff\1\20\12\uffff\1\14\1\16\1\uffff"+
			"\12\15\1\1\1\2\5\uffff\1\3\2\13\1\4\1\5\6\13\1\6\1\7\1\10\1\11\3\13\1"+
			"\12\7\13\4\uffff\1\13\1\uffff\32\13",
			"",
			"",
			"\1\21",
			"\1\22",
			"\1\23",
			"\1\24",
			"\1\25",
			"\1\26",
			"\1\27\14\uffff\1\30",
			"\1\31",
			"",
			"",
			"\1\16\1\uffff\12\15\13\uffff\1\16\37\uffff\1\16",
			"",
			"",
			"",
			"\1\32",
			"\1\33",
			"\1\34",
			"\1\35",
			"\1\36",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\43",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\54",
			"\1\55",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"",
			"\1\64",
			"",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\71",
			"\1\72",
			"",
			"",
			"",
			"",
			"\1\73",
			"\1\74",
			"",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
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

	protected class DFA16 extends DFA {

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
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | ID | INT | FLOAT | WS | STRING );";
		}
	}

}
