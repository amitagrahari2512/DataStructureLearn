package family_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {
	public static void main(String[] args) {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String n = reader.readLine();
		int num = Integer.parseInt(n);
		Factorial f = new Factorial();
		int flower = f.findFlower(num+1);
		System.out.println("Number of flowers on the plant = "+ flower);
		}
		catch(Exception e) {
			System.out.println("Error : "+ e.getMessage());
		}
	}
	
	int findFlower(int n) {
		if(n == 0)
			return 1;
		else {
			return n * findFlower(n-1);
		}
	}
}
