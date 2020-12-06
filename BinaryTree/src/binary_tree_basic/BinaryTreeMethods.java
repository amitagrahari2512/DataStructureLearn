package binary_tree_basic;

public class BinaryTreeMethods {
	Node root;
	public static void main(String[] args) {
		BinaryTreeMethods binaryTree = new BinaryTreeMethods();
		binaryTree.root = new Node(10);
		binaryTree.root.left = new Node(11);
		binaryTree.root.left.left = new Node(7);
		binaryTree.root.right = new Node(9);
		binaryTree.root.right.left = new Node(15);
		binaryTree.root.right.right = new Node(8);
		
		System.out.println("Size in tree "+binaryTree.size());
		System.out.println("max in tree "+binaryTree.max(binaryTree.root));
		System.out.println("min in tree  "+binaryTree.min(binaryTree.root));
	}
	
	int size() {
		return size(root);
	}
	
	int size(Node node) {
		if(node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}
	
	int max(Node node) {
		
		if(node == null)
			return Integer.MIN_VALUE;
		
		int max = node.key;
		int leftMax = max(node.left);
		int rightMax = max(node.right);
		
		if(leftMax > max)
			max = leftMax;
		if(rightMax > max)
			max = rightMax;
		
		return max;
	}
	
	int min(Node node) {
		
		if(node == null)
			return Integer.MAX_VALUE;
		
		int min = node.key;
		int leftMin = min(node.left);
		int rightMin = min(node.right);
		
		if(leftMin < min)
			min = leftMin;
		if(rightMin < min)
			min = rightMin;
		
		return min;
	}
}
