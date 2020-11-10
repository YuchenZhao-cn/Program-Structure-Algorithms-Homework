package NO5;

public class LinkedList {
	
	private Node first = null;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node {
		Student item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Student item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Student pop() {
		Student item = first.item;
		first = first.next;
		return item;
	}

}
