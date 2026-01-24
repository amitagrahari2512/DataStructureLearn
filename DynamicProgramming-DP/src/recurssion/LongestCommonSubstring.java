package recurssion;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s= "horse";
		String t ="ros";
		int m = s.length();
		int n = t.length();
		int lcs = lcs(s,t,m-1,n-1);
		System.out.println("LongestCommonSubstring : " +lcs);
		
	}
	
	
	public static int lcs(String s, String t, int i, int j) {
		if( i < 0 || j < 0) return 0;
		if(s.charAt(i) == t.charAt(j)) return 1 + lcs(s,t, i-1 , j-1);

		return 0 + Math.max(lcs(s, t, i-1 , j) , lcs(s, t, i , j-1));
	 }
	
	

}
