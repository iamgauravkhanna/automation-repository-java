package project10;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.project10.HomeActivity;
import utils.BaseTest;
import utils.DriverUtil;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class TestClass01 extends BaseTest{

	AndroidDriver<AndroidElement> androidDriverObj;
	HomeActivity homeActivityObj;

	@BeforeTest
	public void setUp() {

		DriverUtil driverUtilObj = new DriverUtil(baseTestHashMapObj);

		androidDriverObj = driverUtilObj.initializeAndroidDriverObj();

	}

	@Test
	public void TC001() {

		//homeActivityObj = new HomeActivity(androidDriverObj);

	}

	@AfterTest
	public void tearDown() {

		androidDriverObj.quit();

	}

}
