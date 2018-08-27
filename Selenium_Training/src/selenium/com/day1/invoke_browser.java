package selenium.com.day1;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class invoke_browser {
	
	public static WebDriver driver;
	public static int iBroType = 3; // 1 - Chrome, 2 - FF, 3 - IF,4 - HTMLUnitDriver
	public static String sURL = "https://www.google.co.in/";
	

	public static void main(String[] args) {
		browserInvoke();
		browsercustomization();
		navigateURL();
		getPageInfo();
		closeBrowser();
		

	}
	
	public static void browserInvoke() {
		
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+" , So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+" , So Invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is : "+iBroType+" , So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "./Driver/iedriver.exe");
			driver = new InternetExplorerDriver();
			break;
		case 4:
			System.out.println("User Option is : "+iBroType+" , So Invoking Headless Browser");
			driver = new HtmlUnitDriver();
			break;
		default:
			System.out.println("User Option is wrong: "+iBroType+" , So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	public static void browsercustomization() {
		if(iBroType==2) {
			driver.manage().deleteAllCookies();
		}else {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	}
	
	public static void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void getPageInfo() {
		System.out.println("Page Tile is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
	}
	
	public static void closeBrowser() {
		int iSize = 	driver.getWindowHandles().size();
		System.out.println("Total Window Opened is : "+iSize);
		if(iSize==1) {
			driver.close();
		}else {
			driver.quit();
		}
		
	}

}

