package android.hybridApps.hc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.CommonUtils;

public class hc {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "ZY22363PGD");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		capabilities.setCapability("appPackage", "com.hcentive.hcmobile538102");

		capabilities.setCapability("appActivity", "com.hcentive.hcmobile538102.HcentiveApp");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void firstTest() throws InterruptedException {

		CommonUtils.printContextName(androidDriverObj);

		Thread.sleep(10000);

		//androidDriverObj.context("WEBVIEW_com.hcentive.hcmobile538102");

		CommonUtils.waitForElementPresent(androidDriverObj,
				androidDriverObj.findElement(By.xpath("//input[@name='username']")), 10);

		androidDriverObj.findElement(By.xpath("//input[@name='username']")).click();

		androidDriverObj.findElement(By.xpath("//input[@name='username']")).sendKeys("empone.trsf1@mail.com");

		androidDriverObj.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
		Thread.sleep(5000);
		
		CommonUtils.waitForElementPresent(androidDriverObj,
				androidDriverObj.findElement(By.xpath("//input[@name='password']")), 10);
		
		androidDriverObj.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty@12");
		
		androidDriverObj.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

		Thread.sleep(20000);

	}

	@AfterTest
	public void End() throws IOException {

		androidDriverObj.quit();
	}

}