package kmp_algo;

import java.util.Arrays;

/**
 * Knuth Morris Pratt Algo
 * 
 * @author amitagrahari
 *
 */
public class KmpStringMatchingAlgo {
	public static void main(String[] args) {
		String str = "aabcaabcaabcd";
		String pattern = "aabca";
		kmpAlgo(str, pattern);
	}
	
	private static void kmpAlgo(String str, String pattern) {
		int strLength = str.length();
		int patLength = pattern.length();
		int[] lps = new int[patLength];
		fillLps(pattern, lps);
		System.out.println(Arrays.toString(lps));
		int i = 0;
		int j = 0;
		
		while (i < strLength) {
			if(pattern.charAt(j) == str.charAt(i)) {
				i++;
				j++;
				if(j == patLength) {
					System.out.println("Pattern found at length : " + (i-j) + " to " + (i-1));
					j = lps[j - 1];
				}
			}
			else {
				if(j == 0) {
					i++;
				}
				else {
					j = lps[j - 1];
				}
			}
		}
	}
	
	private static void fillLps(String pattern , int[] lps) {
		int lPatteen = pattern.length();
		int i = 1;
		int len = 0;
		lps[0] = 0;
		while(i < lPatteen) {
			if(pattern.charAt(len) == pattern.charAt(i)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len == 0) {
					lps[i] = len;
					i++;
				}
				else {
					len--;
				}
			}
		}
	}
}
