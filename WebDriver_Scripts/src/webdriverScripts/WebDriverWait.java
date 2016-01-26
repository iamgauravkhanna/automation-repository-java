/*********************************
 
Title  : Webdriver Wait Examples
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverWait {

	//
	WebDriver webDriver = new FirefoxDriver();

	//
	WebDriverWait wait = new WebDriverWait();

	@Test
	public void testwebDriverWait() {

		// Using implicitlyWait
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//
		webDriver.get("http://book.theautomatedtester.co.uk/");

		//
		webDriver.findElement(By.xpath("//a[@href='/chapter1']")).click();

		//
		webDriver.quit();

	}

	@Test
	public void testwebDriverWait1() {

		// Using pageLoadTimeout
		webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		//
		webDriver.get("http://book.theautomatedtester.co.uk/");

		//
		webDriver.findElement(By.xpath("//a[@href='/chapter1']")).click();

		//
		webDriver.quit();
	}

}