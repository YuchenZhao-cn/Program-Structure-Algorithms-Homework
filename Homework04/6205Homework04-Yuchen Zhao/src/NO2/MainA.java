package NO2;

public class MainA {

	public MainA() {
		// TODO Auto-generated constructor stub
	}
	
	public int factorial(int count) {
		if(count == 1) return 1;
		return count * factorial(count - 1);
	}
	
	public static void main(String[] args) {
		MainA m = new MainA();
		System.out.println(m.factorial(6));
	}

}
