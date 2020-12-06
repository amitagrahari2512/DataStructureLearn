package binary_tree_basic;

public class LeftViewTree {
	static Node root;
	static int maxLevel = 0;
	public static void main(String[] args) {
		root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        root.right.left = new Node(15);
        root.right.left.left = new Node(1);
        leftViewTree();
	}
	
	static void leftViewTree() {
		leftViewTree(root, 1);
	}
	
	static void leftViewTree(Node node, int level) {
		
		if(node == null)
			return;
		
		if(maxLevel < level) {
			System.out.print(node.key + " ");
			maxLevel = level;
		}
		
		leftViewTree(node.left, level+1);
		leftViewTree(node.right, level+1);
	}
}
