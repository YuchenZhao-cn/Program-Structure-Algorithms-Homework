package NO9;

import java.util.*;

public class BalancedSPT_GA {
	// Initialize global variables
	private Edge[] Tm;
	private int[] Ts;
	private population p1 = new population();
	private population p2 = new population();
	private double a;
	private double B;
	private Edge[] graph;
	private int source;
	private int V, E, pop, minWeight;
	private double pc, pm;
	private int w1 = -1, w2 = -1, w3 = -1;
	
	// population class
	private class population {
		private int pop = 0;
		private ArrayList<RandomSPT> individuals = new ArrayList<RandomSPT>();
		
		// add individuals to the population
		private void add(RandomSPT ind) {
			individuals.add(ind);
			pop++;
		}
		
		// randomly kill individuals using Roulette Wheel Selection until there are "pop" individuals
		private void kill(int pop) {
			int denominator, rand, weight;
			int[] ind;
			while(individuals.size() > pop) {
				weight = 0;
				denominator = 0;
				ind = new int[individuals.size()];
				for(int i = 0; i < ind.length; i++) {
					denominator += (individuals.get(i).weight - best().weight + 1);
				}
				rand = (int)((double)denominator * Math.random());
				for(int i = 0; i < individuals.size(); i++) {
					weight += (individuals.get(i).weight - best().weight + 1);
					if(weight > rand) {
						individuals.remove(i);
						break;
					}
				}
			}
			this.pop = pop;
		}
		
		// return the best individual in the population
		private RandomSPT best() {
			int min = Integer.MAX_VALUE;
			RandomSPT result = individuals.get(0);
			for(int i = 0; i < individuals.size(); i++) {
				if(min > individuals.get(i).weight) {
					result = individuals.get(i);
					min = result.weight;
				}
			}
			return result;
		}
	}

	/*
	 * Constructor
	 * Input: graph, pop, maxgen, pc, pm, source, a
	 * Output: generation number, the best individual in the last generation
	 */
	public BalancedSPT_GA(int[][] graph, int pop, int maxgen, double pc, double pm, int source, double a) {
		this.a = a;
		this.source = source;
		this.pop = pop;
		this.pc = pc;
		this.pm = pm;
		V = graph.length;
		
		// Count the edge number
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < i; j++) {
				if(graph[i][j] != 0) E++;
			}
		}
		int count = 0;
		this.graph = new Edge[E];
		
		// Create the Edge array to store the edges in the graph
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < i; j++) {
				if(graph[i][j] != 0) this.graph[count++] = new Edge(i, j, graph[i][j]);
			}
		}
		
		// Inputing Minimum Spanning Tree and Shortest Path Tree using Kruskal algorithm and Dijkstra algorithm
		Kruskal TreeMinimumSPT = new Kruskal(this.graph, V, E);
		minWeight = TreeMinimumSPT.weight;
		Tm = TreeMinimumSPT.MinmumSPT();
		Ts = (new Dijkstra(graph, source)).ShortestPath();
		
		// Initialize the first generation
		InitialPop();
		
		for(int i = 0; i < p1.individuals.size(); i++) {
			p2.add(p1.individuals.get(i));
		}
		
		// Begin generations
		int gen;
		for(gen = 0; gen < maxgen; gen++) {
			// Crossover
			for(int i = 0; i < p1.pop; i++) {
				int rand1 = (int)((double)p1.individuals.size() * Math.random());
				int rand2 = (int)((double)p1.individuals.size() * Math.random());
				RandomSPT parent1 = p1.individuals.get(rand1);
				RandomSPT parent2 = p1.individuals.get(rand2);
				double p = Math.random();
				if(p < pc) crossover(parent1.result, parent2.result);
				else {
					p2.add(parent1);
					p2.add(parent2);
				}
			}
			
			// Mutation
			for(int i = 0; i < p1.pop; i++) {
				double r = Math.random();
				if(r < pm) {
					mutation(p1.individuals.get(i));
				}
			}
			
			// Kill the individuals
			p2.kill(pop);
			p1 = new population();
			for(int i = 0; i < p2.individuals.size(); i++) {
				p1.add(p2.individuals.get(i));
			}
			
			// Termination point
			// Works better when the graph has a large density and size
//			w1 = w2; w2 = w3; w3 = p1.best().weight;
//			if(w1 == w2 && w2 == w3) break;
			
			p2 = new population();
			System.out.println("generation: " + (1 + gen));
		}
		
		// Output
		B = (double)p1.best().weight / (double)minWeight;
		System.out.print("------------\nBest individual: \n" + p1.best());
		System.out.println("B = " + B);
		System.out.println("Generations: " + gen);
		System.out.println("source = " + (char)(source + 65) + ",  a = " + a + ",  pop = " + pop + ",  maxgen = " + maxgen + ",  pc = " + pc + ",  pm = " + pm);
	}
	
	// Initialize the first generation
	private void InitialPop() {
		System.out.println("Initializing The first generation...\nTotally " + pop + " individuals are going to be initialized");
		Thread t1 = new Thread();
		while(p1.pop < pop) {
			RandomSPT rspt = new RandomSPT(this.graph, V, E);
			if(jud(rspt.result)) {
				p1.add(rspt);
				System.out.println(p1.pop + " individual created!");
			}
		}
	}
	
	// Judge whether the tree meets the requirement of a
	private boolean jud(Edge[] edges) {
		int[][] graph = new int[edges.length + 1][edges.length + 1];
		int[] ts;
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				graph[i][j] = 0;
			}
		}
		for(int i = 0; i < edges.length; i++) {
			graph[edges[i].src][edges[i].dest] = edges[i].weight;
			graph[edges[i].dest][edges[i].src] = edges[i].weight;
		}
		Dijkstra d = new Dijkstra(graph, source);
		ts = d.ShortestPath();
		for(int i = 0; i < ts.length; i++) {
			if(ts[i] > a * Ts[i]) return false;
		}
		return true;
	}
	
	// Select the sequence number of the edge that is selected in the graph by Roulette Wheel Selection
	private int select(Edge[] edges) {
		int denominator = 0;
		for(int i = 0; i < edges.length; i++) denominator += edges[i].weight;
		int rand = (int)((double)denominator * Math.random());
		int weight = 0;
		for(int i = 0; i < edges.length; i++) {
			weight += edges[i].weight;
			if(weight > rand) return i;
		}
		return -1;
	}
	
	// Fix the cycles in the graph by deleting a random edge in the cycle
	private Edge[] deleteCycle(Edge[] edges, Edge e) {
		ArrayList<Edge> leaf = new ArrayList<Edge>();
		Edge[] result1, result;
		int[] v = new int[2 * edges.length];
		int[] fi = {-1, -1}, se = {-1, -1}, th = {-1, -1};
		int del, num = 1;
		boolean flag = true;
		for(int i = 0; i < edges.length; i++) {
			v[2 * i] = edges[i].src;
			v[2 * i + 1] = edges[i].dest;
		}
		Arrays.sort(v);
		
		// Find the cycle
		for(int i = 0; i < edges.length; i++) {
			fi[0] = -1; fi[1] = -1; se[0] = -1; se[1] = -1; th[0] = -1; th[1] = -1;
			flag = true;
			for(int j = 0; j < v.length + 1; j++) {
				if(j != v.length) {
					if(v[j] != -1) {
						fi[0] = se[0]; fi[1] = se[1]; se[0] = th[0]; se[1] = th[1]; th[0] = j; th[1] = v[j];
					}
				}
				else if(j == v.length) {
					fi[0] = se[0]; fi[1] = se[1]; se[0] = th[0]; se[1] = th[1]; th[0] = -1; th[1] = -1;
				}
				if(fi[1] != se[1] && se[1] != th[1] && e.contains(se[1]) == -1) {
					flag = false;
					for(int k = 0; k < edges.length; k++) {
						if(edges[k] != null) {
							if(edges[k].contains(se[1]) != -1) {
								del = edges[k].contains(se[1]);
								for(int l = 0; l < v.length; l++) {
									if(v[l] == del) {
										v[l] = -1;
										break;
									}
								}
								leaf.add(edges[k]);
								edges[k] = null;
								v[se[0]] = -1;
								se[0] = fi[0]; se[1] = fi[1];
							}
						}
					}
				}
			}
			if(flag) break;
		}
		
		// Fixing the cycle
		for(int i = 0; i < edges.length; i++) {
			if(edges[i] != null) num++;
		}
		result1 = new Edge[num];
		result = new Edge[edges.length];
		int j = 0;
		for(int i = 0; i < edges.length; i++) {
			if(edges[i] != null) result1[j++] = edges[i];
		}
		result1[j] = e;
		j = 0;
		int sel = select(result1);
		for(int i = 0; i < result1.length; i++) {
			if(i != sel) result[j++] = result1[i];
		}
		for(int i = 0; i < leaf.size(); i++) {
			result[j++] = leaf.get(i);
		}
		return result;
	}
	
	// Crossover
	private void crossover(Edge[] par1, Edge[] par2) {
		Edge[] E1, E2, T, T1, T2;
		int same = 0;
		int num = 0;
		Edge[] parent1 = new Edge[V - 1];
		Edge[] parent2 = new Edge[V - 1];
		for(int i = 0; i < V - 1; i++) {
			parent1[i] = par1[i];
			parent2[i] = par2[i];
		}
		for(int i = 0; i < V - 1; i++) {
			for(int j = 0; j < V - 1; j++) {
				if(parent1[i].isSame(parent2[j])) same++;
			}
		}
		T = new Edge[same];
		for(int i = 0; i < V - 1; i++) {
			for(int j = 0; j < V - 1; j++) {
				if(parent1[i].isSame(parent2[j])) T[num++] = parent1[i];
			}
		}
		E1 = new Edge[parent1.length - T.length];
		E2 = new Edge[parent2.length - T.length];
		num = 0;
		for(int i = 0; i < V - 1; i++) {
			int j;
			for(j = 0; j < T.length; j++) {
				if(parent1[i].isSame(T[j])) break;
			}
			if(j == T.length) E1[num++] = parent1[i];
		}
		num = 0;
		for(int i = 0; i < V - 1; i++) {
			int j;
			for(j = 0; j < T.length; j++) {
				if(parent2[i].isSame(T[j])) break;
			}
			if(j == T.length) E2[num++] = parent2[i];
		}
		T1 = parent1;
		T2 = parent2;
		for(int i = 0; i < E1.length; i++) {
			T1 = deleteCycle(T1, E2[i]);
			T2 = deleteCycle(T2, E1[i]);
		}
		RandomSPT child1 = new RandomSPT(T1);
		RandomSPT child2 = new RandomSPT(T2);
		p2.add(child1);
		p2.add(child2);
	}
	
	// Mutation
	private void mutation(RandomSPT T) {
		Edge[] t = T.result;
		Edge e = new Edge();
		Edge[] remain = remain(t);
		double rand;
		for(int i = 0; i < t.length; i++) {
			rand = Math.random();
			if(rand < pm) {
				e = t[i];
				t[i] = remain(t)[select(remain(t))];
				if(!jud(t)) t[i] = e;
			}
		}
		p2.add(new RandomSPT(t));
	}
	
	// return the remaining edges in the graph except the tree
	private Edge[] remain(Edge[] t) {
		Edge[] result;
		int j, num = 0;
		for(int i = 0; i < E; i++) {
			for(j = 0; j < t.length; j++) {
				if(graph[i].isSame(t[j])) break;
			}
			if(j == t.length) num++;
		}
		result = new Edge[num];
		num = 0;
		for(int i = 0; i < E; i++) {
			for(j = 0; j < t.length; j++) {
				if(graph[i].isSame(t[j])) break;
			}
			if(j == t.length) result[num++] = graph[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] graph1 = {{0, 2, 0, 1, 0, 0},
			   	 		 {2, 0, 1, 2, 0, 0},
			   	 		 {0, 1, 0, 1, 5, 4},
			   	 		 {1, 2, 1, 0, 6, 0},
			   	 		 {0, 0, 5, 6, 0, 3},
			   	 		 {0, 0, 4, 0, 3, 0}};
		new BalancedSPT_GA(graph1, 100, 1000, 0.8, 0.2, 0, 1.4);
		System.out.println("----------------------------------------------------------\n\nLarger Graph:");
		int[][] graph2 = {{0, 2, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 4},
	   	 		 		  {2, 0, 1, 2, 0, 0, 0, 0, 4, 9, 4, 9, 4},
	   	 		 		  {0, 1, 0, 1, 5, 4, 0, 2, 0, 7, 6, 8, 0},
	   	 		 		  {1, 2, 1, 0, 6, 0, 0, 0, 0, 0, 3, 6, 8},
	   	 		 		  {0, 0, 5, 6, 0, 3, 4, 3, 8, 0, 5, 7, 8},
	   	 		 		  {0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 0, 5, 7},
	   	 		 		  {3, 0, 0, 0, 4, 0, 0, 5, 0, 0, 7, 4, 0},
	   	 		 		  {0, 0, 2, 0, 3, 0, 5, 0, 4, 0, 1, 4, 0},
	   	 		 		  {0, 4, 0, 0, 8, 0, 0, 4, 0, 0, 6, 7, 7},
	   	 		 		  {0, 9, 7, 0, 0, 0, 0, 0, 0, 0, 4, 7, 4},
	   	 		 		  {0, 4, 6, 3, 5, 0, 7, 1, 6, 4, 0, 4, 3},
	   	 		 		  {0, 9, 8, 6, 7, 5, 4, 4, 7, 7, 4, 0, 3},
	   	 		 		  {4, 4, 0, 8, 8, 7, 0, 0, 7, 4, 3, 3, 0}};
		new BalancedSPT_GA(graph2, 50, 1000, 0.8, 0.3, 0, 1.5);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("The termination point doesn't work very well in these two graphs, so they are not used.");
		System.out.println("It may be caused by the small density and size of the graphs.");
		System.out.println("They are written on the line 143 and 144 and are ready to be used.");
	}

}
