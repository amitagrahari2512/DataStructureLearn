package tree_continuous;

import binary_tree_basic.Node;

/*
 A tree is a Continuous tree if in each root to leaf path, 
 the absolute difference between keys of two adjacent is 1. 
 We are given a binary tree, we need to check if the tree is continuous or not.
*/
public class TreeContinuous {
	Node root;
	
	public static void main(String[] args) {
		TreeContinuous tree = new TreeContinuous();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.right = new Node(5);
		
		if(tree.treeContinuous(tree.root)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public boolean treeContinuous(Node root) {
		// if next node is empty then return true
		if(root == null)
			return true;
		
		// if current node is leaf node then return true
	    // because it is end of root to leaf path
		if(root.left == null && root.right == null)
			return true;
		
		// If left subtree is empty, then only check right
		if(root.left == null) {
			return (Math.abs(root.key - root.right.key) == 1) && treeContinuous(root.right);
		}
		
		// If right subtree is empty, then only check left
		if(root.right == null) {
			return (Math.abs(root.key - root.left.key) == 1) && treeContinuous(root.left);
		}
		
		// If both left and right subtrees are not empty, check
	    // everything
		return Math.abs(root.key - root.left.key) == 1 &&
				Math.abs(root.key - root.right.key) == 1 &&
				treeContinuous(root.left) &&
				treeContinuous(root.right);
				
	}
}
