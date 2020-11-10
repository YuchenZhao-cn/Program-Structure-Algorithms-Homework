package NO7;

import java.util.Stack;

public class InfixToPostfix {
	Stack<String> stack = new Stack<String>();

	public InfixToPostfix() {
		// TODO Auto-generated constructor stub
	}
	
	public int precedence(String item) {
		switch(item) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		}
		return -1;
	}
	
	public void process(String in) {
		if(in.equals("(")) stack.push(in);
		else if(in.equals(")")) {
			String out = stack.pop();
			while(!out.equals("(")) {
				System.out.print(out);
				out = stack.pop();
			}
		}
		else if(in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/") || in.equals("^")) {
			String top = stack.pop();
			if(precedence(in) <= precedence(top)) {
				System.out.print(top);
				stack.push(in);
			}
			else {
				stack.push(top);
				stack.push(in);
			}
		}
		else System.out.print(in);
	}
	
	public static void main(String[] args) {
		String[] MyString = "A * B / C + ( D + E - ( F * ( G / H ) ) )".split(" ");
//		String[] MyString = "A + ( B * C - ( D / E ^ F ) * G ) * H".split(" ");
		InfixToPostfix test = new InfixToPostfix();
		test.process("(");
		for(int i = 0; i < MyString.length; i++) {
			test.process(MyString[i]);
		}
		test.process(")");
	}
}
