/*
 * 
 * Reference : http://seleniumeasy.com/testng-tutorials/logging-with-testng-using-listeners
 * 
 */

package testng.logging;

import org.testng.annotations.Test;

public class LoggingClass {

	@Test(priority = 0)
	public void methodAddingNumbers() {
		System.out.println("Helloo.. Im in method adding numbers");
	}

	@Test(priority = 1)
	public void dividedByZero() {
		System.out.println("Helloo.. Im in method divided by zero");
	}

	@Test(dependsOnMethods = { "dividedByZero" })
	public void methodSkip() {
		System.out.println("Helloo.. Im in method skip");
	}

}