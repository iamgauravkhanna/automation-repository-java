package javaExamples.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Program to read from file line by line

public class ReadFileLineByLine {

	private static BufferedReader bufferedReaderObj;
	
	private static StringBuffer stringBufferObj;

	public static void main(String args[]) throws IOException {

		FileReader fileReaderObj = new FileReader("C:\\app\\dataFile.txt");

		bufferedReaderObj = new BufferedReader(fileReaderObj);

		stringBufferObj = new StringBuffer();

		// First Line will be skipped as we have called readLine method
		while (bufferedReaderObj.readLine() != null) {

			stringBufferObj.append(bufferedReaderObj.readLine());

			stringBufferObj.append(" ");

		}

		System.out.println(stringBufferObj);

	}

}
