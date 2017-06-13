package raftaar.testautomation.webTests.phpTravels;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import raftaar.testautomation.pageObjects.phpTravels.AdminPage;
import raftaar.testautomation.pageObjects.phpTravels.DashBoardPage;
import raftaar.testautomation.pageObjects.phpTravels.HomePage;
import raftaar.testautomation.utils.DriverUtil;
import raftaar.testautomation.utils.LogManager;

public class FrontEndTests {

	DriverUtil iWebDriver;
	WebDriver webDriverObj;
	HomePage homePageObj;
	AdminPage adminPageObj;
	DashBoardPage dashBoardObj;

	@BeforeMethod
	void setup() {

		iWebDriver = new DriverUtil();

		webDriverObj = iWebDriver.initializeDriverObj();

		homePageObj = new HomePage(webDriverObj);

		adminPageObj = new AdminPage(webDriverObj);

		dashBoardObj = new DashBoardPage(webDriverObj);

	}

	@Test
	public void firstTest() {

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
