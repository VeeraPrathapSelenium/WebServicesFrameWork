package com.postscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericfunctions.GenericMethods;
import com.readexcel.ReadExcel;



public class Tc_01_CreateJiraIssue  extends GenericMethods{
	
	
	@Test
	public static void createIssue()
	{
		ReadExcel.loadExcelFile();
	}
	

}
