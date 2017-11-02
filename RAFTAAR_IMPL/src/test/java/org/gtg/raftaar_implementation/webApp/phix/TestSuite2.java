package org.gtg.raftaar_implementation.webApp.phix;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.DriverUtil;
import org.gtg.raftaar.utils.JavaUtils;
import org.gtg.raftaar.utils.LogUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests related to Keywords
 */
public class TestSuite2 extends BasePage {

	DriverUtil driverUtilObj;

	@BeforeMethod
	public void setUp() {

		driverUtilObj = new DriverUtil();

		webDriverObj = driverUtilObj.intializeDriver();

		testCaseMap = new HashMap<String, String>();
	}

	@Test
	public void TestCase1() {

		getPageUrl("http://book.theautomatedtester.co.uk");

		maximizeBrowser();

		LogUtils.info("Page Title : " + getPageTitle());

		click(By.linkText("Chapter1"));

		click(By.id("radiobutton"));

		selectByValue(By.id("selecttype"), "Selenium Core");

		assertEquals("Assert that this text is on the page", findElement(By.id("divontheleft")).getText());

		assertEquals("Verify this button he here", findElement(By.id("verifybutton")).getAttribute("value"));

	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		webDriverObj.quit();
	}
}
