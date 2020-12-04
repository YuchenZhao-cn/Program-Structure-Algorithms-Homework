package NO6;

public class Dijkstra {
	public static final int V = 7;

	public Dijkstra() {
		// TODO Auto-generated constructor stub
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
	
	private void print(int[] dis) {
		char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.out.println("|Vertex\t|Dist\t|\n|-------|-------|");
		for(int i = 0; i < V; i++) System.out.println("|" + ch[i] + "\t|" + dis[i] + "\t|");
		System.out.println("|-------|-------|");
	}
	
	public void ShortestPath(int[][] graph, int sp) {
		boolean[] flag = new boolean[V];
		int[] dis = new int[V];
		
		for(int i = 0; i < V; i++) {
			flag[i] = false;
			dis[i] = Integer.MAX_VALUE;
		}
		
		dis[sp] = 0;
		
		for(int i = 0; i < V - 1; i++) {
			int min_ser = min(dis, flag);
			flag[min_ser] = true;
			for(int j = 0; j < V; j++) {
				if(!flag[j] && graph[min_ser][j] != 0 && graph[min_ser][j] + dis[min_ser] < dis[j])
					dis[j] = graph[min_ser][j] + dis[min_ser];
			}
		}
		print(dis);
	}
	
	public static void main(String[] args) {
		int[][] graph = {{ 0, 5, 3, 0, 0, 0, 0 }, 
						{ 5, 0, 4, 6, 2, 0, 0 }, 
						{ 3, 4, 0, 5, 0, 11, 0 }, 
						{ 0, 6, 5, 0, 7, 9, 0 }, 
						{ 0, 2, 0, 7, 0, 12, 8 }, 
						{ 0, 0, 11, 9, 12, 0, 7 }, 
						{ 0, 0, 0, 0, 8, 7, 0 }};
		Dijkstra d = new Dijkstra(); 
		d.ShortestPath(graph, 0);
	}

}
