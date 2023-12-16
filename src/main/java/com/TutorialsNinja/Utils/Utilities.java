package com.TutorialsNinja.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int Implicit_Wait_Time=10;
	public static final int Page_Load_Wait_Time=10;
	
	public static String generateEmailWithTimeStamp() {
		Date date=new Date();
		String timestamp=date.toString().replace(" ","_").replace(":","_");
		return "mike"+timestamp+"@gmail.com";
	}
	
	public static Object[][] getTestDataFromExcel(String SheetName) throws IOException {
		File excelFile=new File("F:\\EclipsData\\NewTesting\\inetBanking_V1\\src\\main\\java\\com\\TutorialsNinja"
				+ "\\TestData\\TutorialsNinjaSheet.xlsx");
		FileInputStream filExcel=new FileInputStream(excelFile);
		
		XSSFWorkbook workbook=new XSSFWorkbook(filExcel);
		XSSFSheet sheet=workbook.getSheet(SheetName);
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();	
		Object[][]data=new Object[rows][cols];
		for(int i=0;i<rows;i++) {
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<cols;j++) {
				XSSFCell cell=row.getCell(j);
				CellType cellType=cell.getCellType();
				
				switch(cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}
	
	

}
