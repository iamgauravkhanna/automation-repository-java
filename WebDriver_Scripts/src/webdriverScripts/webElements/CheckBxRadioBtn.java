package webdriverScripts.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBxRadioBtn {

	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();

		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://toolsqa.com/automation-practice-form");

		// Step 3 : Select the deselected Radio button (female) for category Sex
		// (Use IsSelected method)
		// Storing all the elements under category 'Sex' in the list of
		// WebLements
		List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));

		// Create a boolean variable which will hold the value (True/False)
		boolean bValue = false;

		// This statement will return True, in case of first Radio button is
		// selected
		bValue = rdBtn_Sex.get(0).isSelected();

		// This will check that if the bValue is True means if the first radio
		// button is selected
		if (bValue == true) {
			// This will select Second radio button, if the first radio button
			// is selected by default
			rdBtn_Sex.get(1).click();
		} else {
			// If the first radio button is not selected by default, the first
			// will be selected
			rdBtn_Sex.get(0).click();
		}

		// Step 4: Select the Third radio button for category 'Years of Exp'
		// (Use Id attribute to select Radio button)
		WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
		rdBtn_Exp.click();

		// STep 5: Check the Check Box 'Automation Tester' for category
		// 'Profession'( Use Value attribute to match the selection)
		// Find the Check Box or radio button element by Name
		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

		// This will tell you the number of Check Boxes are present
		int iSize = chkBx_Profession.size();

		// Start the loop from first Check Box to last Check Boxe
		for (int i = 0; i < iSize; i++) {
			// Store the Check Box name to the string variable, using 'Value'
			// attribute
			String sValue = chkBx_Profession.get(i).getAttribute("value");

			// Select the Check Box it the value of the Check Box is same what
			// you are looking for
			if (sValue.equalsIgnoreCase("Automation Tester")) {
				chkBx_Profession.get(i).click();
				// This will take the execution out of for loop
				break;
			}
		}
		// Step 6: Check the Check Box 'Selenium IDE' for category 'Automation
		// Tool' (Use cssSelector)
		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		oCheckBox.click();

		// Kill the browser
		driver.quit();

	}

}