package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtils {

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

}
