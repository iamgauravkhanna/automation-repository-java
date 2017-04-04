package nativeApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentElementLocators {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", "Emulator");

		// Set android VERSION desired capability. Set your mobile device's OS
		// version.
		capabilities.setCapability("platformVersion", "5.0.2");

		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", "Android");

		// Set android appPackage desired capability. It is
		// com.android.calculator2 for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// Set android appActivity desired capability. It is
		// com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Sum() {
		// Using findElements.
		// Locate DELETE/CLR button using findElements and get() method and
		// click on it.
		driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

		// By xpath.
		// Locate number button 2 by XPATH element locator and click on it.
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();

		// Using findElements.
		// Locate number button + using findElements and get() method and click
		// on it.
		driver.findElements(By.xpath("//android.widget.Button")).get(16).click();

		// By id.
		// Locate number button 5 by ID element locator and click on it.
		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();

		// By name.
		// Locate number button = by name element locator and click on it.
		driver.findElement(By.name("=")).click();

		// By className.
		// Locate result textbox by CLASSNAME element locator and get result
		// from it.
		String result = driver.findElement(By.className("android.widget.EditText")).getText();
		System.out.println("Number sum result is : " + result);

	}

	@AfterTest
	public void End() {
		// Quit
		driver.quit();
	}
}