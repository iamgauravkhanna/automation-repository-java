package utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVUtils {

	Reader readerObj;
	CSVParser csvParserObj;

	public static void main(String[] args) {

		CSVUtils csvUtilsObj = new CSVUtils(
				System.getProperty("user.dir") + "\\src\\test\\resources\\test-data\\test-data.csv");

	}

	public CSVUtils(String filePath) {

		try {
			readerObj = Files.newBufferedReader(Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			csvParserObj = new CSVParser(readerObj, CSVFormat.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (CSVRecord csvRecordObj : csvParserObj) {

			System.out.println(
					"Row No => " + csvRecordObj.getRecordNumber() + " & Value of Coloumn => " + csvRecordObj.get(0));
			
			System.out.println(
					"Row No => " + csvRecordObj.getRecordNumber() + " & Value of Coloumn => " + csvRecordObj.get(1));
			
			System.out.println(
					"Row No => " + csvRecordObj.getRecordNumber() + " & Value of Coloumn => " + csvRecordObj.get(2));

		}
	}

}
