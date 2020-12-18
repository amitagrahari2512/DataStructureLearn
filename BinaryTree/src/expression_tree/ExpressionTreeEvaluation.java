package expression_tree;

import java.util.Stack;

import binary_tree_basic.Node;

public class ExpressionTreeEvaluation {
	
	public static void main(String[] args) {
		ExpressionTreeEvaluation et = new ExpressionTreeEvaluation();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
	}
	
	public void inorder(Node root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}
	
	public Node constructTree(char[] chArr) {
		Stack<Node> stack = new Stack<>();
		Node t, t1, t2;
		
		for (int i = 0; i < chArr.length; i++) {
			if(!isOperator(chArr[i])) {
				t = new Node(chArr[i]);
				stack.push(t);
			}
			else {
				t = new Node(chArr[i]);
				
				t1 = stack.pop();
				t2 = stack.pop();
				
				t.right = t1;
				t.left = t2;
				
				stack.push(t);
			}
		}
		
		t = stack.peek();
		stack.pop();
		return t;
	}
	
	public boolean isOperator(char ch) {
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
			return true;
		}
		return false;
	}
}
