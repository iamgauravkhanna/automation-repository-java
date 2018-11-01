package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.CommonUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebViewExample {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "ZY22363PGD");

//		capabilities.setCapability("browserName", "Chrome");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		androidDriverObj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void checkAppElementPresent() {

		// There is element with name App on screen.
		// So iselementpresent will be set to true.
		Boolean iselementpresent = androidDriverObj.findElementsByAccessibilityId("Views").size() != 0;

		if(iselementpresent) {
			
			androidDriverObj.findElementByAccessibilityId("Views").click();
			
			CommonUtils.printContextName(androidDriverObj);
			
		}
		
		utils.CommonUtils.scrollToElementAndClick(androidDriverObj, "WebView");
		
		CommonUtils.printContextName(androidDriverObj);
		
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@AfterTest
	public void End() throws IOException {

		androidDriverObj.quit();
	}
}