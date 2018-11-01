package javaExamples.json;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathExample {

	// Reference :
	// https://www.pluralsight.com/blog/tutorials/introduction-to-jsonpath

	public static void main (String [] args ) throws IOException {
		
		DocumentContext documentContextObj = JsonPath.parse(new File("inputFile.json"));
		
		String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
		
		String jsonpathCreatorName = documentContextObj.read(jsonpathCreatorNamePath);
		
		System.out.println("Creator Name : " + jsonpathCreatorName);
		
	}

}
