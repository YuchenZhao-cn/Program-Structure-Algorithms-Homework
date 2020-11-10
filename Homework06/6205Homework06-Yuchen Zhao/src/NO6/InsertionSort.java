package NO6;

public class InsertionSort {

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void Sort(String[] arr) {
		int holeposition;
		String valueToInsert;
		for(int i = 0; i < arr.length; i++) {
			holeposition = i;
			valueToInsert = arr[i];
			while(holeposition > 0 && valueToInsert.compareTo(arr[holeposition - 1]) < 0) {
				arr[holeposition] = arr[holeposition - 1];
				holeposition--;
			}
			arr[holeposition] = valueToInsert;
		}
	}
	
	public static void main(String[] args) {
		String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		InsertionSort is = new InsertionSort();
		is.Sort(str);
		for(var c : str) System.out.print(c + " ");
	}

}
