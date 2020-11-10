package NO4;

public class BubbleSort {

	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}
	
	private void swap(int[] arr, int a, int b) {
//		System.out.println("swaping " + a + " " + b);
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	public void Sort(int[] arr) {
		boolean swaped;
		for(int i = arr.length - 1; i > -1; i--) {
			swaped = false;
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swaped = true;
				}
			}
			if(!swaped) break;
		}
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] a = {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};
		bs.Sort(a);
		for(var c : a) {
			System.out.print(c + " ");
		}
	}

}
