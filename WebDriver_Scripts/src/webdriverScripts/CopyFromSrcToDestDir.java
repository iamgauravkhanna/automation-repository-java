/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CopyFromSrcToDestDir {

	@Test
	public void testCopyFromSrcToDestDir() {

		try {

			FileHandler.copy(new File("C:\\gaurav\\Screenshots"), new File("C:\\gaurav\\"));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
