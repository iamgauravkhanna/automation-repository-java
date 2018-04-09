package nativeApps;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	AndroidDriver driver;
	Dimension size;
	String destDir;
	DateFormat dateFormat;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");

		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// This is Launcher activity of your app (you can get it from apk info
		// app)
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void ScreenShotExample() {

		// locate the Text '2' on the calculator by using By.name()
		WebElement two = driver.findElement(By.name("2"));

		// click on webelement
		two.click();

		//
		WebElement plus = driver.findElement(By.name("+"));

		// click on webelement
		plus.click();

		//
		WebElement four = driver.findElement(By.name("4"));

		// click on webelement
		four.click();

		//
		WebElement equalTo = driver.findElement(By.name("="));

		// click on webelement
		equalTo.click();

		// Call takeScreenShot() function to capture screenshot of android
		// screen.
		takeScreenShot();

	}

	public void takeScreenShot() {
		// Set folder name to store screenshots.
		destDir = "screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}