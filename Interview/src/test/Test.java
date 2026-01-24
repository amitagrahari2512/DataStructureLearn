package test;

public class Test {

	public static void main(String[] args) {
		String a = "110";
		int n = a.length() - 1;
		int i = 0;
		while(i <= n) {
			System.out.println(a.charAt(i++) - '0');
		}
	}

}
