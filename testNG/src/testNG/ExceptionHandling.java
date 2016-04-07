package testNG;

import org.testng.annotations.Test;

public class ExceptionHandling {

	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException1() {
		int i = 6 / 0;
		System.out.println(i);
		System.out.println("First Test");
	}

	@Test
	public void divisionWithException2() {
		int j = 6 / 0;
		System.out.println(j);
		System.out.println("Second Test");
	}

}
