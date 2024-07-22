package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTimeToInformAllEmployee {

	    private List<Integer>[] adj;

	    private int dfs(int id, int[] manager, int[] informTime) {
	        int time = 0;
	        System.out.println("adj[id]:" + adj[id]);
	        for(int emp : adj[id]) {
	            time = Math.max(time, dfs(emp, manager, informTime));
	        }
	        return time + informTime[id];
	    }

	    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
	        adj = new ArrayList[n];

	        for(int i = 0 ;i < n ; i++){
	            adj[i] = new ArrayList<>();
	        }

	        for(int i = 0 ;i < n ; i++){
	            if(i == headID)
	                continue;

	            adj[manager[i]].add(i);
	        }

	        return dfs(headID, manager, informTime);
	    }
	    
	    public static void main(String[] args) {
	    	LeetCodeTimeToInformAllEmployee e = new LeetCodeTimeToInformAllEmployee();
	    	/*
	    	int n = 6;
	    	int headId = 2;
	    	int[] manager = {2,2,-1,2,2,2};
	    	int[] informTime = {0,0,1,0,0,0};
	    	*/
	    	int n = 15;
	    	int headId = 0;
	    	int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
	    	int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
	    	System.out.println(e.numOfMinutes(n, headId, manager, informTime));
		}
}
