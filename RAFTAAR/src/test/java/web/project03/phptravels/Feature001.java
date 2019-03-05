package web.project03.phptravels;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.BaseTest;
import web.project03.pageObject.AdminPage;
import web.project03.pageObject.DashBoardPage;
import web.project03.pageObject.HomePage;

public class Feature001 extends BaseTest {

	WebDriver webDriverObj;
	HomePage homePageObj;
	AdminPage adminPageObj;
	DashBoardPage dashBoardObj;

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
}