package ora;

public class SumOfSubstring {
    public static void main(String[] args) {
        System.out.println(substrings("16"));  // Output: 23
        System.out.println(substrings("123")); // Output: 164
    }

    public static int substrings(String n) {
        int MOD = (int) (Math.pow(10, 9) + 7);
        System.out.println(MOD);
        int len = n.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int curr = 0;
            for (int j = i; j < len; j++) {
            	System.out.println("n.charAt(j) - '0' :: " + (n.charAt(j) - '0'));
                curr = curr * 10 + (n.charAt(j) - '0');
                System.out.println("Curr : " + curr);
                //res = res + curr;
                res = (res + curr) % MOD;
                System.out.println("res : " + res);
            }
        }
        return res;
    }
}