package nativeApps;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DialPad {
	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZX1B32FFXF");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.dialer");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void dial() {
		// Click on dial pad button to open dialer pad.
		// driver.findElementById("com.android.dialer:id/dialpad_button").click();
		driver.findElementById("com.android.dialer:id/floating_action_button").click();
		// Create object of TouchAction class.
		TouchAction Action = new TouchAction(driver);
		// Create action chain using TouchAction class reference to perform long
		// press action on button 0 of dialer pad.
		Action.longPress(driver.findElement(By.name("0"))).perform();
		// Get the result from dial text box.
		String result = driver.findElementById("com.android.dialer:id/digits").getText();
		// Compare actual and expected result using testng assertion.
		Assert.assertEquals(result, "+", "Actual value is : " + result + " did not match with expected value: +");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}