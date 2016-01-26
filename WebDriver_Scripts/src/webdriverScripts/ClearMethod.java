/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClearMethod {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testclearMethod() throws InterruptedException {

		webDriver
				.get("file:///C:/hcentive-code/local/phix/htmls/empolyer/employers-registration.html");

		WebElement searchBox = webDriver.findElement(By.id("fname"));

		searchBox.sendKeys(Keys.chord(Keys.SHIFT, "packt publishing"));

		Thread.sleep(5000L);

		searchBox.clear();

	}

}
