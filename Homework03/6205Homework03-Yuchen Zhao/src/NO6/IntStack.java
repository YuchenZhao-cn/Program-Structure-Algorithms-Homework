package NO6;

public class IntStack {

	private Node first = null;

	public IntStack() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node {
		int item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(int item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public int pop() {
		int item = first.item;
		first = first.next;
		return item;
	}

}
