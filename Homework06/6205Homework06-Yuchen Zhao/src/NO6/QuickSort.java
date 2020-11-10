package NO6;

public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(String[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		String c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	// pivot last element
	private int partitionLast(String[] arr, int low, int high) {
//		System.out.println("partition " + low + " " + high);
		int i = low - 1;
		String pivot = arr[high];
		for(int j = low; j <= high - 1; j++) {
			if(arr[j].compareTo(pivot) < 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	
	private void SortLast(String[] arr, int low, int high) {
//		System.out.println(low + " " + high);
		if(low >= high) return;
		int pi = partitionLast(arr, low, high);
//		for(var c : arr) System.out.print(c + " ");
//		System.out.println();
		SortLast(arr, low, pi - 1);
		SortLast(arr, pi + 1, high);
	}
	
	public void SortLast(String[] arr) {
		SortLast(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		QuickSort qs = new QuickSort();
		qs.SortLast(str);
		for(var c : str) System.out.print(c + " ");
	}

}
