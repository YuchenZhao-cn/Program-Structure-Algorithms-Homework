package NO4;

public class Postfix {

	private String[] MyString;
	LinkedListStack list = new LinkedListStack();
	
	public Postfix(String item) {
		MyString = item.split(" ");
	}
	
	public LinkedListStack output() {
		for(int i = 0; i < MyString.length; i++) {
			if(MyString[i].equals("+")) list.push(String.valueOf(Integer.valueOf(list.pop()).intValue() + Integer.valueOf(list.pop()).intValue()));
			else if(MyString[i].equals("*")) list.push(String.valueOf(Integer.valueOf(list.pop()).intValue() * Integer.valueOf(list.pop()).intValue()));
			else if(MyString[i].equals("-")) {
				int num1 = Integer.valueOf(list.pop()).intValue();
				int num2 = Integer.valueOf(list.pop()).intValue();
				list.push(String.valueOf(num2 - num1));
			}
			else if(MyString[i].equals("/")) {
				int num1 = Integer.valueOf(list.pop()).intValue();
				int num2 = Integer.valueOf(list.pop()).intValue();
				list.push(String.valueOf(num2 / num1));
			}
			else list.push(MyString[i]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		String input = "10 2 8 * + 3 -";
		Postfix pf = new Postfix(input);
		LinkedListStack list = pf.output();
		while(!list.isEmpty()) {
			System.out.print(list.pop() + " ");
		}
	}
}
