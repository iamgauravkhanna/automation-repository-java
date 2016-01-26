package webdriverScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariBrowser {
  public static void main(String... args){
	  System.setProperty("SafariDefaultPath", "C:\\Safari\\Safari.exe");
	  WebDriver driver = new SafariDriver();
	  driver.get("http://www.google.com");
	  driver.findElement(By.name("q")).sendKeys("Packt Publishing");
	  driver.findElement(By.name("btnG")).click();
	  driver.quit();
  }
}
