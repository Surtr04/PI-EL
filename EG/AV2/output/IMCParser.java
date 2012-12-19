// $ANTLR 3.x /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g 2012-12-19 12:26:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class IMCParser extends DebugParser {
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


public static final String[] ruleNames = new String[] {
	"invalidRule", "action", "state", "transition_def", "trans_prob_rate", 
    "imc", "markovian_trans", "transitions"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
	false, // invalid decision
	false, false, false, false, false, false, false
};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public IMCParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public IMCParser(TokenStream input, int port, RecognizerSharedState state) {
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

public IMCParser(TokenStream input, DebugEventListener dbg) {
	super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
	dbg.semanticPredicate(result, predicate);
	return result;
}

	@Override public String[] getTokenNames() { return IMCParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g"; }



	// $ANTLR start "imc"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:1: imc : INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+ ;
	public final void imc() throws RecognitionException {
		String a =null;
		String b =null;

		try { dbg.enterRule(getGrammarFileName(), "imc");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(3, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:5: ( INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+ )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:2: INITIAL_STATE (a= state[\"\"] )+ FINAL_STATE (b= state[\"\"] )+ TRANSITION_STATE ( transitions )+
			{
			dbg.location(4,2);
			match(input,INITIAL_STATE,FOLLOW_INITIAL_STATE_in_imc12); dbg.location(4,17);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:17: (a= state[\"\"] )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			do {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:17: a= state[\"\"]
					{
					dbg.location(4,17);
					pushFollow(FOLLOW_state_in_imc16);
					a=state("");
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
						EarlyExitException eee =
							new EarlyExitException(1, input);
						dbg.recognitionException(eee);

						throw eee;
				}
				cnt1++;
			} while (true);
			} finally {dbg.exitSubRule(1);}
			dbg.location(4,29);
			match(input,FINAL_STATE,FOLLOW_FINAL_STATE_in_imc20); dbg.location(4,42);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:42: (b= state[\"\"] )+
			int cnt2=0;
			try { dbg.enterSubRule(2);

			loop2:
			do {
				int alt2=2;
				try { dbg.enterDecision(2, decisionCanBacktrack[2]);

				int LA2_0 = input.LA(1);
				if ( (LA2_0==ID) ) {
					alt2=1;
				}

				} finally {dbg.exitDecision(2);}

				switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:42: b= state[\"\"]
					{
					dbg.location(4,42);
					pushFollow(FOLLOW_state_in_imc24);
					b=state("");
					state._fsp--;

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
						EarlyExitException eee =
							new EarlyExitException(2, input);
						dbg.recognitionException(eee);

						throw eee;
				}
				cnt2++;
			} while (true);
			} finally {dbg.exitSubRule(2);}
			dbg.location(4,54);
			match(input,TRANSITION_STATE,FOLLOW_TRANSITION_STATE_in_imc28); dbg.location(4,71);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:71: ( transitions )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			do {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:71: transitions
					{
					dbg.location(4,71);
					pushFollow(FOLLOW_transitions_in_imc30);
					transitions();
					state._fsp--;

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
						EarlyExitException eee =
							new EarlyExitException(3, input);
						dbg.recognitionException(eee);

						throw eee;
				}
				cnt3++;
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
		dbg.location(4, 82);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "imc");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return ;
	}
	// $ANTLR end "imc"



	// $ANTLR start "transitions"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:6:1: transitions : st= state[\"\"] ( action | markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+ ;
	public final void transitions() throws RecognitionException {
		String st =null;
		boolean markovian_trans1 =false;
		boolean action2 =false;

		try { dbg.enterRule(getGrammarFileName(), "transitions");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(6, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:2: (st= state[\"\"] ( action | markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+ )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:4: st= state[\"\"] ( action | markovian_trans ) ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+
			{
			dbg.location(7,6);
			pushFollow(FOLLOW_state_in_transitions42);
			st=state("");
			state._fsp--;
			dbg.location(7,17);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:17: ( action | markovian_trans )
			int alt4=2;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:18: action
					{
					dbg.location(7,18);
					pushFollow(FOLLOW_action_in_transitions46);
					action2=action();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:25: markovian_trans
					{
					dbg.location(7,25);
					pushFollow(FOLLOW_markovian_trans_in_transitions48);
					markovian_trans1=markovian_trans();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(4);}
			dbg.location(7,43);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:43: ( transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st] )+
			int cnt5=0;
			try { dbg.enterSubRule(5);

			loop5:
			do {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==19) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:43: transition_def[$markovian_trans.isMarkovian, $action.isAction,$state.actual_st]
					{
					dbg.location(7,43);
					pushFollow(FOLLOW_transition_def_in_transitions52);
					transition_def(markovian_trans1, action2, st);
					state._fsp--;

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
						EarlyExitException eee =
							new EarlyExitException(5, input);
						dbg.recognitionException(eee);

						throw eee;
				}
				cnt5++;
			} while (true);
			} finally {dbg.exitSubRule(5);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(7, 122);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "transitions");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return ;
	}
	// $ANTLR end "transitions"



	// $ANTLR start "transition_def"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:9:1: transition_def[boolean isM, boolean isA,String root_state] : '*' a= state[root_state] ( trans_prob_rate[isM,isA] )? ;
	public final void transition_def(boolean isM, boolean isA, String root_state) throws RecognitionException {
		String a =null;

		try { dbg.enterRule(getGrammarFileName(), "transition_def");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(9, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:2: ( '*' a= state[root_state] ( trans_prob_rate[isM,isA] )? )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:4: '*' a= state[root_state] ( trans_prob_rate[isM,isA] )?
			{
			dbg.location(10,4);
			match(input,19,FOLLOW_19_in_transition_def65); dbg.location(10,9);
			pushFollow(FOLLOW_state_in_transition_def69);
			a=state(root_state);
			state._fsp--;
			dbg.location(10,29);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:29: ( trans_prob_rate[isM,isA] )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==FLOAT||LA6_0==INT) ) {
				alt6=1;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:29: trans_prob_rate[isM,isA]
					{
					dbg.location(10,29);
					pushFollow(FOLLOW_trans_prob_rate_in_transition_def73);
					trans_prob_rate(isM, isA);
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(6);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(11, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "transition_def");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return ;
	}
	// $ANTLR end "transition_def"



	// $ANTLR start "trans_prob_rate"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:13:1: trans_prob_rate[boolean isM,boolean isA] : (a= FLOAT |b= INT ) ;
	public final void trans_prob_rate(boolean isM, boolean isA) throws RecognitionException {
		Token a=null;
		Token b=null;

		try { dbg.enterRule(getGrammarFileName(), "trans_prob_rate");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(13, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:14:2: ( (a= FLOAT |b= INT ) )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:14:4: (a= FLOAT |b= INT )
			{
			dbg.location(14,4);
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:14:4: (a= FLOAT |b= INT )
			int alt7=2;
			try { dbg.enterSubRule(7);
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==FLOAT) ) {
				alt7=1;
			}
			else if ( (LA7_0==INT) ) {
				alt7=2;
			}
			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:14:5: a= FLOAT
					{
					dbg.location(14,6);
					a=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_trans_prob_rate92); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:14:13: b= INT
					{
					dbg.location(14,14);
					b=(Token)match(input,INT,FOLLOW_INT_in_trans_prob_rate96); 
					}
					break;

			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(15,2);

					float r;
					if(b == null) { r = Float.parseFloat((a!=null?a.getText():null));} else { r = Float.parseFloat((b!=null?b.getText():null));}

					if(r != 0 && r != 1) {
						if (isA) 
							{		
								System.out.println("Warning (probabilistic transition): line -> " + (a!=null?a.getLine():0)  + " column -> " + (a!=null?a.getCharPositionInLine():0));
							}
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
		dbg.location(26, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "trans_prob_rate");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return ;
	}
	// $ANTLR end "trans_prob_rate"



	// $ANTLR start "state"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:28:1: state[String st] returns [String actual_st] : st2= ID ;
	public final String state(String st) throws RecognitionException {
		String actual_st = null;


		Token st2=null;

		try { dbg.enterRule(getGrammarFileName(), "state");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:29:2: (st2= ID )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:29:4: st2= ID
			{
			dbg.location(29,7);
			st2=(Token)match(input,ID,FOLLOW_ID_in_state120); dbg.location(30,2);

					actual_st = (st2!=null?st2.getText():null);
					if(st.equals(actual_st)) {
						System.out.println("Warning (markovian loop): line -> " + (st2!=null?st2.getLine():0)  + " column -> " + (st2!=null?st2.getCharPositionInLine():0));
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
		dbg.location(36, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "state");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return actual_st;
	}
	// $ANTLR end "state"



	// $ANTLR start "markovian_trans"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:38:1: markovian_trans returns [boolean isMarkovian] : '!' ;
	public final boolean markovian_trans() throws RecognitionException {
		boolean isMarkovian = false;


		try { dbg.enterRule(getGrammarFileName(), "markovian_trans");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(38, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:39:2: ( '!' )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:39:4: '!'
			{
			dbg.location(39,4);
			match(input,18,FOLLOW_18_in_markovian_trans139); dbg.location(39,8);
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
		dbg.location(39, 45);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "markovian_trans");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return isMarkovian;
	}
	// $ANTLR end "markovian_trans"



	// $ANTLR start "action"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:41:1: action returns [boolean isAction] : ID ;
	public final boolean action() throws RecognitionException {
		boolean isAction = false;


		try { dbg.enterRule(getGrammarFileName(), "action");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(41, 0);

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:2: ( ID )
			dbg.enterAlt(1);

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:42:4: ID
			{
			dbg.location(42,4);
			match(input,ID,FOLLOW_ID_in_action155); dbg.location(42,7);
			isAction = true;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(42, 32);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "action");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return isAction;
	}
	// $ANTLR end "action"

	// Delegated rules



	public static final BitSet FOLLOW_INITIAL_STATE_in_imc12 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_imc16 = new BitSet(new long[]{0x0000000000000480L});
	public static final BitSet FOLLOW_FINAL_STATE_in_imc20 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_imc24 = new BitSet(new long[]{0x0000000000008400L});
	public static final BitSet FOLLOW_TRANSITION_STATE_in_imc28 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_transitions_in_imc30 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_state_in_transitions42 = new BitSet(new long[]{0x0000000000040400L});
	public static final BitSet FOLLOW_action_in_transitions46 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_markovian_trans_in_transitions48 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_transition_def_in_transitions52 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19_in_transition_def65 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_state_in_transition_def69 = new BitSet(new long[]{0x0000000000001102L});
	public static final BitSet FOLLOW_trans_prob_rate_in_transition_def73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_trans_prob_rate92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_trans_prob_rate96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_state120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_markovian_trans139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_action155 = new BitSet(new long[]{0x0000000000000002L});
}
