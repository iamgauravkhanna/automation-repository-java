package webdriverScripts.findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocateByName {

	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testlocateByName() throws InterruptedException {

		//
		webDriver.get("http://book.theautomatedtester.co.uk/chapter1");

		//
		WebElement checkbox = webDriver.findElement(By.name("selected(1234)"));

		//
		checkbox.click();

		//
		Thread.sleep(5000);

		//
		webDriver.quit();

	}

}
