package webdriverScripts.others;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Iterator;

import java.util.NoSuchElementException;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver.Navigation;

import org.openqa.selenium.WebDriver.Options;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;

import com.google.common.base.Predicate;

//import org.openqa.selenium.*;

//import org.openqa.selenium.firefox.*;

public class FindBrokenLinks {

/*	public static List findAllLinks(WebDriver driver)

	{

		List elementList = new ArrayList();

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		List finalList = new ArrayList();
		;

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null)

			{

				finalList.add(element);

			}

		}

		return finalList;

	}

	public static String isLinkBroken(URL url) throws Exception

	{

		// url = new URL("http://yahoo.com");

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

			connection.connect();

			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{

			return exp.getMessage();

		}

	}

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

		FirefoxDriver ff = new FirefoxDriver();

		ff.get("http://toolsqa.com/automation-practice-switch-windows/");

		// ff.get("http://www.yahoo.com/");

		List allImages = findAllLinks(ff);

		System.out.println("Total number of elements found " + allImages.size());
		
		WebElement value1 = (WebElement) allImages;

		for (WebElement element : value1 ) {

			try

			{

				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));

				// System.out.println("URL: " +
				// element.getAttribute("outerhtml")+ " returned " +
				// isLinkBroken(new URL(element.getAttribute("href"))));

			}

			catch (Exception exp)

			{

				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());

			}

		}

	}*/

}