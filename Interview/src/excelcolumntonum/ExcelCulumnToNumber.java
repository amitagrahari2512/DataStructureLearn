package excelcolumntonum;

public class ExcelCulumnToNumber {
	public static void main(String[] args) {
		int columnInt = excelColumnToNumber("CDA");
		System.out.println(columnInt);
		String columnStr = numberToExcelColumn(columnInt);
		System.out.println(columnStr);
	}
	
	public static int excelColumnToNumber(String column) {
	    int result = 0;
	    for (int i = 0; i < column.length(); i++) {
	        char c = column.charAt(i);
	        //System.out.print("column :" + c);
	        result = result * 26 + (c - 'A' + 1);
	        //System.out.println(" result : " + result);
	    }
	    return result;
	}
	
	public static String numberToExcelColumn(int number) {
	    StringBuilder sb = new StringBuilder();
	    while (number > 0) {
	        number--; // Adjust for 1-based indexing
	        char ch = (char) ('A' + (number % 26));
	        sb.insert(0, ch); // Prepend to result
	        number /= 26;
	    }
	    return sb.toString();
	}
}
