package thread_test;

class MyClass implements Runnable{
	public static void function() {
		int x = 0;
		int y = 0;
		x = 1;
		
		x = 2;
		y = 1;
		y = 2;
		System.out.println(Thread.currentThread().getName() + " x="+x);
		System.out.println(Thread.currentThread().getName() + " y="+y);
		
		System.out.println(x + y);
	}

	@Override
	public void run() {
		function();
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyClass c1 = new MyClass();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);
		
		t1.start();
		t2.start();
	}
}


