/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CopySimilarFilesFromSrcToDestDir {

	@Test
	public void testCopySimilarFilesFromSrcToDestDir() {

		try {

			FileHandler.copy(new File("C:\\Src\\"), new File("C:\\Dest\\"),
					".txt");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}