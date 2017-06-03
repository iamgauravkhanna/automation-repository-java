package raftaar.testautomation.webTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import raftaar.testautomation.pageObjects.bookTheAutomatedTester.*;

public class ClassA {

	HomePage homePageObj;
	Chapter1Page chapterOneObj;

	@BeforeMethod
	public void setup() {

		// Create Home Page Object
		homePageObj = new HomePage();

		// Create Chapter One Page Object
		chapterOneObj = new Chapter1Page();

	}

	@Test
	public void FirstTestCase() {

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

}
