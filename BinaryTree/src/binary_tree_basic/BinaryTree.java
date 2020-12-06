package binary_tree_basic;

public class BinaryTree {
	
	Node root;
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new Node(1);
		
		/* following is the tree after above statement 
		  
		        1 
		      /   \ 
		    null  null     */
		
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);
		
		
		/* 2 and 3 become left and right children of 1 
			        1 
			      /   \ 
			     2      3 
			   /    \    /  \ 
			 null null null null  */
		
		binaryTree.root.left = new Node(4);
		/* 4 becomes left child of 2 
			        1 
			    /       \ 
			   2          3 
			 /   \       /  \ 
			4    null  null  null 
			/   \ 
			null null 
			*/
		
	}
}
