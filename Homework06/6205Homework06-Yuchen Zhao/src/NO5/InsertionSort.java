package NO5;

public class InsertionSort {

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void Sort(double[] arr) {
		int holeposition;
		double valueToInsert;
		for(int i = 0; i < arr.length; i++) {
			holeposition = i;
			valueToInsert = arr[i];
			while(holeposition > 0 && valueToInsert < arr[holeposition - 1]) {
				arr[holeposition] = arr[holeposition - 1];
				holeposition--;
			}
			arr[holeposition] = valueToInsert;
		}
	}
	
	public static void main(String[] args) throws Exception {
		long time1, time2;
		double[] I;
		ReadColorTest rc = new ReadColorTest();
		I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
		InsertionSort is = new InsertionSort();
		double I1[] = I;
		time1 = System.nanoTime();
		System.out.println("InsertionSort Processing...");
		is.Sort(I1);
		time2 = System.nanoTime();
		System.out.println("InsertionSort takes " + (double)(time2 - time1) / 1000000 + " ms");
//		for(var c : I) System.out.print(c + " ");
	}
}
