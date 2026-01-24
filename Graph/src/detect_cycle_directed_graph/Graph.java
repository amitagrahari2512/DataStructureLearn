package detect_cycle_directed_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Detect Cycle in Directed Graph
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
	}
	
	public boolean isCyclic() {
		int[] inDegree = new int[V];
		Queue<Integer> q = new LinkedList<>();
		int visited = 0;
		
		for(int i = 0 ; i < V ; i ++) {
			for(int j : adj.get(i)) {
				inDegree[j]++;
			}
		}
		
		System.out.println(Arrays.toString(inDegree));
		
		for(int i = 0 ; i < V ; i++) {
			if(inDegree[i] == 0)
			{
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int u = q.poll();
			visited++;
			// reduce in-degree of adjacent vertices
			for(int v : adj.get(u)) {
				inDegree[v]--;
				if(inDegree[v] == 0) {
					q.add(v);
				}
			}
		}
		
		System.out.println(visited);
		return visited != V;
	}

	public static void main(String[] args) {
		/*
		Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        //graph.addEdge(3, 3);
		*/
		Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
		
        // Function call
        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                               + "contain cycle");
	}

}
