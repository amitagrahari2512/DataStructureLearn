package bitco;

public class GasStation {

	public static void main(String[] args) {
		String[] strArr = {"2:2" , "1:2", "0:1", "3:1"};
		System.out.println(possibleToReach(strArr));
		
		String[] strArr1 = {"0:1" , "1:2", "0:1", "3:1"};
		System.out.println(possibleToReach(strArr1));
	}

	private static String possibleToReach(String[] strArr) {
		for(int i = 0 ; i < strArr.length ; i++) {
			int start = i;
			int initial = 0;
			int count = 0;
			
			while(count < strArr.length) {
				String[] arr = strArr[start].split(":");
				initial += Integer.parseInt(arr[0]);
				int gasReq = Integer.parseInt(arr[1]);
				if(initial >=  gasReq) {
					initial -= gasReq;
					start = (start == strArr.length - 1 ? 0 : start + 1);
					count++;
				}
				else {
					break;
				}
			}
			
			if(count == strArr.length)
				return Integer.toString(i + 1);
			
		}
		return "impossible";
	}

}
