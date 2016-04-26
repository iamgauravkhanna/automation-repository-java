/*********************************
 
Title  : Locate Element By Xpath
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByXpath {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByXpath() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter1");

		//
		WebElement button = webDriver.findElement(By
				.xpath("/html/body/div[2]/p[2]/input"));

		//
		button.click();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}
}
