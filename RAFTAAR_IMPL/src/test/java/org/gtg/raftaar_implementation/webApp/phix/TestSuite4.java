package org.gtg.raftaar_implementation.webApp.phix;

import org.gtg.raftaar.utils.*;
import org.gtg.raftaar_implementation.pageObjects.webApp.automationPractice.Home;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 */
public class TestSuite4 extends BaseTest {

	// Calling Constructor
	TestSuite4() {

		super();
	}

	WebDriver webDriverObj;
	Home homePageObj;

	@BeforeMethod
	public void setUp() {

		LogUtils.info("Calling setUp() Method");
		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@AfterMethod
	public void tearDown() {

		LogUtils.info("Calling tearDown() Method");
		webDriverObj.close();

	}

	@Test
	public void TC001() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();

	}

}