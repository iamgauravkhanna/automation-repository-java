package project03;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DriverUtil;
import pageObject.project03.AdminPage;
import pageObject.project03.DashBoardPage;
import pageObject.project03.HomePage;

public class TestClass01 extends BaseTest{

	WebDriver webDriverObj;
	HomePage homePageObj;
	AdminPage adminPageObj;
	DashBoardPage dashBoardObj;

	@BeforeMethod
	public void setUp() {

		DriverUtil driverUtilObj = new DriverUtil(baseTestHashMapObj);
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@Test
	public void TestMethod001() {

		homePageObj = new HomePage(webDriverObj);

		adminPageObj = new AdminPage(webDriverObj);

		dashBoardObj = new DashBoardPage(webDriverObj);

		homePageObj.openBrowser();

		homePageObj.verifyHomeFrontEndPresent();

		homePageObj.clickAdminLink();

		homePageObj.switchToAdminPage();

		adminPageObj.login();

		dashBoardObj.validateHomeTiles();

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.quit();

	}
}
