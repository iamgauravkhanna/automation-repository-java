package raftaar.testautomation.webTests.miscellaneous;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import raftaar.testautomation.utils.DriverUtil;
import raftaar.testautomation.web.miscellaneous.Miscellaneous;
import raftaar.testautomation.web.pageObjects.phpTravels.AdminPage;
import raftaar.testautomation.web.pageObjects.phpTravels.DashBoardPage;
import raftaar.testautomation.web.pageObjects.phpTravels.HomePage;

public class TestScripts {

	DriverUtil iWebDriver;
	WebDriver webDriverObj;
	Miscellaneous miscellenousObj;

	@BeforeMethod
	void setup() throws Exception {

		iWebDriver = new DriverUtil();

		webDriverObj = iWebDriver.initializeDriverObj();

		miscellenousObj = new Miscellaneous(webDriverObj);

	}

	@Test
	public void Script1() {

		miscellenousObj.openBrowser();
		miscellenousObj.click();

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.quit();

	}
}
