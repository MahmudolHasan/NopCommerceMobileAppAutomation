package utils;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader02 {

	protected static String filepath = "src/test/resources/Data.xlsx";
	static XSSFWorkbook workbook;

	// Finding workbook/excel file in given path
	public static XSSFWorkbook findWorkbook(String filepath) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filepath);
			return workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException("Error in finding workbook!");
		}
	}

	public static XSSFSheet getSheetByindex(XSSFWorkbook workbook, int sheetIndex) {
		if (workbook.getNumberOfSheets() < sheetIndex) {
			throw new NullPointerException("Sheet number is out of bound!");
		}
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		return sheet;
	}

	public XSSFSheet getSheetByName(XSSFWorkbook workbook, String name) {
		try {
			XSSFSheet sheet = workbook.getSheet(name);
			return sheet;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	// Get data from specific sheet
	public Map<String, String> dataFromSheet(XSSFSheet sheet) {
		// Assuming excel file has a header

		Map<String, String> allData = new HashMap<String, String>();
		sheet = getSheetByindex(findWorkbook(filepath), 0);
		int rows = sheet.getLastRowNum();
		System.out.println("Rows:"+rows);// total rows number
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Cols:"+cols);// total columns number

		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j <= cols; j++) {
				String header = sheet.getRow(0).getCell(j).getStringCellValue();
				XSSFCell cell = row.getCell(j);
				if ((cell == null) || (cell.getCellType() == CellType.BLANK)) {
					allData.put(header, String.valueOf(cell));
					System.out.println("[Row][Coumn]:" + i + j + " -This cell is empty.");
					continue;
				} else if (cell.getCellType() == CellType.NUMERIC) {
					String valueString = String.valueOf((int) (row.getCell(j).getNumericCellValue()));
//					System.out.println(valueString);
					allData.put(header, valueString);
				} else {
					String valueString = (row.getCell(j).getStringCellValue());
					allData.put(header, valueString);
				}

			}
		}
		return allData;

	}

	public Map<String, String> dataFromSheet(String filepath, int sheetIndex) {
		XSSFWorkbook wb = findWorkbook(filepath);
		XSSFSheet sheet = getSheetByindex(wb, sheetIndex);
		return dataFromSheet(sheet);
	}

	public String getHeaderValue(String header,String filepath, int sheetIndex) {
		Map<String, String> allData = dataFromSheet(filepath,sheetIndex);
		String valueString = allData.get(header);
		return valueString;
	}

}
