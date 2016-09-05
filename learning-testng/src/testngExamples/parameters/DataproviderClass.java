package testngExamples.parameters;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] { { "James", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };

	}
}
