package android.nativeApps.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestVideoRecorder {

	//
	AndroidDriver<AndroidElement> androidDriverObj;

	//
	ATUTestRecorder recorder;

	@BeforeClass
	public void setUp() throws MalformedURLException, ATUTestRecorderException {

		// Get current date and time to provide in recorded video name.
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");

		//
		Date date = new Date();

		// Created object of ATUTestRecorder.
		// Provide path to store videos and file name format.
		recorder = new ATUTestRecorder("C:\\appium\\", "TestVideo-" + dateFormat.format(date), false);

		// Created object of DesiredCapabilities class
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//
		capabilities.setCapability("deviceName", "emulator-5554");

		//
		capabilities.setCapability("platformVersion", "7.1.1");

		//
		capabilities.setCapability("platformName", "Android");

		//
		capabilities.setCapability("appPackage", "com.android.calculator2");

		//
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		//
		capabilities.setCapability("noReset", "true");

		//
		androidDriverObj = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// To start video recording of your PC screen.
		recorder.start();
	}

	@Test
	public void testCal() throws Exception {
		// locate the Text '2' on the calculator by using By.name()
		AndroidElement two = androidDriverObj.findElement(By.id("digit_2"));

		// click on AndroidElement
		two.click();

		//
		AndroidElement plus = androidDriverObj.findElement(By.id("op_add"));

		// click on AndroidElement
		plus.click();

		//
		AndroidElement four = androidDriverObj.findElement(By.id("digit_4"));

		// click on AndroidElement
		four.click();

		//
		AndroidElement equalTo = androidDriverObj.findElement(By.id("eq"));

		// click on AndroidElement
		equalTo.click();

		// Get result from result text box.
		String result = androidDriverObj.findElement(By.id("result")).getText();

		//
		System.out.println("Number sum result is : " + result + "\n");

	}

	@AfterClass
	public void teardown() throws ATUTestRecorderException {

		// close the app
		androidDriverObj.quit();

		// Stop video recording.
		recorder.stop();
	}
}
