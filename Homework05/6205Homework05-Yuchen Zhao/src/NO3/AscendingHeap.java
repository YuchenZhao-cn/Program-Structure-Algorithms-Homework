package NO3;

public class AscendingHeap {
	
	private void swap(double[] arr, int a, int b) {
		double c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	private void heapify(double[] arr, int n, int i) {
		int largest = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		
		if(l < n && arr[l] > arr[largest])
			largest = l;
		
		if(r < n && arr[r] > arr[largest])
			largest = r;
		
		if(largest != i) {
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}
	
	private void heapsort(double[] arr, int n) {
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		for(int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
		
	}
	
	public void heapsort(double[] arr) {
		int n = arr.length;
		heapsort(arr, n);
	}
}
