package string;

public class PalindromString {

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(s + " is : " + (isPalindrome(s) == 1 ? "Palindrome" : "No Palindrome"));
		s = "abab";
		System.out.println(s + " is : " + (isPalindrome(s) == 1 ? "Palindrome" : "No Palindrome"));
		s = "abcba";
		System.out.println(s + " is : " + (isPalindrome(s) == 1 ? "Palindrome" : "No Palindrome"));
		s = "abcab";
		System.out.println(s + " is : " + (isPalindrome(s) == 1 ? "Palindrome" : "No Palindrome"));
	}

	
	public static int isPalindrome(String S) {
		char[] chArr = S.toCharArray();
		for(int i = 0 ;i < chArr .length / 2 ; i++) {
			if(chArr[i] != chArr[chArr.length -1 - i]) {
				return 0;
			}
		}
		return 1;
    }
}
