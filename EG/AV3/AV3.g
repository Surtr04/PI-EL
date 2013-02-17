grammar AV3;

@header {
	package Robot;
	import java.util.HashMap;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
}

@lexer::header {
	package Robot;
}

robot[JFrame janela] returns [RobotPoint area,RobotPoint coord]		
	: a=header[$robot.janela] orders[$a.area,$a.coord, $robot.janela]	{$robot.area = $a.area; $robot.coord = $a.coord;}
	;
	
header[JFrame janela] returns [RobotPoint area,RobotPoint coord]
	: {int vx = 0, vy = 0; movement vor = movement.SOUTH;}'AREA:' x=INT ':' y=INT (';' 'ORIGIN:' x1=INT ':' y1=INT ':' b=orientation {vx = $x1.int; vy = $y1.int; vor = $b.or;})? ';' 
	{
	$header.area = new RobotPoint($x.int,$y.int, $header.janela);
	$header.area.fillWindow();
	$header.coord = new RobotPoint(vx,vy, $header.janela, vor);
	$header.coord.putRobot();	
	if ($header.area.outside($header.coord)) {
		System.out.println("Error: initial RobotPoint is outside determined area " + "(line: " + $y1.line + " column: " + $y1.pos + ")");
		$header.coord = new RobotPoint(0,0, $header.janela, movement.SOUTH);
		$header.coord.putRobot();	
	} 
	};



orders [RobotPoint area, RobotPoint coord, JFrame janela]
	: order[area,coord] (';' order[area,coord])* ';' 
	{
	StringBuilder sb = new StringBuilder();
	sb.append("Distance traversed: ").append($orders.coord.distance() * 25).append("cm\n");
	sb.append("Distance traversed while on: ").append($orders.coord.getOnDist()*25).append("cm\n");
	sb.append("Robot changed direction: ").append($orders.coord.getNumTurns()).append(" times\n");
	sb.append("Mean traversed units in earch direction:\n").append($orders.coord.distanceOrientation());
	JOptionPane.showMessageDialog($orders.janela, sb.toString());
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
