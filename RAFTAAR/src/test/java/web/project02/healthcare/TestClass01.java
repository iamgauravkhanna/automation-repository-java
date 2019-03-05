package web.project02.healthcare;

import utils.*;
import web.project02.pageObject.broker.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 * 
 * @author Gaurav.Khanna
 * 
 */
public class TestClass01 extends BaseTest {

	Reusables brokerReusableObj;

	@BeforeTest
	public void setUp1() {

		brokerReusableObj = new Reusables(webDriverObj, baseTestHashMapObj);

	}

	@Test(description = "Broker Logs In")
	public void TC001() {

		brokerReusableObj.loginBroker();

	}

	@Test(dependsOnMethods = "TC001", description = "Add Employer")
	public void TC002() {

		brokerReusableObj.addEmployer();

	}

	@Test(dependsOnMethods = "TC002", description = "Create Package")
	public void TC003() {

		brokerReusableObj.createPackage();

	}

}