package javaExamples.interviewRecipes;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class replacingVariables {

	public static void main(String args[]) {

		Map<String, String> valuesMap = new HashMap<String, String>();

		valuesMap.put("animal", "quick brown fox");

		valuesMap.put("target", "lazy dog");

		String templateString = "The ${animal} jumped over the ${target}.";

		StrSubstitutor sub = new StrSubstitutor(valuesMap);

		String resolvedString = sub.replace(templateString);

		System.out.println("Before Replacement" + templateString);

		System.out.println("After Replacement" + resolvedString);

	}

}
