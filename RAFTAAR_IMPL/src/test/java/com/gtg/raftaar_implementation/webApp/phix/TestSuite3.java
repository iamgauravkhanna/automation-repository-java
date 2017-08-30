package com.gtg.raftaar_implementation.webApp.phix;

import java.util.HashMap;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.DriverUtil;
import org.gtg.raftaar.utils.JavaUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite3 extends BasePage {

	DriverUtil driverUtilObj;

	@BeforeMethod
	public void setUp() {

		System.out.println("Calling setUp() ");

		driverUtilObj = new DriverUtil();
		
		webDriverObj = driverUtilObj.intializeDriver();
		
		testCaseMap = new HashMap<String, String>();
	}

	@Test
	public void TestCase1() {

		getPageUrl("http://book.theautomatedtester.co.uk");
		
		maximizeBrowser();
		
		System.out.println("Page Title : " + getPageTitle());
		
		click(By.linkText("Chapter1"));
		
		click(By.id("radiobutton"));
		
		selectByValue(By.id("selecttype"), "Selenium Core");
		
	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		webDriverObj.quit();
	}

}