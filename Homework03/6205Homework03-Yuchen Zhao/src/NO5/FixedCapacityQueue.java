package NO5;

public class FixedCapacityQueue {
	private Student[] items;
	private int head, tail;
	int capacity;

	public FixedCapacityQueue(int capacity) {
		items = new Student[capacity];
		this.capacity = capacity;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		return tail == head + capacity;
	}
	
	public void enqueue(Student item) {
		if(isFull()) {
			System.out.println("the queue is full!");
			return;
		}
		items[tail++ % capacity] = item;
	}
	
	public Student dequeue() {
		if(isEmpty()) {
			return (new Student());
		}
		return items[(head++ % capacity)];
	}

}
