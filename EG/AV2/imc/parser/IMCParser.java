// $ANTLR 3.x /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g 2012-12-29 17:54:22

package parser;

import java.util.HashSet;
import imc.IMC;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class IMCParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "ESC_SEQ", "EXPONENT", "FINAL_STATE", "FLOAT", "HEX_DIGIT", "ID", "INITIAL_STATE", "INT", "OCTAL_ESC", "STRING", "TRANSITION_STATE", "UNICODE_ESC", "WS", "'!'", "'*'"
	};

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
	
	//custom defs
	private boolean isInitial = false;
	private boolean isFinal = false;


	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public IMCParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public IMCParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return IMCParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g"; }


		HashSet<String> states;
		int  elems = 0;



	// $ANTLR start "imc"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:17:1: imc : INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+ ;
	public final void imc() throws RecognitionException {
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;


				states = new HashSet<String>();
			
		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:21:2: ( INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+ )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:2: INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+
			{
			match(input,INITIAL_STATE,FOLLOW_INITIAL_STATE_in_imc40); 
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:17: (a= state[\"\"] )+
			int cnt1=0;
			loop1:
			do {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:17: a= state[\"\"]
					{
					pushFollow(FOLLOW_state_in_imc44);
					a=state("");
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

			match(input,FINAL_STATE,FOLLOW_FINAL_STATE_in_imc48); 
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:42: (b= state[\"\"] )+
			int cnt2=0;
			loop2:
			do {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:42: b= state[\"\"]
					{
					pushFollow(FOLLOW_state_in_imc52);
					b=state("");
					state._fsp--;

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

			match(input,TRANSITION_STATE,FOLLOW_TRANSITION_STATE_in_imc56); 
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:71: ( transitions )+
			int cnt3=0;
			loop3:
			do {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:71: transitions
					{
					pushFollow(FOLLOW_transitions_in_imc58);
					transitions();
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
	// $ANTLR end "imc"



	// $ANTLR start "transitions"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:24:1: transitions : st= state[\"\"] (ac= action |mt= markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+ ;
	public final void transitions() throws RecognitionException {
		ParserRuleReturnScope st =null;
		ParserRuleReturnScope ac =null;
		boolean mt =false;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:25:2: (st= state[\"\"] (ac= action |mt= markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+ )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:25:4: st= state[\"\"] (ac= action |mt= markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+
			{
			pushFollow(FOLLOW_state_in_transitions70);
			st=state("");
			state._fsp--;


				
					if (!states.add((st!=null?((IMCParser.state_return)st).actual_st:null))) {
						System.out.println("ERROR (multiple definitions of state " + (st!=null?((IMCParser.state_return)st).actual_st:null) + "): " + "line -> " + (st!=null?((IMCParser.state_return)st).line:0) + " column -> " + (st!=null?((IMCParser.state_return)st).pos:0));
					}					
				
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:31:4: (ac= action |mt= markovian_trans )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			else if ( (LA4_0==18) ) {
				alt4=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:31:5: ac= action
					{
					pushFollow(FOLLOW_action_in_transitions81);
					ac=action();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:31:15: mt= markovian_trans
					{
					pushFollow(FOLLOW_markovian_trans_in_transitions85);
					mt=markovian_trans();
					state._fsp--;

					}
					break;

			}


				  	if(mt == false) {
					  	if((ac!=null?((IMCParser.action_return)ac).action_value:null).equals("tau")) {
							System.out.println("Warning (source is unstable state): " + "line -> " + (st!=null?((IMCParser.state_return)st).line:0) + " column -> " + (st!=null?((IMCParser.state_return)st).pos:0));
						}
					}
				  
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:38:5: ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+
			int cnt5=0;
			loop5:
			do {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==19) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:38:5: transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st]
					{
					pushFollow(FOLLOW_transition_def_in_transitions94);
					transition_def(mt, (ac!=null?((IMCParser.action_return)ac).isAction:false), (st!=null?((IMCParser.state_return)st).actual_st:null));
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
	// $ANTLR end "transitions"



	// $ANTLR start "transition_def"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:40:1: transition_def[boolean isM, boolean isA,String root_state] : '*' a= state[root_state] trans_prob_rate[isM,isA] ;
	public final void transition_def(boolean isM, boolean isA, String root_state) throws RecognitionException {
		ParserRuleReturnScope a =null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:2: ( '*' a= state[root_state] trans_prob_rate[isM,isA] )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:4: '*' a= state[root_state] trans_prob_rate[isM,isA]
			{
			match(input,19,FOLLOW_19_in_transition_def107); 
			pushFollow(FOLLOW_state_in_transition_def111);
			a=state(root_state);
			state._fsp--;

			pushFollow(FOLLOW_trans_prob_rate_in_transition_def115);
			trans_prob_rate(isM, isA);
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
		return ;
	}
	// $ANTLR end "transition_def"



	// $ANTLR start "trans_prob_rate"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:44:1: trans_prob_rate[boolean isM,boolean isA] : (a= FLOAT |b= INT ) ;
	public final void trans_prob_rate(boolean isM, boolean isA) throws RecognitionException {
		Token a=null;
		Token b=null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:45:2: ( (a= FLOAT |b= INT ) )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:45:4: (a= FLOAT |b= INT )
			{
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:45:4: (a= FLOAT |b= INT )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FLOAT) ) {
				alt6=1;
			}
			else if ( (LA6_0==INT) ) {
				alt6=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:45:5: a= FLOAT
					{
					a=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_trans_prob_rate133); 
					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:45:13: b= INT
					{
					b=(Token)match(input,INT,FOLLOW_INT_in_trans_prob_rate137); 
					}
					break;

			}


					float r;
					if(b == null) { r = Float.parseFloat((a!=null?a.getText():null));} else { r = Float.parseFloat((b!=null?b.getText():null));}

					if (isA && (r != 0 && r != 1))		
						System.out.println("Warning (probabilistic transition): line -> " + (a!=null?a.getLine():0)  + " column -> " + (a!=null?a.getCharPositionInLine():0));
					
					if(isM && r == 0 && a == null) 
						System.out.println("ERROR (0 rate markovian transition ): line -> " + (b!=null?b.getLine():0)  + " column -> " + (b!=null?b.getCharPositionInLine():0)); 
						
					if(isM && r == 0 && b == null) 
						System.out.println("ERROR (0 rate markovian transition ): line -> " + (a!=null?a.getLine():0)  + " column -> " + (a!=null?a.getCharPositionInLine():0)); 				
					
					
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
	// $ANTLR end "trans_prob_rate"


	public static class state_return extends ParserRuleReturnScope {
		public String actual_st;
		public int line;
		public int pos;
	};


	// $ANTLR start "state"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:62:1: state[String st] returns [String actual_st, int line, int pos] : st2= ID ;
	public final IMCParser.state_return state(String st) throws RecognitionException {
		IMCParser.state_return retval = new IMCParser.state_return();
		retval.start = input.LT(1);

		Token st2=null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:63:2: (st2= ID )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:63:4: st2= ID
			{
			st2=(Token)match(input,ID,FOLLOW_ID_in_state178); 

					retval.actual_st = (st2!=null?st2.getText():null);
					retval.line = (st2!=null?st2.getLine():0);
					retval.pos = (st2!=null?st2.getCharPositionInLine():0);
									
					if(st.equals(retval.actual_st)) {
						System.out.println("Warning (markovian loop): line -> " + (st2!=null?st2.getLine():0)  + " column -> " + (st2!=null?st2.getCharPositionInLine():0));
					}
				
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
		return retval;
	}
	// $ANTLR end "state"



	// $ANTLR start "markovian_trans"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:75:1: markovian_trans returns [boolean isMarkovian] : '!' ;
	public final boolean markovian_trans() throws RecognitionException {
		boolean isMarkovian = false;


		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:76:2: ( '!' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:76:4: '!'
			{
			match(input,18,FOLLOW_18_in_markovian_trans197); 
			isMarkovian = true;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return isMarkovian;
	}
	// $ANTLR end "markovian_trans"


	public static class action_return extends ParserRuleReturnScope {
		public boolean isAction;
		public String action_value;
	};


	// $ANTLR start "action"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:78:1: action returns [boolean isAction, String action_value] : a= ID ;
	public final IMCParser.action_return action() throws RecognitionException {
		IMCParser.action_return retval = new IMCParser.action_return();
		retval.start = input.LT(1);

		Token a=null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:79:2: (a= ID )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:79:4: a= ID
			{
			a=(Token)match(input,ID,FOLLOW_ID_in_action215); 
			retval.isAction = true; retval.action_value = (a!=null?a.getText():null);
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
		return retval;
	}
	// $ANTLR end "action"

	// Delegated rules



	public static final BitSet FOLLOW_INITIAL_STATE_in_imc40 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_imc44 = new BitSet(new long[]{0x0000000000000480L});
	public static final BitSet FOLLOW_FINAL_STATE_in_imc48 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_imc52 = new BitSet(new long[]{0x0000000000008400L});
	public static final BitSet FOLLOW_TRANSITION_STATE_in_imc56 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_transitions_in_imc58 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_state_in_transitions70 = new BitSet(new long[]{0x0000000000040400L});
	public static final BitSet FOLLOW_action_in_transitions81 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_markovian_trans_in_transitions85 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_transition_def_in_transitions94 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19_in_transition_def107 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_transition_def111 = new BitSet(new long[]{0x0000000000001100L});
	public static final BitSet FOLLOW_trans_prob_rate_in_transition_def115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_trans_prob_rate133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_trans_prob_rate137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_state178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_markovian_trans197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_action215 = new BitSet(new long[]{0x0000000000000002L});
}
