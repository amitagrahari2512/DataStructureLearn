package default_Static_test;

public class DefaultTestWithoutOverride implements I_Default{
	
	public void myMethod() {
		I_Default.super.display();
		I_Default.staticMethod();
	}
	
	public static void main(String[] args) {
		DefaultTestWithoutOverride d = new DefaultTestWithoutOverride();
		d.myMethod();
		I_Default.staticMethod();
	}

}
