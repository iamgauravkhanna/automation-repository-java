package org.gtg.raftaar_implementation.webApp.phix;

import java.util.HashMap;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.DriverUtil;
import org.gtg.raftaar.utils.JavaUtils;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker.Broker;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker.Employer;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.gtg.raftaar.utils.*;

/**
 * Test Suite containing Tests
 */
public class TestSuite1 extends BasePage {

	DriverUtil driverUtilObj;

	@BeforeMethod
	public void setUp() {		

		driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();
		testCaseMap = new HashMap<String, String>();
	}

	@Test
	public void TestCase1() {

		setVariable("Portal", "https://hc.phix-dev18.demo.hcinternal.net/broker/broker/homePage");

		// getUrl(testCaseMap.get("Portal"));

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

	@Test
	public void TestCase2() {

		setVariable("EmployerPortal", "https://newauth.phix-qa07.demo.hcinternal.net/employer");

		openBrowser(Employer.HOME__EMPLOYER_URL);

		maximizeBrowser();

		EmployerSignUp();

		EmployerLogIn();

	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		webDriverObj.quit();
	}

	public void EmployerSignUp() {

		waitFor(By.xpath(
				"//*[text()='Enter the email address you use as your username, your password, and click Log In.']"));

		click(Employer.LOGIN__SIGNUP_LINK);

		/*
		 * waitFor(By
		 * .xpath("//*[text()='Great! You have chosen hCentive Employee Benefits. To find plans and review proposals, enter the requested information below to complete your registration.']"
		 * ), 60);
		 */

		String Email = JavaUtils.generateEmail();

		setVariable("EmployerEmail", Email);

		/*
		 * String a = BasePage.propertiesMap.get("EmployerEmail");
		 * 
		 * System.out.println(BasePage.propertiesMap.get("EmployerEmail"));
		 */
		setText(Employer.SIGN_UP__EMAIL_ID, BasePage.testCaseMap.get("EmployerEmail"));

		setText(Employer.SIGN_UP__PASSWORD, "Qwerty@12");

		setText(Employer.SIGN_UP__CONFIRM_PASSWORD, "Qwerty@12");

		click(Employer.SIGN_UP__SECURITY_QUESTION_1_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion0-menu']/li"),
				"What is the make and model of your first car?");

		setText(Employer.SIGN_UP__SECURITY_QUESTION_1_ANSWER, "Black");

		click(Employer.SIGN_UP__SECURITY_QUESTION_2_DROPDOWN);

		clickLiElement(By.xpath("//ul[@id='securityQuestion1-menu']/li"), "Where were you born");

		setText(Employer.SIGN_UP__SECURITY_QUESTION_2_ANSWER, "Green");

		click(Employer.SIGN_UP__ATTESTATION_CHECKBOX);

		click(Employer.SIGN_UP__REGISTER_BUTTON);

	}

	public void EmployerLogIn() {

		setText(By.name("emailId"), JavaUtils.replaceVariable("${EmployerEmail}"));

	}
}
