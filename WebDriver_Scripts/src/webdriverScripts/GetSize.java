/*********************************
 
Title  : Get Size
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetSize {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testgetSize() {

		//
		webDriver.get("http://www.google.com");

		//
		WebElement searchButton = webDriver.findElement(By.name("btnK"));

		//
		System.out.println(searchButton.getSize());

	}

}
