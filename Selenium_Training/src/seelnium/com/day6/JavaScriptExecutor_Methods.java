package seelnium.com.day6;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptExecutor_Methods {
	
	public static WebDriver driver;
	public static int iBroType = 5; //1 - Chrome,2 - FF,3 - Edge,4 - HTML Unit Driver
	public static String sURL = "http://newtours.demoaut.com/";

	public static void main(String[] args) throws Exception {
		
		invokeBrowser();
		browserSettings();
		navigateURL();
		getPageInfo();
		javaScriptMethod();
	//	closeBrowser();

	}
	
	public static void invokeBrowser() {
		
		switch (iBroType) {
		case 1:
			System.out.println("User Selection is : "+iBroType+" ,So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Selection is : "+iBroType+" ,So Invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Selection is : "+iBroType+" ,So Invoking Edge Browser");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		case 4:
			System.out.println("User Selection is : "+iBroType+" ,So Invoking Headless Browser");
		//	System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new HtmlUnitDriver();
			break;

		default:
			System.out.println("User Selection is Wrong : "+iBroType+" ,So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	public static void browserSettings() {
		if(iBroType==2) {
			driver.manage().deleteAllCookies();
		}else {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
	}
	
	public static void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void getPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
	}
	
	public static void closeBrowser() {
		
		int iCount = driver.getWindowHandles().size();
		System.out.println("Total Window Opened is : "+iCount);
		if(iCount==1) {
			driver.close();
		}else {
			driver.quit();
		}
	}
	
	public static void javaScriptMethod() throws Exception {
		WebElement oBtn,oLink,oText;
		oBtn = driver.findElement(By.name("login"));
		JavascriptExecutor oJs;
		oJs = (JavascriptExecutor) driver;
		oJs.executeScript("arguments[0].click();",oBtn);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		oLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
		oJs.executeScript("arguments[0].click();",oLink);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		oText = driver.findElement(By.xpath("//input[@name='firstName']"));
		oJs.executeScript("arguments[0].value='Mathan';",oText);
		Thread.sleep(2000);
		oJs.executeScript("history.go(0);");
		Thread.sleep(2000);
		String sTitle = (String) oJs.executeScript("return document.title;");
		System.out.println(sTitle);
	}
	
	
	
	
	
	

}







