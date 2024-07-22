package array;

public class MinMaxInArray {
	
	static class Pair {
		int min;
		int max;
	}
	public static void main(String[] args) {
		int arr[] = {2,3,1,5,6,2};
		
		Pair pair = findMinMax(arr);
		System.out.println("Min : " + pair.min + " :: Max : " + pair.max);
	}

	private static Pair findMinMax(int[] arr) {
		Pair pair = new Pair();
		// TODO Auto-generated method stub
		if(arr[0] > arr[1])
		{
			pair.min = arr[1];
			pair.max = arr[0];
		}
		else {
			pair.min = arr[0];
			pair.max = arr[1];
		}
		
		for(int i = 2 ; i < arr.length ;i++)
		{
			if(arr[i] > pair.max)
				pair.max = arr[i];
			else if (arr[i] < pair.min)
				pair.min = arr[i];
		}
		
		return pair;
	}
}
