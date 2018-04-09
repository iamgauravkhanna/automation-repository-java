package nativeApps;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetDateExample {
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
	public void dateSet() {

		// Click on Views.
		driver.findElement(By.name("Views")).click();

		// Scroll till element which contains "Date Widgets" text.
		driver.findElement(By.name("Date Widgets")).click();

		// Click on element which contains "1. Dialog" text.
		driver.findElement(By.name("1. Dialog")).click();

		// Click on button which contains "change the date" text.
		driver.findElement(By.name("change the date")).click();

		// Set Date = 25.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("25");

		// Set Month = Aug.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("Aug");

		// Set Year = 2009.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("2009");

		// Click on Done button.
		driver.findElement(By.id("android:id/button1")).click();
	}

	@Test
	public void timeSet() {
		// Click on button which contains "change the time" text.
		driver.findElement(By.name("change the time")).click();
		// Set Hours = 1.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("1");
		// Set Minutes = 25.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("25");
		// Set pm.
		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("pm");
		// Click on Done button.
		driver.findElement(By.id("android:id/button1")).click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}