package NO4;

public class CircularQueue {
	private int[] items;
	private int head, tail;
	int capacity;

	public CircularQueue() {
		// TODO Auto-generated constructor stub
	}

	public CircularQueue(int capacity) {
		items = new int[capacity];
		this.capacity = capacity;
		head = 0;
		tail = 0;
	}
	
	public boolean isFull() {
		return head == tail - capacity + 1;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public void enqueue(int item) {
		if(isFull()) {
			System.err.println("Queue is full!");
			return;
		}
		items[tail++ % capacity] = item;
		
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.err.println("Queue is empty!");
			return 65536;
		}
		return items[(head++ % capacity)];
	}
	
	public void displayQueue() {
		System.out.print("Display queue: Head->");
		for(int i = head; i < tail; i++) {
			System.out.print(items[i % capacity] + " ");
		}
		System.out.println("Tail");
	}
	
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(11);
		int[] input = {12, 22, 38, 3, 9, 82, 10, 31, 24, 33};
		
		// enqueue all elements
		System.out.println("enqueue all elements...");
		for(var c : input) queue.enqueue(c);
		queue.displayQueue();
		System.out.println();
		
		// dequeue three elements
		System.out.println("dequeue three elements...");
		for(int i = 0; i < 3; i++) {
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
		queue.displayQueue();
		System.out.println();
		
		// enqueue two elements
		System.out.println("enqueue two elements...");
		for(int i = 0; i < 2; i++) {
			queue.enqueue(input[i]);
		}
		queue.displayQueue();
		System.out.println();
		
		// dequeue all elements
		System.out.println("dequeue all elements");
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
		queue.displayQueue();
	}

}
