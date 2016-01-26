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

public class ClickOnWebElement {

	@Test
	public void testClickOnWebElement() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Selectable.html");

		WebElement one = webDriver.findElement(By.name("one"));

		WebElement eleven = webDriver.findElement(By.name("eleven"));

		WebElement five = webDriver.findElement(By.name("five"));

		Actions builder = new Actions(webDriver);

		// Click on One
		builder.click(one);

		builder.build().perform();

		// Click on Eleven.
		builder.click(eleven);

		builder.build().perform();

		// Click on Five
		builder.click(five);

		builder.build().perform();
	}
}