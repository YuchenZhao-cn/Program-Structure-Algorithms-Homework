package NO2;

public class MainD {

	public MainD() {
		// TODO Auto-generated constructor stub
	}
	
	public int Fibonacci(int i) {
		if(i == 0) return 1;
		else if(i == 1) return 1;
		return Fibonacci(i - 1) + Fibonacci(i - 2);
	}
	
	public static void main(String[] args) {
		MainD m = new MainD();
		System.out.println("Fibonacci (n=6): " + m.Fibonacci(6));
		System.out.println("Fibonacci (n=7): " + m.Fibonacci(7));
	}

}
