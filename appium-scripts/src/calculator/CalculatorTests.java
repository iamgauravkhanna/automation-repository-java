package calculator;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorTests {

	// Create Object of WebDriver
	AndroidDriver<?> androidDriverObj;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android VERSION desired capability
		capabilities.setCapability("VERSION", "5.0.1");

		// Set android deviceName desired capability
		capabilities.setCapability("deviceName", "Emulator");

		// Set platformName desired capability.
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the
		// configurations specified in Desired Capabilities
		androidDriverObj = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	}

	@Test
	public void addition() throws Exception {

		// locate the Text on the calculator by using By.name()
		WebElement two = androidDriverObj.findElement(By.name("2"));

		// click on 2
		two.click();

		// locate the Text on the calculator by using By.name()
		WebElement plus = androidDriverObj.findElement(By.name("+"));

		// click on +
		plus.click();

		// locate the Text on the calculator by using By.name()
		WebElement four = androidDriverObj.findElement(By.name("4"));

		// click on 4
		four.click();

		// locate the Text on the calculator by using By.name()
		WebElement equalTo = androidDriverObj.findElement(By.name("="));

		// click on =
		equalTo.click();

		// Get result from result text box.
		String result = androidDriverObj.findElement(By.className("android.widget.EditText")).getText();

		// Print the output
		System.out.println("Sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() {

		// close the app
		androidDriverObj.quit();
	}
}