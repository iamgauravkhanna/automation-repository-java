package raftaar.testautomation.main;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class SuiteRunner {

	public static void main(String args[]) {

		TestNG tng = new TestNG();

		List<String> suites = Lists.newArrayList();

		suites.add(
				"C:\\office\\code\\github\\automation-repository-java\\raftaar-pom-flavour\\src\\test\\resources\\suites\\webTestSuite.xml");

		tng.setTestSuites(suites);

		tng.run();

	}
}