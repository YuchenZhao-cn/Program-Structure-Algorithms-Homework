package NO3;

public class Main {
	String[] array = {"0", "1"};

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] GrayCode(int n) {
		if(n == 1) return array;
		String[] array1 = GrayCode(n - 1);
		int len = array1.length;
		String[] array2 = new String[len * 2];
		for(int i = 0; i < len; i++) {
			array2[i] = "0" + array1[i];
		}
		for(int i = len; i < len * 2; i++) {
			array2[i] = "1" + array1[len * 2 - i - 1];
		}
		return array2;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		String[] a1 = m.GrayCode(1);
		String[] a2 = m.GrayCode(2);
		String[] a3 = m.GrayCode(3);
		String[] a4 = m.GrayCode(4);
		String[] a5 = m.GrayCode(5);
		String[] a6 = m.GrayCode(6);
		System.out.print("GrayCode (n=1):");
		for(var c : a1) {
			System.out.print(c + " ");
		}
		System.out.print("\nGrayCode (n=2):");
		for(var c : a2) {
			System.out.print(c + " ");
		}
		System.out.print("\nGrayCode (n=3):");
		for(var c : a3) {
			System.out.print(c + " ");
		}
		System.out.print("\nGrayCode (n=4):");
		for(var c : a4) {
			System.out.print(c + " ");
		}
		System.out.print("\nGrayCode (n=5):");
		for(var c : a5) {
			System.out.print(c + " ");
		}
		System.out.print("\nGrayCode (n=6):");
		for(var c : a6) {
			System.out.print(c + " ");
		}
	}

}
