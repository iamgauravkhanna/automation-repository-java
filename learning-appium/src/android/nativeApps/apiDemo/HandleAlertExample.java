package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleAlertExample {

	AndroidDriver androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void okOnAlert() {

		// Click on App.
		androidDriverObj.findElement(By.id("App")).click();

		// Click on Alert Dialogs.
		androidDriverObj.findElement(By.id("Alert Dialogs")).click();

		// Click on "OK Cancel dialog with a message" button.
		androidDriverObj.findElement(By.id("OK Cancel dialog with a message")).click();

		// Get the text from alert dialog.
		String result = androidDriverObj.findElementById("android:id/alertTitle").getText();

		System.out.println("Alert text Is -> " + result);

		// Click on OK button of alert dialog.
		androidDriverObj.findElement(By.id("android:id/button1")).click();

		// Click on Cancel button of alert dialog.
		// androidDriverObj.findElement(By.id("android:id/button1")).click();
	}

	@AfterTest
	public void End() {

		androidDriverObj.quit();
	}
}