package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.Page;


public class Utilities extends Page {
	public static String screenshotPath;
	public static String screenshotName;
	
	
public static void captureScreenshot() throws IOException {
	
	Date d = new Date();
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	screenshotName = d.toString().replace(":","_").replace(" ", "_")+".jpg";
			
	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
}



@DataProvider (name="dp")//создаем дата провайдер

public Object[][] getData(Method m){
	
	String sheetName = m.getName();
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);
	
	Object[][] data = new Object[rows-1][1];//ряд -1 тк первый ряд шапка, 2 ряда 3 колонки
	
	Hashtable<String,String> table = null; //тоесть каждая строка будет воспринематься как таблица, если в икселе 3 строки заполнены, то будет типа 3 таблицы)
	
	for(int rowNum=2; rowNum<=rows; rowNum++) {//логика дата провайдера - начнет читать со второй строки, тк первая шапка
		
		table = new Hashtable<String,String>();
		for(int colNum = 0; colNum<cols; colNum++) {//затем читает колонки, нулевая колонка это самая первая
			
			//data[0][0] then data [0][1] etc
			
			table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum)); //row 1 будет ряд с названиями столбцов, а дальше заполняются данные по каждому ряду - таблице
		data[rowNum-2][0]=table;
		}
		
	}
	
	return data; 
	
	
}

public static boolean IsTestRunnable(String testName, ExcelReader excel) {
	
	String sheetName = "test_suite";
	int rows = excel.getRowCount(sheetName);
	
	for(int rNum=2; rNum<=rows; rNum++) {
		
		String testCase = excel.getCellData(sheetName, "TCID", rNum);
		
		if(testCase.equalsIgnoreCase(testName)) {
			
			String runmode = excel.getCellData(sheetName, "Runmode", rNum);
			
			if(runmode.equalsIgnoreCase("Y"))
				return true;
			else
				return false;
		}
		
	}
	return false;
}


}
