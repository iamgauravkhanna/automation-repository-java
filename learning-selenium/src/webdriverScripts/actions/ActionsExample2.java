package webdriverScripts.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExample2 {

	@Test
	public void testActionBuildPerform2() throws InterruptedException {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Selectable.html");

		WebElement one = webDriver.findElement(By.name("one"));

		WebElement three = webDriver.findElement(By.name("three"));

		WebElement five = webDriver.findElement(By.name("five"));

		// Add all the actions into the Actions builder.
		Actions builder = new Actions(webDriver);

		builder.keyDown(Keys.CONTROL).click(one).click(three).click(five)
				.keyUp(Keys.CONTROL);

		// Perform the action.
		builder.perform();

		webDriver.quit();
	}
}
