package android.nativeApps.apiDemo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FindElementsExample {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		//
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Real Device");

		// Set android VERSION desired capability
		capabilities.setCapability("platformVersion", "7.1.1");

		//
		capabilities.setCapability("platformName", "Android");
		
		//
		capabilities.setCapability("browserName","Chrome");

		//
		capabilities.setCapability("appPackage", "io.appium.android.apis");

		//
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		//
		capabilities.setCapability("noReset", "true");

		//
		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//
		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void test001() {

		Boolean isDisplayed;

		// Find Element By ID
		isDisplayed = androidDriverObj.findElement(By.id("Views")).isDisplayed();

		System.out.println("Elements Visible on UI ? - " + isDisplayed);

		// Find Element By Class Name
		isDisplayed = androidDriverObj.findElement(By.className("android.widget.TextView")).isDisplayed();

		System.out.println("Elements Visible on UI ? - " + isDisplayed);

		// Find Element By Xpath
		isDisplayed = androidDriverObj.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))
				.isDisplayed();

		System.out.println("Elements Visible on UI ? - " + isDisplayed);

	}
}