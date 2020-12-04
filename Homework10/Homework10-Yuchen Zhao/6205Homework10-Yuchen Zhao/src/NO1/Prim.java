package NO1;

public class Prim {
	private int V;
	private int[] parent;
	private int[][] graph;
	
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

	public Prim(int[][] g, int sp) {
		graph = g;
		V = graph.length;
		boolean[] flag = new boolean[V];
		parent = new int[V];
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
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i = 1; i < V; i++) {
			str.append((char)(parent[i] + 65) + " -- " + (char)(i +65) + " : " + graph[parent[i]][i] + "\n");
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, 2, 0, 1, 0, 0},
						 {2, 0, 1, 2, 0, 0},
						 {0, 1, 0, 1, 5, 4},
						 {1, 2, 1, 0, 6, 0},
						 {0, 0, 5, 6, 0, 3},
						 {0, 0, 4, 0, 3, 0}};
		Prim p = new Prim(graph, 0);
		System.out.println(p);
	}
}
