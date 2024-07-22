package interview;

import java.util.ArrayList;
import java.util.List;

public class Graph1 {
	 private List<Vertex1> vertices;

	    public Graph1() {
	        this.vertices = new ArrayList<>();
	    }

	    public void addVertex1(Vertex1 Vertex1) {
	        this.vertices.add(Vertex1);
	    }

	    public void addEdge(Vertex1 from, Vertex1 to) {
	        from.addNeighbor(to);
	    }
	    
	    
	    public static void main(String[] args) {
			String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z"};
			for(String data : str) {
				String[] strArr = data.split("->");
				Vertex1 v1 = new Vertex1(strArr[0]);
				Vertex1 v2 = new Vertex1(str[1]);
			}
		}
}
class Vertex1 {
	private String label;
    private boolean beingVisited;
    private boolean visited;
    private List<Vertex1> adjacencyList;

    public Vertex1(String label) {
        this.label = label;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex1 adjacent) {
        this.adjacencyList.add(adjacent);
    }
}
