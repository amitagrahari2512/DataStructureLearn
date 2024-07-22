package bp;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 You are given a notice board with length n.
You need to write 2 funtions.
1. add_notice(left, right): in this function, you need to add a notice to the notice board in the co-ordinates given as input.
                            New notice can partially or completely overlap previous notice on the board.
                            The user will call this method multiple times and add different notices on the board at various places.
2. get_visible_notices(): After all the notices are applied, using the above method, the user will call this method to get all the notices which will be visible at the end.
                          Here, you need to return fully exposed as well as partially exposed notices.

eg. if the user gives us notices like this: (5,15), (16, 18), (12, 20) -> then, the second notice(16,18) will be overlapped by the third notice (12,20) and thus, it will not be visible.
and first notice will be partially overlapped. Thus, we should return 2 as an answer

 */
public class NoticeBoard {
	
	List<int[]> notices;
	
	public NoticeBoard() {
		notices = new ArrayList<>();;
	}
	
	public static void main(String[] args) {
		NoticeBoard notice = new NoticeBoard();
		notice.add_notice(5, 15);
		notice.add_notice(16, 18);
		notice.add_notice(12,  20);
		System.out.println(notice.get_visible_notices());
	}
	
	public void add_notice(int left, int right) {
		notices.add(new int[] {left, right});
	}
	
	public int get_visible_notices() {
		
		if(notices.isEmpty()) {
			return 0;
		}
		
		notices.sort((a,b) -> a[1] - b[1]);
		
		int visibleNotice = 1;
		int rightBoundary = notices.get(0)[1];
		for(int i = 1 ;i < notices.size(); i++) {
			if(notices.get(i)[0] >= rightBoundary) {
				visibleNotice +=1;
				rightBoundary = notices.get(i)[1];
			}
		}
		return visibleNotice;
	}

}
