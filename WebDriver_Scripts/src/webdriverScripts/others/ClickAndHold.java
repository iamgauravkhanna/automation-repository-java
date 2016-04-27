/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickAndHold {

	@Test
	public void testClickAndHold() {

		WebDriver webDriver = new FirefoxDriver();

		webDriver.get("file:///C:/gk/code/selenium/html/Sortable.html");

		Actions builder = new Actions(webDriver);

		// Move tile3 to the position of tile2
		builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0)
				.perform();
	}
}
