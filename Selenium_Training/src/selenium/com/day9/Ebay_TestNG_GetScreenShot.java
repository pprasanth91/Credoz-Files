package selenium.com.day9;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ebay_TestNG_GetScreenShot {
	
	public static WebDriver driver;
	public static int iBrType = 1; //1 - Chrome, 2-FF, 3-IE, 4-HTML Unit Driver
	public static String sURL = "https://www.ebay.in/";
	
	@BeforeTest
     public static void browserInvoke(){
		
		switch (iBrType) {
		case 1:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "E:\\selenium\\Selenium_Software\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
			
		case 3:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "E:\\selenium\\Selenium_Software\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		case 4:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking Headless Browser");
			driver = new HtmlUnitDriver();
			break;

		default:
			System.err.println("User Option is Wrong :"+iBrType+" ,So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Selenium_Software\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}
	
	@AfterTest
	 public static void closeBrowser(){
		driver.close();
	}
	
	
  @Test(priority=1)
  public static void browserProperty(){
		if(iBrType==2){
			driver.manage().deleteAllCookies();
		}else{
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	}
  
  @Test(priority=2)
  public static void navigatePage(){
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
  @Test(priority=3)
  public static void getPageInfo() throws Exception{
		System.out.println("Page Title is : " +driver.getTitle());
		String sTitle = driver.getTitle();
		System.out.println("Page URL is : " +driver.getCurrentUrl());
		System.out.println("Page Title Validated");
		Assert.assertEquals(sTitle, "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
		System.out.println("Assert is Success");
		getscreenshot("Search_Page");
		
	}
  @Test(priority=4)
  public static void searchProduct() throws Exception{
		WebElement oText,oDropDown,oBtn;
		
		oText = driver.findElement(By.xpath("//*[@id='gh-ac']"));
		boolean oResult = oText.isDisplayed();
		Assert.assertEquals(oResult, true);
		oText.sendKeys("iPod");
		
		oDropDown = driver.findElement(By.xpath("//*[@id='gh-cat']"));
		Select oSelect = new Select(oDropDown);
		oSelect.selectByVisibleText("Mobile Phones");
		
		getscreenshot("Search_Product");
		oBtn = driver.findElement(By.xpath("//*[@id='gh-btn']"));
		oBtn.click();
	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
  
  @Test(priority=5)
  public static void getList() throws Exception{
		WebElement oText,oElement;
	try{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oText = driver.findElement(By.xpath("//*[@class='listingscnt']"));
		String sText = oText.getText();
		System.out.println("Search Result is : "+sText);
		sText = sText.replaceAll("[^0-9]", "").trim();
		int iText = Integer.parseInt(sText);
		if(iText>0){
			System.out.println("Search Result is Listed");
		}else{
			System.out.println("No Search Result");
		} 
		
		List<WebElement> oList = driver.findElements(By.xpath("//*[@id='ListViewInner']/li"));
		
		for(int i=0;i<oList.size();i++){
			oElement = oList.get(i);
			System.out.println(oElement.findElement(By.className("vip")).getText());
			int x = oElement.getLocation().x;
			int y = oElement.getLocation().y;
			ScrollPageto(x, y);
		}
		ScrollPageto(0, 0);
		
	}catch (Exception e) {
		System.out.println("Element Not Found");
		getscreenshot("Get_Result_Fail");
	}
	}
  
  public static void ScrollPageto(int x,int y){
		JavascriptExecutor oJs;
		String sCmd;
		oJs = (JavascriptExecutor) driver;
		sCmd = String.format("window.scrollTo(%d,%d)",x,y);
		oJs.executeScript(sCmd);
			
	}
  
  public static void getscreenshot(String sName) throws Exception 
  {
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("D:\\"+sName+".png"));
  }
  
  
  
  
}