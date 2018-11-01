package android.nativeApps.apiDemo;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxExample {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "ZY22363PGD");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		//capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		capabilities.setCapability("noReset", "true");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		driver.findElementByAccessibilityId("Views").click();

		// Click on Controls.
		driver.findElement(By.name("Controls")).click();

		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();

		// Click on check-box to select it.
		driver.findElement(By.name("Checkbox 2")).click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}