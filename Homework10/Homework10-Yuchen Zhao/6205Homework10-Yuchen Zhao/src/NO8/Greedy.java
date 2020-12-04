package NO8;

import java.util.*;

public class Greedy {

	public Greedy(int[] arr, int T) {
		Arrays.sort(arr);
		int sum = 0;
		int Things = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum <= T) Things++;
			else break;
		}
		System.out.println(Things);
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
		int T = 15;
		new Greedy(arr, T);
	}

}
