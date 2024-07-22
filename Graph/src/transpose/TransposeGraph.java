package transpose;

import java.util.ArrayList;
import java.util.Iterator;

public class TransposeGraph {
	
	private final int vertices;
	
	private ArrayList<Integer>[] actual;
	private ArrayList<Integer>[] transpose;
	
	public TransposeGraph(int vertices) {
		this.vertices = vertices;
		actual = new ArrayList[vertices];
		transpose = new ArrayList[vertices];
		for(int i = 0; i < vertices; i++)
        {
			actual[i] = new ArrayList<Integer>();
			transpose[i] = new ArrayList<Integer>();
        }
	}
	
	public void addEdge(int u, int v, boolean choice) {
		if(!choice) {
			actual[u].add(v);
		}
		else {
			transpose[u].add(v);
		}
	}
	
	public void getTranspose() {
		for(int i = 0 ;i < vertices ;i++) {
			for(int j = 0; j<actual[i].size() ;j++) {
				addEdge(actual[i].get(j), i, true);
			}
		}
	}
	
	public void printGraph() {
		for(int i = 0 ;i < vertices ; i++) {
				System.out.print(i + " ----> ");
				for(int j = 0; j<transpose[i].size() ;j++) {
					System.out.print(transpose[i].get(j) + " ");
				}
				System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		TransposeGraph t = new TransposeGraph(5);
		t.addEdge(0, 1, false);
        t.addEdge(0, 4, false);
        t.addEdge(0, 3, false);
        t.addEdge(2, 0, false);
        t.addEdge(3, 2, false);
        t.addEdge(4, 1, false);
        t.addEdge(4, 3, false);
        
        t.getTranspose();
        t.printGraph();
	}
	
}
