package com.macys.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Utility {

	
	public static String[][] readExcel(String fileName,String sheetName) throws BiffException, IOException
	{
		File f = new File(fileName);
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		
		//Declare an 2D array..
		String data[][] = new String[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Cell cell = sheet.getCell(j,i);
				data[i][j] =cell.getContents();
				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}
	
	

	public static void unconditionalWait(long timeinmillis)
	{
		try{
			Thread.sleep(timeinmillis);
		}
		catch(InterruptedException e)
		{

		}
	}
	public static WebElement findWebElement(WebDriver driver,String elementRef,String value){

		WebElement e = null ;
		switch(elementRef)
		{
		case "cssSelector":
			e= driver.findElement(By.cssSelector(value));
			break;
		}
		return e;
	}
}
