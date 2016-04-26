/*********************************
 
Title  : Locate Element By Tag Name
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByTagName {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByTagName() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk");

		//
		List<WebElement> buttons = webDriver.findElements(By.tagName("a"));

		//
		System.out.println(buttons.size());

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}
}
