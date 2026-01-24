package detect_cycle_undirected_graph;

import java.util.ArrayList;
import java.util.Iterator;

//Detect Cycle in UnDirected Graph
public class Graph {
	
	private int V;
	private ArrayList<ArrayList<Integer>> adj;
	
	public Graph(int V) {
		this.V =  V;
		adj = new ArrayList<>(V);
		for(int i = 0 ; i < V ;i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
		
	}
	
	public boolean isCycleUtil(int v, boolean[] visited, int parent) {
		visited[v] = true;
		Integer i;
		
		Iterator<Integer> ite = adj.get(v).iterator();
		while(ite.hasNext()) {
			i = ite.next();
			
			if(!visited[i]) {
				if(isCycleUtil(i, visited, v)) {
					return true;
				}
			}
			else if(i != parent) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean isCycle() {
		boolean visited[] = new boolean[V];
		
		for(int u = 0; u < V ; u++) {
			if(!visited[u]) {
				if(isCycleUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// Create a graph given
        // in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        
        System.out.println(g1.isCycle() ? "Graph contains cycle" : "Graph doesn't contain cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.isCycle() ? "Graph contains cycle" : "Graph doesn't contain cycle");
        
        Graph g3 = new Graph(3);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(0, 0);
        
        System.out.println(g3.isCycle() ? "Graph contains cycle" : "Graph doesn't contain cycle");
	}

}
