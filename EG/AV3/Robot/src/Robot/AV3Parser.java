// $ANTLR 3.5 /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g 2013-02-15 18:52:56
package Robot;

	import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AV3Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ESC_SEQ", "EXPONENT", "FLOAT", 
		"HEX_DIGIT", "ID", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", 
		"':'", "';'", "'AREA:'", "'DESLIGAR'", "'ESTE'", "'LIGAR'", "'MOVER'", 
		"'NORTE'", "'OESTE'", "'ORIGIN:'", "'SUL'"
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

	@Override public String[] getTokenNames() { return AV3Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g"; }



		public enum movement {
			NORTH,
			SOUTH,
			EAST,
			WEST
		}
		
		class RobotPoint {
		
			private int x;
			private int y;
			private HashMap<movement,Integer> dist;
			private HashMap<movement,Integer> turns;
			private int distOn;
			private Boolean isOn;
			private Boolean isOff;		
			
			public RobotPoint(int x, int y) {
				this.x = x;
				this.y = y;
				dist = new HashMap<movement,Integer>();
				turns = new HashMap<movement,Integer>();
				distOn = 0;
			}
			
			//test wether RobotPoint is outside the area
			public Boolean outside (RobotPoint p) {
				if(p.x > this.x || p.x < 0)
					return true;
				if(p.y > this.y || p.y < 0)
					return true;
					
				return false;
			}
			
			public int getOnDist() {
				return distOn;
			}
									
			public void setOn() {
				isOn = true;
				isOff = false;
			}
			
			public void setOff() {
				isOff = true;
				isOn = false;
			}
			
			public void move(int d, movement or) {
			
				if(isOn)
					distOn += d;
				
			
				if(or == movement.NORTH) {
					this.y += d;
					if(dist.containsKey(or)) {
						dist.put(or,dist.get(or) + d);
						turns.put(or,turns.get(or) + 1);
					}
					else {
						dist.put(or,d);
						turns.put(or,1);
					}
				}
				
				if(or == movement.SOUTH) {
					this.y -= d;
					if(dist.containsKey(or)) {
						dist.put(or,dist.get(or) + d);
						turns.put(or,turns.get(or) + 1);
					}
					else {
						dist.put(or,d);
						turns.put(or,1);
					}
				}
				
				if(or == movement.EAST) {
					this.x += d;
					if(dist.containsKey(or)) {
						dist.put(or,dist.get(or) + d);
						turns.put(or,turns.get(or) + 1);
					}
					else {
						dist.put(or,d);
						turns.put(or,1);
					}
				}
				
				if(or == movement.WEST) {
					this.x -= d;
					if(dist.containsKey(or)) {
						dist.put(or,dist.get(or) + d);
						turns.put(or,turns.get(or) + 1);
					}
					else {
						dist.put(or,d);
						turns.put(or,1);
					}
				}
			}
			
			
			public Integer distance() {
				Integer d = 0;
				for (movement o : dist.keySet()) {
					d+= dist.get(o);
				}
				return d;
			}
			
			public String distanceOrientation() {
				StringBuilder str = new StringBuilder();			
				for (movement o : dist.keySet()) {
					if (o == movement.NORTH) {
						str.append("NORTH: " + dist.get(o) / turns.get(o) + "u\n");
					}
					if (o == movement.SOUTH) {
						str.append("SOUTH: " + dist.get(o) / turns.get(o) + "u\n");
					}
					if (o == movement.EAST) {
						str.append("EAST: " + dist.get(o) / turns.get(o) + "u\n");
					}
					if (o == movement.WEST) {
						str.append("WEST: " + dist.get(o) / turns.get(o) + "u\n");
					}			
				}
				return str.toString();
			}
			
			public Integer getNumTurns() {
				Integer d = 0;
				for (movement o : turns.keySet()) {
					d += turns.get(o);
				}
				return d;
			}
		
		}
		



	// $ANTLR start "robot"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:153:1: robot : a= header orders[$a.area,$a.coord] ;
	public final void robot() throws RecognitionException {
		ParserRuleReturnScope a =null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:154:2: (a= header orders[$a.area,$a.coord] )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:154:4: a= header orders[$a.area,$a.coord]
			{
			pushFollow(FOLLOW_header_in_robot27);
			a=header();
			state._fsp--;

			pushFollow(FOLLOW_orders_in_robot29);
			orders((a!=null?((AV3Parser.header_return)a).area:null), (a!=null?((AV3Parser.header_return)a).coord:null));
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
	}
	// $ANTLR end "robot"


	public static class header_return extends ParserRuleReturnScope {
		public RobotPoint area;
		public RobotPoint coord;
	};


	// $ANTLR start "header"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:157:1: header returns [RobotPoint area,RobotPoint coord] : 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' orientation )? ';' ;
	public final AV3Parser.header_return header() throws RecognitionException {
		AV3Parser.header_return retval = new AV3Parser.header_return();
		retval.start = input.LT(1);

		Token x=null;
		Token y=null;
		Token x1=null;
		Token y1=null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:158:2: ( 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' orientation )? ';' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:158:4: 'AREA:' x= INT ':' y= INT ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' orientation )? ';'
			{
			match(input,16,FOLLOW_16_in_header47); 
			x=(Token)match(input,INT,FOLLOW_INT_in_header51); 
			match(input,14,FOLLOW_14_in_header53); 
			y=(Token)match(input,INT,FOLLOW_INT_in_header57); 
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:158:28: ( ';' 'ORIGIN:' x1= INT ':' y1= INT ':' orientation )?
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:158:29: ';' 'ORIGIN:' x1= INT ':' y1= INT ':' orientation
					{
					match(input,15,FOLLOW_15_in_header60); 
					match(input,23,FOLLOW_23_in_header62); 
					x1=(Token)match(input,INT,FOLLOW_INT_in_header66); 
					match(input,14,FOLLOW_14_in_header68); 
					y1=(Token)match(input,INT,FOLLOW_INT_in_header72); 
					match(input,14,FOLLOW_14_in_header74); 
					pushFollow(FOLLOW_orientation_in_header76);
					orientation();
					state._fsp--;

					}
					break;

			}

			match(input,15,FOLLOW_15_in_header80); 

				retval.area = new RobotPoint((x!=null?Integer.valueOf(x.getText()):0),(y!=null?Integer.valueOf(y.getText()):0)); 
				retval.coord = new RobotPoint((x1!=null?Integer.valueOf(x1.getText()):0),(y1!=null?Integer.valueOf(y1.getText()):0));
				
				if (retval.area.outside(retval.coord)) {
					System.out.println("Error: initial RobotPoint is outside determined area " + "(line: " + (y1!=null?y1.getLine():0) + " column: " + (y1!=null?y1.getCharPositionInLine():0) + ")");
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
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:170:1: orders[RobotPoint area, RobotPoint coord] : order[area,coord] ( ';' order[area,coord] )* ';' ;
	public final void orders(RobotPoint area, RobotPoint coord) throws RecognitionException {
		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:171:2: ( order[area,coord] ( ';' order[area,coord] )* ';' )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:171:4: order[area,coord] ( ';' order[area,coord] )* ';'
			{
			pushFollow(FOLLOW_order_in_orders97);
			order(area, coord);
			state._fsp--;

			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:171:22: ( ';' order[area,coord] )*
			loop2:
			while (true) {
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:171:23: ';' order[area,coord]
					{
					match(input,15,FOLLOW_15_in_orders101); 
					pushFollow(FOLLOW_order_in_orders103);
					order(area, coord);
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,15,FOLLOW_15_in_orders108); 

				System.out.println("Distance traversed: " + coord.distance() * 25 +"cm");
				System.out.println("Distance traversed while on: " + coord.getOnDist()*25 + "cm");
				System.out.println("Robot changed direction: " + coord.getNumTurns() + " times");
				System.out.println("Mean traversed units in earch direction:" + "\n" + coord.distanceOrientation());
				
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "orders"



	// $ANTLR start "order"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:183:1: order[RobotPoint area, RobotPoint coord] : ( 'MOVER' o= orientation d= distance | 'LIGAR' | 'DESLIGAR' );
	public final void order(RobotPoint area, RobotPoint coord) throws RecognitionException {
		movement o =null;
		ParserRuleReturnScope d =null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:184:2: ( 'MOVER' o= orientation d= distance | 'LIGAR' | 'DESLIGAR' )
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:184:4: 'MOVER' o= orientation d= distance
					{
					match(input,20,FOLLOW_20_in_order127); 
					pushFollow(FOLLOW_orientation_in_order131);
					o=orientation();
					state._fsp--;

					pushFollow(FOLLOW_distance_in_order135);
					d=distance();
					state._fsp--;


						coord.move((d!=null?((AV3Parser.distance_return)d).d:0),o);
						
						if(area.outside(coord))
							System.out.println("Error: RobotPoint is outside determined area " + "(line: " + (d!=null?((AV3Parser.distance_return)d).line:0) + " column: " + (d!=null?((AV3Parser.distance_return)d).column:0) + ")" );
							
						
					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:192:4: 'LIGAR'
					{
					match(input,19,FOLLOW_19_in_order144); 
					coord.setOn();
					}
					break;
				case 3 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:193:4: 'DESLIGAR'
					{
					match(input,17,FOLLOW_17_in_order151); 
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
	}
	// $ANTLR end "order"



	// $ANTLR start "orientation"
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:198:1: orientation returns [movement or] : ( 'NORTE' | 'SUL' | 'ESTE' | 'OESTE' );
	public final movement orientation() throws RecognitionException {
		movement or = null;


		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:199:2: ( 'NORTE' | 'SUL' | 'ESTE' | 'OESTE' )
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
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:199:4: 'NORTE'
					{
					match(input,21,FOLLOW_21_in_orientation173); 
					or = movement.NORTH;
					}
					break;
				case 2 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:200:4: 'SUL'
					{
					match(input,24,FOLLOW_24_in_orientation180); 
					or = movement.SOUTH;
					}
					break;
				case 3 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:201:4: 'ESTE'
					{
					match(input,18,FOLLOW_18_in_orientation187); 
					or = movement.EAST;
					}
					break;
				case 4 :
					// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:202:4: 'OESTE'
					{
					match(input,22,FOLLOW_22_in_orientation194); 
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
	// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:206:1: distance returns [int d,int line, int column] : a= INT ;
	public final AV3Parser.distance_return distance() throws RecognitionException {
		AV3Parser.distance_return retval = new AV3Parser.distance_return();
		retval.start = input.LT(1);

		Token a=null;

		try {
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:207:2: (a= INT )
			// /Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/AV3.g:207:4: a= INT
			{
			a=(Token)match(input,INT,FOLLOW_INT_in_distance216); 
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



	public static final BitSet FOLLOW_header_in_robot27 = new BitSet(new long[]{0x00000000001A0000L});
	public static final BitSet FOLLOW_orders_in_robot29 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_header47 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_INT_in_header51 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_header53 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_INT_in_header57 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_header60 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_header62 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_INT_in_header66 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_header68 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_INT_in_header72 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_header74 = new BitSet(new long[]{0x0000000001640000L});
	public static final BitSet FOLLOW_orientation_in_header76 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_header80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_order_in_orders97 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_orders101 = new BitSet(new long[]{0x00000000001A0000L});
	public static final BitSet FOLLOW_order_in_orders103 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_orders108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_order127 = new BitSet(new long[]{0x0000000001640000L});
	public static final BitSet FOLLOW_orientation_in_order131 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_distance_in_order135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_order144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_order151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_orientation173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_orientation180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_orientation187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_orientation194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_distance216 = new BitSet(new long[]{0x0000000000000002L});
}
