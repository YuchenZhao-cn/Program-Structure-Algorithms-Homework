package NO5;

public class QuickSortLast {

	public QuickSortLast() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(double[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		double c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	// pivot last element
	private int partitionLast(double[] arr, int low, int high) {
//		System.out.println("partition " + low + " " + high);
		int i = low - 1;
		double pivot = arr[high];
		for(int j = low; j <= high - 1; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	
	private void SortLast(double[] arr, int low, int high) {
//		System.out.println(low + " " + high);
		if(low >= high) return;
		int pi = partitionLast(arr, low, high);
		SortLast(arr, low, pi - 1);
		SortLast(arr, pi + 1, high);
	}
	
	public void SortLast(double[] arr) {
		SortLast(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) throws Exception {
		long time1, time2;
		double[] I;
		ReadColorTest rc = new ReadColorTest();
		I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
		QuickSortLast qsl = new QuickSortLast();
		time1 = System.nanoTime();
		System.out.println("QuickSort(Last) Processing...");
		qsl.SortLast(I);
		time2 = System.nanoTime();
		System.out.println("QuickSort(Last) takes " + (double)(time2 - time1) / 1000000 + " ms");
//		for(var c : I) System.out.print(c + " ");
	}
}
