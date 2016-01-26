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

public class ClickAndHoldAndReleaseOnWebElement {

	@Test
	public void testClickAndHoldAndReleaseOnWebElement() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Sortable.html");

		WebElement three = webDriver.findElement(By.name("three"));

		WebElement two = webDriver.findElement(By.name("two"));

		Actions builder = new Actions(webDriver);

		// Move tile3 to the position of tile2
		builder.clickAndHold(three).release(two).perform();
	}
}
