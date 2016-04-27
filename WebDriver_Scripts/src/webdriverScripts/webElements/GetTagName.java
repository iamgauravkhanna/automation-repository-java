package webdriverScripts.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetTagName {

	//
	WebDriver webDriver = new FirefoxDriver();

	@Test
	public void testgetTagName() {

		//
		webDriver.get("http://www.google.com");

		//
		WebElement searchButton = webDriver.findElement(By.name("btnK"));

		//
		System.out.println(searchButton.getTagName());
	}
}
