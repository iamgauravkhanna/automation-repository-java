package testngExamples.testNG;

import java.util.ArrayList;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	private Collection<String> collection;

	@BeforeClass
	public void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@BeforeMethod
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@BeforeMethod - setUp");
	}

	@AfterMethod
	public void tearDown() {
		collection.clear();
		System.out.println("@AfterMethod - tearDown");
	}

	@Test
	public void testEmptyCollection() {
		Assert.assertEquals(collection.isEmpty(), true);
		System.out.println("@Test - testEmptyCollection");
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		Assert.assertEquals(collection.size(), 1);
		System.out.println("@Test - testOneItemCollection");
	}
}
