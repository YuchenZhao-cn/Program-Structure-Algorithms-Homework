package NO10;

public class BTree<Key extends Comparable<Key>, Value> {
	
	private static final int m = 5;
	private Node root;
	
	public class Record {
	    private Comparable[] key;
	    private Object[] val;
	    private Node[] children;
	    public Record(Comparable[] key, Object[] val, Node[] children) {
	        this.key = key;
	        this.val = val;
	        this.children = children;
	    }
	    public Record(Comparable[] key){
	        this.key = key;
	    }
		public Comparable[] getKey() {
			return key;
		}
		public void setKey(Comparable[] key) {
			this.key = key;
		}
		public Object[] getVal() {
			return val;
		}
		public void setVal(Object[] val) {
			this.val = val;
		}
		public Node[] getChildren() {
			return children;
		}
		public void setChildren(Node[] children) {
			this.children = children;
		}
	}
	
	private static class Node{
		private Comparable[] key = new Comparable[m];
		private Object[] val = new Object[m];
		private Node[] children;
		public int num = 0;
		
		public Node() {
		}
		
		public Node(Comparable key, Object val) {
			this.key[0] = key;
			this.val[0] = val;
			num++;
		}
		
		private boolean isLeaf() {
			return children == null;
		}
	}

	public BTree() {
		// TODO Auto-generated constructor stub
	}
	
	public void put(Comparable key, Object val) {
		if(root == null) root = new Node(key, val);
		else put(key, val, root);
	}
	
	private Node put(Comparable key, Object val, Node x) {
		int i = 0;
		Node y, z;
		for(; i < x.num; i++) {
			if(x.key[i].compareTo(key) > 0) break;
		}
		if(!x.isLeaf()) y = put(key, val, x.children[i]);
		else y = Insert(key, val, x, i, null);
		if(y == null) return null;
		else if(x.isLeaf()) {
			z = y;
		}
		else {
			z = Insert(x.children[i].key[x.children[i].num], x.children[i].val[x.children[i].num], x, i, y);
			if(x.children[i] == null) z.children[(int)Math.ceil((double)m / 2) - 1] = y;
		}
		if(x == root && z != null) {
			Node r = new Node(x.key[x.num], x.val[x.num]);
			r.children = new Node[m + 1];
			r.children[0] = x;
			r.children[1] = z;
			root = r;
			return null;
		}
		return z;
	}
	
	private Node Insert(Comparable key, Object val, Node x, int position, Node y) {
		for(int i = m - 1; i > position; i--) {
			x.key[i] = x.key[i - 1];
			x.val[i] = x.val[i - 1];
			if((i != position) && x.children != null) x.children[i + 1] = x.children[i];
		}
		if(y != null) x.children[position + 1] = y;
		x.key[position] = key;
		x.val[position] = val;
		x.num++;
		if(x.num == m) return split(x);
		return null;
	}
	
	private Node split(Node x) {
		Node y = new Node();
		x.num = (int)Math.ceil((double)x.num / 2) - 1;
		for(int i = x.num + 1; i < m; i++) {
			Insert(x.key[i], x.val[i], y, i - x.num - 1, null);
			x.key[i] = null;
		}
		if(x.children != null) {
			y.children = new Node[m + 1];
			for(int i = (int)Math.ceil((double)m / 2); i < m + 1; i++) {
				y.children[i - (int)Math.ceil((double)m / 2)] = x.children[i];
				x.children[i] = null;
			}
		}
		return y;
	}
	
	public void delete(Comparable key) {
		delete(key, root, 0);
	}
	
	private void delete(Comparable key, Node x, int count) {
		int i = 0, j = 0;
		boolean flag = true;
		if(x == root) {
			for(; i < x.num; i++) {
				if(x.key[i].compareTo(key) > 0) break;
			}
		}
		else i = count;
		for(; j < x.children[i].num; j++) {
			if(x.children[i].key[j].compareTo(key) > 0) break;
			else if(x.children[i].key[j].compareTo(key) == 0) {
				if(x.children[i].isLeaf()) {
					while(flag) {
						flag = erase(j, x.children[i], x.key[i - 1], x.val[i - 1]);
						if(flag) {
							x.key[i - 1] = x.children[i - 1].key[x.children[i - 1].num - 1];
							x.val[i - 1] = x.children[i - 1].val[x.children[i - 1].num - 1];
						}
						i--;
						j = x.children[i].num - 1;
					}
					return;
				}
				else {
					while(flag) {
						if(flag) {
							x.children[i].key[j] = x.children[i].children[j].key[x.children[i].children[j].num - 1];
							x.children[i].val[j] = x.children[i].children[j].val[x.children[i].children[j].num - 1];
						}
						if(j > 0) flag = erase(x.children[i].children[j].num, x.children[i].children[j], x.children[i].key[j - 1], x.children[i].val[j - 1]);
						else {
							flag = false;
							x.children[i].children[j].key[x.children[i].children[j].num] = null;
							x.children[i].children[j].num--;
						}
						j--;
					}
					return;
				}
			}
		}
		delete(key, x.children[i], j);
	}
	
	private boolean erase(int position, Node x, Comparable key1, Object val1) {
		if(x.isLeaf()) {
			if(x.num > m / 2) {
				for(int i = position; i < x.num; i++) {
					x.key[i] = x.key[i + 1];
					x.val[i] = x.val[i + 1];
				}
				x.num--;
				return false;
			}
			else {
				for(int i = 1; i < position; i++) {
					x.key[i] = x.key[i - 1];
					x.val[i] = x.val[i - 1];
				}
				x.key[0] = key1;
				x.val[0] = val1;
				return true;
			}
		}
		else {
			if(x.children[position + 1].num > m / 2 - 1) {
				x.key[position] = x.children[position + 1].key[0];
				x.val[position] = x.children[position + 1].val[0];
				erase(0, x.children[position + 1], null, null);
			}
			else if(x.children[position].num > m / 2 - 1) {
				x.key[position] = x.children[position].key[x.children[position].num - 1];
				x.val[position] = x.children[position].val[x.children[position].num - 1];
				erase(x.children[position].num - 1, x.children[position], null, null);
			}
			else {
				for(int i = position; i < x.num; i++) {
					x.key[i] = x.key[i + 1];
					x.val[i] = x.val[i + 1];
					if(i != position) x.children[i + 1] = x.children[i + 2];
				}
				x.children[position] = merge(x.children[position], x.children[position + 1]);
				x.children[position + 1] = x.children[position + 2];
			}
		}
		return false;
	}
	
	private Node merge(Node x, Node y) {
		Node z = new Node();
		z.children = new Node[m + 1];
		for(int i = 0; i < x.num; i++) {
			z.key[i] = x.key[i];
			z.val[i] = x.val[i];
		}
		for(int i = x.num; i < x.num + y.num; i++) {
			z.key[i] = x.key[i];
			z.val[i] = x.val[i];
		}
		return z;
	}
	
	public void printTree() {
		int ht = -1;
		int[] nodenum = {0, 0, 0};
		printNode(root, ht, nodenum);
	}
	
	public void printNode(Node x, int ht, int[] nodenum) {
		ht++;
		System.out.print("layer:" + ht + " node: " + nodenum[ht]++ + " | ");
		for(int i = 0; i < x.num; i++) {
			System.out.print(x.key[i] + " ");
		}
		System.out.println();
		if(!x.isLeaf()) {
			for(int i = 0; i < x.num + 1; i++) {
				printNode(x.children[i], ht, nodenum);
			}
		}
		ht--;
	}
	
	public static void main(String[] args) {
		BTree<Integer, Integer> bt = new BTree<Integer, Integer>();
		int[] arr = {3,7,9,23,45,1,5,14,5,24,13,11,8,19,4,31,35,56,17,29,6,22};
		for(int i = 0; i < arr.length; i++) {
			bt.put(arr[i], arr[i]);
		}
		System.out.println("Results are shown through preorder traversals :\n-------------------------------");
		bt.printTree();
		System.out.println("-------------------------------\ndelete 45:");
		bt.delete(45);
		bt.printTree();
		System.out.println("-------------------------------\ndelete 11:");
		bt.delete(11);
		bt.printTree();
		System.out.println("-------------------------------\ndelete 31:");
		bt.delete(31);
		bt.printTree();
	}
}
