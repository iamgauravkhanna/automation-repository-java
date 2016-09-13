package dataDrivenScriptWithMaps;

import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(monochrome = true, format = { "pretty", "html:target/cucumber", "json:target/Cucumber.json",
		"junit:target/Cucumber.xml" })

public class RunCucumberTest {
}