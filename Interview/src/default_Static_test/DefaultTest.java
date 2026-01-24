package default_Static_test;

public class DefaultTest implements I_Default {
	@Override
	public void display() {
		// TODO Auto-generated method stub
		I_Default.super.display();
		I_Default.staticMethod();
		System.out.println("DefaultTest display");
	}
	
	public static void main(String[] args) {
		I_Default d = new DefaultTest();
		d.display();
		
		I_Default.staticMethod();
		
		
	}
}
