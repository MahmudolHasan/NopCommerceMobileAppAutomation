package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
	final static String path = "src/test/resources/Data.xlsx";
	static FileInputStream fileInputStream = null;

	public Map<String, String> getAllData(int sheetIndex) throws IOException {
		Map<String, String> data = new HashMap<>();
		XSSFWorkbook wb = null;

		try {
			fileInputStream = new FileInputStream(path);
			wb = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = wb.getSheetAt(sheetIndex);

			XSSFRow headerRow = sheet.getRow(0);
			int rows = sheet.getLastRowNum() + 1; // Add 1 to include the last row
			int columns = headerRow.getLastCellNum();

			for (int r = 1; r < rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < columns; c++) {
					String header = headerRow.getCell(c).getStringCellValue();
					XSSFCell cell = row.getCell(c);
					if (cell != null) {
						switch (cell.getCellType()) {
						case STRING: {
							//System.out.print(cell.getStringCellValue());
							String value = cell.getStringCellValue();
							data.put(header, value);
							break;
						}
						case NUMERIC: {
						//	System.out.print(cell.getNumericCellValue());
							String value = String.valueOf((int) cell.getNumericCellValue());
							data.put(header, value);
							break;
						}
						}

					}

				}
			}
		} finally {
			FileInputStream fileInputStream22 = fileInputStream;
			if (fileInputStream22 != null) {
				fileInputStream22.close();
			}
			if (wb != null) {
				wb.close();
			}

		}

		return data;
	}

}
