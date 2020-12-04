package NO9;

public class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    public Edge() {
    }
    
    public Edge(int src, int dest, int weight) {
    	this.src = src;
    	this.dest = dest;
    	this.weight = weight;
    }
    
    public int contains(int s) {
    	if(s == src) return dest;
    	if(s == dest) return src;
    	return -1;
    }
    
    public Edge ThisEdge(int s, int d) {
    	if((s == src && d == dest) || (d == src && s == dest)) return this;
    	else return null;
    }
    
    public boolean isSame(Edge e) {
    	if((e.src == src && e.dest == dest) || (e.src == dest && e.dest == src)) return true;
    	return false;
    }
    
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
