package raftaar.testautomation.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.helpers.UtilLoggingLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import raftaar.testautomation.manager.TestManager;
import raftaar.testautomation.manager.UITests;

public class MobilePage {

	public static AndroidDriver mobileWebDriver;
	public String StepOutCome;
	public By Locator;
	public static WebElement element;
	public String locatorType;
	public String value;
	public By loc;

	public MobilePage() throws MalformedURLException {

		UITests.log.debug("MobilePage() constructor called");

	}

	public String ExecuteKeyword(String action, String parent, String object, String data, String description,

			String testcaseid) throws Exception {

		System.out.println("Executing Mobile Keywords");		

		switch (action) {

		case "launchApp":

			// Created object of DesiredCapabilities class
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// Set android VERSION desired capability
			capabilities.setCapability("VERSION", TestManager.MyDataDicitonary.get("version"));

			// Set android deviceName desired capability
			capabilities.setCapability("deviceName", TestManager.MyDataDicitonary.get("deviceName"));

			// Set platformName desired capability.
			capabilities.setCapability("platformName", TestManager.MyDataDicitonary.get("platformName"));

			// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appPackage", TestManager.MyDataDicitonary.get("appPackage"));

			// This is Launcher activity of your app (you can get it from apk
			// info
			// app)
			capabilities.setCapability("appActivity", TestManager.MyDataDicitonary.get("appActivity"));

			if (mobileWebDriver == null) {

				System.out.println("Entering into Mobile Page Constructor");

				mobileWebDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} else {
				System.out.println("Unable to Initialize Obj of mobileWebDriver");
			}

			break;

		case "click":
			
			element = findLocator(object);

			element.click();

			String screenShotPath = WebPage.getscreenshot(mobileWebDriver);

			UITests.extentTestObj.log(Status.PASS, "Click Successful",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath, "Title of the screenshot").build());

			break;

		case "closeApp":

			mobileWebDriver.closeApp();

			break;

		case "setVariable":

			System.out.println("Set Variable : ");
			TestManager.MyDataDicitonary.put(object, data);
			System.out.println("Value : " + TestManager.MyDataDicitonary.get(object));				

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
