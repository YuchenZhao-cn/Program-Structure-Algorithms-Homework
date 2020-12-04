package NO6;

public class Prim {
	public static final int V = 7;

	public Prim() {
		// TODO Auto-generated constructor stub
	}
	
	private int min(int[] key, boolean[] flag) {
		int min = Integer.MAX_VALUE;
		int min_ser = -1;
		for(int i = 0; i < V; i++) {
			if(!flag[i] && key[i] < min) {
				min = key[i];
				min_ser = i;
			}
		}
		return min_ser;
	}
	
	private void print(int[] parent, int[][] graph) {
		char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.out.println("|edge\t|weight\t|\n|-------|-------|");
		for(int i = 1; i < V; i++)
			System.out.println("|" + ch[parent[i]] + " - " + ch[i] + "\t|" + graph[parent[i]][i] + "\t|");
		System.out.println("|-------|-------|");
	}
	
	public void MinimumSpanningTree(int[][] graph, int sp) {
		boolean[] flag = new boolean[V];
		int[] parent = new int[V];
		int[] key = new int[V];
		
		for(int i = 0; i < V; i++) {
			flag[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
		
		key[sp] = 0;
		parent[sp] = -1;
		
		for(int i = 0; i < V - 1; i++) {
			int min_ser = min(key, flag);
			flag[min_ser] = true;
			for(int j = 0; j < V; j++) {
				if(!flag[j] && graph[min_ser][j] != 0 && graph[min_ser][j] < key[j]) {
					parent[j] = min_ser;
					key[j] = graph[min_ser][j];
				}
			}
		}
		print(parent, graph);
	}
	
	public static void main(String[] args) {
		Prim p = new Prim();
		int[][] graph = {{ 0, 5, 3, 0, 0, 0, 0 }, 
				{ 5, 0, 4, 6, 2, 0, 0 }, 
				{ 3, 4, 0, 5, 0, 11, 0 }, 
				{ 0, 6, 5, 0, 7, 9, 0 }, 
				{ 0, 2, 0, 7, 0, 12, 8 }, 
				{ 0, 0, 11, 9, 12, 0, 7 }, 
				{ 0, 0, 0, 0, 8, 7, 0 }};
		p.MinimumSpanningTree(graph, 0);
	}
}
