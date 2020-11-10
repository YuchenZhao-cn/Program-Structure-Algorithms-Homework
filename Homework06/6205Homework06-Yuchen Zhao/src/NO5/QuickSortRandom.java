package NO5;

public class QuickSortRandom {

	public QuickSortRandom() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(double[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		double c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	// pivot random element
	private int partitionRandom(double[] arr, int low, int high) {
		int i = low - 1;
		int r = (int)((float)(high - low + 1) *  Math.random()) + low;
		double pivot = arr[r];
		for(int j = low; j <= high; j++) {
			if(i == r) i++;
			if(j == r) j++;
			if(j <= high) {
				if(arr[j] < pivot) {
					i++;
					swap(arr, i, j);
				}
			}
		}
		if(r < i) swap(arr, i, r);
		if(r >=  i) swap(arr, i + 1, r);
		return i + 1;
	}
		
		private void SortRandom(double[] arr, int low, int high) {
//			System.out.println(low + " " + high);
			if(low >= high) return;
			int pi = partitionRandom(arr, low, high);
			SortRandom(arr, low, pi - 1);
			SortRandom(arr, pi + 1, high);
		}
		
		public void SortRandom(double[] arr) {
			SortRandom(arr, 0, arr.length - 1);
		}
		
		public static void main(String[] args) throws Exception {
			long time1, time2;
			double[] I;
			ReadColorTest rc = new ReadColorTest();
			I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
			QuickSortRandom qsr = new QuickSortRandom();
			time1 = System.nanoTime();
			System.out.println("QuickSort(Random) Processing...");
			qsr.SortRandom(I);
			time2 = System.nanoTime();
			System.out.println("QuickSort(Random) takes " + (double)(time2 - time1) / 1000000 + " ms");
//			for(var c : I) System.out.print(c + " ");
		}

}
