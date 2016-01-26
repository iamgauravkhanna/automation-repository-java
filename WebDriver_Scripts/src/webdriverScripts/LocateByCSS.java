/*********************************
 
Title  : Locate Element By CSS
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByCSS {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByCSS() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter1");

		//
		WebElement button = webDriver.findElement(By
				.cssSelector("html body div.mainbody p input#radiobutton"));

		//
		button.click();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}

}
