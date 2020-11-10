package NO2;

import java.util.Scanner;

public class MainC {

	public MainC() {
		// TODO Auto-generated constructor stub
	}
	
	public int IterativePow(int x, int n) {
		int result = 1;
		for(int i = 0; i < n; i++) {
			result = x * result;
		}
		return result;
	}
	
	public int RecursivePow(int x, int n) {
		if(n == 1) return x;
		return x * RecursivePow(x, n - 1);
	}
	
	public static void main(String[] args) {
		MainC m =new MainC();
		Scanner in = new Scanner(System.in);
		System.out.print("Input an Integer as x: ");
		int x = in.nextInt();
		System.out.print("Input an Integer as n: ");
		int n = in.nextInt();
		in.close();
		long time1 = System.nanoTime();
		int result = m.IterativePow(x, n);
		long time2 = System.nanoTime();
		System.out.println("Iterative algorithm: " + result);
		System.out.println("Iterative algorithm takes " + (time2 - time1) + " ns");
		time1 = System.nanoTime();
		result = m.RecursivePow(x, n);
		time2 = System.nanoTime();
		System.out.println("Recursive algorithm: " + result);
		System.out.println("Recursive algorithm takes " + (time2 - time1) + " ns");
		
	}

}
