package leetcode;

import java.util.Arrays;

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int row = 3;
		System.out.println(convertZigZag(s, row));
		
	}

	private static String convertZigZag(String s, int numRows) {
		int row = 0;
		boolean down = true;
		char[] ch  = s.toCharArray();
		String[] arr = new String[numRows];
		Arrays.fill(arr, "");
		for(int i = 0 ; i < ch.length ; i++) {
			if(ch.length == 1)
				return new String(ch);
			
			arr[row] += ch[i];
			
			if(row == numRows - 1) {
				down = false;
			}
			else if(row == 0) {
				down = true;
			}
			
			if(down) {
				row++;
			}
			else {
				row--;
			}
			
			
		}
		return String.join("", arr);
	}	
}
