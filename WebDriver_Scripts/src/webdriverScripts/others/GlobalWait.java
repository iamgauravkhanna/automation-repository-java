/*********************************
 
Title  : Global / Implicit Wait
Author : Gaurav Khanna

 *********************************/

package webdriverScripts.others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GlobalWait {

	@Test
	public void testglobalWait() {

		//
		System.out.println("Hello!!! how are you?");

		//
		WebDriver webDriver = new FirefoxDriver();

		//
		webDriver.get("http://not-just-a-tester.blogspot.in/");

		//
		webDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		//
		System.out.println("I am good!!!");

	}

}
