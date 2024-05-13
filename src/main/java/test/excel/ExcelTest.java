package test.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelTest {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\陈毅宸\\Desktop\\pkuEssYear.xls")));
        Sheet sheetAt = workbook.getSheetAt(0);
        Row row = sheetAt.getRow(0);
        Cell cell = row.getCell(0);
        String stringCellValue = cell.getStringCellValue();
        stringCellValue = stringCellValue.replaceAll(" ", "").replaceAll("\\{date}","");
        System.out.println(stringCellValue);
    }
}
