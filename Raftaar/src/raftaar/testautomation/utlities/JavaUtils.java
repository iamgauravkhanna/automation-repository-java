package raftaar.testautomation.utlities;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class JavaUtils {

	private static SecureRandom random = new SecureRandom();

	/**
	 * Extract numeric characters from a string
	 * E.g. gets 30 from $30
	 * 
	 * @param inputString input string from which numbers needs to be extracted
	 * @return float retrieved from the string
	 */
	public static String getNumbersFromString(String inputString)
	{
		String outValue = "";
		for (char c : inputString.toCharArray())
		{
			if ((c >= '0' && c <= '9') || (c == '.'))
				outValue = outValue + c;
			else if (outValue.length() > 0 && (c == ' ')) break;
		}
		try
		{
			// return Float.parseFloat(outValue);
			return outValue;
		} catch (NumberFormatException e)
		{
			if (e.getMessage().toLowerCase().contains("empty string"))
			{
				// return (float) 0.00;
				return "0.00";
			} else
			{
				throw e;
			}
		}
	}

	public static boolean assertEqual(float actual, float expected) throws Exception {
		if (!(actual == expected))
			throw new Exception("expected [" + expected + "] but found [" + actual + "]");
		return true;
	}

	public static boolean assertEqual(String actual, String expected, String options) throws Exception {
		actual = normalizeForAssertion(actual, options);
		expected = normalizeForAssertion(expected, options);
		if (options != null && (options.contains("{partmatch}") || options.contains("{partialmatch}"))) {
			return assertContains(actual, expected, options);
		}

		if (!actual.equals(expected))
			throw new Exception("expected [" + expected + "] but found [" + actual + "]");
		return true;
	}

	public static String normalizeForAssertion(String toNormalize, String options) {
		if (options != null && options.contains("{ignorecase}")) {
			toNormalize = toNormalize.toLowerCase();
		}

		if (options != null && options.contains("{ignorespace}")) {
			toNormalize = toNormalize.replace(" ", "");
		}

		return toNormalize;
	}

	public static boolean assertContains(String actual, String expected) throws Exception {
		if (!actual.contains(expected))
			throw new Exception("expected [" + expected + "] NOT found in [" + actual + "]");
		return true;
	}

	public static boolean assertContainsNot(String actual, String expected) throws Exception {
		if (actual.contains(expected))
			throw new Exception("expected [" + expected + "] WAS FOUND in [" + actual + "]");
		return true;
	}

	public static boolean assertContains(String actual, String expected, String options) throws Exception {
		actual = normalizeForAssertion(actual, options);
		expected = normalizeForAssertion(expected, options);

		if (!actual.contains(expected))
			throw new Exception("expected [" + expected + "] NOT found in [" + actual + "]");
		return true;
	}

	/**
	 * Generate random string of length x
	 * 
	 * @return
	 */
	public static String getRandomString(int length) {
		String result = new BigInteger(Long.SIZE * length, random).toString(32);
		return result.substring(0, length);
	}

	public static volatile HashMap<String, String> additionalParams = new HashMap<String, String>();

	/**
	 * Replaces variables in a string, keys being stored in the dictionary
	 * passed As a special feature in automation framework, we could write
	 * something like this in test data column AssertTextPresent Welcome, Anil
	 * Kumar! OR Welcome, ${username}! OR simply--> #username! Now, username
	 * varible would represent runtime actual name of the user who has logged in
	 * or recently registered
	 * 
	 * @param tobeReplaced
	 *            String that contains variables, usually from testdata column
	 * @param variablesDictionary
	 *            Dictionary that holds all know variables
	 * @return String after replacing all known variables
	 * @throws Exception
	 */
	public static String replaceVariablesInString(String tobeReplaced, HashMap<String, String> variablesDictionary)
			throws Exception {
		if (tobeReplaced == null)
			tobeReplaced = "";

		variablesDictionary.remove("");

		// Variables in a string are defined by ${varname}
		if (!(tobeReplaced.contains("${") || tobeReplaced.contains("#")))
			return replaceCharsInString(tobeReplaced);
		else {
			// Ensure there is no possibility of infinite looping
			/*
			 * for (Entry<String, String> keyPair :
			 * variablesDictionary.entrySet()) { String keyName=
			 * keyPair.getKey().toLowerCase(); String keyValue=
			 * keyPair.getValue().toLowerCase(); if(keyValue.contains("#" +
			 * keyName)) throw new Exception("Variable #" + keyName +
			 * "'s value contains itself, which will cause infinite looping. Please fix usage of variable in test case."
			 * ); }
			 */
		}

		String beforeReplacement = tobeReplaced;
		while (true && tobeReplaced.contains("${")) {
			String[] part1 = tobeReplaced.split("\\$\\{");
			for (int i = 0; i < part1.length; i++) {
				String varName = part1[i].split("\\}")[0];
				if (variablesDictionary.containsKey(varName.toLowerCase().trim())) {
					String varValue = variablesDictionary.get(varName.toLowerCase().trim());
					tobeReplaced = tobeReplaced.replace("${" + varName + "}", varValue);
				}
			}

			// If there was even a single replacement done, its possible that
			// variables could be holding other variables
			if (beforeReplacement.equals(tobeReplaced))
				break;
			else
				beforeReplacement = tobeReplaced;
		}

		// Since now we have two ways of using variables, addition one being
		// just by prefixing #
		if (!tobeReplaced.contains("#")) {
			return replaceCharsInString(tobeReplaced);
		}
		// List<String> sortedKeyList =
		// getSortedListByKeys(variablesDictionary);

		beforeReplacement = tobeReplaced;
		int triedCounter = 0;
		int maxTries = StringUtils.countMatches(tobeReplaced, "#") * 50;

		// First of all, check if there is an exact match
		if (tobeReplaced.startsWith("#")) {
			String possibleKey = tobeReplaced.substring(1).toLowerCase();
			if (variablesDictionary.containsKey(possibleKey))
				tobeReplaced = variablesDictionary.get(possibleKey);
			else if (additionalParams.containsKey(possibleKey))
				tobeReplaced = additionalParams.get(possibleKey);
		}

		// try replacing with default dictionary
		for (triedCounter = 0; triedCounter < maxTries; triedCounter++) {
			System.out.println("tobeReplaced : " + tobeReplaced);
			if (!tobeReplaced.contains("#"))
				break;

			// Try first with local dictionary
			tobeReplaced = replaceStringByPrefixChar("[", tobeReplaced, variablesDictionary);

			if (!tobeReplaced.contains("[#"))
				tobeReplaced = replaceStringByPrefixChar("", tobeReplaced, variablesDictionary);// variablesDictionary.size();

			// If there was even a single replacement done, its possible that
			// variables could be holding other variables
			if (beforeReplacement.equals(tobeReplaced))
				break;
			else
				beforeReplacement = tobeReplaced;
		}

		// if it wasn't possible to replace with default dictionary, try with
		// additiona parameters
		HashMap<String, String> allParameters = new HashMap<>();
		for (triedCounter = 0; triedCounter < maxTries; triedCounter++) {
			if (triedCounter == 0) {
				allParameters.putAll(additionalParams);
				allParameters.putAll(variablesDictionary);
			}

			if (!tobeReplaced.contains("#"))
				break;

			// Try first with local dictionary
			tobeReplaced = replaceStringByPrefixChar("[", tobeReplaced, allParameters);

			if (!tobeReplaced.contains("[#"))
				tobeReplaced = replaceStringByPrefixChar("", tobeReplaced, allParameters);

			// If there was even a single replacement done, its possible that
			// variables could be holding other variables
			if (beforeReplacement.equals(tobeReplaced))
				break;
			else
				beforeReplacement = tobeReplaced;
		}

		// System.out.println("Took " + (System.currentTimeMillis() - startTime)
		// + "ms to replace variables in org:" + originalString + " to: "
		// + tobeReplaced + " with " + triedCounter + " loops.");
		return replaceCharsInString(tobeReplaced);
	}

	private static String replaceCharsInString(String tobeReplaced) {
		// Neutralize line feeds
		tobeReplaced = tobeReplaced.replaceAll("\r\n|\r|\n", "\n");
		tobeReplaced = tobeReplaced.replace("{PIPE}", "|");
		return tobeReplaced;
	}

	private static String replaceStringByPrefixChar(String prefixChar, String tobeReplaced,
			HashMap<String, String> variablesDictionary) throws Exception {
		if (!tobeReplaced.contains(prefixChar + "#"))
			return tobeReplaced;

		List<String> sortedKeyList = getSortedListByKeys(variablesDictionary, tobeReplaced.length());// variablesDictionary.size();

		for (String key : sortedKeyList) {
			String varName = "#" + key.toLowerCase();
			if (tobeReplaced.toLowerCase().contains(prefixChar + varName)) {
				int startIndex = tobeReplaced.toLowerCase().indexOf(varName);
				int endIndex = startIndex + varName.length();

				// Extract the way variable is exactly used in the string/ data
				// This way, we are able to perform case insensitive
				// replacements
				String varNameInString = new String(tobeReplaced.substring(startIndex, endIndex));
				String varValueInDictionary = variablesDictionary.get(key);

				// If value of a variable contains itself, we need to see
				// possibility of replacing other variables first
				// Do this only when there are more variables than the current
				// one
				if ((varValueInDictionary.toLowerCase().contains(varNameInString.toLowerCase())
						&& StringUtils.countMatches(varValueInDictionary, "#") > StringUtils
								.countMatches(varValueInDictionary.toLowerCase(), varName))) {
					// Create a copy of dictionary and remove current key
					// @SuppressWarnings("unchecked")
					HashMap<String, String> reducedParams = new HashMap<String, String>();
					reducedParams.putAll(variablesDictionary);
					reducedParams.remove(key);
					varValueInDictionary = replaceVariablesInString(varValueInDictionary, reducedParams);
					reducedParams.clear();
				}

				// if a key contains itself, it will lead us to infinite looping
				// so, we'll replace variable in that case
				// Also, if no # is there in var value, we're good to go
				if ((!varNameInString.toLowerCase().contains("#" + varValueInDictionary.toLowerCase())
						|| varValueInDictionary.isEmpty()) || !varNameInString.equalsIgnoreCase(tobeReplaced)
						|| !varValueInDictionary.contains("#")) {
					tobeReplaced = tobeReplaced.replace(varNameInString, varValueInDictionary);
				}

				break;
			}
			varName = null;
			key = null;
		}

		sortedKeyList.clear();
		return tobeReplaced;
	}

	public static List<String> getSortedListByKeys(HashMap<String, String> keysDictionary, int maxKeyLength) {
		if (keysDictionary == null || keysDictionary.size() == 0) {
			return Collections.emptyList();
		}

		List<String> sortedKeysList = new ArrayList<>();
		sortedKeysList.addAll(keysDictionary.keySet());
		/*
		 * for (String key : keysDictionary.keySet()) { if (key.length() <=
		 * maxKeyLength || maxKeyLength < 0) sortedKeysList.add(key); }
		 */

		Collections.sort(sortedKeysList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s2.length(), s1.length());
			}
		});

		return sortedKeysList;
	}

	/**
	 * Generates a random string of specified length
	 * 
	 * @param length no of characters in the string to be generated
	 * @return a random string
	 */
	public static synchronized String generateUniqueString(int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	protected static List<String> convertStringToList(String pattern)
	{
		String strArr[] = pattern.split("\\|");
		List<String> list = Arrays.asList(strArr);
		return list;
	}
		
}
