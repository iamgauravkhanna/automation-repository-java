/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CopyResource {

	@Test
	public void testCopyResource() {

		try {

			FileHandler.copyResource(new File("C:\\gaurav\\"),
					FileHandler.class, "C:\\gaurav\\test.txt");

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
