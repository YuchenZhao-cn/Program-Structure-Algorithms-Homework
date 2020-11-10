package NO5;

public class FixedCapacityStack {
	
	private Student[] students;
	public int N = 0;
	private int capacity;

	public FixedCapacityStack() {
		// TODO Auto-generated constructor stub
	}
	
	public FixedCapacityStack(int capacity) {
		students = new Student[capacity];
		this.capacity = capacity;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(Student item) {
		if(N == capacity) {
			System.err.println("out of bound");
			return;
		}
		if(N < 0) N = 0;
		students[N++] = item;
	}
	
	public Student pop() {
		Student item = students[--N];
		students[N] = null;
		return item;
	}
}
