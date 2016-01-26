/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {

	@Test
	public void testContextClick() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/ContextClick.html");

		WebElement contextMenu = webDriver.findElement(By.id("div-context"));

		Actions builder = new Actions(webDriver);

		builder.contextClick(contextMenu)
				.click(webDriver.findElement(By.name("Item 4"))).perform();
	}
}
