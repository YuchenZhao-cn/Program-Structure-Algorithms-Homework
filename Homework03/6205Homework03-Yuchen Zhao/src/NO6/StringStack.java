package NO6;

public class StringStack {

	private Node first = null;

	public StringStack() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public String pop() {
		if(isEmpty()) {
			return null;
		}
		String item = first.item;
		first = first.next;
		return item;
	}
}
