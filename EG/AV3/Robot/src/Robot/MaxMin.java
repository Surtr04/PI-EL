package Robot;

public class MaxMin{
	public int max;
	public int min;
	public int inicio;
	public int fim;
	public int step;
	public MaxMin(int a, int b){
		this.inicio = a;
		this.fim = b;
		if (a > b) {this.max = a; this.min = b; this.step = -1;}
		else {this.max = b; this.min = a; this.step = 1;}
	}
	public boolean teste(int i){
		if (this.inicio > this.fim) 
			return (i >= this.fim);
		else
			return (i <= this.fim);
				
	}
}
