package selenium.com.day4;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.io.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;


public class SwitchToBrowser {
	
	private static final String i = null;
	public static WebDriver driver;
	public static int iBroType = 1; //1-Chrome,2-FF,3-IE,4-HTML Unit Driver
	public static String sURL = "https://www.hdfcbank.com/";

	public static void main(String[] args) throws Exception {
		
		browserInvoke();
		browserSettings();
		navigateURL();
		getPageInfo();
		switchTobrowser();
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
			System.setProperty("webdriver.gecko.driver", "F:\\credo\\Selenium Software\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is : "+iBroType+", So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "F:\\credo\\Selenium Software\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case 4:
			System.out.println("User Option is : "+iBroType+", So Invoking Headless Browser");
			driver = new HtmlUnitDriver();
			break;

		default:
			System.out.println("User Option is Wrong : "+iBroType+", So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "F:\\credo\\Selenium Software\\chromedriver.exe");
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
		//driver.get(sURL);
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().refresh();
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void getPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page URL is : "+driver.getCurrentUrl());
	}
	
	
	
	public static void switchTobrowser() throws Exception {
		WebElement oPension,oHDFCLife;
		oPension = driver.findElement(By.xpath("//a[text()='HDFC Pension']"));
		WebDriverWait oWait = new WebDriverWait(driver, 30);
		oWait.until(ExpectedConditions.elementToBeClickable(oPension));
		Actions oMouse = new Actions(driver);
		oMouse.moveToElement(oPension).build().perform();
		System.out.println("Before Clicking Pension Link : "+driver.getWindowHandles().size());
		oPension.click();
		Thread.sleep(3000);
		System.out.println("After Clicking Pension Link : "+driver.getWindowHandles().size());
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getPageInfo();
		oHDFCLife = driver.findElement(By.xpath("//a[text()='HDFC Life']"));
		oWait.until(ExpectedConditions.elementToBeClickable(oHDFCLife));
		//oMouse = new Actions(driver);
		oMouse.moveToElement(oHDFCLife).build().perform();
		System.out.println("Before Clicking HDFC Life Link : "+driver.getWindowHandles().size());
		oHDFCLife.click();
		Thread.sleep(3000);
		System.out.println("After Clicking Pension Link : "+driver.getWindowHandles().size());
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getPageInfo();
		//driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//getPageInfo();
		//driver.close();
		//System.out.println("After Closing HDFC Home Page "+driver.getWindowHandles().size());
	}
	
	public static void closeBrowser() {
		//driver.close();]
		
		String s = driver.getWindowHandles().toArray().toString();
		char[] abs1 = s.toCharArray();
		int i = Integer.parseInt(s);
		System.out.println(s);
		System.out.println(abs1);
		
		if (i==1)
		{
			driver.close();
		}
		else if(i>1)
		{
			for(int j=abs1.length-1;j>1;j--)
			{
				//int sSize = iSize--;
				//String sSize1 = Integer.toString(sSize);
				String F=abs1.toString();
				driver.switchTo().window(F);
				driver.close();
				
			}
		}
	}
}

	
	