package testRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import utils.readExcel;

public class test {

	public static void main(String[] args) throws IOException {
		String path = "src/test/resources/Data.xlsx";
		// TODO Auto-generated method stub
		Map<String, String> data;

		readExcel rd = new readExcel();
		data = rd.getAllData(1);
		System.out.println("Data:"+data);

		}

	}
	//	rd.getSheetByName();
		
		//System.out.println(data.get("Header"));
//		ExcelReader02 reader = new ExcelReader02();
//		XSSFWorkbook wb = reader.findWorkbook(path);
//		XSSFSheet sheet = reader.getSheetByindex(wb, 0);
//		allData = reader.dataFromSheet(sheet);
//		String valueString =reader.getHeaderValue("Header", path, 0);
//		System.out.println(sheet.getLastRowNum());
//		XSSFRow row=sheet.getRow(1);
//		int colm= row.getLastCellNum();
//		System.out.println("colm: "+colm);
//		for(int i =0; i<colm ;i++) {
//			String header = sheet.getRow(0).getCell(i).getStringCellValue();
//			XSSFCell cell = row.getCell(i);
//			if (cell.getCellType()== org.apache.poi.ss.usermodel.CellType.NUMERIC) {
//				String valueString = String.valueOf((int)( row.getCell(i).getNumericCellValue()));
//				System.out.println(valueString);
//				allData.put(header,valueString);
//			}
//			
//			else {
//				System.out.println(row.getCell(i).getStringCellValue());
//				String valueString= (row.getCell(i).getStringCellValue());
//				allData.put(header,valueString);
//			}
//		}

		// String valueString = reader.getHeaderValue("Header", sheet, 1);
	
