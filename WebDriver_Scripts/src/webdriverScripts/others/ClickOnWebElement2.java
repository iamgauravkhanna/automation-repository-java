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

public class ClickOnWebElement2 {

	@Test
	public void testClickOnWebElement2() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Selectable.html");

		WebElement one = webDriver.findElement(By.name("one"));

		WebElement eleven = webDriver.findElement(By.name("eleven"));

		WebElement five = webDriver.findElement(By.name("five"));

		Actions builder = new Actions(webDriver);

		// Click on One, Eleven and Five
		builder.click(one).click(eleven).click(five);

		builder.build().perform();
	}
}