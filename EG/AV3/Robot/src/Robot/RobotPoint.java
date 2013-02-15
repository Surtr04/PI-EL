package Robot;
import java.util.HashMap;

	
	public class RobotPoint {
	
		public enum movement {
			NORTH,
			SOUTH,
			EAST,
			WEST
		}
		
		private int x;
		private int y;
		private HashMap<movement,Integer> dist;
		private HashMap<movement,Integer> turns;
		private int distOn;
		private Boolean isOn;		
		
		public RobotPoint(int x, int y) {
			this.x = x;
			this.y = y;
			dist = new HashMap<movement,Integer>();
			turns = new HashMap<movement,Integer>();
			distOn = 0;
		}
		
		//test whether RobotPoint is outside the area
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
		}
		
		public void setOff() {			
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