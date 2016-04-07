package testNG;

import org.testng.annotations.*;

public class TimeOut {

	@Test(timeOut = 5000)
	public void infinity() {
		while (true)
			;
	}

}
