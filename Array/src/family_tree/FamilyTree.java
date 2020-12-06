package family_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String n = reader.readLine();
			int num = Integer.parseInt(n);
			Family f = null;
			int i = 0;
			while (i < num) {
				i++;
				String[] str = reader.readLine().split(" ");
				if (str.length == 3) {
					Family fam = new Family();
					fam.name = str[0];
					fam.age = Integer.parseInt(str[1]);
					String ancestor = str[2];
					Family ans = f.findAncestor(f, ancestor);
					ans.next.add(fam);
				} else {
					f = new Family();
					f.name = str[0];
					f.age = Integer.parseInt(str[1]);
				}
			}
			//System.out.println(f);
			System.out.println("{next=" +f.next + ", name=" + f.name + ", age="+ f.age + "}");
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}

class Family {
	int age;
	String name;
	List<Family> next = new ArrayList<>();

	public Family findAncestor(Family f, String name) {
		if (name.equals(f.name)) {
			return f;
		} else {
			List<Family> list = f.next;
			for (int i = 0; i < list.size(); i++) {
				Family inner = list.get(i);
				if (name.equals(inner.name)) {
					return inner;
				} else {
					findAncestor(inner, name);
				}
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "{name=" + this.name + ", age="+ this.age + ", next=" +this.next + "}";
	}

}
