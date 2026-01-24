package custom_executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomExecutorTest {
	
	public static void main(String[] args) throws InterruptedException {
		CustomExecutorService cus = new CustomExecutorService(5);
		
		
		for(int i = 1 ;i < 1000 ; i++) {
			cus.submit(() -> System.out.println(" Loop : "));
		}
		
		
		/*
		cus.submit(() -> System.out.println(" First"));
		cus.submit(() -> System.out.println(" Second"));
		cus.submit(() -> System.out.println(" Third"));
		cus.submit(() -> System.out.println(" Fourth"));
		cus.submit(() -> System.out.println(" Fifth"));
		cus.submit(() -> System.out.println(" Six"));
		cus.submit(() -> System.out.println(" Seven"));
		cus.submit(() -> System.out.println(" Eight"));
		cus.submit(() -> System.out.println(" Nine"));
		cus.submit(() -> System.out.println(" Ten"));
		cus.submit(() -> System.out.println(" Eleven"));
	   */	
		
		cus.shutdown();
		
		
	}

}
