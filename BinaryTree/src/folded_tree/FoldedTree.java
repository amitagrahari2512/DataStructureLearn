package folded_tree;

import binary_tree_basic.Node;

/*
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror
 * image of each other. An empty tree is considered as foldable.
 */
public class FoldedTree {
	Node root;
	
	public boolean isFolded(Node node) {
		boolean res;
		if(node == null)
			return true;
		
		mirror(node.left);
		res = isStructureSame(node.left, node.right);
		mirror(node.right);
		
		return res;
	}
	
	public Node mirror(Node node) {
		if(node == null)
			return node;
		
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	
	public boolean isStructureSame(Node a, Node b) {
		if(a == null && b == null)
			return true;
		if(a != null && b != null 
				&& isStructureSame(a.left, b.left)
				&& isStructureSame(a.right, b.right))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		FoldedTree fTree = new FoldedTree();
		fTree.root = new Node(1);
		fTree.root.left = new Node(2);
		fTree.root.right = new Node(3);
		fTree.root.left.right = new Node(4);
		fTree.root.right.left = new Node(5);
		
		if(fTree.isFolded(fTree.root)) {
			System.out.println("tree is foldable");
		}
		else {
			System.out.println("tree is not foldable");
		}
	}
}
