package dataDrivenScriptWithDataTables;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(name = { "pretty", "html:target/cucumber" })

public class RunCucumberTest {
}