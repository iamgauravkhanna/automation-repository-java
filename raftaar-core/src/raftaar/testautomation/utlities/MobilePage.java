package raftaar.testautomation.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import raftaar.testautomation.manager.TestManager;

public class MobilePage {

	public static WebDriver mobileWebDriver;
	public String StepOutCome;
	public By Locator;
	public static WebElement element;
	public String locatorType;
	public String value;
	public By loc;

	public MobilePage() {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "5.0.2");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Emulator");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", TestManager.MyDataDicitonary.get("appPackage"));

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", TestManager.MyDataDicitonary.get("appActivity"));

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		try {

			mobileWebDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Unable to Initialize Obj of mobileWebDriver");

		}

		System.out.println("MobilePage() Constructor Called");

	}

	public String ExecuteKeyword(String action, String parent, String object, String data, String description,

			String testcaseid) throws Exception {

		System.out.println("Executing Mobile Keywords");

		element = findLocator(object);

		switch (action) {

		case "click":

			element.click();

			break;

		}

		return (StepOutCome = "Its StepName");

	}

	private WebElement findLocator(String object) {

		if (object.contains("=") && !(object.isEmpty())) {
			locatorType = object.split("=")[0].toLowerCase().trim();

			System.out.println("locatorType = " + locatorType);

			System.out.println("Value = " + value);

			if (locatorType.contains("xpath")) {
				value = object.substring(6);

			} else if (object.contains("==")) {
				value = "=";

			} else {
				value = object.split("=")[1].trim();

			}

			loc = WebPage.locatorValue(locatorType, value);
		} else {
			loc = null;
		}

		WebElement e = null;

		if (loc == null) {

		} else {
			try {
				e = what(loc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return e;
	}

	public static WebElement what(By locator) throws Exception {

		element = mobileWebDriver.findElement(locator);

		return element;

	}

}
