package project02;

import utils.*;
import pageObject.project01.Home;
import pageObject.project02.broker.*;
import pageObject.project02.employer.*;
import pageObject.project02.uiMap.Auth0LogIn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 */
public class TestClass03 extends BaseTest {

	WebDriver webDriverObj;
	Home employerHomeObj;
	Auth0LogIn auth0LogInObj;
	SignUp signUpObj;
	BrokerHome brokerHomePageObj;
	TopLinks topLinksObj;
	ManageEmployer manageEmployerPageObj;
	AddEmployer addEmployerPageObj;
	Reusables employerReusableObj;

	@BeforeMethod
	public void setUp() {

		LogUtils.info("Calling setUp() Method");
		DriverUtil driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();
		employerHomeObj = new Home(webDriverObj);
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		signUpObj = new SignUp(webDriverObj);
		topLinksObj = new TopLinks(webDriverObj);
		manageEmployerPageObj = new ManageEmployer(webDriverObj);
		addEmployerPageObj = new AddEmployer(webDriverObj);
		brokerHomePageObj = new BrokerHome(webDriverObj);
		employerReusableObj = new Reusables(webDriverObj);
	}

	@Test(description = "Workflow #1")
	public void TC001() {

		brokerHomePageObj.openHomePage();		
		auth0LogInObj.brokerLogin();
		topLinksObj.clickClientsTab();
		manageEmployerPageObj.clickAddEmployer();
		manageEmployerPageObj.clickEnterManually();
		employerReusableObj.fillEmployerDetails();

	}

	@AfterMethod
	public void tearDown() {

		LogUtils.info("Calling tearDown() Method");
		webDriverObj.close();

	}

}