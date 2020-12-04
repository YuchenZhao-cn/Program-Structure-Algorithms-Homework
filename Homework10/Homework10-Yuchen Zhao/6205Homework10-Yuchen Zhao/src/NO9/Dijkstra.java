package NO9;

public class Dijkstra {
	private int V;
	private int[] dis;
	private int[][] graph;
	private int sp;

	public Dijkstra(int[][] graph, int sp) {
		this.graph = graph;
		this.sp = sp;
		run();
	}
	
	private int min(int[] dis, boolean[] flag) {
		int min = Integer.MAX_VALUE;
		int min_ser = -1;
		for(int i = 0; i < V; i++) {
			if(!flag[i] && dis[i] < min) {
				min = dis[i];
				min_ser = i;
			}
		}
		return min_ser;
	}
	
	private void print() {
		char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.out.println("|Vertex\t|Dist\t|\n|-------|-------|");
		for(int i = 0; i < V; i++) System.out.println("|" + ch[i] + "\t|" + dis[i] + "\t|");
		System.out.println("|-------|-------|");
	}
	
	public void run() {
		V = graph.length;
		boolean[] flag = new boolean[V];
		dis = new int[V];
		
		for(int i = 0; i < V; i++) {
			flag[i] = false;
			dis[i] = Integer.MAX_VALUE;
		}
		
		dis[sp] = 0;
		
		for(int i = 0; i < V - 1; i++) {
			int min_ser = min(dis, flag);
			if(min_ser == -1) break;
			flag[min_ser] = true;
			for(int j = 0; j < V; j++) {
				if(!flag[j] && graph[min_ser][j] != 0 && graph[min_ser][j] + dis[min_ser] < dis[j])
					dis[j] = graph[min_ser][j] + dis[min_ser];
			}
		}
//		print();
	}
	
	public int[] ShortestPath() {
		return dis;
	}
}
