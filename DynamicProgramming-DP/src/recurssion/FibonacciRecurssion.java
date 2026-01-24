package recurssion;

public class FibonacciRecurssion {

	public static void main(String[] args) {
		int n = 7;
		FibonacciRecurssion f = new FibonacciRecurssion();
		System.out.println("fibonacci series for : " + n + " is : " + f.fibonacci(n));
	}
	
	public int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		
		return fibonacci(n -1) + fibonacci(n - 2);
	}
 
}
