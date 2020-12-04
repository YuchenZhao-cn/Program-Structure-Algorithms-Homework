package NO7;

public class BellmanFord {
	private int V, E = 0;
	private edge[] edge;
	private int[] Nodes;
	private boolean Flag = true;
	
	private class edge {
		private int src, dest, weight;
		
		private edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public BellmanFord(int[][] graph, int source) {
		V = graph.length;
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(graph[i][j] != 0) E++;
			}
		}
		edge = new edge[E];
		int count = 0;
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(graph[i][j] != 0) edge[count++] = new edge(i, j, graph[i][j]);
			}
		}
		
		Nodes = new int[V];
		for(int i = 0; i < V; i++) {
			if(i == source) Nodes[i] = 0;
			else Nodes[i] = Integer.MAX_VALUE / 2;
		}
		
		for(int i = 0; i < V - 1; i++) {
			for(int j = 0; j < E; j++) {
				if(Nodes[edge[j].src] + edge[j].weight < Nodes[edge[j].dest]) Nodes[edge[j].dest] = Nodes[edge[j].src] + edge[j].weight;
			}
		}
		
		for(int j = 0; j < E; j++) {
			if(Nodes[edge[j].src] + edge[j].weight < Nodes[edge[j].dest]) {
				Flag = false;
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		if(Flag) {
			for(int i = 0; i < V; i++) {
				str.append((char)(i + 65) + " " + Nodes[i] + "\n");
			}
		}
		else str.append("Negative Cycle Detected!");
		
		return str.toString();
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, -1, 4, 0, 0},
						 {0, 0, 3, 2, 2},
						 {0, 0, 0, 0, 0},
						 {0, 1, 5, 0, 0},
						 {0, 0, 0, -3, 0}};
		System.out.println(new BellmanFord(graph, 0));
		int[][] graph2 = {{0, 3, 0, 0, 0},
						  {0, 0, -5, 0, 0},
						  {0, 0, 0, -3, 1},
						  {0, 6, 0, 0, 0},
						  {0, 0, 0, 0, 0}};
		System.out.println(new BellmanFord(graph2, 0));
	}
}
