// $ANTLR 3.4 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g 2012-12-16 03:57:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
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
    "invalidRule", "action", "state", "transition_def", "markovian_trans", 
    "probabilistic_trans", "transitions", "imc"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false
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

    public String[] getTokenNames() { return IMCParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g"; }



    // $ANTLR start "imc"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:1: imc : INITIAL_STATE state FINAL_STATE state TRANSITION_STATE ( transitions )+ ;
    public final void imc() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "imc");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(3, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:3:5: ( INITIAL_STATE state FINAL_STATE state TRANSITION_STATE ( transitions )+ )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:2: INITIAL_STATE state FINAL_STATE state TRANSITION_STATE ( transitions )+
            {
            dbg.location(4,2);
            match(input,INITIAL_STATE,FOLLOW_INITIAL_STATE_in_imc12); 
            dbg.location(4,16);
            pushFollow(FOLLOW_state_in_imc14);
            state();

            state._fsp--;

            dbg.location(4,22);
            match(input,FINAL_STATE,FOLLOW_FINAL_STATE_in_imc16); 
            dbg.location(4,34);
            pushFollow(FOLLOW_state_in_imc18);
            state();

            state._fsp--;

            dbg.location(4,40);
            match(input,TRANSITION_STATE,FOLLOW_TRANSITION_STATE_in_imc20); 
            dbg.location(4,57);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:57: ( transitions )+
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

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:4:57: transitions
            	    {
            	    dbg.location(4,57);
            	    pushFollow(FOLLOW_transitions_in_imc22);
            	    transitions();

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(4, 68);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:6:1: transitions : state ( action | markovian_trans ) ( transition_def )+ ;
    public final void transitions() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "transitions");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(6, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:2: ( state ( action | markovian_trans ) ( transition_def )+ )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:4: state ( action | markovian_trans ) ( transition_def )+
            {
            dbg.location(7,4);
            pushFollow(FOLLOW_state_in_transitions32);
            state();

            state._fsp--;

            dbg.location(7,10);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:10: ( action | markovian_trans )
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:11: action
                    {
                    dbg.location(7,11);
                    pushFollow(FOLLOW_action_in_transitions35);
                    action();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:18: markovian_trans
                    {
                    dbg.location(7,18);
                    pushFollow(FOLLOW_markovian_trans_in_transitions37);
                    markovian_trans();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}

            dbg.location(7,35);
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:35: ( transition_def )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:7:35: transition_def
            	    {
            	    dbg.location(7,35);
            	    pushFollow(FOLLOW_transition_def_in_transitions40);
            	    transition_def();

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
        dbg.location(7, 49);

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
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:9:1: transition_def : '*' state probabilistic_trans ;
    public final void transition_def() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "transition_def");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(9, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:2: ( '*' state probabilistic_trans )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:10:4: '*' state probabilistic_trans
            {
            dbg.location(10,4);
            match(input,19,FOLLOW_19_in_transition_def50); 
            dbg.location(10,8);
            pushFollow(FOLLOW_state_in_transition_def52);
            state();

            state._fsp--;

            dbg.location(10,14);
            pushFollow(FOLLOW_probabilistic_trans_in_transition_def54);
            probabilistic_trans();

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
        dbg.location(10, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "transition_def");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "transition_def"



    // $ANTLR start "probabilistic_trans"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:12:1: probabilistic_trans : ( FLOAT | INT ) ;
    public final void probabilistic_trans() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "probabilistic_trans");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(12, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:13:2: ( ( FLOAT | INT ) )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:
            {
            dbg.location(13,2);
            if ( input.LA(1)==FLOAT||input.LA(1)==INT ) {
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
        dbg.location(13, 14);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "probabilistic_trans");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "probabilistic_trans"



    // $ANTLR start "markovian_trans"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:15:1: markovian_trans : '!' ;
    public final void markovian_trans() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "markovian_trans");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:16:2: ( '!' )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:16:4: '!'
            {
            dbg.location(16,4);
            match(input,18,FOLLOW_18_in_markovian_trans76); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(16, 6);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "markovian_trans");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "markovian_trans"



    // $ANTLR start "state"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:18:1: state : ID ;
    public final void state() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "state");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(18, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:19:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:19:4: ID
            {
            dbg.location(19,4);
            match(input,ID,FOLLOW_ID_in_state85); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(19, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "state");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "state"



    // $ANTLR start "action"
    // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:21:1: action : ID ;
    public final void action() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "action");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 0);

        try {
            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:2: ( ID )
            dbg.enterAlt(1);

            // /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/IMC.g:22:4: ID
            {
            dbg.location(22,4);
            match(input,ID,FOLLOW_ID_in_action95); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(22, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "action");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "action"

    // Delegated rules


 

    public static final BitSet FOLLOW_INITIAL_STATE_in_imc12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_state_in_imc14 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FINAL_STATE_in_imc16 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_state_in_imc18 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_TRANSITION_STATE_in_imc20 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_transitions_in_imc22 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_state_in_transitions32 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_action_in_transitions35 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_markovian_trans_in_transitions37 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_transition_def_in_transitions40 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_transition_def50 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_state_in_transition_def52 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_probabilistic_trans_in_transition_def54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_markovian_trans76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_state85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_action95 = new BitSet(new long[]{0x0000000000000002L});

}