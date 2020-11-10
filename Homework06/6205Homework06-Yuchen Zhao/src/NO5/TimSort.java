package NO5;

public class TimSort {
	private final int minrun = 32;

	public TimSort() {
		// TODO Auto-generated constructor stub
	}
	
	private int min(int a, int b) {
		if(a <= b) return a;
		return b;
	}
	
	private void merge(double[] a, double[] aux, int lo, int mid, int hi) {
//		System.out.println(lo + " " + mid + " " + hi);
		for(int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(aux[i] < aux[j]) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	private void InsertionSort(double[] arr, int lo, int hi) {
		int holeposition;
		double valueToInsert;
		for(int i = lo; i <= hi; i++) {
			holeposition = i;
			valueToInsert = arr[i];
			while(holeposition > lo && valueToInsert < arr[holeposition - 1]) {
				arr[holeposition] = arr[holeposition - 1];
				holeposition--;
			}
			arr[holeposition] = valueToInsert;
		}
	}
	
	public void Sort(double[] a) {
		int len = a.length;
		for(int i = 0; i < len; i += minrun) {
			InsertionSort(a, i, min(i + minrun - 1, len - 1));
		}
		double[] aux = new double[len];
		for(int i = minrun; i < len; i *= 2) {
			for(int j = 0; j < len; j += i * 2) {
				merge(a, aux, j, j + i - 1, min(j + i * 2 - 1, len - 1));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		long time1, time2;
		double[] I;
		ReadColorTest rc = new ReadColorTest();
		I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
		TimSort ts = new TimSort();
		time1 = System.nanoTime();
		System.out.println("TimSort Processing...");
		ts.Sort(I);
		time2 = System.nanoTime();
		System.out.println("TimSort takes " + (double)(time2 - time1) / 1000000 + " ms");
//		for(var c : I) System.out.print(c + " ");
	}
}
