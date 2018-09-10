package apachePoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class GetDataFromExcel {

	public Map<String, Integer> getKnownGoodMap(String filePath) {
		String key = "";
		int value = 0;
		// filePath="TestMethodDetails.xls";
		Map<String, Integer> knownGoodMap = new LinkedHashMap<String, Integer>();
		try {

			FileInputStream file = new FileInputStream(new File(filePath));

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						value = (int) cell.getNumericCellValue();
						break;
					case Cell.CELL_TYPE_STRING:
						key = cell.getStringCellValue();
						break;
					}

					if (key != null && value != Integer.MIN_VALUE) {
						knownGoodMap.put(key, value);
						key = null;
						value = Integer.MIN_VALUE;
					}
				}
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return knownGoodMap;
	}

	public static void main(String[] args) {
		GetDataFromExcel details = new GetDataFromExcel();
		System.out.println("Method Details : " + details.getKnownGoodMap("TestMethodDetails.xls"));
	}
}