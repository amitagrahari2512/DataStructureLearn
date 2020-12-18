package mirror_tree;

import binary_tree_basic.Node;

/*
 *Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) 
 *with left and right children of all non-leaf nodes interchanged.
 * 
 *   4                       4 
    / \                     / \
   5   2    Mirror Tree    2   5
  / \                     / \   
 3   1                   1   3 
 */
public class MirrorTree {
	Node root;
	
	public void inorder(Node node) {
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.key + " ");
		inorder(node.right);
	}
	
	public void mirror() {
		mirror(root);
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
	
	public static void main(String[] args) {
		MirrorTree mTree = new MirrorTree();
		mTree.root = new Node(1);
		mTree.root.left = new Node(2);
		mTree.root.right = new Node(3);
		mTree.root.left.left = new Node(4);
		mTree.root.left.right = new Node(5);
		
		mTree.inorder(mTree.root);
		
		/* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :"); 
        mTree.inorder(mTree.root); 
        System.out.println(""); 
  
        /* convert tree to its mirror */
        mTree.mirror(); 
  
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : "); 
        mTree.inorder(mTree.root); 
	}
}
