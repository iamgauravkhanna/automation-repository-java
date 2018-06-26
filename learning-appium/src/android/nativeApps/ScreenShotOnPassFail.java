package android.nativeApps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ ScreenshotUtility.class })
public class ScreenShotOnPassFail {
	static AndroidDriver driver;

	@BeforeClass
	public void initialize() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// Method Is written In such a way to fail It Intentionally.
	// This method will fail as actual result 6 will not match with expected 7.
	@Test
	public void TestForFailure() throws IOException {
		// Click on DELETE/CLR button to clear result text box before running
		// test.
		((WebElement) driver.findElements(By.xpath("//android.widget.Button")).get(0)).click();
		// Click on 2, +, 4 and = buttons.
		driver.findElement(By.name("2")).click();
		driver.findElement(By.name("+")).click();
		driver.findElement(By.name("4")).click();
		driver.findElement(By.name("=")).click();
		// Get result from calc result textbox.
		String result = driver.findElement(By.className("android.widget.EditText")).getText();
		// Compare actual and expected result using testng assertion and mark
		// test pass or fail based on result.
		// Assertion will fail. So It will call onTestFailure method from
		// ScreenshotUtility.
		assert result.equals("7") : "Expected value : 7 did not match with Actual value: " + result;
	}

	@Test
	public void TestForPass() throws IOException {
		// Click on DELETE/CLR button to clear result text box before running
		// test.
		((WebElement) driver.findElements(By.xpath("//android.widget.Button")).get(0)).click();
		// Click on 3, +, 4 and = buttons.
		driver.findElement(By.name("3")).click();
		driver.findElement(By.name("+")).click();
		driver.findElement(By.name("4")).click();
		driver.findElement(By.name("=")).click();
		// Get result from calc result textbox.
		String result = driver.findElement(By.className("android.widget.EditText")).getText();
		// Compare actual and expected result using testng assertion and mark
		// test pass or fail based on result.
		// Assertion will pass. So It will call onTestSuccess method from
		// ScreenshotUtility.
		assert result.equals("7") : "Expected value : 7 did not match with Actual value: " + result;
	}

	@AfterClass
	public void End() {
		driver.quit();
	}
}