package NO5;

public class LinkedListQueue {

	private Node first, last;
	
	public LinkedListQueue() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node{
		Student item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(Student item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else	oldlast.next = last;
	}
	
	public Student dequeue() {
		if(isEmpty()) {
			return (new Student());
		}
		Student item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		return item;
	}
	
}