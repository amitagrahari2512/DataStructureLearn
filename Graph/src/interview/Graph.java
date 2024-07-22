package interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;


//If need to use Vertex then remove uncommented code for Vertex
public class Graph {
	
	public static void main(String[] args) {
    	Graph g = new Graph();
    	String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z"};
    	//String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z", "c->a", "c->d"};
		for(String data : str) {
			String[] strArr = data.split("->");
			//System.out.println(Arrays.toString(strArr));
			g.addEdge(strArr[0], strArr[1]);
		}
		g.displayGraph();
		
		
		List<String> listOfSet1 = new ArrayList<>();
		listOfSet1.add("a");
		listOfSet1.add("q");
		listOfSet1.add("w");
		System.out.println("Common val set 1 : " + g.commonVal(listOfSet1));
		
		List<String> listOfSet2 = new ArrayList<>();
		listOfSet2.add("a");
		listOfSet2.add("c");
		listOfSet2.add("r");
		
		//System.out.println("Common val set 2 : " + g.commonVal(listOfSet2));
		
		
		List<String> listOfSet3 = new ArrayList<>();
		listOfSet3.add("y");
		listOfSet3.add("z");
		listOfSet3.add("a");
		listOfSet3.add("r");
		
		//System.out.println("Common val set 3 : " + g.commonVal(listOfSet3));
		
		List<String> listOfSet4 = new ArrayList<>();
		listOfSet4.add("a");
		listOfSet4.add("w");
		
		
		//System.out.println("Common val set 4 : " + g.commonVal(listOfSet4));
		
	}
	
	//Map<String, List<Vertex>> map = new LinkedHashMap<>();
	Map<String, List<String>> map = new LinkedHashMap<>();
	Map<String, Integer> mapCount = new LinkedHashMap<>();
	
	public void addVertex(String s)
    {
        //map.put(s, new LinkedList<Vertex>());
		map.put(s, new LinkedList<String>());
        
    }
	
	
	//public void addEdge(String source, String destination, boolean bidirectional) {
	public void addEdge(String source, String destination) {

		//Vertex srcVertex = new Vertex(source);
		//Vertex destVertex = new Vertex(destination);
		if (!map.containsKey(source))
		{
			addVertex(source);
			//map.get(source).add(srcVertex);
		}

		if (!map.containsKey(destination)) {
			addVertex(destination);
			//map.get(destination).add(destVertex);
		}
			

		
		//map.get(source).add(destVertex);
		map.get(source).add(destination);
		/*
		if (bidirectional == true) {
			map.get(destination).add(source);
		}
		*/
	}
	
	// This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                           + map.keySet().size()
                           + " vertex");
    }
    
    public void displayGraph() {
    	//for(Map.Entry<String, List<Vertex>> entry :  map.entrySet()) {
    	for(Map.Entry<String, List<String>> entry :  map.entrySet()) {
    		System.out.print(entry.getKey() + ": " );
    		entry.getValue().forEach(System.out::print);
    		System.out.println();
    	}
    }
    
	public boolean commonVal(List<String> list) {
		mapCount = new LinkedHashMap<>(); 
		for(String v : list) {
			int val = checkCycle(v);
			if(val == 0)
				continue;
			if(val == 1)
				return true;
		}
		
		/*
		System.out.println("Without sortedMap :: "+ mapCount);
		
		Map<String, Integer> sortedMap =
			    mapCount.entrySet().stream()
			       .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			       .collect(Collectors.toMap(
		                      Map.Entry::getKey,
		                      Map.Entry::getValue,
		                      (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println("sortedMap :: "+ sortedMap);
		
		 for(Map.Entry<String, Integer> entry: sortedMap.entrySet()) {
			 if(entry.getValue() > 1) {
				 return true;
			 }
		 }
		 */
		
		return false;
	}
    
	public int checkCycle(String s) {
		boolean visited[] = new boolean[26];
		//int visited[] = new int[map.keySet().size()];
		
		int asccai = (int)s.charAt(0);
		System.out.println("asccai ::" + asccai);
		visited[(int)s.charAt(0) - 97] = true;
		Queue<String> q = new LinkedList<>();
		q.add(s);
		
		//List<Vertex> list = map.get(str);
		
		while(q.size() != 0) {
        	// Dequeue a vertex from queue and print it
            String str = q.poll();
            System.out.print(str + " ");
            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            
            //List<Vertex> list = map.get(str);
            List<String> list = map.get(str);
            if(!list.isEmpty()) {
	            for (int i = 0 ; i < list.size() ; i++ ) {
	                //Vertex v = list.get(i);
	            	String v = list.get(i);
	            	/*
	                if (!visited[(int)v.label.charAt(0)-97]) {
	                    visited[(int)v.label.charAt(0)-97] = true;
	                    q.add(v.label);
	                    
	                    if(mapCount.containsKey(v.label)) {
	                    	mapCount.put(v.label, mapCount.get(str)+1);
	                    }
	                    else {
	                    	mapCount.put(v.label, 1);
	                    }
	                }
	                else {
	                	System.out.println("Cycle Present for value :: " + s);
	                	return;
	                }
	            }
	            */
	            	if (!visited[(int)v.charAt(0)-97]) {
	                    visited[(int)v.charAt(0)-97] = true;
	                    q.add(v);
	                    
	                    if(mapCount.containsKey(v)) {
	                    	mapCount.put(v, mapCount.get(str)+1);
	                    	return 1;
	                    }
	                    else {
	                    	mapCount.put(v, 1);
	                    }
	                }
	                else {
	                	System.out.println("Cycle Present for value :: " + s);
	                	return 0;
	                }
            }
            }
            else {
            	if(mapCount.containsKey(s)) {
                	mapCount.put(s, mapCount.get(s)+1);
                	return 1;
                }
            	else {
            		mapCount.put(s, 1);
            	}
            }
        }
		return 0;
	}
	 
}

class Vertex {
	public String label;
    private boolean beingVisited;
    private boolean visited;
    
    public Vertex(String label) {
    	this.label = label;
    }
    
    @Override
    public String toString() {
    	return label;
    }
    
}
