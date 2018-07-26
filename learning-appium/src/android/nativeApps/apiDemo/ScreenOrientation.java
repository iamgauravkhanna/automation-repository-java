package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenOrientation {

	//
	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void performOrientation() throws InterruptedException {

		// Get and print current screen orientation.
		System.out.println("Current screen orientation : " + androidDriverObj.getOrientation());

		// Changing screen Orientation to LANDSCAPE
		System.out.println("Changing screen Orientation to LANDSCAPE.");
		androidDriverObj.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

		// Get and print screen orientation after changing It.
		System.out.println("Now screen orientation Is : " + androidDriverObj.getOrientation());

		//
		Thread.sleep(5000);

		//
		System.out.println("Scrolling has been started to find text -> Views");

		// Scroll till element which contains Tabs text.
		androidDriverObj
				.findElementByAndroidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Views\"));")
				.click();

		// Changing screen Orientation to PORTRAIT.
		System.out.println("Changing screen Orientation to PORTRAIT.");
		androidDriverObj.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);

		// Get and print screen orientation after changing It.
		System.out.println("Now screen orientation Is : " + androidDriverObj.getOrientation());

		//
		Thread.sleep(5000);
	}

	@AfterTest
	public void End() throws IOException {

		//
		androidDriverObj.quit();

	}
}