package NO3;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		double t1, t2;
		double[] I;
		ReadColorTest rc = new ReadColorTest();
		I = rc.getImagePixel("F:\\学业\\Northeastern\\6205\\Week5\\Boston.jpeg");
		
		Merge m = new Merge();
		double I1[] = I;
		long time1 = System.nanoTime();
		m.sort(I1);
		long time2 = System.nanoTime();
		System.out.println("Merge Sort Processing...");
		System.out.println("Merge sort takes " + (t1 = (double)(time2 - time1) / 1000000) + " ms");
		
		System.out.println();
		AscendingHeap h = new AscendingHeap();
		double I2[] = I;
		 time1 = System.nanoTime();
		h.heapsort(I2);
		time2 = System.nanoTime();
		System.out.println("Heap Sort Processing...");
		System.out.println("Heap sort takes " + (t2 = (double)(time2 - time1) / 1000000) + " ms");
		
		System.out.println("\n------------------------------------------\nInput \"Merge\" or \"Heap\" to show the sorted array(An empty line terminates the program):");
		DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String s;
        try {
            while((s = in.readLine()).length() != 0) {
            	if(s.equals("Merge")) {
            		for(var c : I1) {
            			System.out.print(c + " ");
            		}
            		System.out.println("\nMerge sort takes " + t1 + " ms");
            	}
            	
            	if(s.equals("Heap")) {
            		for(var c : I1) {
            			System.out.print(c + " ");
            		}
            		System.out.println("\nHeap sort takes " + t2 + " ms");
            	}
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
	}
}
