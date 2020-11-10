package NO1;

public class Merge {

	public Merge() {
		// TODO Auto-generated constructor stub
	}
	
	private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
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
	
	private void sort(int[] a, int[] aux, int lo, int hi) {
//		System.out.println(lo + " " + hi);
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public void sort(int[] a) {
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		Merge m = new Merge();
		int[] array = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		m.sort(array);
		for(var c : array) {
			System.out.print(c + " ");
		}
	}

}
