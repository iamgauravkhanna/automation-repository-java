package raftaar.testautomation.webTests.makeMyTrip;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import raftaar.testautomation.pageObjects.makeMyTrip.HomePage;
import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.LogManager;
import raftaar.testautomation.utils.WebPage;

public class ClassB extends BaseTest {

	HomePage homePageObj;
	WebPage webPageObj;
	WebDriver webDriverObj;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		webPageObj = new WebPage();
		webDriverObj = webPageObj.initializeDriverObj();
		homePageObj = new HomePage(webDriverObj);

	}

	@Test
	public void TestCase1() {
		
		LogManager.startTestCase(this.getClass().getName());

		homePageObj.openHomePage();
		
		homePageObj.clickFromField();

	}
}
