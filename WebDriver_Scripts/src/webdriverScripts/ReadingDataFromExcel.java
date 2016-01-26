/*********************************
 
Title  : Reading Data From Excel
Author : Gaurav Khanna

 *********************************/

package webdriverScripts;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class ReadingDataFromExcel {

	@Test
	public void testreadingDataFromExcel() throws BiffException, IOException {

		// Creating File Object
		FileInputStream f = new FileInputStream(
				"C:\\gk\\code\\selenium\\sample\\sample1.xls");

		// Reading File as WorkBook
		Workbook wb = Workbook.getWorkbook(f);

		// Reading Sheet by Name
		Sheet sheet = wb.getSheet("register");

		int r = sheet.getRows();
		int c = sheet.getColumns();

		// Printing Total Number of Rows and Coloumns
		System.out.println("Total Rows : " + r);
		System.out.println("Total Coloumns : " + c);

		for (int rows = 0; rows < sheet.getRows(); rows++) {
			for (int cols = 0; cols < sheet.getColumns(); cols++) {
				// Print all the Values present in Excel Sheet
				System.out.println("(" + rows + "," + cols + ") : "
						+ sheet.getCell(cols, rows).getContents() + "\t");
			}
		}

	}

}
