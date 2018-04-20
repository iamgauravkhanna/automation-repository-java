package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {

	public static void main(String args[]) {

		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss_aa");

		String outputDirectory = "test-output/html/screenshots/" + dateFormat.format(new Date());
		
		System.out.println(outputDirectory);

		File dir = new File(outputDirectory);

		// attempt to create the directory here
		boolean successful = dir.mkdir();

		if (successful) {
			// creating the directory succeeded
			System.out.println("directory was created successfully");
		} else {
			// creating the directory failed
			System.out.println("failed trying to create the directory");
		}
	}

}
