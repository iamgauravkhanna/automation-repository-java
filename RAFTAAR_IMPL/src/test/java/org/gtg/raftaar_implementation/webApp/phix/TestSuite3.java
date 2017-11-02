package org.gtg.raftaar_implementation.webApp.phix;

import org.gtg.raftaar.utils.*;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker.*;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.common.Auth0LogIn;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.employer.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 */
public class TestSuite3 extends BaseTest {

	TestSuite3() {

		super();
	}

	WebDriver webDriverObj;
	Home employerHomeObj;
	Auth0LogIn auth0LogInObj;
	SignUp signUpObj;
	BrokerHome brokerHomePageObj;
	TopLinks topLinksObj;
	ManageEmployer manageEmployerPageObj;
	AddEmployer addEmployerPageObj;

	@BeforeMethod
	public void setUp() {

		LogUtils.info("Calling setUp() Method");
		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@AfterMethod
	public void tearDown() {

		LogUtils.info("Calling tearDown() Method");
		//webDriverObj.close();

	}

	@Test(enabled = false)
	public void TC001() {

		employerHomeObj = new Home(webDriverObj);
		employerHomeObj.openHomePage();
		employerHomeObj.maximizeBrowser();
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		auth0LogInObj.clickSignUp();
		signUpObj = new SignUp(webDriverObj);
		signUpObj.startSignUp();
		auth0LogInObj.employerLogin();
	}

	@Test
	public void TC002() {

		brokerHomePageObj = new BrokerHome(webDriverObj);
		brokerHomePageObj.openHomePage();
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		auth0LogInObj.brokerLogin();
		topLinksObj = new TopLinks(webDriverObj);
		topLinksObj.clickClientsTab();
		manageEmployerPageObj = new ManageEmployer(webDriverObj);
		manageEmployerPageObj.clickAddEmployer();
		manageEmployerPageObj.clickEnterManually();
		addEmployerPageObj = new AddEmployer(webDriverObj);
		addEmployerPageObj.fillEmployerDetails();

	}

}