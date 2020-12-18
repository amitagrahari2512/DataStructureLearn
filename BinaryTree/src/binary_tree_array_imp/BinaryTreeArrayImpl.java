package binary_tree_array_imp;

public class BinaryTreeArrayImpl {
	static int root = 0;
	static String[] arr = new String[10];
	
	public void root(String data) {
		arr[root] = data;
	}
	
	public void setLeft(String data, int root) {
		int i = (2 * root) + 1;
		arr[i] = data;
	}
	
	public void setRight(String data, int root) {
		int i = (2 * root) + 2;
		arr[i] = data;
	}
	
	public void printTree() {
		for (int i = 0; i < 10; i++) {
            if (arr[i] != null)
                System.out.print(arr[i]);
            else
                System.out.print("-");
        }
	}
	
	public static void main(String[] args) {
		BinaryTreeArrayImpl binary = new BinaryTreeArrayImpl();
		binary.root("A");
		binary.setLeft("B", 0);
		binary.setRight("C", 0);
		binary.setLeft("D",1);
		binary.setRight("E", 1);
		binary.setLeft("F", 2);
		
		binary.printTree();
		
	}
}
