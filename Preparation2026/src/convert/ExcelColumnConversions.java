package convert;


//1 - Convert Excel column to No
//2 - Convert No to column
public class ExcelColumnConversions {
	
	public static void main(String[] args) {
		System.out.println("CAB" + " : titleToNo : " + titleToNo("CAB"));
		System.out.println("A" + " : titleToNo : " + titleToNo("A"));
		System.out.println("Z" + " : titleToNo : " + titleToNo("Z"));
		System.out.println("AA" + " : titleToNo : " + titleToNo("AA"));
		System.out.println("AB" + " : titleToNo : " + titleToNo("AB"));
		System.out.println("ZZZ" + " : titleToNo : " + titleToNo("ZZZ"));
		
		System.out.println();
		
		System.out.println(2056 +" : numberToTitle : " + numberToTitle(2056));//CAB
		System.out.println(1 +" : numberToTitle : " + numberToTitle(1));     // A
        System.out.println(26 +" : numberToTitle : " + numberToTitle(26));    // Z
        System.out.println(27 +" : numberToTitle : " + numberToTitle(27));    // AA
        System.out.println(28 +" : numberToTitle : " + numberToTitle(28));    // AB
		
	}
	
	
	//We multiply by 26 ,Because alphabet is A-Z and total is 26
	public static int titleToNo(String column) {
		char[] chArr = column.toCharArray();
		int result = 0;
		for(char ch : chArr) {
			int value = ch - 'A' + 1;
			result = 26 * result + value;
		}
		
		return result;
	}
	
	public static String numberToTitle(int columnNo) {
		StringBuilder result = new StringBuilder();
		while(columnNo > 0) {
			columnNo--; //As Excel not start from Zero.
			
			int rem = columnNo % 26;
			char c = (char) (rem + 'A');
			result.append(c);
			
			columnNo = columnNo/26;
		}
		
		return result.reverse().toString();
		
	}
}
