package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckElementPresent {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("browserName", "Chrome");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void checkAppElementPresent() {

		// There is element with name App on screen.
		// So iselementpresent will be set to true.
		Boolean iselementpresent = androidDriverObj.findElementsByAccessibilityId("App").size() != 0;

		// iselementpresent will be true so assertion will pass and so test
		// method will pass too.
		Assert.assertTrue(iselementpresent, "Targeted element App is not present on screen");

		System.out.println("Targeted element App is present on screen.");
	}

	@Test
	public void checkLoaderElementPresent() {

		// There is not any element like Loader on screen.
		// So iselementpresent will be set to false.
		Boolean iselementpresent = androidDriverObj.findElementsByAccessibilityId("Loader").size() != 0;

		// iselementpresent will be false so assertion will fail and so test
		// method will fail too.
		Assert.assertTrue(iselementpresent, "Targeted element Loader is not present on screen");

		System.out.println("Targeted element Loader is present on screen.");
	}

	@AfterTest
	public void End() throws IOException {

		androidDriverObj.quit();
	}
}