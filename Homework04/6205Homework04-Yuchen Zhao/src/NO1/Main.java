package NO1;

import java.util.Scanner;

public class Main {

	public int countZero(int count) {
		if(count == 1) return 1;
		else if(count == 2) return 1;
		return countZero(count - 1) + countZero(count - 2);
	}
	
	public int countOne(int count) {
		if(count == 1) return 1;
		else if(count == 2) return 2;
		return countOne(count - 1) + countOne(count - 2);
	}
	
	public int countBinary(int count) {
		return countZero(count) + countOne(count);
	}
	
//	public int countBinary(int count) {
//		if(count == 1) return 2;
//		else if(count == 2) return 3;
//		return countOne(count - 1) + countOne(count - 2);
//	}
	
	public static void main(String[] args) { 
		Main m = new Main();
		System.out.print("Input an integer:");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		in.close();
		System.out.println(m.countBinary(input));
	}

}
