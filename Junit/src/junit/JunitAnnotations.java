package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitAnnotations {

	public static boolean dbconnection() {

		return false;
	}

	@BeforeClass
	public static void Seleniumsetup() {

		System.out.println("Initilizing the Selenium Server");
		Assume.assumeTrue(dbconnection());

	}

	@Before
	public void testOpenbrowser() {

		System.out.println("Opening firefox browser");

	}

	@Test
	public void testNavigation() {

		System.out.println("Opening the website");

	}

	/*
	 * 
	 * @Test
	 * 
	 * @after
	 * 
	 * @before
	 * 
	 * @beforeClass
	 * 
	 * @AfterClass
	 * 
	 * @ignore
	 */

	// @Ignore
	@Test
	public void testlogindetails() {

		System.out.println("Enter login details");

	}

	@After
	public void testClosebrowser() {

		System.out.println("Closing the firefox browser");

	}

	@AfterClass
	public static void Seleniumshutdown() {

	System.out.println("Shutting down Selenium server");
	}

}
