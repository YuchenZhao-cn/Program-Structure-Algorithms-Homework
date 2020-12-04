package NO9;

import java.util.*;

public class RandomSPT implements Comparable<RandomSPT> {
	public int V, E, weight = 0;
	private Edge[] graph;
	public Edge[] result;
	private int[] visited;
	private int previous;
	private int ThisV;
	private ArrayList<Integer> neighbour = new ArrayList<Integer>();

	public RandomSPT(Edge[] graph, int V, int E) {
		this.graph = graph;
		this.V = V;
		this.E = E;
		result = new Edge[V - 1];
		visited = new int[V];
		for(int i = 0; i < V; i++) visited[i] = -1;
		Spanning();
	}
	
	public RandomSPT(Edge[] graph) {
		this.graph = graph;
		this.V = graph.length + 1;
		this.E = graph.length;
		result = graph;
		for(int i = 0; i < E; i++) {
			weight += result[i].weight;
		}
	}
	
	private boolean visited(int v) {
		for(int i = 0; i < V - 1; i++) {
			if(v == visited[i]) return true;
		}
		return false;
	}
	
	private boolean isNeighbour(int v) {
		for(int i = 0; i < neighbour.size(); i++) {
			if(v == neighbour.get(i)) return true;
		}
		return false;
	}
	
	private void Spanning() {
		int rand = (int)((float)V * Math.random());
		Edge[] ass;
		int e, n, r;
		for(int i = 0; i < E; i++) {
			if(graph[i].contains(rand) != -1) neighbour.add(graph[i].contains(rand));
		}
		visited[0] = rand;
		previous = rand;
		for(int i = 0; i < V - 1; i++) {
			e = 0;
			n = 0;
			rand = (int)((float)neighbour.size() * Math.random());
			ThisV = neighbour.get(rand);
			for(int j = 0; j < E; j++)
				if(graph[j].contains(ThisV) != -1 && !visited(graph[j].contains(ThisV)) && !isNeighbour(graph[j].contains(ThisV))) neighbour.add(graph[j].contains(ThisV));
			visited[i + 1] = ThisV;
			for(int j = 0; j < E; j++) {
				for(int k = 0; k < i + 1; k++) {
					if(graph[j].ThisEdge(visited[k], ThisV) != null) e++;
				}
			}
			ass = new Edge[e];
			for(int j = 0; j < E; j++) {
				for(int k = 0; k < i + 1; k++) {
					if(graph[j].ThisEdge(visited[k], ThisV) != null) ass[n++] = graph[j].ThisEdge(visited[k], ThisV);
				}
			}
			r = (int)((double)e * Math.random());
			result[i] = ass[r];
			previous = ThisV;
			neighbour.remove(rand);
		}
		for(int i = 0; i < V - 1; i++) weight += result[i].weight;
	}

	@Override
	public int compareTo(RandomSPT o) {
		return this.weight - o.weight;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < result.length; i++) {
			str.append((char)(result[i].src + 65) + " - " + (char)(result[i].dest + 65) + " = " + result[i].weight + "\n");
		}
		str.append("weight: " + weight + "\n");
		return str.toString();
	}
}
