package android.nativeApps.apiDemo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetDropDownList {
	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void select() throws InterruptedException {

		// Click on Views.
		driver.findElement(By.name("Views")).click();

		// Click on Controls.
		driver.findElement(By.name("Controls")).click();

		// Click on 2. Dark Theme.
		driver.findElement(By.name("2. Dark Theme")).click();
		// Typing in text box using sendKeys command.
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Test");
		// To hide keyboard
		driver.hideKeyboard();
		// Click on dropdown to open list.
		driver.findElement(By.id("android:id/text1")).click();
		// Locate all drop down list elements
		List dropList = driver.findElements(By.id("android:id/text1"));
		// Extract text from each element of drop down list one by one.
		for (int i = 0; i < dropList.size(); i++) {
			MobileElement listItem = (MobileElement) dropList.get(i);
			System.out.println(listItem.getText());
		}
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}