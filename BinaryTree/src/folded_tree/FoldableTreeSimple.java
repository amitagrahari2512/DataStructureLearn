package folded_tree;

import binary_tree_basic.Node;

public class FoldableTreeSimple {
	Node root;
	
	public boolean isFoldableTree(Node node) {
		if(node == null)
			return true;
		
		return isFoldableTreeUtil(node.left, node.right);
	}
	
	public boolean isFoldableTreeUtil(Node a , Node b) {
		if(a == null && b == null)
			return true;
		
		if(a == null || b == null)
			return false;
		
		return isFoldableTreeUtil(a.left, b.right) &&
				isFoldableTreeUtil(a.right, b.left);
	}
	
	public static void main(String[] args) {
		FoldableTreeSimple fTree = new FoldableTreeSimple();
		fTree.root = new Node(1);
		fTree.root.left = new Node(2);
		fTree.root.right = new Node(3);
		fTree.root.left.right = new Node(4);
		fTree.root.right.left = new Node(5);
		
		if(fTree.isFoldableTree(fTree.root)) {
			System.out.println("tree is foldable");
		}
		else {
			System.out.println("tree is not foldable");
		}
	}
}
