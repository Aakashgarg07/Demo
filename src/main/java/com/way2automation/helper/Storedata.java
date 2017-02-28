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

public class Storedata {
		public static void toExcel(String filepath, String sheetname,int rIndex, int cIndex, String data)
		{
			
		
			try
			{
				File f = new File(filepath);
				FileInputStream fin = new FileInputStream(f);
				Workbook wb = WorkbookFactory.create(fin);
				Sheet st = wb.getSheet(sheetname);
			    Row r = st.createRow(rIndex);
			    Cell c= r.createCell(cIndex);
			    c.setCellValue(data);
			    FileOutputStream fos = new FileOutputStream(f);
			    wb.write(fos);
			}
			catch(Exception e)
			{
				
			}
		
		}

		public static void toProperty(String filepath, String Key, String value)
		{
			
				try
			{
				File f = new File(filepath);
				FileInputStream fin = new FileInputStream(f);
				Properties prop = new Properties();
				prop.load(fin);
				prop.setProperty(Key,value);
				FileOutputStream fos = new FileOutputStream(f);
			    prop.store(fos, null);;
			    
			}
			catch(Exception e)
			{
				
			}
			
		}


	}


