/*********************************
 
Title  : Using Css Value 1
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UsingCssValue {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testcssValue() {

		//
		webDriver.get("http://www.google.com");
		
		//
		WebElement searchButton = webDriver.findElement(By.name("btnK"));
		
		//
		System.out.println(searchButton.getCssValue("font-family"));

	}

}
