package array_rotation;

public class GCD {
	
	public static void main(String[] args) {
		System.out.println(gcd(12,3));
	}
	
	/*Fuction to get gcd of a and b*/
    static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 

}
