package raftaar.testautomation.webTests.bookTheAutomatedTester;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import raftaar.testautomation.pageObjects.bookTheAutomatedTester.Chapter1Page;
import raftaar.testautomation.pageObjects.bookTheAutomatedTester.HomePage;
import raftaar.testautomation.utils.BaseTest;
import raftaar.testautomation.utils.LogManager;
import raftaar.testautomation.utils.WebPage;

public class ClassA extends BaseTest{

	HomePage homePageObj;
	Chapter1Page chapterOneObj;
	WebDriver webDriverObj;
	WebPage webPageObj;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		// Create Web Page Object
		webPageObj = new WebPage();

		// Passing WebDriver Object
		webDriverObj = webPageObj.initializeDriverObj();

		// Create Home Page Object
		homePageObj = new HomePage(webDriverObj);

		// Create Chapter One Page Object
		chapterOneObj = new Chapter1Page(webDriverObj);
		
		//PropertyConfigurator.configure("log4j.properties");

	}

	@Test
	public void FirstTestCase() {
		
		LogManager.startTestCase(this.getClass().getName());

		// Open Home Page
		homePageObj.openHomePage();

		// Verify Home Page Text
		homePageObj.verifyHomePageText();

		// Click on First Link
		homePageObj.clickOnLinkChapter1();

		// Click on Home Page Link
		chapterOneObj.clickHomePageLink();

	}

	@Test
	public void SecondTestCase() {

		// Open Home Page
		homePageObj.openHomePage();

		// Verify Home Page Text
		homePageObj.verifyHomePageText();

		// Click on First Link
		homePageObj.clickOnLinkChapter2();
	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.quit();

	}
}
