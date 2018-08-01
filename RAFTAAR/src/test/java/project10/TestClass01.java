package project10;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.project10.HomeActivity;
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

		androidDriverObj = driverUtilObj.initializeAndroidDriverObj("org.zwanoo.android.speedtest",
				"com.ookla.speedtest.softfacade.MainActivity");

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
