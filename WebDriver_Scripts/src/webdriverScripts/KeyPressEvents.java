/*********************************
 
Title  : Key Press Events
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KeyPressEvents {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testkeyPressEvents() throws InterruptedException {

		//
		webDriver.get("http://gmail.com");

		//
		webDriver.findElement(By.xpath("//*[@id='Email']")).sendKeys(
				"seleniumcoaching@gmail.com");

		//
		webDriver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("abcd");

		//
		webDriver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(
				Keys.ENTER);

		//
		webDriver.findElement(
				By.xpath("html/body/div[1]/div[2]/div[2]/ul[1]/li[3]/p[2]/a"))
				.click();

		//
		Thread.sleep(3000L);

		//
		webDriver.findElement(
				By.xpath("//*[@id='en_us']/body/div[1]/div[3]/h2")).sendKeys(
				Keys.PAGE_DOWN);

		//
		Thread.sleep(3000L);

		//
		webDriver.findElement(
				By.xpath("//*[@id='en_us']/body/div[1]/div[3]/h2")).sendKeys(
				Keys.PAGE_UP);

		//
		Thread.sleep(3000L);

		//
		webDriver.findElement(
				By.xpath("//*[@id='en_us']/body/div[1]/div[3]/h2")).sendKeys(
				Keys.BACK_SPACE);

	}

}
