package javaExamples.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractContent {

	public static void main(String args[]) {

		String in = "{#Alpha}{Beta}{testSheet=James}{skip}{nowait}";

		Pattern p = Pattern.compile("\\{(.*?)\\}");
		Matcher m = p.matcher(in);

		while (m.find()) {
			System.out.println(m.group(1));
		}
	}

}