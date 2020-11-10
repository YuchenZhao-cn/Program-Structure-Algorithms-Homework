package NO07;

public class BinaryTree {
	
	private Node root = new Node("A");
	private String min = "Z";
	
	private class Node{
		private String str;
		private Node left, right;
		private Node(String str) {
			this.str = str;
		}
	}

	public BinaryTree() {
		root.left = new Node("B");
		root.right = new Node("C");
		root.left.right = new Node("D");
		root.right.left = new Node("E");
		root.right.right = new Node("F");
		root.left.right.left = new Node("G");
		root.right.left.right = new Node("H");
		root.left.right.left.left = new Node("I");
		root.right.left.right.left = new Node("J");
		root.right.left.right.right = new Node("K");
	}
	
	public String SearchMin() {
		return SearchMin(root);
	}
	
	public String SearchMin(Node x) {
		if(x != null) {
			if(min.compareTo(x.str) > 0) {
				min = x.str;
			}
			SearchMin(x.left);
			SearchMin(x.right);
		}
		return min;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		System.out.println(bt.SearchMin());
	}
	
}
