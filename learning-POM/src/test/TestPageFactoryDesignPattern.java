package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactoryDesignPattern.*;

public class TestPageFactoryDesignPattern {

	WebDriver myDriver;

	HomePage objHomePage;

	Chapter1Page objChapter1Page;

	@BeforeMethod
	public void setup() {

		myDriver = new FirefoxDriver();

		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create Home Page Object
		objHomePage = new HomePage(myDriver);

		// Create Chapter 1 Page Object
		objChapter1Page = new Chapter1Page(myDriver);

		SessionId session = ((FirefoxDriver) myDriver).getSessionId();

		System.out.println("Session id: " + session.toString());

	}

	@Test
	public void FirstTestCase() {

		myDriver.get("http://book.theautomatedtester.co.uk/");

		// Verify Home Page Text
		objHomePage.verifyHomePageText();

		// Click on First Link
		objHomePage.clickOnLinkChapter1();

		// Click on Home Page Link
		objChapter1Page.clickHomePageLink();

	}

	@Test
	public void SecondTestCase() {

		myDriver.get("http://book.theautomatedtester.co.uk/");

		// Verify Home Page Text
		objHomePage.verifyHomePageText();

		// Click on First Link
		objHomePage.clickOnLinkChapter2();

	}

	@AfterMethod
	public void tearDown() {

		myDriver.quit();
	}
}
