/*********************************
 
Title  : Handling JavaScript Alerts
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingJavaScriptAlerts {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testhandlingJavaScriptAlerts() {

		//
		webDriver.get("http://in.rediff.com");

		//
		webDriver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();

		//
		webDriver.findElement(By.xpath("//input[@id='btn_login']")).click();

		//
		Alert javascriptAlert = webDriver.switchTo().alert();

		//
		System.out.println(javascriptAlert.getText());

		//
		javascriptAlert.accept();

		//
		javascriptAlert.dismiss();
	}

}
