package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    protected String filepath;
    XSSFWorkbook workbook;

    public XSSFWorkbook findWorkbook(String filepath){
        try {
            FileInputStream fileInputStream = new FileInputStream (filepath);
            return workbook = new XSSFWorkbook (fileInputStream);
        }catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    public List<String> dataFromSheet(XSSFWorkbook workbook, int sheetIndex, boolean removeHeader){
        int rowIndex =0;
        int colIndex =0;
        List<String> allData= new ArrayList<> ();

        if(workbook.getNumberOfSheets ()<sheetIndex){
            throw new NullPointerException("Sheet number is out of bound!");
        }
        XSSFSheet sheet = workbook.getSheetAt (sheetIndex);
        int rows = sheet.getLastRowNum (); // total rows number
        int cols = sheet.getRow (0).getLastCellNum (); // total columns number

        if(removeHeader){
            rowIndex = 1;
            colIndex = 1;
        }
        for(; rowIndex<rows ; rowIndex++){
            XSSFRow row = sheet.getRow (rowIndex);
            for (; colIndex<cols; colIndex++)
            {
                XSSFCell cell = row.getCell (colIndex);
                if ((cell == null) || (cell.getCellType () == CellType.BLANK))
                {
                    allData.add (String.valueOf (cell));
                    System.out.println ("[Row][Coumn]:"+rowIndex+colIndex+" -This cell is empty.");
                    continue;
                }
                allData.add (String.valueOf (cell));
            }
        }


        return allData;
    }

    public List<String> dataFromSheet(XSSFWorkbook workbook){
        return dataFromSheet(workbook, 0, false);
    }
}
