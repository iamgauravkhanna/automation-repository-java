package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonUtils {

	AndroidDriver androidDriverObject;

	public void DesiredCapiblitiesMethod() throws MalformedURLException {

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

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriverObject = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	public static void scrollToElementAndClick(AndroidDriver driver, String Value) {

		// Scroll till element which contains Tabs text.
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + Value + "\"));")
				.click();

	}

	public static void printContextName(AndroidDriver androidDriverObj) {

		Set<String> contextNames = androidDriverObj.getContextHandles();

		for (String contextName : contextNames) {

			System.out.println("Context is : " + contextName);

		}

	}

	public static void waitForElementPresent(AndroidDriver driverObj, AndroidElement ele, int secondsToWait) {

		try {

			WebDriverWait wait = new WebDriverWait(driverObj, secondsToWait);

			wait.until(ExpectedConditions.visibilityOf(ele));

			System.out.println("Great! Element Found");

		} catch (Exception e) {

			System.out.println("Oops !! Element was not visible on UI");

			System.out.println(e.getMessage());

		}

	}

}
