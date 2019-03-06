package web.project01.automationpractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataDictionary;
import utils.DriverFactory;
import utils.DriverManager;
import web.project01.automationpractice.pageObject.Home;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class Feature001 extends BaseTest {

	ThreadLocal<Home> homePageObj = new ThreadLocal<Home>();

	@Test
	public void TC_001() {

		homePageObj.set(new Home(webDriverPool.get()));
		homePageObj.get().openHomePage();
		homePageObj.get().clickContactUs();
		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "001");

	}

	@Test
	public void TC_002() {

		homePageObj.set(new Home(webDriverPool.get()));
		homePageObj.get().openHomePage();
		homePageObj.get().clickContactUs();
		DataDictionary.getInstance().putKey("TC_ID", "002");

	}

	@Test
	public void TC_003() {

		homePageObj.set(new Home(webDriverPool.get()));
		homePageObj.get().openHomePage();
		homePageObj.get().clickContactUs();
		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "003");

	}

}