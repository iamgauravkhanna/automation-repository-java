package android.nativeApps.apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetDropDownList {

	AndroidDriver<AndroidElement> androidDriverObj;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("noReset", "true");

		capabilities.setCapability("browserName", "");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		androidDriverObj.findElementByAccessibilityId("Views").click();

		// Click on Controls.
		androidDriverObj.findElementByAccessibilityId("Controls").click();

		// Click on 2. Dark Theme.
		androidDriverObj.findElementByAccessibilityId("2. Dark Theme").click();

		// Typing in text box using sendKeys command.
		androidDriverObj.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Test");

		// To hide keyboard
		androidDriverObj.hideKeyboard();

		// Click on dropdown to open list.
		androidDriverObj.findElement(By.id("android:id/text1")).click();
		
		androidDriverObj.manage().logs().get("console");

		// Locate all drop down list elements
		List<AndroidElement> dropList = androidDriverObj.findElements(By.id("android:id/text1"));

		// Extract text from each element of drop down list one by one.
		for (int i = 0; i < dropList.size(); i++) {
			
			AndroidElement listItem = dropList.get(i);

			System.out.println(listItem.getText());
		}
	}

	@AfterTest
	public void End() {

		androidDriverObj.quit();

	}
}