grammar AV3;

@header {
	import java.util.HashMap;
}

@members {

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
	
}

robot		
	: a=header orders[$a.area,$a.coord]	
	;
	
header returns [RobotPoint area,RobotPoint coord]
	: 'AREA:' x=INT ':' y=INT (';' 'ORIGIN:' x1=INT ':' y1=INT ':' orientation)? ';' 
	{
	$header.area = new RobotPoint($x.int,$y.int); 
	$header.coord = new RobotPoint($x1.int,$y1.int);
	
	if ($header.area.outside($header.coord)) {
		System.out.println("Error: initial RobotPoint is outside determined area " + "(line: " + $y1.line + " column: " + $y1.pos + ")");
	} 
	};



orders [RobotPoint area, RobotPoint coord]
	: order[area,coord] (';' order[area,coord])* ';' 
	{
	System.out.println("Distance traversed: " + $orders.coord.distance() * 25 +"cm");
	System.out.println("Distance traversed while on: " + $orders.coord.getOnDist()*25 + "cm");
	System.out.println("Robot changed direction: " + $orders.coord.getNumTurns() + " times");
	System.out.println("Mean traversed units in earch direction:" + "\n" + $orders.coord.distanceOrientation());
	
	};



	
order [RobotPoint area, RobotPoint coord]
	: 'MOVER' o=orientation d=distance 
	{
	$order.coord.move($d.d,o);
	
	if($order.area.outside($order.coord))
		System.out.println("Error: RobotPoint is outside determined area " + "(line: " + $d.line + " column: " + $d.column + ")" );
		
	}
	| 'LIGAR' {$order.coord.setOn();}
	| 'DESLIGAR' {$order.coord.setOff();};
	
	
	
	
orientation returns [movement or]
	:	'NORTE' {$orientation.or = movement.NORTH;}
	|	'SUL' {$orientation.or = movement.SOUTH;}
	|	'ESTE' {$orientation.or = movement.EAST;}
	|	'OESTE' {$orientation.or = movement.WEST;};
	
	
	
distance returns [int d,int line, int column]
	: a=INT {$distance.d = $a.int; $distance.line = $a.line; $distance.column = $a.pos;}; 


ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'-'?'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
