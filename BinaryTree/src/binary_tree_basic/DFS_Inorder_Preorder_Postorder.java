package binary_tree_basic;

public class DFS_Inorder_Preorder_Postorder {

	static Node root;
	
	//LNR - Left Node Right
	public static void printInorder(Node node) {
		if(node == null)
			return;
		
		printInorder(node.left);
		
		System.out.print(node.key + " ");
		
		printInorder(node.right);
	}
	
	//LNR - Node Left Right
	public static void printPreOrder(Node node) {
		if (node == null)
			return;
		
		System.out.print(node.key + " ");

		printPreOrder(node.left);

		printPreOrder(node.right);
	}
	
	//LNR - Left Right Node
	public static void printPostOrder(Node node) {
		if (node == null)
			return;

		printPostOrder(node.left);

		printPostOrder(node.right);
		
		System.out.print(node.key + " ");
	}
	
	public static void main(String[] args) {
		/**
		 	 1
		 	/ \
		   2   3
		  / \
		 4   5
		 
		 */
		
		root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        printPreOrder(root); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        printInorder(root); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        printPostOrder(root); 
	}
	
}
