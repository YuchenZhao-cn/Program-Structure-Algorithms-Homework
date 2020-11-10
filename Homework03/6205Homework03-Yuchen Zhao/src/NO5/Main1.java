package NO5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

	ArrayList<Student> students = new ArrayList<Student>();
	File f;
	Scanner in;
	LinkedListQueue list = new LinkedListQueue();

	public Main1() {
		f = new File("F:/学业/Northeastern/6205/Week3/input.txt");
		try {
			in = new Scanner(f);
			in.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		int ID = in.nextInt();
		String FirstName = in.next();
		String LastName = in.next();
		String[] Course = in.nextLine().split("\t");
		Student student = new Student(ID, FirstName, LastName, Course[1]);
		students.add(student);
	}
	
	public static void main(String[] args) {
		Main1 m = new Main1();
		for(int i = 0; i < 10; i++) {
			m.read();
		}
		
		// enqueue all elements into queue
		System.out.println("enqueue all elements into queue...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.enqueue(m.students.get(i));
		}
		
		// dequeue 4 elements from queue
		System.out.println("dequeue 4 elements from queue...");
		for(int i = 0; i < 4; i++) {
			System.out.println(m.list.dequeue().toString());
		}
		
		System.out.println("----------------------------------------------------");
		
		// enqueue all elements into queue
		System.out.println("enqueue all elements into queue...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.enqueue(m.students.get(i));
		}
		
		// dequeue all elements from queue
		System.out.println("dequeue all elements from queue...");
		while(!m.list.isEmpty()) {
			System.out.println(m.list.dequeue());
		}
		
		System.out.println("----------------------------------------------------");
		
		// dequeue 1 element
		System.out.println("dequeue 1 element...");
		System.out.println(m.list.dequeue().toString());
		
		System.out.println("----------------------------------------------------");
		
		// enqueue all elements into queue
		System.out.println("enqueue all elements into queue...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.enqueue(m.students.get(i));
		}
		
		// enqueue this element into the queue
		System.out.println("enqueue 11 John Johnson Java Programming...");
		m.list.enqueue(new Student(11, "John", "Johnson", "Java Programming"));
		
		// print queue
		System.out.println("\nprint queue...");
				
		// reverse order
		System.out.println("reverse order...");
		LinkedListStack stack = new LinkedListStack();
		while(!m.list.isEmpty()) {
			stack.push(m.list.dequeue());
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().toString());
		}
		
		// original order
		System.out.println("\noriginal order...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.enqueue(m.students.get(i));
		}
		m.list.enqueue(new Student(11, "John", "Johnson", "Java Programming"));
		while(!m.list.isEmpty()) {
			System.out.println(m.list.dequeue());
		}
	}
}
