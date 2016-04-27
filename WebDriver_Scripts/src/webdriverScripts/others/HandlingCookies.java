package webdriverScripts.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingCookies {

	/**
	 * Add Cookie
	 * 
	 * Method Name: addCookie(Cookie cookie)
	 * Syntax:driver.manage().addCookie(arg0); Purpose: To add a specific cookie
	 * into cookies. If the cookie's domain name is left blank, it is assumed
	 * that the cookie is meant for the domain of the current document.
	 * Parameters: cookie - The name of the cookie to add. Click here for
	 * example program
	 * 
	 * Delete Cookie Method Name: deleteCookie(Cookie cookie) Syntax:
	 * driver.manage().deleteCookie(arg0); Purpose: Delete a cookie from the
	 * browser's "cookie jar". The domain of the cookie will be ignored.
	 * Parameter: Cookie Click here for example program
	 * 
	 * Delete Cookie with Name Method Name: deleteCookieNamed(java.lang.String
	 * name) Syntax: driver.manage().deleteCookieNamed(arg0); Purpose: Delete
	 * the named cookie from the current domain. This is equivalent to setting
	 * the named cookie's expiry date to sometime in the past. Parameters: name
	 * - The name of the cookie to delete Click here for example program
	 * 
	 * Delete All Cookies Method Name: deleteAllCookies() Syntax:
	 * driver.manage().deleteAllCookies(); Purpose: It will delete all the
	 * cookies for the current domain. Parameters: N/A Click here for example
	 * program
	 * 
	 * Get Cookies Method Name: getCookies() Syntax:
	 * driver.manage().getCookies(); Purpose: Get all the cookies for the
	 * current domain. This is the equivalent of calling "document.cookie" and
	 * parsing the result. Returns: A Set of cookies for the current domain.
	 * 
	 * Get the Cookie with Specific Name Method Name:
	 * getCookieNamed(java.lang.String name) Syntax:
	 * driver.manage().getCookieNamed(arg0); Purpose: To Get a cookie with a
	 * given name. Parameters: name - the name of the cookie Returns: It will
	 * return the cookie value for the name specified, or null if no cookie
	 * found with the given name
	 */

	WebDriver webDriver;

	@Test
	public void testbasicScript2() {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		String baseUrl = "http://www.webmath.com/";
		
		// Open the link
		webDriver.get(baseUrl);
		
		//Add Cookie
		webDriver.manage().addCookie(null);
	}
}
