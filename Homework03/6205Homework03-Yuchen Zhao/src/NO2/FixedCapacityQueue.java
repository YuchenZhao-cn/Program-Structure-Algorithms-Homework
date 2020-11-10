package NO2;

public class FixedCapacityQueue {
	private String[] items;
	private int head, tail;
	int capacity;

	public FixedCapacityQueue(int capacity) {
		items = new String[capacity];
		this.capacity = capacity;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty() {
		return (head % capacity) == (tail % capacity);
	}
	
	public void enqueue(String item) {
		items[tail++ % capacity] = item;
		
	}
	
	public String dequeue() {
		return items[(head++ % capacity)];
	}

}
