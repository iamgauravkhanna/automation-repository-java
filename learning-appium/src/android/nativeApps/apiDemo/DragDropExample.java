package android.nativeApps.apiDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class DragDropExample {

	AndroidDriver<AndroidElement> driver;

	Dimension size;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "emulator-5554");

		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "io.appium.android.apis");

		capabilities.setCapability("appActivity", "io.appium.android.apis.view.DragAndDropDemo");

		capabilities.setCapability("noReset", "true");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dragNDropByCoordinatesTest() throws InterruptedException {

		AndroidElement dragDot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		AndroidElement dragDot3 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));

		// WebElement dragText =
		// driver.findElement(By.id("io.appium.android.apis:id/drag_text"));

		// assertEquals("Drag text not empty", "", dragText.getText());

		Point center1 = dragDot1.getCenter();

		Point center2 = dragDot3.getCenter();

		TouchAction dragNDrop = new TouchAction(driver).longPress(PointOption.point(center1.x, center1.y)).moveTo(PointOption.point(center2.x, center2.y)).release();

		dragNDrop.perform();

		Thread.sleep(5000);

	}

}