package NO6;

public class Main {
	
	String[] item;
	IntStack operand = new IntStack();
	IntStack operand2 = new IntStack();
	StringStack operator = new StringStack();
	StringStack operator2 = new StringStack();

	public Main(String[] item) {
		this.item = item;
	}
	
	public void PushStack(int i) {
		if(item[i].equals("+") || item[i].equals("-") || item[i].equals("*") || item[i].equals("/") || item[i].equals("(") || item[i].equals(")"))
			operator.push(item[i]);
		else operand.push(Integer.valueOf(item[i]).intValue());
	}
	
	public int precedence(String item) {
		switch(item) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		}
		return -1;
	}
	
	public void process() {
		String a = operator.pop();
		String b = " ";
		while(true) {
			b = operator.pop();
			if(b == null) b = "(";
			if(!(b == null) && (precedence(a) <= precedence(b))) {
				operator2.push(a);
				operand2.push(operand.pop());
				a = b;
			}
			else {
				int i1 = operand.pop();
				int i2 = operand.pop();
				switch(a) {
				case "+":
					operand.push(i1 + i2);
					break;
				case "-":
					operand.push(i2 - i1);
					break;
				case "*":
					operand.push(i1 * i2);
					break;
				case "/":
					operand.push(i2 / i1);
					break;
				}
				if(!b.equals("(")) 
					operator.push(b);
				while(!operator2.isEmpty()) operator.push(operator2.pop());
				while(!operand2.isEmpty()) operand.push(operand2.pop());
				a = operator.pop();
			}
			if(b.equals("(")) {
				if(!(a == null)) operator.push(a);
				break;
			}
		}
	}
	
	public void run() {
		for(int i = 0; i < item.length; i++) {
			if(!item[i].equals(")"))
				PushStack(i);
			else process();
		}
		while(!operator.isEmpty())
			process();
		while(!operand.isEmpty()) {
			System.out.println(operand.pop());
		}
		while(!operator.isEmpty()) {
			System.out.println(operator.pop());
		}
	}
	
	public static void main(String[] args) {
		String[] MyString1 = "( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )".split(" ");
		String[] MyString2 = "( 4 + 8 ) * ( 6 - 5 ) / ( ( 3 - 2 ) * ( 2 + 2 ) )".split(" ");
		Main m1 = new Main(MyString1);
		m1.run();
		Main m2 = new Main(MyString2);
		m2.run();
	}
}
