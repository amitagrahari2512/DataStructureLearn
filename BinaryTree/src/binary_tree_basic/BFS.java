package binary_tree_basic;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static Node root;
	public static void main(String[] args) {
		root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        traverseBfs();
	}
	
	public static void traverseBfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.key + " ");
			
			if(temp.left != null) 
				q.add(temp.left);
			
			if(temp.right != null) 
				q.add(temp.right);
		}
	}
	
}
