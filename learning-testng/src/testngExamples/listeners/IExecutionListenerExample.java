package testngExamples.listeners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IExecutionListenerExample {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am in Before Suite Method");
	}

	@Test
	public void t() {
		System.out.println("I am in Test Method");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am in After Suite Method");
	}
}