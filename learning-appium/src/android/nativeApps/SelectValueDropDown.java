package android.nativeApps;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectValueDropDown {

	WebDriver webDriverObj;
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
		webDriverObj = new AndroidDriver<?>(appiumServerURL, capabilities);
		// driver = new RemoteWebDriver(appiumServerURL, capabilities);
		webDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		webDriverObj.findElement(By.name("Views")).click();

		// Click on Controls.
		webDriverObj.findElement(By.name("Controls")).click();

		// Click on 2. Dark Theme.
		webDriverObj.findElement(By.name("2. Dark Theme")).click();

		// Typing in text box using sendKeys command.
		webDriverObj.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Loerum Ipsoum");

		// To hide keyboard
		// driver.hideKeyboard();

		// Click on dropdown to open list.
		webDriverObj.findElement(By.id("android:id/text1")).click();

		// Select item "Mars" from drop down list.
		webDriverObj.findElement(By.name("Mars")).click();
	}

	@AfterTest
	public void End() {
		webDriverObj.quit();
	}
}