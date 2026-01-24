package iterative_dfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Iterative DFS
public class Graph {
	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v ;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int e) {
		adj[v].add(e);
	}
	
	public void iterativeDfs(int s) {
		
		System.out.println(
	            "Following is Depth First Traversal "
	            + "(starting from vertex "+ s+ ")");
		
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		
		while(stack.empty() == false) {
			s = stack.peek();
			stack.pop();
			
			if(visited[s] == false) {
				System.out.print(s + " ");
				visited[s] = true;
			}
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext()) {
				int v = itr.next();
				if(!visited[v]) {
					stack.push(v);
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
        
        
        // Function call
        g.iterativeDfs(2);
        g.iterativeDfs(1);
    }
}
