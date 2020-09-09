package com.slk.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoObjectArray(String fileLocation,String sheetName) throws IOException {

		FileInputStream file = new FileInputStream(fileLocation);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);	
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] main=new Object[rowCount-1][cellCount];
		
		DataFormatter format=new DataFormatter();
		
		for(int i=1;i<rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellCount;j++)
			{
				XSSFCell cell= row.getCell(j);
				String cellValue = format.formatCellValue(cell);
				main[i-1][j]=cellValue;
			}
		}
		book.close();
		file.close();
		return main;
	}

}
