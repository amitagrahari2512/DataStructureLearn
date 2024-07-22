package overload_test;

public class StaticOverrideTest {
	
	public void method() {
		System.out.println("method");
	}

}


class Value extends StaticOverrideTest {
	
	//This use this give error, As static same name method can not hide
	/*
	static void method() {
		System.out.println("method");
	}
	*/
}



