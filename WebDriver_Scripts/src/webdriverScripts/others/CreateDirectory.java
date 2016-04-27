/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts.others;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CreateDirectory {

	@Test
	public void testCreateDirectory() {

		try {

			FileHandler.createDir(new File("C:\\gaurav\\SelDir"));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
