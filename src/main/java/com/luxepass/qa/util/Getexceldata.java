package com.luxepass.qa.util;

import java.util.ArrayList;
import com.luxepass.qa.util.Excelops;
public class Getexceldata {
	static Excelops excel;
	
	  public static ArrayList<Object[]>fetchdata()
	  
	  {
		 ArrayList<Object[]> data= new ArrayList<Object[]>();
		     
		    try {
		          excel = new Excelops("D:\\Automation\\Workspace\\TheLuxepass\\src\\main\\java\\com\\luxepass\\qa\\testdata\\Logindata.xlsx");
		      }
		    
		     catch(Exception e) {
		      
			     e.printStackTrace();
		      }
		    
			int sheetIndex = 1; 
			for(int row=2; row<=excel.rowcount(sheetIndex);row++)
			{
			    
				String firstname = excel.getData(sheetIndex, row, "Firstname");
				String lastname = excel.getData(sheetIndex, row, "Lastname");
				String username = excel.getData(sheetIndex, row, "Username");
				String pass = excel.getData(sheetIndex, row, "Password");
				String confirmpass = excel.getData(sheetIndex, row, "Confirmpassword"); 	
				
				Object[] object = {firstname,lastname,username,pass,confirmpass};
				
				data.add(object); 
	       }
       return data; 
    }
 }