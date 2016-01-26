/*********************************
 
Title  : Page Load Time
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class PageLoadTime {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testpageLoadTime() {

		//
		webDriver.get("https://www.407etr.com/myaccount/Login.jsf");

		//
		webDriver
				.findElement(
						By.xpath("//*[@id='j_id1454958180_5ddf75ef']/div[2]/ul/li[4]/a"))
				.click();

		//
		Object result = ((JavascriptExecutor) webDriver)
				.executeScript("function pageloadingtime()" + "{"
						+ "return 'Page has completely loaded'" + "}"
						+ "return (window.onload=pageloadingtime());");

		//
		System.out.println(result);

		//
		System.out.println("page loaded");

		// time for the page to load
		// submit form

		//
		System.out.println(result);

	}

}
