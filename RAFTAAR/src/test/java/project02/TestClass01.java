package project02;

import java.util.HashMap;

import utils.BasePage;
import utils.DriverUtil;
import utils.JavaUtils;
import pageObject.project02.broker.Reusables;
import pageObject.project02.uiMap.Broker;
import pageObject.project02.uiMap.Employer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests
 */
public class TestClass01 extends BasePage {

	DriverUtil driverUtilObj;
	Reusables employerReusables;

	@BeforeMethod
	public void setUp() {

		driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();
		testCaseMap = new HashMap<String, String>();
		employerReusables = new Reusables(webDriverObj);
	}

	@Test(enabled = false)
	public void TestMethod001() {

		setVariable("Portal", Broker.HOME__BROKER_URL);

		openBrowser(Broker.HOME__BROKER_URL);

		// click(Broker.HOME__LOGIN_LINK);

		setText(Broker.LOGIN__USERNAME, "xxx");

		setText(Broker.LOGIN__PASSWORD, "yyy");

		click(Broker.LOGIN__LOG_IN);

		waitFor(Broker.TOP_LINKS__CLIENTS_TAB);

		clickUsingJavaScript(Broker.TOP_LINKS__CLIENTS_TAB);

		waitFor(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);

		click(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);

		waitFor(Broker.MANAGE_EMPLOYERS_ENTER_MANUALLY_BUTTON);

	}

	@Test(enabled = false)
	public void TestMethod002() {

		setVariable("EmployerPortal", Employer.HOME__EMPLOYER_URL);

		openBrowser(Employer.HOME__EMPLOYER_URL);

		maximizeBrowser();

		employerReusables.EmployerSignUp();

		employerReusables.EmployerLogIn();

	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		webDriverObj.quit();
	}
}
