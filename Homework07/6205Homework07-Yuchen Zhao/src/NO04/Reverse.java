package NO04;

import java.util.Random;

public class Reverse {

	public Reverse() {
		// TODO Auto-generated constructor stub
	}
	
	public void StringBuilderRun(String str) {
		double time1 = System.nanoTime();
		StringBuilder mystr = new StringBuilder(str);
		for(int i = 0; i < 300000; i++) {
			if((i + 1) % 10000 == 0 || i == 0) System.out.println("String Builder: " + (System.nanoTime() - time1) / 1000000);
			mystr.reverse();
		}
	}
	
	public void StringOperationRun(String str) {
		double time1 = System.nanoTime();
		 char[] array = str.toCharArray();
		 for(int i = 0; i < array.length; i++) {
			 array[i] = str.charAt(str.length() - 1 - i);
		 }
		 for(int j = 0; j < 300000; j++) {
			if((j + 1) % 10000 == 0 || j == 0) System.out.println("String Operation: " + (System.nanoTime() - time1) / 1000000);
			for(int i = 0; i < array.length; i++) {
				array[str.length() - 1 - i] = str.charAt(i);
			 }
		 }
		 
	}
	
	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < 600; i++){
	      int number = random.nextInt(62);
	      sb.append(str.charAt(number));
	    }
	    String mystr = sb.toString();
	    
	    double time1, time2;
	    Reverse r = new Reverse();
		time1 = System.nanoTime();
	    r.StringOperationRun(mystr);
		time2 = System.nanoTime();
		System.out.println("String operation takes " + (double)((time2 - time1) / 1000000) + " ms");
		
		time1 = System.nanoTime();
	    r.StringBuilderRun(mystr);
		time2 = System.nanoTime();
		System.out.println("String Builder takes " + (double)((time2 - time1) / 1000000) + " ms");
	}

}
