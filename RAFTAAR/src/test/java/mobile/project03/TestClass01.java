package mobile.project03;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobile.project03.pageObject.HomeActivity;
import utils.BaseTest;
import utils.BrowserFactory;

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

		BrowserFactory driverUtilObj = new BrowserFactory();

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
