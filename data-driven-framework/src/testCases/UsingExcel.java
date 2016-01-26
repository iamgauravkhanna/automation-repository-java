/*
 * @Author : Gaurav Khanna 
 */

package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testUtils.ExcelUsingApachePOI;

public class UsingExcel {

	WebDriver webDriver;

	public String baseUrl;

	public String fileLocation = System.getProperty("user.dir")
			+ "\\src\\testData\\Core.xlsx";

	@Test
	public void testusingExcel() {

		webDriver = new FirefoxDriver();

		baseUrl = "http://www.wikipedia.org/";

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		webDriver.get(baseUrl + "/wiki/Main_Page");

		ExcelUsingApachePOI excelObject = new ExcelUsingApachePOI(fileLocation);

		for (int i = 1; i < excelObject.getRowCount("country"); i++) {

			String countryName = excelObject.getCellData("country", 0, i);

			webDriver.findElement(By.id("searchInput")).clear();

			webDriver.findElement(By.id("searchInput")).sendKeys(countryName);

			webDriver.findElement(By.id("searchButton")).click();

			String str = webDriver.findElement(
					By.xpath("//h1[@id='firstHeading']/span")).getText();

			System.out.println(countryName);

			Assert.assertTrue(str.contains(countryName));

		}

	}
}