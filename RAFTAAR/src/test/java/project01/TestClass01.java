package project01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.project01.Home;
import utils.BaseTest;
import utils.DataDictionary;
import utils.DriverUtil;
import utils.JavaUtil;

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
	public void doBefore() {

		driverUtilObj = new DriverUtil(baseTestHashMapObj);
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@Test
	public void TC001() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();

		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "001");

	}

	@Test
	public void TC002() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();
		DataDictionary.getInstance().putKey("TC_ID", "002");

	}

	@Test
	public void TC003() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();
		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "003");

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.quit();

		JavaUtil.printHashMapValues(DataDictionary.getInstance().getDataDictionary());

	}

}