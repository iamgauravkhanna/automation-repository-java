package webdriverScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopupsHandling1 {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void ExampleForAlert() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("file:///C:/Selenium/Raftaar/html/alerts.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
}