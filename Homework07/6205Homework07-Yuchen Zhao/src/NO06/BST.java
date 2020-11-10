package NO06;

public class BST {
	
	private Node root;

	public BST() {
		// TODO Auto-generated constructor stub
	}
	
	private class Node{
		private int key;
		private int val;
		private int count;
		private Node left, right;
		private Node(int key, int val, int count) {
			this.key = key;
			this.val = val;
			this.count = count;
		}
	}
	
	public void Insert(int key, int val) {
		root = Insert(root, key, val);
	}
	
	private Node Insert(Node x, int key, int val) {
		if(x == null) return new Node(key, val, 1);
		if(key < x.key) {
			x.left = Insert(x.left, key, val);
			x.count++;
		}
		else if(key > x.key) {
			x.right = Insert(x.right, key, val);
			x.count++;
		}
		else x.val = val;
		return x;
	}
	
	public int Search(int key) {
		Node x = root;
		while(x != null) {
			if(x.key < key) x = x.right;
			else if(x.key > key) x = x.left;
			else return x.val;
		}
		return (Integer)null;
	}
	
	public int size(Node x) {
		if(x == null) return 0;
		return x.count;
	}
	
	// delete1 -> deleteMin
	
	public void delete1(int key) {
		root = delete1(root, key);
	}
	
	private Node delete1(Node x, int key) {
		if(x == null) return null;
		if(key < x.key) x.left = delete1(x.left, key);
		else if(key > x.key) x.right = delete1(x.right, key);
		else {
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = DeleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Node min(Node x) {
		if(x.left == null) return x;
		else return min(x.left);
	}
	
	public void DeleteMin() {
		root = DeleteMin(root);
	}
	
	private Node DeleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = DeleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	// delete2 -> deleteMax
	
	public void delete2(int key) {
		root = delete2(root, key);
	}
	
	private Node delete2(Node x, int key) {
		if(x == null) return null;
		if(key < x.key) x.left = delete2(x.left, key);
		else if(key > x.key) x.right = delete2(x.right, key);
		else {
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			
			Node t = x;
			x = max(t.left);
			x.left = DeleteMax(t.left);
			x.right = t.right;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Node max(Node x) {
		if(x.right == null) return x;
		else return max(x.right);
	}
	
	public void DeleteMax() {
		root = DeleteMax(root);
	}
	
	private Node DeleteMax(Node x) {
		if(x.right == null) return x.left;
		x.right = DeleteMax(x.right);
		x.count = 1 + size(x.right) + size(x.left);
		return x;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 7, 9, 23, 45, 1, 5, 14, 55, 24, 13, 11, 8, 19, 4, 31, 35, 56};
		BST bst = new BST();
		for(int i = 0; i < arr.length; i++) {
			bst.Insert(arr[i], arr[i]);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(bst.Search(arr[i]) + " ");
		}
		System.out.println();
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(bst.min(bst.root).val + " ");
			bst.DeleteMin();
		}
		System.out.print(bst.min(bst.root).val + " ");
		
		System.out.println("\n-----------------------");
		
		for(int i = 0; i < arr.length; i++) {
			bst.Insert(arr[i], arr[i]);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(bst.Search(arr[i]) + " ");
		}
		System.out.println();
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(bst.max(bst.root).val + " ");
			bst.DeleteMax();
		}
		System.out.print(bst.max(bst.root).val + " ");
	}
}
