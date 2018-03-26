package project1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.project1.Home;
import utils.BaseTest;
import utils.DriverUtil;

/**
 * Test Suite containing Tests using POM Model
 */
public class TestSuite1 extends BaseTest {

	WebDriver webDriverObj;
	Home homePageObj;

	@BeforeMethod
	public void setUp() {

		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.close();

	}

	@Test
	public void TC001() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();

	}

}