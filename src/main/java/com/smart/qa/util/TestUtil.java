package com.smart.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

  public static long Page_loadtime = 50;
  public static long Page_WaitTime=60;
  public static long Element_timeout=10;
  static Workbook book;
  static Sheet sheet;
  public static String FilePath = "D://Jitesh//Automation//MV//SMART_CBT//src//main"
		  		+"//java//com//smart//qa//testdata//UserCreationData.xlsx";
  
  public static String[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" +
		sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	

}
