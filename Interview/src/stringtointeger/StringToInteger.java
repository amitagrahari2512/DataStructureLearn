package stringtointeger;

public class StringToInteger {
	public static void main(String[] args) {
		String inputString = "account101";
		String digitsOnly = inputString.replaceAll("\\D", ""); 
		System.out.println(digitsOnly); 
	}
}
