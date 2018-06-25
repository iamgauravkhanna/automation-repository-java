package project09;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObject.project09.HomeActivity;
import utils.DriverUtil;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class TestClass01 {

	AndroidDriver<MobileElement> androidDriverObj;
	HomeActivity homeActivityObj;

	@BeforeTest
	public void setUp() {

		DriverUtil driverUtilObj = new DriverUtil();
		androidDriverObj = driverUtilObj.initializeAndroidDriverObj();

	}

	@Test
	public void TC001() {

		homeActivityObj = new HomeActivity(androidDriverObj);
		homeActivityObj.clickDigit2();
		homeActivityObj.clickSymbolPlus();
		homeActivityObj.clickDigit4();
		homeActivityObj.clickEqualsTo();

	}
	
	@AfterTest
	public void tearDown() {
		
		androidDriverObj.quit();
		
	}

}
