package bp;

import java.util.List;

/*
 * 
 * ou have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.

All gardens have at most 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.

 

Example 1:

Input: n = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Explanation:
Gardens 1 and 2 have different types.
Gardens 2 and 3 have different types.
Gardens 3 and 1 have different types.
Hence, [1,2,3] is a valid answer. Other valid answers include [1,2,4], [1,4,2], and [3,2,1].
Example 2:

Input: n = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 
 
 */
public class FlowerPlantingWithNoAdjacent {
	
	boolean[] visited;
	int[] colors;
	List<List<Integer>> graph;

	public static void main(String[] args) {
		
	}
	
	public List<Integer> gardenNoAdj(int n, int[][] paths) {
		
		for(int[] path : paths) {
			graph.get(path[0] - 1).add(path[1] - 1);
			graph.get(path[1] - 1).add(path[0] - 1);
		}
		
	}

}
