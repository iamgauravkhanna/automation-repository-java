package raftaar.testautomation.utlities;

import java.util.HashMap;

import org.testng.annotations.Test;

public class DataDictionary {

	public HashMap<String, String> dictionary;

	public DataDictionary() {

		super();

		this.dictionary = new HashMap<String, String>();

		System.out.println("Hash Map initialized using Constructor");
	}

	@Test
	public void foo() {

		dictionary.put("description", "Hello World");

		System.out.println("Value of Key is : " + dictionary.get("description"));

	}
}
