/*
 * @Author : Gaurav Khanna 
 */

package webdriverScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class CanExecute {

	@Test
	public void testCanExecute() {
		try {

			System.out.println(FileHandler.canExecute(new File(
					"C:\\gaurav\\test.txt")));

			FileHandler.makeExecutable(new File("C:\\gaurav\\test.txt"));

			System.out.println(FileHandler.canExecute(new File(
					"C:\\gaurav\\test.txt")));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
