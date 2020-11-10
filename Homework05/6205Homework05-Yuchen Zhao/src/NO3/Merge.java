package NO3;

public class Merge {
	
	private void merge(double[] a, double[] aux, int lo, int mid, int hi) {
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
	
	private void sort(double[] a, double[] aux, int lo, int hi) {
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public void sort(double[] a) {
		double[] aux = new double[a.length];
		sort(a, aux, 0, a.length - 1);
	}

}
