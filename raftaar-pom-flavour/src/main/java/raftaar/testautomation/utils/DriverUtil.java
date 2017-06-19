package raftaar.testautomation.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverUtil {

	WebDriver webDriverObj;
	AndroidDriver<?> androidDriverObj;
	IOSDriver<?> iOSDriverObj;

	public WebDriver initializeDriverObj() {

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		capability.setBrowserName("firefox");

		capability.setPlatform(Platform.WINDOWS);

		try {
			webDriverObj = new RemoteWebDriver(new URL("http://192.168.49.72:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		LogManager.info("Browser Initialized");

		return webDriverObj;

	}

	public AndroidDriver<?> initializeAndroidDriverObj() {
		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set BROWSER_NAME desired capability
		capabilities.setCapability("BROWSER_NAME", "Android");

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "5.0.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Emulator");

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
		try {
			androidDriverObj = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		return androidDriverObj;
	}

}
