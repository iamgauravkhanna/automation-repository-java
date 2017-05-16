package testngExamples.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	// Run before the first test method that belongs to the group is invoked.
	@BeforeGroups("shopping")
	public void beforeGroups() {
		System.out.println("@BeforeGroups");
	}

	// Run after the last test method that belongs to the groups is invoked.
	@AfterGroups("shopping")
	public void afterGroups() {
		System.out.println("@AfterGroups");
	}

	// Run before the first test method in the current class is invoked.
	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	// Run after all the test methods in the current class have been run.
	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	// Run before each test method.
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	// Run after each test method.
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@Test(groups = "shopping")
	public void runTest1() {
		System.out.println("@Test - runTest1 - shopping");
	}

	// Marks a class or a method as a part of the test.
	@Test
	public void runTest2() {
		System.out.println("@Test - runTest2");
	}

	// For suite test, run before any test method belonging to the classes
	// inside the <test> tag is run.
	@BeforeTest
	public void beforeTest() {

		System.out.println("@BeforeTest");

	}

	// For suite test, run after all the test methods belonging to the classes
	// inside the <test> tag have run.
	@AfterTest
	public void afterTest() {

		System.out.println("@AfterTest");

	}

	// For suite test, run before all tests in this suite have run.
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	// For suite test, run after all tests in this suite have run.
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}
}
