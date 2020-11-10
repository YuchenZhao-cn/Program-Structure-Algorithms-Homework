package NO2;

public class DescendingHeap {
	int[] a = new int[16];
	int count = 0;

	public DescendingHeap() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(int[] arr, int a, int b) {
		System.out.println("Swaping node " + a + " and " + b + " ...");
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	private void heapify(int[] arr, int n, int i) {
		System.out.println("Heapifying node " + i + " ...");
		int smallest = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		
		if(l < n && arr[l] < arr[smallest])
			smallest = l;
		
		if(r < n && arr[r] < arr[smallest])
			smallest = r;
		
		if(smallest != i) {
			swap(arr, smallest, i);
			printTree(arr);
			System.out.println("---------------------------------");
			heapify(arr, n, smallest);
		}

		if(l > n || r > n || smallest == i) {
			printTree(arr);
			System.out.println("=================================");
		}
	}
	
	private void heapsort(int[] arr, int n) {
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		for(int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);
			a[i] = arr[i];
			printTree(arr);
			System.out.println("*********************************");
			heapify(arr, i, 0);
		}
		
	}
	
	private void printTree(int[] arr) {
		count++;
		if(arr[0] != a[0]) System.out.printf("               %2d", arr[0]);
		System.out.println();
		System.out.println("            /      \\ ");
		for(int i = 1; i < 3; i++) {
			if(arr[i] != a[i]) System.out.printf("       %2d       ", arr[i]);
		}
		System.out.println();
		System.out.println("      /  \\            /  \\");
		for(int i = 3; i < 7; i++) {
			if(arr[i] != a[i]) System.out.printf("   %2d   ", arr[i]);
		}
		System.out.println();
		System.out.println("  /  \\    /  \\    /  \\    /  \\");
		for(int i = 7; i < 15; i++) {
			if(arr[i] != a[i]) System.out.printf(" %2d ", arr[i]);
		}
		System.out.println();
		System.out.println(" /");
		if(arr[15] != a[15]) System.out.println(arr[15]);
		
		System.out.println("              0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
		System.out.print("Sorted array:");
		for(int c : a) {
			if(c == 0) System.out.print("   ");
			else System.out.printf("%2d ", c);
		}
		System.out.println();
	}
	
	public void heapsort(int[] arr) {
		System.out.println("begin!");
		printTree(arr);
		int n = arr.length;
		heapsort(arr, n);
		System.out.println("There are " + count + " trees");
	}
	
	public static void main(String[] args) {
		DescendingHeap dh = new DescendingHeap();
		int[] arr = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		dh.heapsort(arr);
		for(var c : arr)
			System.out.print(c + " ");
	}

}
