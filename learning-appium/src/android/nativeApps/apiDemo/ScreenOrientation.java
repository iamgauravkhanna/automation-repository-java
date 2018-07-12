package android.nativeApps.apiDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmentable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenOrientation {
	// AndroidDriver driver;
	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void performOrientation() throws InterruptedException {

		// Get and print current screen orientation.
		System.out.println("*--*--*-- Current screen orientation Is : " + driver.getOrientation());

		System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		// Changing screen Orientation to LANDSCAPE
		//driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());

		Thread.sleep(5000);
		// Scroll till element which contains "Views" text If It Is not visible
		// on screen.
		driver.findElement(By.name("Views")).click();

		System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		// Changing screen Orientation to PORTRAIT.

		//driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);

		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());

		Thread.sleep(5000);
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();

	}
}