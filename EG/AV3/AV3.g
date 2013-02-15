grammar AV3;

@header {
	import java.util.HashMap;
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
