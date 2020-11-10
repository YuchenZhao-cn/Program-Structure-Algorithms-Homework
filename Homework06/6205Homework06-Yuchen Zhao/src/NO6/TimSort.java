package NO6;

public class TimSort {
	private final int minrun = 32;

	public TimSort() {
		// TODO Auto-generated constructor stub
	}
	
	private int min(int a, int b) {
		if(a <= b) return a;
		return b;
	}
	
	private void merge(String[] a, String[] aux, int lo, int mid, int hi) {
//		System.out.println(lo + " " + mid + " " + hi);
		for(int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	private void InsertionSort(String[] arr, int lo, int hi) {
		int holeposition;
		String valueToInsert;
		for(int i = lo; i <= hi; i++) {
			holeposition = i;
			valueToInsert = arr[i];
			while(holeposition > lo && valueToInsert.compareTo(arr[holeposition - 1]) < 0) {
				arr[holeposition] = arr[holeposition - 1];
				holeposition--;
			}
			arr[holeposition] = valueToInsert;
		}
	}
	
	public void Sort(String[] a) {
		int len = a.length;
		for(int i = 0; i < len; i += minrun) {
			InsertionSort(a, i, min(i + minrun - 1, len - 1));
		}
		String[] aux = new String[len];
		for(int i = minrun; i < len; i *= 2) {
			for(int j = 0; j < len; j += i * 2) {
				merge(a, aux, j, j + i - 1, min(j + i * 2 - 1, len - 1));
			}
		}
	}
	
	public static void main(String[] args) {
		String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		TimSort ts = new TimSort();
		ts.Sort(str);
		for(var c : str) System.out.print(c + " ");
	}

}
