/*
 *
 * @Author : Gaurav Khanna
 * 
 */

package webdriverScripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class HandlingOnlineWebTables1 {

	// Declaring Variables

	int rowcount = 0;

	WebDriver webDriver;

	String baseUrl;

	String start;

	String mid;

	String end;

	String x;

	@Test

	public void testhandlingOnlineWebTables1() throws InterruptedException {

		// Initializing FireFox Driver

		webDriver = new FirefoxDriver();

		// Assigning URL to variable `baseUrl`

		baseUrl = "http://www.espncricinfo.com/icc_cricket_worldcup2011/engine/match/473326.html";

		// Calling the baseUrl

		webDriver.get(baseUrl);

		// Maximizing the window

		webDriver.manage().window().maximize();

		// Storing the first part of xPath leaving the row number

		start = "//*[@id='inningsBat1']/tbody/tr[";

		// Storing the last part of xPath leaving the row number

		end = "]/td[2]";

		Thread.sleep(3000L);

		// Starting the loop from 1 till last number number of row

		for (int i = 1; i <= 17; i = i + 1) {

			// Storing text

			x = webDriver.findElement(By.xpath(start + i + end)).getText();

			// Incrementing rowcount variable

			rowcount++;

			// Printing text

			System.out.println(x);

		}

		// Printing total number of rows in Web Table

		System.out.println("Total Number of Rows : " + rowcount);

		// This will close the browser

		webDriver.quit();

	}

}