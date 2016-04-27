package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByClass {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByClass() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter1");

		//
		WebElement textBox = webDriver.findElement(By.className("belowcenter"));

		//
		textBox.clear();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}
}
