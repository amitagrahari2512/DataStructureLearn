package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*
 * 
 * 
 * 
 * Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.

 */
public class CommonElementsInThreeSortedArray {
	public static void main(String[] args) {
		int[] a = {1, 5, 10, 20, 40, 80};
		int[] b = {6, 7, 20, 80, 100};
		int[] c = {3, 4, 15, 20, 30, 70, 80, 120};
		
		System.out.println("Common Elements : " + commonElements(a, b, c));
	}
	
	public static ArrayList<Integer> commonElements(int A[], int B[], int C[]) 
    {
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		
		int n1 = A.length;
		int n2 = B.length;
		int n3 = C.length;
		
        // code here 
        for(int i = 0 ; i < n1 ; i++)
		{
			if(!map.containsKey(A[i])) {
				map.put(A[i], 1);
			}
		}
		
		for(int i = 0 ; i < n2 ; i++)
		{
			if(map.containsKey(B[i])) {
				map.put(B[i], 2);
			}
		}
		
		
		for(int i = 0 ; i < n3 ; i++)
		{
			if(map.containsKey(C[i])) {
				map.put(C[i], map.get(C[i]) == 2 ? 3 : map.get(C[i]) == 3 ? 3 : 0);
			}
			
		}
		
		ArrayList<Integer> list = new ArrayList<>(); 
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet() ) {
			if(entry.getValue() == 3) {
			    //System.out.println(entry.getKey() + "::" + entry.getValue());
				list.add(entry.getKey());
			}
		}
		
		if(list.size() == 0)
			list.add(-1);
		
		return list;
    }
}
