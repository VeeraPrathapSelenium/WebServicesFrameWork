package com.readexcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.genericfunctions.GenericMethods;

public class ReadExcel {
	
	public static XSSFWorkbook workbook;
	
	public static void loadExcelFile()
	{
		System.out.println("***** Excel File is loading........ ************");
		String path=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
		
		File f=new File(path);
		
		//very if the testdata file is exist
		
		if(f.exists())
		{
			
			try
			{
				FileInputStream fis=new  FileInputStream(f);
				workbook=new XSSFWorkbook(fis);	
				System.out.println("***** Excel File is loaded sucessfully ************");
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		}else
		{
			
			System.out.println("Test data file not found under "+System.getProperty("user.dir")+"\\TestData");
		}
		
	}
	
	
	public static int getRowCount(String sheetname)
	{
		int rowcount=0;
		try
		{
			XSSFSheet sheet=workbook. getSheet(sheetname);
			
			rowcount=sheet.getLastRowNum();
			
		}catch(Exception e)
		{
			System.out.println("Unable to get the rowcount for the sheet "+sheetname);
		}
		return rowcount;
		
		
	}
	
	public static  int getColumnCount(String sheetname)
	{
		int colcount=0;
		try
		{
			XSSFSheet sheet=workbook. getSheet(sheetname);
			
			colcount=sheet.getRow(getRowCount(sheetname)).getLastCellNum();
			
			
			
		}catch(Exception e)
		{
			System.out.println("Unable to get the rowcount for the sheet "+sheetname);
		}
		return colcount;
		
		
	}
	
	
	public static int searchTestcase(String sheetname)
	{
		int rowfound=0;
		try
		{
			int rowcount=getRowCount(sheetname);
			
			
			for(int i=1;i<=rowcount;i++)
			{
				
				XSSFSheet sheet=workbook.getSheet(sheetname);
				
				String crnttestcase=sheet.getRow(i).getCell(0).getStringCellValue();
				if(crnttestcase.equals(GenericMethods.currentclass))
				{
					rowfound=i;
					break;
					
				}
				
				
				
				
				
			}
			
			
			
		}catch(Exception e)
		{
			System.out.println("Unable to dearch the row item "+e.getMessage());
		}
		return rowfound;
		
		
		
	}
	
	
	

	
}
