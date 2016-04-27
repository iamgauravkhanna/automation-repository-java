package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String... args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/gk/code/selenium/html/DragAndDrop.html");
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement trgt = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(src, trgt).perform();
	}
}
