package others;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class ReadFileExample {

	public static void main(String[] args) throws IOException {

		File file = new File("C://Selenium//Raftaar//assets//sql//GetConfigElementKeyStatus.sql");

		try (FileInputStream fis = new FileInputStream(file)) {

			System.out.println("Total file size to read (in bytes) : "+ fis.available());
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				//System.out.print((char) content);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//String content = readFile("C://Selenium//Raftaar//assets//sql//GetConfigElementKeyStatus.sql", StandardCharsets.UTF_8);
		
		// http://abhinandanmk.blogspot.in/2012/05/java-how-to-read-complete-text-file.html
		String str = FileUtils.readFileToString(new File("C://Selenium//Raftaar//assets//sql//GetConfigElementKeyStatus.sql"));
		
		System.out.println("SQL Query is :" + str) ;
	}
}