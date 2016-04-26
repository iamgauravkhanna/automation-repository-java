/*********************************
 
Title  : Locate Element By Partial Link Text
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByPartialLinkText {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByPartialLinkText() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter2");

		//
		WebElement link = webDriver.findElement(By.partialLinkText("In"));

		//
		link.click();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}

}
