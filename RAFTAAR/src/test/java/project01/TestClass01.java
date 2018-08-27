package project01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.project01.Home;
import utils.BaseTest;
import utils.DriverUtil;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class TestClass01 extends BaseTest {

	WebDriver webDriverObj;
	Home homePageObj;
	DriverUtil driverUtilObj;

	@BeforeMethod
	public void setUp() {

		driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@Test
	public void TC001() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.close();

	}

}