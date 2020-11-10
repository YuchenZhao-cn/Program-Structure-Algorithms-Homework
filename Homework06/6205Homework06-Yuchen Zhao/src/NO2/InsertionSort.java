package NO2;

public class InsertionSort {

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void Sort(int[] arr) {
		int holeposition;
		int valueToInsert;
		for(int i = 0; i < arr.length; i++) {
			holeposition = i;
			valueToInsert = arr[i];
			while(holeposition > 0 && valueToInsert < arr[holeposition - 1]) {
				arr[holeposition] = arr[holeposition - 1];
				holeposition--;
			}
			arr[holeposition] = valueToInsert;
		}
	}
	
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] a = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		is.Sort(a);
		for(var c : a) {
			System.out.print(c + " ");
		}
	}

}
