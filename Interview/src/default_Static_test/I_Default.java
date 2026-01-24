package default_Static_test;

public interface I_Default {
	public default void display() {
		System.out.println("I_Default display");
	}
	
	public static void staticMethod() {
		System.out.println("I_Default staticMethod");
	}
}
