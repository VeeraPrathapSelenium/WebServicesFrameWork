package com.genericfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.readexcel.ReadExcel;

import io.restassured.path.json.JsonPath;

public class GenericMethods extends ReadExcel{
//===================================================Variables Declaration==============================================================================
	
public static Properties property ;  

public static String currentclass;
	
	
	
//====================================================Methods Declaration===========================================================================================	
	/*
	 * Methodname : getRawJson(String jsonString,String fieldname)
	 * 
	 * Purpose : This method help to fetch the json object value 
	 * 
	 * Input Parameters : User must send json String and fieldname
	 * 
	 * Output Parameter : String
	 * 
	 * Designer : ****
	 * 
	 * Reviewer : *****
	 * 
	 * Design date : 12 oct 2018
	 * 
	 * Review date : ****
	 * 
	 * Status : Inprogress or to be review
 	 */
	public static String getRawJson(String jsonString,String fieldname)
	{  
		// initialise string value as null
		
		String jsondata="";
		try
		{
			// creating JsonPath object 
			
			JsonPath jp=new JsonPath(jsonString);
			jsondata=jp.get(fieldname).toString();
			
			System.out.println("Test");
		}
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	
	    }
	return jsondata;
	}
	
	/*
	 * Methodname : getRawJson(String jsonString,String fieldname)
	 * 
	 * Purpose : This method help to fetch the json object value 
	 * 
	 * Input Parameters : User must send json String and fieldname
	 * 
	 * Output Parameter : String
	 * 
	 * Designer : ****
	 * 
	 * Reviewer : *****
	 * 
	 * Design date : 12 oct 2018
	 * 
	 * Review date : ****
	 * 
	 * Status : Inprogress or to be review
 	 */
	
  public static void loadPropertiesFile() 
  
  { File propertiesfile = new File("Environment.properties");
    // Verify file existance
    if (propertiesfile.exists()) 
    {
    	FileInputStream fis;
		try {
			
			fis = new FileInputStream(propertiesfile);
			property = new Properties();
	    	property.load(fis);
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    	
    }
	
}


}

