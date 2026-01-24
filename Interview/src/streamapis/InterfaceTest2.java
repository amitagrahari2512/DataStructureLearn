package streamapis;

@FunctionalInterface
interface func {
	void m1();
	
	//one method and Object class method we can use in functional interface
	boolean equals(Object obj);
	String toString();
	//void m2(); //Second method we can not use
}
public class InterfaceTest2 {

}
