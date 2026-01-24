package streamapis;

interface i1 {
	public default void display() {
		System.out.println("i1 display");
	}
}

interface i2 {
	public default void display() {
		System.out.println("i2 display");
	}
}


public class InterfaceTest implements i1, i2 {
	
	public static void main(String[] args) {
		i1 i = new InterfaceTest();
		i.display();
	}

	
	//default method should be override
	@Override
	public void display() {
		System.out.println("InterfaceTest");
	}
}
