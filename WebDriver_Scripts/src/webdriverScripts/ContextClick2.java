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

@Test
public class ContextClick2 {
	public void testContextClick2() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/ContextClick.html");

		WebElement contextMenu = webDriver.findElement(By.id("div-context"));

		Actions builder = new Actions(webDriver);

		builder.moveToElement(contextMenu).contextClick()
				.click(webDriver.findElement(By.name("Item 4"))).perform();
	}
}
