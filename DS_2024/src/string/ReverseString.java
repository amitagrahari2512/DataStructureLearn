package string;

import java.util.Arrays;

/*
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 
 * 
 * 
 */
public class ReverseString {
	public static void main(String[] args) {
		char[] ch = {'H','a','n','n','a','h'};
		System.out.println("Char Array : "+ Arrays.toString(ch));
		System.out.println("Reverser Char Array : " + Arrays.toString(reverse(ch)));
	}
	
	public static char[] reverse(char[] ch) {
		for(int i = 0 ; i <= ch.length / 2; i++) {
			char temp = ch[i];
			ch[i] = ch[ch.length - 1 - i];
			ch[ch.length - 1 - i] = temp;
		}
		
		return ch;
	}
}
