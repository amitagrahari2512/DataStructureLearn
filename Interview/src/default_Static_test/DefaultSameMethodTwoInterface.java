package default_Static_test;

public class DefaultSameMethodTwoInterface implements I_Default,I_Default1{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		I_Default.super.display();
		I_Default1.super.display();
		System.out.println("Override default");
	}
	
	public static void main(String[] args) {
		DefaultSameMethodTwoInterface d= new DefaultSameMethodTwoInterface();
		d.display();
		
	}

}
