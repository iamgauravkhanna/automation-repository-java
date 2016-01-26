/*********************************
 
Title  : Handling Text Files
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class HandlingTextFiles {

	private BufferedWriter out;
	private BufferedReader bfr;

	@Test
	public void testhandlingTextFiles() throws IOException {

		// creating
		File f = new File("C:\\testing\\temp.txt");

		//
		f.createNewFile();

		// writing
		FileWriter w = new FileWriter("C:\\testing\\temp.txt");

		out = new BufferedWriter(w);

		//
		out.write("hello we are writing in a file");

		//
		out.newLine();

		//
		out.write("This is a new line");

		//
		out.flush();

		// reading
		FileReader r = new FileReader("C:\\testing\\temp.txt");

		bfr = new BufferedReader(r);

		//
		String x = "";

		//
		System.out.println(bfr.readLine());

		//
		while ((x = bfr.readLine()) != null) {

			//
			System.out.println(x);
		}

	}

}
