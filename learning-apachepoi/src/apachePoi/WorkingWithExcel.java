package apachePoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithExcel {

	public String excelFilePath;
	public FileInputStream fileInputStreamObj = null;
	public FileOutputStream fileOutputStreamObj = null;
	private XSSFWorkbook xssfWorkbookObj = null;
	private XSSFSheet xssfSheetObj = null;
	private XSSFRow xssRowObj = null;
	private XSSFCell xssCellObj = null;

	/**
	 * 
	 * Constructor to Initialize File
	 * 
	 * @param excelFilePath
	 */
	public WorkingWithExcel(String excelFilePath) {

		System.out.println("Constructor to Intialize Excel File");

		this.excelFilePath = excelFilePath;

		try {

			System.out.println("File Path => " + excelFilePath);

			fileInputStreamObj = new FileInputStream(excelFilePath);

			xssfWorkbookObj = new XSSFWorkbook(fileInputStreamObj);

			// xssfSheetObj = xssfWorkbookObj.getSheetAt(0);

			fileInputStreamObj.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Main Program of Excel Util Class
	 * 
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String arg[]) throws IOException {

		WorkingWithExcel excelUtilsObj = null;

		excelUtilsObj = new WorkingWithExcel(
				System.getProperty("user.dir") + "\\src\\test\\resources\\test-data\\test-data.xlsx");

		System.out.println("Total No. of Sheets => " + excelUtilsObj.getSheetCount());

		System.out.println("Sheet Name at position 1 => " + excelUtilsObj.getSheetName(0));

		System.out.println("Value of Cell at (Row,Coloumn) - (2,2) => " + excelUtilsObj.getCellData("signup", 2, 2));

		System.out.println("Value of Cell at (Row,Coloumn) - (2,companyname) => "
				+ excelUtilsObj.getCellData("signup", 2, "companyname"));

		System.out.println("Name of Coloumn => " + excelUtilsObj.getColumnName(3, "signup"));

		System.out.println("Total No. of Rows => " + excelUtilsObj.getRowCount("signup"));

	}

	// Get Sheet Count present in workbook
	public int getSheetCount() {

		int index = xssfWorkbookObj.getNumberOfSheets();

		if (index == -1) {
			return 0;
		} else {
			return index;
		}
	}

	// Sheet Number will start from 0 as its using it in index
	public String getSheetName(int SheetNumber) {

		return xssfWorkbookObj.getSheetName(SheetNumber);

	}

	// Coloumn and Row number passed will be change to (n-1) to make this user
	// friendly
	public String getCellData(String sheetName, int rowNum, int colNum) {

		try {

			if (rowNum <= 0) {
				return "";
			}

			int index = xssfWorkbookObj.getSheetIndex(sheetName);

			if (index == -1) {
				return "";
			}

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);

			xssRowObj = xssfSheetObj.getRow(rowNum - 1);

			if (xssRowObj == null) {
				return "";
			}

			xssCellObj = xssRowObj.getCell(colNum);

			if (xssCellObj == null) {
				return "";
			}

			if (xssCellObj.getCellType() == Cell.CELL_TYPE_STRING) {
				return xssCellObj.getStringCellValue();
			} else if (xssCellObj.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| xssCellObj.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(xssCellObj.getNumericCellValue());

				if (DateUtil.isCellDateFormatted(xssCellObj)) {

					// format in form of M/D/YY
					double d = xssCellObj.getNumericCellValue();

					Calendar cal = Calendar.getInstance();

					cal.setTime(DateUtil.getJavaDate(d));

					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);

					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

				}

				return cellText;
			} else if (xssCellObj.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			} else {
				return String.valueOf(xssCellObj.getBooleanCellValue());
			}
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	// returns the data from a cell
	public String getCellData(String sheetName, int rowNum, String colName) {
		try {
			if (rowNum <= 0)
				return "";

			int index = xssfWorkbookObj.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);
			xssRowObj = xssfSheetObj.getRow(0);
			for (int i = 0; i < xssRowObj.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (xssRowObj.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);
			xssRowObj = xssfSheetObj.getRow(rowNum - 1);
			if (xssRowObj == null)
				return "";
			xssCellObj = xssRowObj.getCell(col_Num);

			if (xssCellObj == null)
				return "";

			if (xssCellObj.getCellType() == Cell.CELL_TYPE_STRING)
				return xssCellObj.getStringCellValue();
			else if (xssCellObj.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| xssCellObj.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(xssCellObj.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(xssCellObj)) {

					double d = xssCellObj.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

				}

				return cellText;
			} else if (xssCellObj.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(xssCellObj.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	// Get Column Name
	public String getColumnName(int Coloumn, String sheetName) {

		xssfSheetObj = getSheetName(sheetName);

		// LogUtils.info(sheet.getSheetName());

		return xssfSheetObj.getRow(0).getCell(Coloumn).getRichStringCellValue().toString();

	}

	// returns the row count in a sheet
	public int getRowCount(String sheetName) {

		int index = xssfWorkbookObj.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);
			int number = xssfSheetObj.getLastRowNum() + 1;
			return number;
		}

	}

	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName, int rowNum, String colName, String data) {
		try {
			fileInputStreamObj = new FileInputStream(excelFilePath);
			xssfWorkbookObj = new XSSFWorkbook(fileInputStreamObj);

			if (rowNum <= 0)
				return false;

			int index = xssfWorkbookObj.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);

			xssRowObj = xssfSheetObj.getRow(0);
			for (int i = 0; i < xssRowObj.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (xssRowObj.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			xssfSheetObj.autoSizeColumn(colNum);
			xssRowObj = xssfSheetObj.getRow(rowNum - 1);
			if (xssRowObj == null)
				xssRowObj = xssfSheetObj.createRow(rowNum - 1);

			xssCellObj = xssRowObj.getCell(colNum);
			if (xssCellObj == null)
				xssCellObj = xssRowObj.createCell(colNum);

			xssCellObj.setCellValue(data);

			fileOutputStreamObj = new FileOutputStream(excelFilePath);

			xssfWorkbookObj.write(fileOutputStreamObj);

			fileOutputStreamObj.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName, int rowNum, String colName, String data, String url) {

		try {
			fileInputStreamObj = new FileInputStream(excelFilePath);
			xssfWorkbookObj = new XSSFWorkbook(fileInputStreamObj);

			if (rowNum <= 0)
				return false;

			int index = xssfWorkbookObj.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);

			xssRowObj = xssfSheetObj.getRow(0);
			for (int i = 0; i < xssRowObj.getLastCellNum(); i++) {

				if (xssRowObj.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			if (colNum == -1)
				return false;
			xssfSheetObj.autoSizeColumn(colNum);
			xssRowObj = xssfSheetObj.getRow(rowNum - 1);
			if (xssRowObj == null)
				xssRowObj = xssfSheetObj.createRow(rowNum - 1);

			xssCellObj = xssRowObj.getCell(colNum);
			if (xssCellObj == null)
				xssCellObj = xssRowObj.createCell(colNum);

			xssCellObj.setCellValue(data);
			XSSFCreationHelper createHelper = xssfWorkbookObj.getCreationHelper();

			// cell style for hyperlinks

			CellStyle hlink_style = xssfWorkbookObj.createCellStyle();
			XSSFFont hlink_font = xssfWorkbookObj.createFont();
			hlink_font.setUnderline(Font.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			// hlink_style.setWrapText(true);

			XSSFHyperlink link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
			link.setAddress(url);
			xssCellObj.setHyperlink(link);
			xssCellObj.setCellStyle(hlink_style);

			fileOutputStreamObj = new FileOutputStream(excelFilePath);
			xssfWorkbookObj.write(fileOutputStreamObj);

			fileOutputStreamObj.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if sheet is created successfully else false
	public boolean addSheet(String sheetname) {

		FileOutputStream fileOut;
		try {
			xssfWorkbookObj.createSheet(sheetname);
			fileOut = new FileOutputStream(excelFilePath);
			xssfWorkbookObj.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if sheet is removed successfully else false if sheet does
	// not exist
	public boolean removeSheet(String sheetName) {
		int index = xssfWorkbookObj.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			xssfWorkbookObj.removeSheetAt(index);
			fileOut = new FileOutputStream(excelFilePath);
			xssfWorkbookObj.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if column is created successfully
	public boolean addColumn(String sheetName, String colName) {

		try {

			fileInputStreamObj = new FileInputStream(excelFilePath);

			xssfWorkbookObj = new XSSFWorkbook(fileInputStreamObj);

			int index = xssfWorkbookObj.getSheetIndex(sheetName);

			if (index == -1)
				return false;

			XSSFCellStyle style = xssfWorkbookObj.createCellStyle();

			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);

			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

			xssfSheetObj = xssfWorkbookObj.getSheetAt(index);

			xssRowObj = xssfSheetObj.getRow(0);
			if (xssRowObj == null)
				xssRowObj = xssfSheetObj.createRow(0);

			if (xssRowObj.getLastCellNum() == -1)
				xssCellObj = xssRowObj.createCell(0);
			else
				xssCellObj = xssRowObj.createCell(xssRowObj.getLastCellNum());

			xssCellObj.setCellValue(colName);
			xssCellObj.setCellStyle(style);

			fileOutputStreamObj = new FileOutputStream(excelFilePath);
			xssfWorkbookObj.write(fileOutputStreamObj);
			fileOutputStreamObj.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fileInputStreamObj = new FileInputStream(excelFilePath);
			xssfWorkbookObj = new XSSFWorkbook(fileInputStreamObj);
			xssfSheetObj = xssfWorkbookObj.getSheet(sheetName);
			XSSFCellStyle style = xssfWorkbookObj.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			// XSSFCreationHelper createHelper = workbook.getCreationHelper();
			style.setFillPattern(CellStyle.NO_FILL);

			for (int i = 0; i < getRowCount(sheetName); i++) {
				xssRowObj = xssfSheetObj.getRow(i);
				if (xssRowObj != null) {
					xssCellObj = xssRowObj.getCell(colNum);
					if (xssCellObj != null) {
						xssCellObj.setCellStyle(style);
						xssRowObj.removeCell(xssCellObj);
					}
				}
			}
			fileOutputStreamObj = new FileOutputStream(excelFilePath);
			xssfWorkbookObj.write(fileOutputStreamObj);
			fileOutputStreamObj.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = xssfWorkbookObj.getSheetIndex(sheetName);
		if (index == -1) {
			index = xssfWorkbookObj.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		xssfSheetObj = xssfWorkbookObj.getSheet(sheetName);
		xssRowObj = xssfSheetObj.getRow(0);

		if (xssRowObj == null)
			return -1;

		return xssRowObj.getLastCellNum();

	}

	// String sheetName, String testCaseName,String keyword ,String URL,String
	// message
	public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url,
			String message) {

		url = url.replace('\\', '/');
		if (!isSheetExist(sheetName))
			return false;

		xssfSheetObj = xssfWorkbookObj.getSheet(sheetName);

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {

				setCellData(sheetName, i + index, screenShotColName, message, url);
				break;
			}
		}

		return true;
	}

	//
	public int getCellRowNum(String sheetName, String colName, String cellValue) {

		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, i, colName).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

	// Get Sheet Name
	public XSSFSheet getSheetName(String sheetName) {

		return xssfWorkbookObj.getSheet(sheetName);

	}

}