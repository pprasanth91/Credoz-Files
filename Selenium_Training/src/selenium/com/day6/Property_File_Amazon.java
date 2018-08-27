package selenium.com.day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Property_File_Amazon {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Page_Info();
	}
	public static void Page_Info(){
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 String sFile = "./Data/DetailsAmazon.properties";
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
	      String URL = prop.getProperty("app.url");
	      System.out.println(URL);
	      driver.get(URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 		 
	}
}
