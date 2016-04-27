/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickAndHoldAndRelease {

	@Test
	public void testClickAndHoldAndRelease() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Sortable.html");

		WebElement three = webDriver.findElement(By.name("three"));

		Actions builder = new Actions(webDriver);

		// Move tile3 to the position of tile2
		builder.clickAndHold(three).moveByOffset(120, 0).release().perform();
	}
}
