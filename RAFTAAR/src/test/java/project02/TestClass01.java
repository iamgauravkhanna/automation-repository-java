package project02;

import utils.*;
import pageObject.project01.Home;
import pageObject.project02.broker.*;
import pageObject.project02.employer.*;
import pageObject.project02.uiMap.Auth0LogIn;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 */
public class TestClass01 extends BaseTest {

	DriverUtil driverUtilObj;
	Home employerHomeObj;
	Auth0LogIn auth0LogInObj;
	SignUp signUpObj;
	BrokerHome brokerHomePageObj;
	TopLinks topLinksObj;
	ManageEmployer manageEmployerPageObj;
	AddEmployer addEmployerPageObj;
	Reusables employerReusableObj;

	@BeforeTest
	public void setUp() {

		driverUtilObj = new DriverUtil();
		webDriverObj = driverUtilObj.intializeDriver();
		employerHomeObj = new Home(webDriverObj);
		auth0LogInObj = new Auth0LogIn(webDriverObj);
		signUpObj = new SignUp(webDriverObj);
		topLinksObj = new TopLinks(webDriverObj);
		manageEmployerPageObj = new ManageEmployer(webDriverObj);
		addEmployerPageObj = new AddEmployer(webDriverObj);
		brokerHomePageObj = new BrokerHome(webDriverObj);
		employerReusableObj = new Reusables(webDriverObj);

		System.out.println("@BeforeMethod => setUp() Finished");
	}

	@Test(description = "Workflow #1")
	public void TC001() {

		brokerHomePageObj.openHomePage();
		auth0LogInObj.brokerLogin();
		System.out.println("Test Method Finished");

	}

	@Test(dependsOnMethods = "TC001")
	public void TC002() {

		topLinksObj.clickClientsTab();
		manageEmployerPageObj.clickAddEmployer();
		manageEmployerPageObj.clickEnterManually();
		employerReusableObj.fillEmployerDetails();

	}

	@AfterTest
	public void tearDown() {

		webDriverObj.quit();

	}

}