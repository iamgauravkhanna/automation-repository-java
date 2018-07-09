package android.nativeApps.calculator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorTests {

	// Create Object of WebDriver
	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "7.1.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Create Android instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
	}

	@Test
	public void addition() throws Exception {

		// locate the Text '2' on the calculator by using By.name()
		AndroidElement two = androidDriverObj.findElement(By.id("digit_2"));

		// click on AndroidElement
		two.click();

		//
		AndroidElement plus = androidDriverObj.findElement(By.id("op_add"));

		// click on AndroidElement
		plus.click();

		//
		AndroidElement four = androidDriverObj.findElement(By.id("digit_4"));

		// click on AndroidElement
		four.click();

		//
		AndroidElement equalTo = androidDriverObj.findElement(By.id("eq"));

		// click on AndroidElement
		equalTo.click();

		// Get result from result text box.
		String result = androidDriverObj.findElement(By.id("result")).getText();

		//
		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() {

		// close the app
		androidDriverObj.quit();
	}
}