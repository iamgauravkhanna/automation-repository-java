package flipkart;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class Script1 {

	//
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// Set Drag-Sort Demos app folder path. This statement will refer
		// project's folder path.
		File classpathRoot = new File(System.getProperty("user.dir"));

		// Set folder name "Apps" where .apk file is stored.
		File appDir = new File(classpathRoot, "/apps");

		// Set Drag-Sort Demos .apk file name.
		File app = new File(appDir, "com.flipkart.android-5.9.apk");

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set BROWSER_NAME desired capability
		capabilities.setCapability("BROWSER_NAME", "Android");

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
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {

		// locate the Text on the calculator by using By.name()
		WebElement two = driver.findElement(By.name("2"));

		//
		two.click();

		//
		WebElement plus = driver.findElement(By.name("+"));

		//
		plus.click();

		//
		WebElement four = driver.findElement(By.name("4"));

		//
		four.click();

		//
		WebElement equalTo = driver.findElement(By.name("="));

		equalTo.click();

		// Get result from result text box.
		String result = driver.findElement(By.className("android.widget.EditText")).getText();

		//
		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}
