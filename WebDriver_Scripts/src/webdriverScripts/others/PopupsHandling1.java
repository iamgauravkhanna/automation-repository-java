package webdriverScripts.others;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopupsHandling1 {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void ExampleForAlert() throws InterruptedException {		
		driver.get("file:///C:/Code/Selenium/Raftaar/html/alerts.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
/*		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text :  "+alert.getText());
		alert.accept();*/
	}
}