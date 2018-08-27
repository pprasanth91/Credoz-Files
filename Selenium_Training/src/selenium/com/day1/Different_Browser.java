package selenium.com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Different_Browser {
	public static WebDriver driver;
	public static String BroType;
	static int IBroType;
	public static String sURL = "https://www.facebook.com/";
	public static String sURL1 = "https://mail.google.com/mail/";
	public static String sURL2 = "https://www.seleniumhq.org/";
	
	public static void Browser_Type() throws Exception
	{
        System.out.println("Browser Type : ");
        BufferedReader input = new BufferedReader ( new InputStreamReader ( System.in ) );
        BroType = input.readLine();
        IBroType = Integer.parseInt(BroType);
    
	}
	
	public static void invoke_browser()
	{
		
			switch (IBroType)
			{
			case 1:
				System.out.println("User Option is : "+IBroType+" , So Invoking Chrome Browser");
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case 2:
				System.out.println("User Option is : "+IBroType+" , So Invoking FF Browser");
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case 3:
				System.out.println("User Option is : "+IBroType+" , So Invoking Headless Browser");
				System.setProperty("webdriver.IE.driver", "./Driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("User Option is wrong: "+IBroType+" , So Invoking Default Chrome Browser");
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
	}
	
	public static void getTitle()
	{
		if (IBroType ==1)
		{
			driver.get(sURL);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			if( driver.getTitle().equalsIgnoreCase("Facebook – log in or sign up"))
			{
				System.out.println("User in Facebook Page Currently");
			}
			
						
		}
		
		else if (IBroType ==2)
		{
			driver.get(sURL1);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			if( driver.getTitle().equalsIgnoreCase("Gmail"))
			{
			System.out.println("User in Gmail Page Currently");
			}
		}
		else
		{
			driver.get(sURL2);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			if(driver.getTitle().equalsIgnoreCase("Selenium"))
			{
			System.out.println("User in Selenium Tutorial Page Currently");
		}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Browser_Type();
		invoke_browser();
		getTitle();
	}
}


