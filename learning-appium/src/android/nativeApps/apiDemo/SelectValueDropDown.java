package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectValueDropDown {

	AndroidDriver<AndroidElement> androidElementObj;
	URL appiumServerURL;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
		capabilities.setCapability("deviceName", "ZY22363PGD");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		androidElementObj = new AndroidDriver<AndroidElement>(appiumServerURL, capabilities);
		// driver = new RemoteWebDriver(appiumServerURL, capabilities);
		androidElementObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		androidElementObj.findElement(By.id("Views")).click();

		// Click on Controls.
		androidElementObj.findElement(By.id("Controls")).click();

		// Click on 2. Dark Theme.
		androidElementObj.findElement(By.id("2. Dark Theme")).click();

		// Typing in text box using sendKeys command.
		androidElementObj.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Loerum Ipsoum");

		// To hide keyboard
		androidElementObj.hideKeyboard();

		// Click on dropdown to open list.
		androidElementObj.findElement(By.id("android:id/text1")).click();

		// Select item "Mars" from drop down list.
		androidElementObj.findElement(By.name("Mars")).click();
	}

	@AfterTest
	public void End() {
		androidElementObj.quit();
	}
}