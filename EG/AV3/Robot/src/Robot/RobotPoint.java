package Robot;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import java.lang.StringBuilder;
import javax.swing.JButton;
import javax.swing.JFrame;

	
	public class RobotPoint {
	
		public final int BTNSIZE = 50;
		
		private int x;
		private int y;
		private JFrame j;
		private static ArrayList<ArrayList<JButton>> btns = new ArrayList<ArrayList<JButton>>();
		private HashMap<movement,Integer> dist;
		private HashMap<movement,Integer> turns;
		private int distOn;
		private Boolean isOn;	
		private movement dir;
		
		
		public RobotPoint(int x, int y, JFrame j) {
			this(x,y,j,movement.SOUTH);
		}
		public RobotPoint(int x, int y, JFrame j, movement dir) {
			this.x = x;
			this.y = y;
			this.j = j;
			dist = new HashMap<movement,Integer>();
			turns = new HashMap<movement,Integer>();
			distOn = 0;
			this.isOn = false;
			this.dir = dir;
		}
		private boolean check(){
			int a = this.getAltura();
			int l = this.getLargura();
			return !(a < 0 || a >= btns.size() || l < 0 || l >= btns.get(a).size());
		}
		public void putRobot(){
			if (this.check()){
				JButton btn = btns.get(this.getAltura()).get(this.getLargura());
				StringBuilder sb = new StringBuilder("");
				if (this.isOn) btn.setForeground(Color.green); else btn.setForeground(Color.black);
				switch (this.dir){
					case NORTH: sb.append("/\\"); break;
					case SOUTH: sb.append("V"); break;
					case WEST: sb.append("<"); break;
					case EAST: sb.append(">"); break;
				}
				btn.setText(sb.toString());
			}
		}
		public void cleanRobot(){
			if (this.check()) btns.get(this.getAltura()).get(this.getLargura()).setText(" ");
		}
		public void fillWindow(){
			ArrayList<JButton> linha;
			int altura, largura;
			JButton btn;
			
			altura = this.getAltura();
            largura = this.getLargura();
			
			for(int i = 0; i<altura;i++){
            	btns.add(new ArrayList<JButton>());
            	linha = btns.get(i);
            	for(int j = 0; j<largura;j++){
            		btn = new JButton(" ");
            		btn.setName("btn" + i + "_" + j);
            		this.j.getContentPane().add(btn);
            		btn.setBounds(BTNSIZE*j, BTNSIZE*i, BTNSIZE, BTNSIZE);
            		linha.add(btn);
            	}
            }
            this.j.pack();
            this.j.setSize((largura+2)*BTNSIZE, (altura+2)*BTNSIZE);
			
		}
		
		//test whether RobotPoint is outside the area
		public Boolean outside (RobotPoint p) {
			if(p.x > this.x || p.x < 0)
				return true;
			if(p.y > this.y || p.y < 0)
				return true;
				
			return false;
		}
		
		
		public int getX() { return this.x;}
		public int getY() { return this.y;}
		
		public int getLargura() { return this.x;}
		public int getAltura() { return this.y;}
		
		public int getOnDist() { return distOn;}
								
		public void setOn() { isOn = true;}
		
		public void setOff() { isOn = false; }
		
		public void move(int d, movement or) {
		
			MaxMin ny, nx;
			int actualy = this.y, actualx = this.x;
			int novoy = this.y, novox = this.x;
			this.cleanRobot();
			if(isOn)
				distOn += d;
			
		
			if(or == movement.NORTH) novoy -= d;
			if(or == movement.SOUTH) novoy += d;
			if(or == movement.EAST) novox += d;
			if(or == movement.WEST) novox -= d;

			
			if(dist.containsKey(or)) {
				dist.put(or,dist.get(or) + d);
				turns.put(or,turns.get(or) + 1);
			}
			else {
				dist.put(or,d);
				turns.put(or,1);
			}
			this.dir = or;
			nx = new MaxMin(actualx, novox);
			ny = new MaxMin(actualy, novoy);
			for(int i = ny.inicio; ny.teste(i); i+= ny.step){
				for (int j = nx.inicio; nx.teste(j); j+= nx.step){
					this.cleanRobot();
					this.y = i;
					this.x = j;
					this.putRobot();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			//this.putRobot();
			
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
			for (movement o : movement.values()) {
				if (dist.containsKey(o)){
					str.append(o.toString()).append(": ").append(dist.get(o) / turns.get(o)).append("u\n");
				} else {
					str.append(o.toString()).append(": 0u\n");
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