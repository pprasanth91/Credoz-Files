package selenium.com.day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ebay_TestNG_DependsOnMethod {
	
	public static WebDriver driver;
	public static int iBroType = 5; //1 - Chrome,2 - FF,3 - Edge,4 - HTML Unit Driver
	public static String sURL = "https://www.ebay.in/";
	
  @BeforeTest
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
  
  @AfterTest
  public static void closeBrowser() {
		
		int iCount = driver.getWindowHandles().size();
		System.out.println("Total Window Opened is : "+iCount);
		if(iCount==1) {
			driver.close();
		}else {
			driver.quit();
		}
	}
  @Test(priority=1)
  public static void browserSettings() {
		if(iBroType==2) {
			driver.manage().deleteAllCookies();
		}else {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
	}
  
  @Test(priority=2,dependsOnMethods="browserSettings")
  public static void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
  
  
  @Test(priority=3,dependsOnMethods="navigateURL")
  public static void getPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
		String sTitle = driver.getTitle();
		Assert.assertEquals(sTitle, "eBay");
		System.out.println("Assert Title Matches");
	}
  
  @Test(priority=4,dependsOnMethods="getPageInfo")
  public static void ebaySearch() {
		WebElement oTxt,oDropdown,oBtn;
		oTxt = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		boolean result = oTxt.isDisplayed();
		Assert.assertEquals(result, true);
		oTxt.sendKeys("iPhone 7"); 
		
		oDropdown = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oDropdown);
		oSelect.selectByVisibleText("Mobile Phones");
		
		oBtn = driver.findElement(By.xpath("//input[@id='gh-btn']"));
		oBtn.click();
		
	}
  
   
  
  
  
  
  
  
}