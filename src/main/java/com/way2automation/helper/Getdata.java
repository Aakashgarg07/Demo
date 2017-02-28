package main.java.com.way2automation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Getdata {
	public static String fromExcel(String filepath,String sheetname,int rIndex, int cIndex)
	{
		
		String data = null;
		try
		{
			File f = new File(filepath);
			FileInputStream fin = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fin);
			Sheet st = wb.getSheet(sheetname);
		    Row r = st.getRow(rIndex);
		    Cell c= r.getCell(cIndex);
		    data = c.toString();
		    
		}
		catch(Exception e)
		{
			
		}
		return data;
	}

	public static String fromProperty(String filepath, String Key)
	{
		String value = null;
			try
		{
		
			File f = new File(filepath);
			FileInputStream fin = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fin);
		    value= prop.getProperty(Key);
		    System.out.println("exit try"+filepath);
		}
		catch(Exception e)
		{
			
		}
			return value;
	}


}

 
 