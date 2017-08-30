package com.gtg.raftaar_implementation.webApp.phix;

import java.util.HashMap;

import org.gtg.raftaar.utils.BasePage;
import org.gtg.raftaar.utils.DriverUtil;
import org.gtg.raftaar.utils.JavaUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gtg.raftaar_implementation.pageObjects.webApp.phix.Employer;

/**
 * Test Suite containing Tests
 */
public class TestSuite2 extends BasePage {

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

		setVariable("EmployerPortal", "https://newauth.phix-qa07.demo.hcinternal.net/employer");

		openBrowser(Employer.HOME__EMPLOYER_URL);

		maximizeBrowser() ;

		EmployerSignUp();
		
		EmployerLogIn();

	}

	@AfterMethod
	public void tearDown() {

		JavaUtils.printHashMapValues(testCaseMap);

		// This will close the browser
		// webDriverObj.quit();
	}

	public void EmployerSignUp() {

		waitFor(By.xpath(
				"//*[text()='Enter the email address you use as your username, your password, and click Log In.']"));

		click(Employer.LOGIN__SIGNUP_LINK);

	/*	waitFor(By
				.xpath("//*[text()='Great! You have chosen hCentive Employee Benefits. To find plans and review proposals, enter the requested information below to complete your registration.']"),
				60);*/

		String Email = JavaUtils.generateEmail();

		setVariable("EmployerEmail", Email);

		/*String a = BasePage.propertiesMap.get("EmployerEmail");
		
		System.out.println(BasePage.propertiesMap.get("EmployerEmail"));
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
	
	public void EmployerLogIn(){
		
		setText(By.name("emailId"), JavaUtils.replaceVariable("${EmployerEmail}"));
		
	}
}
