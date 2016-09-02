package webdriverScripts.others;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeTable_2 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-table");
		String sRow = "1";
		String sCol = "2";

		// Here we are locating the xpath by passing variables in the xpath
		String sCellValue = driver
				.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
		System.out.println(sCellValue);
		String sRowValue = "Clock Tower Hotel";

		// First loop will find the 'ClOCK TWER HOTEL' in the first column
		for (int i = 1; i <= 5; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
			if (sValue.equalsIgnoreCase(sRowValue)) {
				// If the sValue match with the description, it will initiate
				// one more inner loop for all the columns of 'i' row
				for (int j = 1; j <= 5; j++) {
					String sColumnValue = driver
							.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText();
					System.out.println(sColumnValue);
				}
				break;
			}
		}
		driver.close();
	}
}