package webdriverScripts.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownCommands {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();

		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://toolsqa.com/automation-practice-form");

		// Step 3: Select 'Continents' Drop down ( Use Id to identify the
		// element )
		// Find Select element of "Single selection" using ID locator.
		Select oSelect = new Select(driver.findElement(By.id("continents")));

		// Step 4:) Select option 'Europe' (Use selectByIndex)
		oSelect.selectByVisibleText("Europe");

		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Africa' now (Use selectByVisibleText)
		oSelect.selectByIndex(2);
		Thread.sleep(2000);

		// Step 6: Print all the options for the selected drop down and select
		// one option of your choice
		// Get the size of the Select element
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();

		// Setting up the loop to print all the options
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = oSelect.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal
			// to 'Africa" then select it
			if (sValue.equals("Africa")) {
				oSelect.selectByIndex(i);
				break;
			}
		}
		// Kill the browser
		driver.quit();
	}
}