void main() {
	int i;
	int max;
	int min;
	int n;
	int d;

	min = 4;
	max = 0;
	i = min;
	n = 10;
	d = 5;

	if(n > d) {
		while (n > 0) {
			n = n-d;
		}
	}
	
	while (i < max ){
		if( i % 2 == 0){
			print( i );
		}
		i = i+1;
	}
}
