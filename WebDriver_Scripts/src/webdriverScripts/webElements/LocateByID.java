/*********************************
 
Title  : Locate Element By ID
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByID {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByID() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter1");

		//
		WebElement button = webDriver.findElement(By.id("radiobutton"));

		//
		button.click();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}

}
