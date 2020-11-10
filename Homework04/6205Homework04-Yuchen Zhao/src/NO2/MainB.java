package NO2;

public class MainB {
	private int count = 0;

	public MainB() {
		// TODO Auto-generated constructor stub
	}
	
	public void Tower_of_Hanoi(int n, char from_rod, char to_rod, char aux_rod) {
		if(n == 1) {
			System.out.println("Move disk-1 from rod " + from_rod + " to rod " + to_rod);
			count++;
			return;
		}
		Tower_of_Hanoi(n-1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk-" + n + " from rod " + from_rod + " to rod " + to_rod);
		count++;
		Tower_of_Hanoi(n-1, aux_rod, to_rod, from_rod);
	}
	
	public static void main(String[] args) {
		int n = 6;
		MainB m = new MainB();
		m.Tower_of_Hanoi(n, 'A', 'B', 'C');
		System.out.println("It takes " + m.count + " steps");
	}

}
