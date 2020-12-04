package NO9;

import java.util.*;
 
public class Kruskal {
	private int V, E;
    private Edge edge[];
    private Edge result[]; 
    private int num = 0;
    public int weight = 0;
 
    private class subset {
        int parent, rank;
    }

    private int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
 
    private void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    public Kruskal(Edge[] graph, int V, int E) {
    	this.V = V;
    	this.E = E;
    	this.edge = graph;
		
		Arrays.sort(edge);
		
		result = new Edge[V];
		
        subset subsets[] = new subset[V];
        for (int i = 0; i < V; i++) subsets[i] = new subset();
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        int i = 0;
        while (num < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            if (x != y) {
                result[num++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for(int j = 0; j < V - 1; j++) {
        	weight += result[j].weight;
        }
    }
    
    public Edge[] MinmumSPT() {
    	return result;
    }
    
    @Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < num; i++) {
			str.append((char)(result[i].src + 65) + " -- " + (char)(result[i].dest + 65) + " : " + result[i].weight + "\n");
		}
		return str.toString();
	}
}
