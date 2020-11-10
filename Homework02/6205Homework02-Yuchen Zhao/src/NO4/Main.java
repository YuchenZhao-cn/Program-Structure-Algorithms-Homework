package NO4;

public class Main {
	
	LinkedList list1 = new LinkedList();
	LinkedList list2 = new LinkedList();
	
	String MyString = "It was the best of time";

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		String[] St = MyString.split(" ");
		for(int i = 0; i < St.length; i++) {
			list1.push(St[i]);
		}
		while(!list1.isEmpty()) {
			list2.push(list1.pop());
		}
		while(!list2.isEmpty()) {
			System.out.print(list2.pop() + " ");
		}
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

}
