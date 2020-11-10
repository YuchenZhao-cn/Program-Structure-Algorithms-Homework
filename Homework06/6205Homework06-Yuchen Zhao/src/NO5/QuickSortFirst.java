package NO5;

public class QuickSortFirst {

	public QuickSortFirst() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(double[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		double c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	// pivot first element
		private int partitionFirst(double[] arr, int low, int high) {
//			System.out.println("partition " + low + " " + high);
			int i = low;
			double pivot = arr[low];
			for(int j = low + 1; j <= high; j++) {
				if(arr[j] < pivot) {
					i++;
					swap(arr, i, j);
				}
			}
			swap(arr, i, low);
			return i;
		}
		
		private void SortFirst(double[] arr, int low, int high) {
//			System.out.println(low + " " + high);
			if(low >= high) return;
			int pi = partitionFirst(arr, low, high);
			SortFirst(arr, low, pi - 1);
			SortFirst(arr, pi + 1, high);
		}
		
		public void SortFirst(double[] arr) {
			SortFirst(arr, 0, arr.length - 1);
		}
		
		public static void main(String[] args) throws Exception {
			long time1, time2;
			double[] I;
			ReadColorTest rc = new ReadColorTest();
			I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
			QuickSortFirst qsf = new QuickSortFirst();
			time1 = System.nanoTime();
			System.out.println("QuickSort(First) Processing...");
			qsf.SortFirst(I);
			time2 = System.nanoTime();
			System.out.println("QuickSort(First) takes " + (double)(time2 - time1) / 1000000 + " ms");
//			for(var c : I) System.out.print(c + " ");
		}

}
