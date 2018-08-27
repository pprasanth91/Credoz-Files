package selenium.com.day2;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Webtable_Ex {
	
	public static WebDriver driver;
	public static int iBroType = 1; //1-Chrome,2-FF,3-IE,4-HTML Unit Driver
	public static String sURL = "https://www.seleniumhq.org/download/";

	public static void main(String[] args) {
		
		browserInvoke();
		browserSettings();
		navigateURL();
		getPageInfo();
		getWebTableValue();
		closeBrowser();

	}
	
	public static void browserInvoke() {
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+", So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+", So Invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "./Driver/chromedriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is : "+iBroType+", So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "./Driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
			break;
		case 4:
			System.out.println("User Option is : "+iBroType+", So Invoking Headless Browser");
			driver = new HtmlUnitDriver();
			break;

		default:
			System.out.println("User Option is Wrong : "+iBroType+", So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}
	
	public static void browserSettings() {
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
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page URL is : "+driver.getCurrentUrl());
	}
	
	public static void getWebTableValue() {
		WebElement oTable,oRow,oCol;
		oTable = driver.findElement(By.xpath("(//div[@id='mainContent']/table)[1]/tbody"));
		List<WebElement> oRow_List = oTable.findElements(By.tagName("tr"));
		for(int i=0;i<oRow_List.size();i++) {
			oRow = oRow_List.get(i);
			List<WebElement> oCol_List = oRow.findElements(By.tagName("td"));
			for(int j=0;j<oCol_List.size();j++) {
				oCol = oCol_List.get(j);
				System.out.print(oCol.getText()+"  ");
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void closeBrowser() {
		driver.close();
	}

}









