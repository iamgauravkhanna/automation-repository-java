package web.project02.healthcare;

import utils.*;
import web.project02.healthcare.pageObject.broker.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 * 
 * @author Gaurav.Khanna
 * 
 */
public class Feature001 extends BaseTest {

	Reusables brokerReusableObj;

	@BeforeMethod
	public void beforeStartingTestMethod() {

		LogUtils.info("============ beforeStartingTestMethod() begins ============");

		brokerReusableObj = new Reusables(webDriverObj);

		LogUtils.info("============ beforeStartingTestMethod() ends ============");

	}

	@Test(description = "Test Case 001")
	public void TC001() {

		TestDataWriter.getInstance().putAllKeys(testDataMap);

		brokerReusableObj.loginBroker();
		
		brokerReusableObj.addEmployer();

		brokerReusableObj.createPackage();

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

	}

}	