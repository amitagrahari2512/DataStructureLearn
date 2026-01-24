package detect_cycle_directed_graph_color;

import java.util.ArrayList;

//Detect Cycle in Directed Graph using color

/*
 * 
 * Algorithm:  

1 - Create a recursive function that takes the edge and color array (this can be also kept as a global variable)
2 - Mark the current node as GREY.
3 - Traverse all the adjacent nodes and if any node is marked GREY then return true as a loop is bound to exist.
4 - If any adjacent vertex is WHITE then call the recursive function for that node. If the function returns true. Return true.
5 - If no adjacent node is grey or has not returned true then mark the current Node as BLACK and return false.
 * 
 * 
 * 
 */
public class Graph {
	
	static int WHITE = 0, GRAY = 1, BLACK = 2;
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
	}
	
	public boolean isCyclicUtil(Graph g, int u, int[] color) {
		color[u] = GRAY;
		for(int in : adj.get(u)) {
			if(color[in] == GRAY) {
				return true;
			}
			if(color[in] == WHITE && isCyclicUtil(g, in, color) == true)
				return true;
		}
		color[u] = BLACK;
		return false;
	}
	
	public boolean isCyclic() {
		int[] color = new int[this.V];
		for(int i = 0 ; i < this.V ; i++) {
			color[i] = WHITE;
		}
		
		for(int i = 0 ; i < this.V ; i++) {
			if(color[i] == WHITE) {
				if(isCyclicUtil(this, i, color) == true)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        
        System.out.println(g1.isCyclic() ? "Graph contains cycle" : "Graph doesn't contain cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.isCyclic() ? "Graph contains cycle" : "Graph doesn't contain cycle");
        
        Graph g3 = new Graph(3);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(0, 0);
        
        System.out.println(g3.isCyclic() ? "Graph contains cycle" : "Graph doesn't contain cycle");
	}

}
