package NO1;

public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(int[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	// pivot last element
	private int partitionLast(int[] arr, int low, int high) {
//		System.out.println("partition " + low + " " + high);
		int i = low - 1;
		int pivot = arr[high];
		for(int j = low; j <= high - 1; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	
	private void SortLast(int[] arr, int low, int high) {
//		System.out.println(low + " " + high);
		if(low >= high) return;
		int pi = partitionLast(arr, low, high);
		SortLast(arr, low, pi - 1);
		SortLast(arr, pi + 1, high);
	}
	
	public void SortLast(int[] arr) {
		SortLast(arr, 0, arr.length - 1);
	}

	// pivot first element
	private int partitionFirst(int[] arr, int low, int high) {
//		System.out.println("partition " + low + " " + high);
		int i = low;
		int pivot = arr[low];
		for(int j = low + 1; j <= high; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i, low);
		return i;
	}
	
	private void SortFirst(int[] arr, int low, int high) {
//		System.out.println(low + " " + high);
		if(low >= high) return;
		int pi = partitionFirst(arr, low, high);
		SortFirst(arr, low, pi - 1);
		SortFirst(arr, pi + 1, high);
	}
	
	public void SortFirst(int[] arr) {
		SortFirst(arr, 0, arr.length - 1);
	}

	// pivot random element
//	private int partitionRandom(int[] arr, int low, int high) {
////		System.out.println("partition " + low + " " + high);
//		int i = low - 1;
//		int r = (high - low + 1) * (int)Math.random() + low;
//		int pivot = arr[r];
//		swap(arr, r, high);
//		for(int j = low; j <= high - 1; j++) {
//			if(arr[j] < pivot) {
//				i++;
//				swap(arr, i, j);
//			}
//		}
//		swap(arr, i + 1, high);
//		return i + 1;
//	}
	
	private int partitionRandom(int[] arr, int low, int high) {
		int i = low - 1;
		int r = (int)((float)(high - low + 1) *  Math.random()) + low;
		int pivot = arr[r];
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
	
	private void SortRandom(int[] arr, int low, int high) {
//		System.out.println(low + " " + high);
		if(low >= high) return;
		int pi = partitionRandom(arr, low, high);
		SortRandom(arr, low, pi - 1);
		SortRandom(arr, pi + 1, high);
	}
	
	public void SortRandom(int[] arr) {
		SortRandom(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		
		int[] a1 = a;
		qs.SortLast(a1);
		System.out.print("pivot last element: ");
		for(var c : a1) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		int[] a2 = a;
		qs.SortFirst(a2);
		System.out.print("pivot first element: ");
		for(var c : a2) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		int[] a3 = a;
		qs.SortRandom(a3);
		System.out.print("pivot random element: ");
		for(var c : a3) {
			System.out.print(c + " ");
		}
	}

}
