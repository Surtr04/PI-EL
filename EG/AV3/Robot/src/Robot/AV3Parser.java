// $ANTLR 3.4 C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g 2013-02-17 20:33:36

	package Robot;
	import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AV3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "':'", "';'", "'AREA:'", "'DESLIGAR'", "'ESTE'", "'LIGAR'", "'MOVER'", "'NORTE'", "'OESTE'", "'ORIGIN:'", "'SUL'"
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


    public AV3Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AV3Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AV3Parser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g"; }


    public static class robot_return extends ParserRuleReturnScope {
        public RobotPoint area;
        public RobotPoint coord;
    };


    // $ANTLR start "robot"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:14:1: robot[JFrame janela] returns [RobotPoint area,RobotPoint coord] : a= header[$robot.janela] orders[$a.area,$a.coord, $robot.janela] ;
    public final AV3Parser.robot_return robot(JFrame janela) throws RecognitionException {
        AV3Parser.robot_return retval = new AV3Parser.robot_return();
        retval.start = input.LT(1);


        AV3Parser.header_return a =null;


        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:15:2: (a= header[$robot.janela] orders[$a.area,$a.coord, $robot.janela] )
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:15:4: a= header[$robot.janela] orders[$a.area,$a.coord, $robot.janela]
            {
            pushFollow(FOLLOW_header_in_robot35);
            a=header(janela);

            state._fsp--;


            pushFollow(FOLLOW_orders_in_robot38);
            orders((a!=null?a.area:null), (a!=null?a.coord:null), janela);

            state._fsp--;


            retval.area = (a!=null?a.area:null); retval.coord = (a!=null?a.coord:null);

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
    // $ANTLR end "robot"


    public static class header_return extends ParserRuleReturnScope {
        public RobotPoint area;
        public RobotPoint coord;
    };


    // $ANTLR start "header"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:18:1: header[JFrame janela] returns [RobotPoint area,RobotPoint coord] : 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' b= orientation )? ';' ;
    public final AV3Parser.header_return header(JFrame janela) throws RecognitionException {
        AV3Parser.header_return retval = new AV3Parser.header_return();
        retval.start = input.LT(1);


        Token x=null;
        Token y=null;
        Token x1=null;
        Token y1=null;
        movement b =null;


        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:19:2: ( 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' b= orientation )? ';' )
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:19:4: 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' b= orientation )? ';'
            {
            int vx = 0, vy = 0; movement vor = movement.SOUTH;

            match(input,16,FOLLOW_16_in_header59); 

            x=(Token)match(input,INT,FOLLOW_INT_in_header63); 

            match(input,14,FOLLOW_14_in_header65); 

            y=(Token)match(input,INT,FOLLOW_INT_in_header69); 

            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:19:80: ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' b= orientation )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==23) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:19:81: ';' 'ORIGIN:' x1= INT ':' y1= INT ':' b= orientation
                    {
                    match(input,15,FOLLOW_15_in_header72); 

                    match(input,23,FOLLOW_23_in_header74); 

                    x1=(Token)match(input,INT,FOLLOW_INT_in_header78); 

                    match(input,14,FOLLOW_14_in_header80); 

                    y1=(Token)match(input,INT,FOLLOW_INT_in_header84); 

                    match(input,14,FOLLOW_14_in_header86); 

                    pushFollow(FOLLOW_orientation_in_header90);
                    b=orientation();

                    state._fsp--;


                    vx = (x1!=null?Integer.valueOf(x1.getText()):0); vy = (y1!=null?Integer.valueOf(y1.getText()):0); vor = b;

                    }
                    break;

            }


            match(input,15,FOLLOW_15_in_header96); 


            	retval.area = new RobotPoint((x!=null?Integer.valueOf(x.getText()):0),(y!=null?Integer.valueOf(y.getText()):0), janela);
            	retval.area.fillWindow();
            	retval.coord = new RobotPoint(vx,vy, janela, vor);
            	retval.coord.putRobot();	
            	if (retval.area.outside(retval.coord)) {
            		System.out.println("Error: initial RobotPoint is outside determined area " + "(line: " + (y1!=null?y1.getLine():0) + " column: " + (y1!=null?y1.getCharPositionInLine():0) + ")");
            		retval.coord = new RobotPoint(0,0, janela, movement.SOUTH);
            		retval.coord.putRobot();	
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
    // $ANTLR end "header"



    // $ANTLR start "orders"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:34:1: orders[RobotPoint area, RobotPoint coord, JFrame janela] : order[area,coord] ( ';' order[area,coord] )* ';' ;
    public final void orders(RobotPoint area, RobotPoint coord, JFrame janela) throws RecognitionException {
        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:35:2: ( order[area,coord] ( ';' order[area,coord] )* ';' )
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:35:4: order[area,coord] ( ';' order[area,coord] )* ';'
            {
            pushFollow(FOLLOW_order_in_orders113);
            order(area, coord);

            state._fsp--;


            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:35:22: ( ';' order[area,coord] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==17||(LA2_1 >= 19 && LA2_1 <= 20)) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:35:23: ';' order[area,coord]
            	    {
            	    match(input,15,FOLLOW_15_in_orders117); 

            	    pushFollow(FOLLOW_order_in_orders119);
            	    order(area, coord);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,15,FOLLOW_15_in_orders124); 


            	StringBuilder sb = new StringBuilder();
            	sb.append("Distance traversed: ").append(coord.distance() * 25).append("cm\n");
            	sb.append("Distance traversed while on: ").append(coord.getOnDist()*25).append("cm\n");
            	sb.append("Robot changed direction: ").append(coord.getNumTurns()).append(" times\n");
            	sb.append("Mean traversed units in earch direction:\n").append(coord.distanceOrientation());
            	JOptionPane.showMessageDialog(janela, sb.toString());
            	

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
    // $ANTLR end "orders"



    // $ANTLR start "order"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:48:1: order[RobotPoint area, RobotPoint coord] : ( 'MOVER' o= orientation d= distance | 'LIGAR' | 'DESLIGAR' );
    public final void order(RobotPoint area, RobotPoint coord) throws RecognitionException {
        movement o =null;

        AV3Parser.distance_return d =null;


        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:49:2: ( 'MOVER' o= orientation d= distance | 'LIGAR' | 'DESLIGAR' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:49:4: 'MOVER' o= orientation d= distance
                    {
                    match(input,20,FOLLOW_20_in_order143); 

                    pushFollow(FOLLOW_orientation_in_order147);
                    o=orientation();

                    state._fsp--;


                    pushFollow(FOLLOW_distance_in_order151);
                    d=distance();

                    state._fsp--;



                    	coord.move((d!=null?d.d:0),o);
                    	if(area.outside(coord))
                    		System.out.println("Error: RobotPoint is outside determined area " + "(line: " + (d!=null?d.line:0) + " column: " + (d!=null?d.column:0) + ")" );
                    		
                    	

                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:56:4: 'LIGAR'
                    {
                    match(input,19,FOLLOW_19_in_order160); 

                    coord.setOn();

                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:57:4: 'DESLIGAR'
                    {
                    match(input,17,FOLLOW_17_in_order167); 

                    coord.setOff();

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
        return ;
    }
    // $ANTLR end "order"



    // $ANTLR start "orientation"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:62:1: orientation returns [movement or] : ( 'NORTE' | 'SUL' | 'ESTE' | 'OESTE' );
    public final movement orientation() throws RecognitionException {
        movement or = null;


        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:63:2: ( 'NORTE' | 'SUL' | 'ESTE' | 'OESTE' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:63:4: 'NORTE'
                    {
                    match(input,21,FOLLOW_21_in_orientation189); 

                    or = movement.NORTH;

                    }
                    break;
                case 2 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:64:4: 'SUL'
                    {
                    match(input,24,FOLLOW_24_in_orientation196); 

                    or = movement.SOUTH;

                    }
                    break;
                case 3 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:65:4: 'ESTE'
                    {
                    match(input,18,FOLLOW_18_in_orientation203); 

                    or = movement.EAST;

                    }
                    break;
                case 4 :
                    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:66:4: 'OESTE'
                    {
                    match(input,22,FOLLOW_22_in_orientation210); 

                    or = movement.WEST;

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
        return or;
    }
    // $ANTLR end "orientation"


    public static class distance_return extends ParserRuleReturnScope {
        public int d;
        public int line;
        public int column;
    };


    // $ANTLR start "distance"
    // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:70:1: distance returns [int d,int line, int column] : a= INT ;
    public final AV3Parser.distance_return distance() throws RecognitionException {
        AV3Parser.distance_return retval = new AV3Parser.distance_return();
        retval.start = input.LT(1);


        Token a=null;

        try {
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:71:2: (a= INT )
            // C:\\Users\\António\\Documents\\Escola\\Universidade\\4º Ano\\EL\\EG\\AV3\\AV3.g:71:4: a= INT
            {
            a=(Token)match(input,INT,FOLLOW_INT_in_distance232); 

            retval.d = (a!=null?Integer.valueOf(a.getText()):0); retval.line = (a!=null?a.getLine():0); retval.column = (a!=null?a.getCharPositionInLine():0);

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
    // $ANTLR end "distance"

    // Delegated rules


 

    public static final BitSet FOLLOW_header_in_robot35 = new BitSet(new long[]{0x00000000001A0000L});
    public static final BitSet FOLLOW_orders_in_robot38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_header59 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_header63 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_header65 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_header69 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_header72 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_header74 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_header78 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_header80 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INT_in_header84 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_header86 = new BitSet(new long[]{0x0000000001640000L});
    public static final BitSet FOLLOW_orientation_in_header90 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_header96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_in_orders113 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_orders117 = new BitSet(new long[]{0x00000000001A0000L});
    public static final BitSet FOLLOW_order_in_orders119 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_orders124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_order143 = new BitSet(new long[]{0x0000000001640000L});
    public static final BitSet FOLLOW_orientation_in_order147 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_distance_in_order151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_order160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_order167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_orientation189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_orientation196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_orientation203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_orientation210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_distance232 = new BitSet(new long[]{0x0000000000000002L});

}