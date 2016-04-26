/*********************************
 
Title  : HTML Unit Driver
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HtmlUnitDriver {

	@Test
	public void testhtmlUnitDriver() {

		//
		//WebDriver webDriver = new HtmlUnitDriver();
		WebDriver webDriver = new FirefoxDriver();

		//
		webDriver.get("http://www.gmail.com");

		//
		System.out.println("Title is --  " + webDriver.getTitle());

		//
		System.out.println("Current URL -- " + webDriver.getCurrentUrl());

		//
		System.out.println("Page source ---- ");

		//
		System.out.println(webDriver.getPageSource());

		//
		webDriver.quit();

	}

}
