package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JunitAnnotations.class, Assertions.class,
		Parameterization.class })
public class TestSuite {

}
