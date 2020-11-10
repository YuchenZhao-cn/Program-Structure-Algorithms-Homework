package NO3;

public class TimSort {
	private final int minrun = 32;

	public TimSort() {
		// TODO Auto-generated constructor stub
	}
	
	private int min(int a, int b) {
		if(a <= b) return a;
		return b;
	}
	
	private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
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
	
	private void InsertionSort(int[] arr, int lo, int hi) {
		int holeposition;
		int valueToInsert;
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
	
	public void Sort(int[] a) {
		int len = a.length;
		for(int i = 0; i < len; i += minrun) {
			InsertionSort(a, i, min(i + minrun - 1, len - 1));
		}
		int[] aux = new int[len];
		for(int i = minrun; i < len; i *= 2) {
			for(int j = 0; j < len; j += i * 2) {
				merge(a, aux, j, j + i - 1, min(j + i * 2 - 1, len - 1));
			}
		}
	}
	
	public static void main(String[] args) {
		TimSort ts = new TimSort();
		int[] a = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		ts.Sort(a);
		for(var c : a) {
			System.out.print(c + " ");
		}
	}

}
