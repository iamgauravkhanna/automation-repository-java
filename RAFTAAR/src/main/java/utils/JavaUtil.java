package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class JavaUtil {

	public static void printHashMapValues(HashMap<String, String> mapObj) {

		LogUtils.info("Calling Method : printHashMapValues() ");

		int counter = 1;

		for (Entry<String, String> entry : mapObj.entrySet()) {

			LogUtils.info("Entry #" + counter + " : " + entry.getKey() + " => " + entry.getValue());

			counter++;

		}

	}

	public static String generateEmail() {

		return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz") + "@" + "mailinator.com";
	}

	public static String generateRandomString() {

		return RandomStringUtils.randomAlphabetic(10);

	}

	public static String generateRandomNumber(int i) {

		return RandomStringUtils.randomNumeric(i);

	}

	/**
	 * 
	 * Replace variable provided
	 * 
	 * @param templateString
	 * 
	 * @return
	 * 
	 */
	public static String replaceVariable(String templateString) {

		StrSubstitutor sub = new StrSubstitutor(BasePage.propertiesMap);

		String resolvedString = sub.replace(templateString);

		return resolvedString;

	}

	public static String getTimeStamp() {

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");

		String timeStamp = dateFormat1.format(new Date());

		return timeStamp;

	}

	public static void createDirectory(String directoryName) {

		LogUtils.info("Directory Created : " + directoryName);

		File dir = new File(directoryName);

		// attempt to create the directory here
		boolean successful = dir.mkdir();

		if (successful) {

			// creating the directory succeeded
			LogUtils.info("directory was created successfully");

		} else {

			// creating the directory failed
			LogUtils.info("failed trying to create the directory");
		}

	}

	public static void takeScreenShot(WebDriver webDriverObj) {

		// Set folder name to store screenshots.
		String destDir = "screenshots";

		// Capture screenshot.
		File scrFile = ((TakesScreenshot) webDriverObj).getScreenshotAs(OutputType.FILE);

		// Set date format to set It as screenshot file name.
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh-mm-ss-aa");

		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();

		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {

			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static boolean assertEqual(String actual, String expected) throws Exception {

		if (!actual.equals(expected))
			throw new Exception("expected [" + expected + "] but found [" + actual + "]");
		return true;
	}

	public static void readTestDataFiles(String workBookName, String sheetName, int rowNumber) {

		LogUtils.info("Entered readTestDataFiles Method");

		ExcelUtils excelUtilsObj = new ExcelUtils("./src/test/resources/test-data/" + workBookName);

		LogUtils.info("Entering into the Loop...");

		for (int i = 0; i < excelUtilsObj.getColumnCount(sheetName); i++) {

			LogUtils.info("In the Loop...");

			String key = excelUtilsObj.getColumnName(i, sheetName);

			LogUtils.info("Key = " + key);

			String value = excelUtilsObj.getCellData(sheetName, rowNumber, key);

			LogUtils.info("Value = " + value);

			BaseTest.baseTestHashMapObj.put(key, value);

		}

		LogUtils.info("Exited the Loop....");

	}

	public static String getCurrentDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Date date = new Date();

		return formatter.format(date);

	}

	public static String getCurrentTimeStamp() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");

		Date date = new Date();

		return formatter.format(date);

	}

	public static void writeToFileApacheCommonIO(File file, String msg) {
		
		try {
			//FileUtils.writeStringToFile(file, msg, true);
			FileUtils.writeStringToFile(file, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}