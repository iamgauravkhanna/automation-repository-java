package android.nativeApps.demodslv;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragandDrop1 {
	// WebDriver driver;
	// AppiumDriver<WebElement> driver;
	RemoteWebDriver driver;

	String device = "Android";
	String devicename = "0123456789ABCDEF";
	String platformversion = "4.2.1";
	String platformname = "Android";

	@Test
	public void getDesireCapabilities() throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("device", device);
		/*
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		 * cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformversion);
		 */
		cap.setCapability("deviceName", devicename);
		cap.setCapability("platformName", platformname);
		cap.setCapability("platformVersion", platformversion);
		cap.setCapability("browserName", "");
		cap.setCapability("appPackage", "com.mobeta.android.demodslv");
		cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		// driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Basic usage playground']")).click();

		WebElement source = (WebElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Chick Corea']"));
		WebElement destination = (WebElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text='Wayne Shorter']"));

		TouchAction action = new TouchAction((MobileDriver) driver);
		System.out.println("Dragging item");
		action.longPress(source).moveTo(destination).release().perform();
		System.out.println("Dragged Succssfully");
		// driver.quit();

	}

}