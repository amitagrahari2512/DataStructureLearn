package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
  /**
   * Iterate through each line of input.
   */
  Map<String, List<String>> map = new LinkedHashMap<>();
  Map<String, Integer> mapCount = new LinkedHashMap<>();
  
  public static void main(String[] args) throws IOException {
    //InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    //BufferedReader in = new BufferedReader(reader);
    Main m = new Main();
    List<String> al = null;
    //String line;
    
    //String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z", "c->a", "c->d"};
    String[] str = {"A->B","G->B","B->C","C->D","D->E","H->J","J->F", "A,G,E" ,"H,A"};
	for(String line : str) {
    //while ((line = in.readLine()) != null) {
      if(line.contains("->")) {
        String[] strArr = line.split("->");
		m.addEdge(strArr[0].toLowerCase(), strArr[1].toLowerCase());
      }
      else if(line.contains(",")) {
    	  m.displayGraph();
        String[] strCommaArr = line.split(",");
        al = Arrays.asList(strCommaArr);
        al = al.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        try {
        System.out.println(m.DoLinkedListsIntersect(al) == true ? "True" : "False");
        }
        catch(RuntimeException e) {
          System.out.println(e.getMessage());
        }
      }
    }
    
  }
  
  public void addVertex(String s)
    {
		map.put(s, new LinkedList<String>());
        
    }
	
	
	public void addEdge(String source, String destination) {

		if (!map.containsKey(source))
		{
			addVertex(source);
		}

		if (!map.containsKey(destination)) {
			addVertex(destination);
		}
			
		map.get(source).add(destination);
	}
  
   public void displayGraph() {
    	for(Map.Entry<String, List<String>> entry :  map.entrySet()) {
    		System.out.print(entry.getKey() + ": " );
    		entry.getValue().forEach(System.out::print);
    		System.out.println();
    	}
    }
  
  public boolean DoLinkedListsIntersect(List<String> list) {
		mapCount = new LinkedHashMap<>(); 
		for(String v : list) {
			int val = checkIntersectCycle(v);
			if(val == -1) {
				
				throw new RuntimeException("Error Thrown!");
			}
			if(val == 0) {
				continue;
			}
				
			if(val == 1)
				return true;
		}
		
		return false;
	}
    
	public int checkIntersectCycle(String s) {
		boolean visited[] = new boolean[127];
		
		visited[(int)s.charAt(0)] = true;
		//visited[(int)s.charAt(0) - 97] = true;
		Queue<String> q = new LinkedList<>();
		q.add(s);
		
		
		while(q.size() != 0) {
            String str = q.poll();
            //System.out.print(str + " ");
            List<String> list = map.get(str);
            System.out.println(list + "list.empty" + list.isEmpty());
            if(!list.isEmpty()) {
	            for (int i = 0 ; i < list.size() ; i++ ) {
	            	String v = list.get(i);
	            	//if (!visited[(int)v.charAt(0)-97]) {
	                    //visited[(int)v.charAt(0)-97] = true;
                    if (!visited[(int)v.charAt(0)]) {
	                    visited[(int)v.charAt(0)] = true;
	                    q.add(v);
	                    
	                    if(mapCount.containsKey(v)) {
	                    	mapCount.put(v, mapCount.get(v)+1);
	                    	return 1;
	                    }
	                    else {
	                    	mapCount.put(v, 1);
	                    }
	                }
	                else {
	                	//System.out.println("Cycle Present for value :: " + s);
	                	return -1;
	                }
	            }
            }
            else {
            	System.out.println("Error");
            	System.out.println(mapCount);
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
