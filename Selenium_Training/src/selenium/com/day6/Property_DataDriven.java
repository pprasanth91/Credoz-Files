package selenium.com.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_DataDriven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Property_DataDriven oBj = new Property_DataDriven();
		oBj.propertyReader();
		System.out.println(oBj.propertyReturn("url"));

	}
	
	public void propertyReader(){
		String sFile = "./Data/Details.properties";
		File ofile = new File(sFile);
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(ofile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(file);
			System.out.println(prop.getProperty("appName"));
			System.out.println(prop.getProperty("app.url"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String propertyReturn(String sName){
		String sFile = "./Data/Details.properties";
		File ofile = new File(sFile);
		String name = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(ofile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(file);
			System.out.println(prop.getProperty("appName"));
			name = prop.getProperty(sName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}

}


