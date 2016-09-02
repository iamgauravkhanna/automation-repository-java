package webdriverScripts.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExample1 {

	@Test
	public void testActionBuildPerform() throws InterruptedException {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("http://jqueryui.com/selectable/");

		Thread.sleep(5000);

		WebElement one = webDriver.findElement(By.xpath("//*[@id='selectable']/li[1]"));

		WebElement three = webDriver.findElement(By.xpath("//*[@id='selectable']/li[2]"));

		WebElement five = webDriver.findElement(By.xpath("//*[@id='selectable']/li[3]"));

		// Add all the actions into the Actions builder.
		Actions builder = new Actions(webDriver);

		builder.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyUp(Keys.CONTROL);

		// Generate the composite action.
		Action compositeAction = builder.build();

		// Perform the composite action.
		compositeAction.perform();

		Thread.sleep(5000);

		webDriver.quit();
	}

}