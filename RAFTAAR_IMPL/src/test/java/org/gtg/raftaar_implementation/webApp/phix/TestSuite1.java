package com.gtg.raftaar_implementation.webApp.phix;

import java.util.HashMap;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.DriverUtil;
import org.gtg.raftaar.utils.JavaUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gtg.raftaar_implementation.pageObjects.webApp.phix.Broker;

/**
 * Test Suite containing Tests
 */
public class TestSuite1 extends BasePage {

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
		
		setVariable("Portal", "https://hc.phix-dev18.demo.hcinternal.net/broker/broker/homePage");
		
		//getUrl(testCaseMap.get("Portal"));
		
		openBrowser(Broker.HOME__BROKER_URL);
		
		click(Broker.HOME__LOGIN_LINK);
		
		setText(Broker.LOGIN__USERNAME, "phix.agencyadmin01@qa05.org");
		
		setText(Broker.LOGIN__PASSWORD, "Qwerty@12");
		
		click(Broker.LOGIN__LOG_IN);

		waitFor(Broker.TOP_LINKS__CLIENTS_TAB);
		
		clickUsingJavaScript(Broker.TOP_LINKS__CLIENTS_TAB);
		
		waitFor(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);
		
		click(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);
		
		waitFor(Broker.MANAGE_EMPLOYERS_ENTER_MANUALLY_BUTTON);
		
		
	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		webDriverObj.quit();
	}
}
