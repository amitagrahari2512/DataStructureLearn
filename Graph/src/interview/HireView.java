package interview;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

public class HireView {
	
	public static void main(String[] args) {
		HireView g = new HireView();
    	//String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z"};
    	//String[] str = {"a->b","r->s","b->c","x->c","q->r","y->x","w->z", "c->a", "c->d"};
		String[] str = {"A->B","G->B","B->C","C->D","D->E","H->J","J->F"};
		for(String data : str) {
			String[] strArr = data.split("->");
			g.addEdge(strArr[0].toLowerCase(), strArr[1].toLowerCase());
		}
		g.displayGraph();
		
		
		List<String> listOfSet1 = new ArrayList<>();
		listOfSet1.add("a");
		listOfSet1.add("q");
		listOfSet1.add("w");
		//System.out.println("Common val set 1 : " + g.commonVal(listOfSet1));
		
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
		
		
		List<String> listOfSet5 = new ArrayList<>();
		listOfSet5.add("a");
		listOfSet5.add("g");
		listOfSet5.add("e");
		
		
		System.out.println("Common val set 5 : " + g.commonVal(listOfSet5));
		
	}
	
	Map<String, List<String>> map = new LinkedHashMap<>();
	Map<String, Integer> mapCount = new LinkedHashMap<>();
	
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
    
	public boolean commonVal(List<String> list) {
		mapCount = new LinkedHashMap<>(); 
		for(String v : list) {
			int val = checkIntersectCycle(v);
			if(val == -1) {
				//System.out.println("Cycle Found on :: " + v);
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
		boolean visited[] = new boolean[26];
		
		//System.out.println("asccai ::" + asccai);
		visited[(int)s.charAt(0) - 97] = true;
		Queue<String> q = new LinkedList<>();
		q.add(s);
		
		
		while(q.size() != 0) {
            String str = q.poll();
            System.out.println("poll : " + str);
            //System.out.print(str + " ");
            List<String> list = map.get(str);
            System.out.println(list + ":: "+ list.isEmpty());
            if(!list.isEmpty()) {
	            for (int i = 0 ; i < list.size() ; i++ ) {
	            	String v = list.get(i);
	            	System.out.println("V value" + v);
	            	if (!visited[(int)v.charAt(0)-97]) {
	                    visited[(int)v.charAt(0)-97] = true;
	                    q.add(v);
	                    System.out.println(mapCount);
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



