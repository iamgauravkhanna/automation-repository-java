package org.gtg.raftaar.utils;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtils {

	public static void printHashMapValues(HashMap<String, String> mapObj) {

		System.out.println("Calling Method : printHashMapValues() ");

		int counter = 1;

		for (Entry<String, String> entry : mapObj.entrySet()) {

			System.out.println("Entry #" + counter + " : " + entry.getKey() + " => " + entry.getValue());

			counter++;

		}

	}

	public static String generateEmail() {
		return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz") + "@" + "mailinator.com";
	}

	public static String replaceVariable(String templateString) {

		StrSubstitutor sub = new StrSubstitutor(BasePage.propertiesMap);

		String resolvedString = sub.replace(templateString);

		return resolvedString;

	}

}
