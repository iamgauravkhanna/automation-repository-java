package android.hybridApps.spellthem;

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

public class spellthemTests {

	AndroidDriver<AndroidElement> androidDriverObj;

	AndroidElement element;

	/**
	 * 
	 * Chromedriver need to configured while running Appium Server
	 * 
	 * */
	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "ZY22363PGD");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");
				
		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		capabilities.setCapability("appPackage", "com.spellthem.webpages");

		capabilities.setCapability("appActivity", "com.spellthem.webpages.MainActivity");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void firstTest() throws InterruptedException {

		CommonUtils.printContextName(androidDriverObj);

		Thread.sleep(30000);

		//androidDriverObj.context("WEBVIEW_com.spellthem.webpages");

		CommonUtils.waitForElementPresent(androidDriverObj,
				androidDriverObj.findElement(By.xpath("//span[text()='Try Oracle Cloud Free']")), 30);

		androidDriverObj.findElement(By.xpath("//span[text()='Try Oracle Cloud Free']")).click();

		CommonUtils.waitForElementPresent(androidDriverObj,
				androidDriverObj.findElement(By.xpath("//a[text()='Create a Free Account']")), 30);

		androidDriverObj.findElement(By.xpath("//a[text()='Create a Free Account']")).click();

	}

	@AfterTest
	public void End() throws IOException {

		androidDriverObj.quit();
	}

}