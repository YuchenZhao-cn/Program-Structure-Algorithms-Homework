package NO1;

public class LinkedQueueOfStrings {

	private Node first, last;
	
	public LinkedQueueOfStrings() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else	oldlast.next = last;
	}
	
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		return item;
	}
	
}
