package bp;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSumOfDeepestLevels {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	static TreeNode createNode(int val) {
		TreeNode treeNode = new TreeNode();
		treeNode.val = val;
		treeNode.left = null;
		treeNode.right = null;
		return treeNode;
	}
	
	private static int findSumOfFullTree(TreeNode root) {
		int sum = 0;
		if(root == null)
			return sum;
		
		Queue<TreeNode> qu = new LinkedList<>();
		qu.offer(root);
		
		while(qu.size() != 0) {
			int size = qu.size();
			while(size-- != 0) {
				
				TreeNode t = qu.poll();
				sum = sum + t.val;
				
				if(t.left != null) {
					qu.offer(t.left);
				}
				
				if(t.right != null) {
					qu.offer(t.right);
				}
			}
		}
		
		return sum;
	}

	
	private static int findSumOfDeepestLevel(TreeNode root) {
		int sumOfCurrentLevel = 0;
		if(root == null)
			return sumOfCurrentLevel;
		
		Queue<TreeNode> qu = new LinkedList<>();
		qu.offer(root);
		
		while(qu.size() != 0) {
			sumOfCurrentLevel = 0;
			int size = qu.size();
			while(size-- != 0) {
				
				TreeNode t = qu.poll();
				sumOfCurrentLevel = sumOfCurrentLevel + t.val;
				
				if(t.left != null) {
					qu.offer(t.left);
				}
				
				if(t.right != null) {
					qu.offer(t.right);
				}
			}
		}
		
		return sumOfCurrentLevel;
	}

	public static void main(String[] args) {
		TreeNode root;
		root = createNode(1);
		root.left  = createNode(2);
		root.right  = createNode(3);
		root.left.left = createNode(4);
		root.left.right = createNode(5);
		root.right.left = createNode(6);
		root.right.right = createNode(7);
		System.out.println( "Sum Of Full Tree : " + findSumOfFullTree(root));
		System.out.println( "Sum Of Deepest Level : " + findSumOfDeepestLevel(root));
	}

}
