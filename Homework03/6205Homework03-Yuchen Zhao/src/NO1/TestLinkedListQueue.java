package NO1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class TestLinkedListQueue {
	
	public TestLinkedListQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
		String[] MyString = "to be or not to - be - - that - - - is".split(" ");
		for(int i = 0; i < MyString.length; i++) {
			if(MyString[i].equals("-")) System.out.print(queue.dequeue() + " ");
			else queue.enqueue(MyString[i]);
		}
		System.out.println();
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
		System.out.println("Enter a sample data (An empty line terminates the program)");
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String s;
        try {
            while((s = in.readLine()).length() != 0) {
                MyString = s.split(" ");
            	for(int i = 0; i < MyString.length; i++) {
        			if(MyString[i].equals("-")) System.out.print(queue.dequeue() + " ");
        			else queue.enqueue(MyString[i]);
        		}
        		System.out.println("");
        		while(!queue.isEmpty()) {
        			System.out.print(queue.dequeue() + " ");
        		}
        		System.out.println();
        		System.out.println("Enter a sample data (An empty line terminates the program)");
            }
        } catch(IOException e) {
            e.printStackTrace();
        } 
	}
}
