package android.nativeApps.settings;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tools.ant.taskdefs.Touch;
import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.touch.offset.PointOption;
import utils.CommonUtils;

public class NotificationTests {

	// Create Object of WebDriver
	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "7.1.1");
		
		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "ZY22363PGD");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("noReset", "true");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.settings");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", ".Settings");

		// Create Android instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
	}

	@Test
	public void addition() throws Exception {

		Thread.sleep(5000);

		MobileElement displayObj = androidDriverObj.findElementByXPath("//android.widget.TextView[@text='Display']");
		
		displayObj.click();
		
		System.out.println("Current Activity => " + androidDriverObj.currentActivity());
		
		androidDriverObj.openNotifications();

		Thread.sleep(5000);

	}

	@AfterClass
	public void teardown() {

		// close the app
		androidDriverObj.quit();
	}

}