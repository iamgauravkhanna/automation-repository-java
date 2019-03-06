package web.project02.healthcare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DriverManager;

public class Feature003 extends BaseTest{
	
	@Test
	public void TC001() {
		
		webDriverPool.get().get("https://www.google.com/");
		
		WebElement element = webDriverPool.get().findElement(By.name("q"));
        
		element.sendKeys("Cheese!");
        
        element.submit();
	}
	
	@Test
	public void TC002() {
		
		webDriverPool.get().get("https://www.google.com/");
		
		WebElement element = webDriverPool.get().findElement(By.name("q"));
        
		element.sendKeys("Cheese!");
        
        element.submit();
	}
	
	@Test
	public void TC003() {
		
		webDriverPool.get().get("https://www.google.com/");
		
		WebElement element = webDriverPool.get().findElement(By.name("q"));
        
		element.sendKeys("Cheese!");
        
        element.submit();
	}

}
