package symmetric_tree;

import binary_tree_basic.Node;

/*
 * Symmetric Tree (Mirror Image of itself)
 * 
 *   1
   /   \
  2     2
 / \   / \
3   4 4   3

 */
public class SymmetricTree {
	
	Node root;
	
	public boolean symmetricTree(Node root) {
		return isMirror(root, root);
	}
	
	public boolean isMirror(Node node1, Node node2) {
		if(node1 == null && node2 == null)
			return true;
		
		if (node1 != null && node2 != null && node1.key == node2.key)
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
		
		return false;
	}
	
	public static void main(String[] args) {
		SymmetricTree sym = new SymmetricTree();
		sym.root = new Node(1);
		sym.root.left = new Node(2);
		sym.root.left.left = new Node(3);
		sym.root.left.right = new Node(4);
		
		sym.root.right = new Node(2);
		sym.root.right.left = new Node(4);
		sym.root.right.right = new Node(3);
		//sym.root.right.right.left = new Node(5);
		
		if(sym.symmetricTree(sym.root)) {
			System.out.println("Symmetric Tree");
		}
		else {
			System.out.println("No Symmetric Tree");
		}
	}
}
