package nativeApps;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BasicScript {

	//
	WebDriver webDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("platformVersion", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		webDriverObj = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {

		// locate the Text '2' on the calculator by using By.name()
		WebElement two = webDriverObj.findElement(By.id("digit_2"));

		// click on webelement
		two.click();

		//
		WebElement plus = webDriverObj.findElement(By.id("op_add"));

		// click on webelement
		plus.click();

		//
		WebElement four = webDriverObj.findElement(By.id("digit_4"));

		// click on webelement
		four.click();

		//
		WebElement equalTo = webDriverObj.findElement(By.id("eq"));

		// click on webelement
		equalTo.click();

		// Get result from result text box.
		String result = webDriverObj.findElement(By.id("result")).getText();

		//
		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() {
		// close the app
		webDriverObj.quit();
	}
}