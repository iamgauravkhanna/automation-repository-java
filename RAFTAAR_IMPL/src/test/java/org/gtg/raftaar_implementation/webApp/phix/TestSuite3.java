package org.gtg.raftaar_implementation.webApp.phix;

import org.gtg.raftaar.utils.*;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.broker.BrokerHome;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.employer.Auth0LogIn;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.employer.Home;
import org.gtg.raftaar_implementation.pageObjects.webApp.phix.employer.SignUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void setUp1() {

	}

	@BeforeMethod
	public void setUp() {

		LogUtils.info("Calling setUp() Method");
		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();

	}

	@AfterMethod
	public void tearDown() {

		webDriverObj.close();

	}

	@Test
	public void TC001() {

		employerHomeObj = new Home(webDriverObj);
		employerHomeObj.openHomePage();
		employerHomeObj.maximizeBrowser();
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		auth0LogInObj.clickSignUp();
		signUpObj = new SignUp(webDriverObj);
		signUpObj.startSignUp();
		auth0LogInObj.login();
	}

}