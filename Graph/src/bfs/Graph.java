package bfs;

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
	
	public void bfs(int s) {
		System.out.println(
	            "Following is Breadth First Traversal "
	            + "(starting from vertex "+ s +")");
		// Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[v];
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        
        while(queue.size() != 0) {
        	// Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            
        }
        System.out.println();
	}
	
	
	
	
	public static void main(String args[])
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        g.bfs(2);
        g.bfs(1);
    }
}

/*
  Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
  Auxiliary Space: O(V)
 */
