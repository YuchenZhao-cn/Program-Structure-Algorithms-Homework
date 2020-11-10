package NO5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Student> students = new ArrayList<Student>();
	File f;
	Scanner in;
	LinkedList list = new LinkedList();

	public Main() {
		f = new File("F:/学业/Northeastern/6205/Week2/input.txt");
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
		Main m = new Main();
		for(int i = 0; i < 10; i++) {
			m.read();
		}
		
		// push 9 elements
		System.out.println("push 9 elements...");
		for(int i = 0; i < 9; i++) {
			m.list.push(m.students.get(i));
		}
		
		// pop 10 elements
		System.out.println("\npop 10 elements...");
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println(m.list.pop().toString());
			} catch (NullPointerException e) {
				System.err.println("no more elements!");
			}
		}
		
		System.out.println("----------------------------------------------------");
		
		// push all elements into stack
		System.out.println("\npush all elements into stack...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.push(m.students.get(i));
		}
		
		// push 11 John Johnson Java Programming
		System.out.println("\npush 11 John Johnson Java Programming...");
		m.list.push(new Student(11, "John", "Johnson", "Java programming"));
		
		// pop all elements from stack
		System.out.println("\npop all elements from stack...");
		while(!m.list.isEmpty()) {
			try {
				System.out.println(m.list.pop().toString());
			} catch (NullPointerException e) {
				System.err.println("no more elements!");
			}
		}

		System.out.println("----------------------------------------------------");
		
		// push 4 elements\
		System.out.println("\npush 4 elements...");
		for(int i = 0; i < 4; i++) {
			m.list.push(m.students.get(i));
		}
				
		// pop 5 elements
		System.out.println("\npop 5 elements...");
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println(m.list.pop().toString());
			} catch (NullPointerException e) {
				System.err.println("no more elements!");
			}
		}

		System.out.println("----------------------------------------------------");
		
		// push all elements into stack
		System.out.println("\npush all elements into stack...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.push(m.students.get(i));
		}
						
		// pop all elements from stack
		System.out.println("\npop all elements from stack...");
		while(!m.list.isEmpty()) {
			try {
				System.out.println(m.list.pop().toString());
			} catch (NullPointerException e) {
				System.err.println("no more elements!");
			}
		}
		
		System.out.println("----------------------------------------------------");
		
		// print stack
		System.out.println("\nprint stack...");
		
		// reverse order
		System.out.println("reverse order...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.push(m.students.get(i));
		}
		while(!m.list.isEmpty()) {
			try {
				System.out.println(m.list.pop().toString());
			} catch (NullPointerException e) {
				System.err.println("no more elements!");
			}
		}
		
		// original order
		System.out.println("\noriginal order...");
		for(int i = 0; i < m.students.size(); i++) {
			m.list.push(m.students.get(i));
		}
		LinkedList list = new LinkedList();
		while(!m.list.isEmpty()) {
			list.push(m.list.pop());
		}
		while(!list.isEmpty()) {
			System.out.println(list.pop());
		}
	}
}
