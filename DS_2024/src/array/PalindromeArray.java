package array;

public class PalindromeArray {

	public static void main(String[] args) {
		int[] arr = {111, 222, 333, 444, 555};
		System.out.println(palinArray(arr));
		
		int[] arr1 = {111, 222, 333, 444, 20};
		System.out.println(palinArray(arr1));
	}
	
	public static boolean palinArray(int[] arr) {
        for(int a : arr) {
            int sum = 0;
            int initial = a;
            while(a > 0) {
                int r = a % 10;
                sum = (sum * 10) + r;
                a = a / 10;
            }
            if(initial != sum) {
                    return false;
            }
        }
        return true;
    }

}
