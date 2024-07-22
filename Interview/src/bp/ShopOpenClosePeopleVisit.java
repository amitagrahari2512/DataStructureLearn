package bp;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 
 * Given number of shops with open and close time -
[[2,5],[1,8], [5,8], [9,13]]

given person time when they visit the shop - [1,3,6,12]

find the number of open shops fir every time person visit the shop - 
output - [1, 2, 2, 1]

Explanation - 
when person visit shop at time 1 then shop [1,8] is open so answer is 1
when person visit shop at time 3 then shop [1,8] [2,5] is open so answer is 2
when person visit shop at time 6 then shop [1,8] [5,8] is open so answer is 2
when person visit shop at time 12 then shop [9,13] is open so answer is 1

 *
 */
public class ShopOpenClosePeopleVisit {
	
	List<int[]> shopsTimes;
	
	public ShopOpenClosePeopleVisit() {
		shopsTimes = new ArrayList<>();
	}
	
	public void addShop(int left, int right) {
		shopsTimes.add(new int[] {left, right});
	}
	
	public static void main(String[] args) {
		ShopOpenClosePeopleVisit visit = new ShopOpenClosePeopleVisit();
		visit.addShop(2, 5);
		visit.addShop(1, 8);
		visit.addShop(5, 8);
		visit.addShop(9, 13);
		
		int[] person = {1,3, 6, 12};
		System.out.println(visit.visitShop(person));
	}
	
	public List<Integer> visitShop(int[] person) {
		List<Integer> list = new ArrayList<>();
		this.shopsTimes.sort((a,b) -> a[0] - b[0]);
		
		//System.out.println(shopsTimes);
		
		for(int p : person) {
			int countPersonVisit = 0;
			for(int i = 0 ;i < this.shopsTimes.size() ; i++) {
				if(this.shopsTimes.get(i)[0] <= p && this.shopsTimes.get(i)[1] >= p) {
					countPersonVisit++;
				}
			}
			list.add(countPersonVisit);
		}
		return list;
	}
}
