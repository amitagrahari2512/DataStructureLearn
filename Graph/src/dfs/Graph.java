package dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int v;
	private LinkedList<Integer> adj[];
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v]; 
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	
	public void addEdge(int v, int e) {
		adj[v].add(e);
	}
	
	public void dfs(int s) {
		
		 System.out.println(
		            "Following is Depth First Traversal "
		            + "(starting from vertex "+ s+ ")");
		boolean visited[] = new boolean[v];
		
		DfsUtil(s, visited);
		System.out.println();
	}
	
	public void DfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> i = adj[s].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DfsUtil(n, visited);
			}
		}
	}
	
	 // Driver Code
    public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        // Function call
        g.dfs(2);
        g.dfs(1);
    }
}
