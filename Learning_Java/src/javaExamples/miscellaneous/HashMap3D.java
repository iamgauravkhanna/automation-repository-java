package javaExamples.miscellaneous;

import java.util.*;

import org.junit.Test;

public class HashMap3D {

	public HashMap3D() {
		super();
		this.c = new HashMap<String, HashMap<String, HashMap<String, String>>>();
		;
		this.b = new HashMap<String, HashMap<String, String>>();
		;
		this.a = new HashMap<String, String>();
		;
	}

	HashMap<String, HashMap<String, HashMap<String, String>>> c;
	HashMap<String, HashMap<String, String>> b;
	HashMap<String, String> a;

	@Test
	public void testabc() {

		// Storing a map
		a.put("comments", "Get proposal link from database");
		b.put("Step6", a);

		a.put("object", "//a[text()='Broker Packages']");
		b.put("Step5", a);

		a.put("action", "click");
		b.put("Step4", a);

		a.put("data", "abc");
		b.put("Step3", a);

		a.put("iteration", "1");
		b.put("Step2", a);
		c.put("1", b);

		a.put("flag", "skip");
		b.put("Step1", a);
		c.put("1", b);

		// Retrieving a map and its values

		String coloumn = c.get("1").get("Step1").toString();
		String value = c.get("1").get("Step2").get("iteration").toString();
		System.out.println(" Retreived value is : " + value);
	}

}