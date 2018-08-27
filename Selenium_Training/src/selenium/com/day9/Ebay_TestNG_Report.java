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

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class Ebay_TestNG_Report {
	public static WebDriver driver;
	public static int iBrType = 1; //1 - Chrome, 2-FF, 3-IE, 4-HTML Unit Driver
	public static String sURL = "https://www.ebay.in/";
	public static ExtentReports logger;
	
	public static void main(String[] args) throws Exception {
		
		browserInvoke();
		browserProperty();
		navigatePage();
		getPageInfo();
		searchProduct();
		getList();
	}

    public static void browserInvoke(){
    	logger = new ExtentReports();
    	logger.init("./Report/Ebay_Report.html",true);
		logger.startTest("Browser Invoke", "User can invoke the corresponding Browser");
		switch (iBrType) {
		case 1:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			logger.log(LogStatus.INFO, "User Option is :"+iBrType+" ,So Invoking Chrome Browser");
			break;
		case 2:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "E:\\selenium\\Selenium_Software\\geckodriver.exe");
			driver=new FirefoxDriver();
			logger.log(LogStatus.INFO, "User Option is :"+iBrType+" ,So Invoking FF Browser");
			break;
			
		case 3:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "E:\\selenium\\Selenium_Software\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			logger.log(LogStatus.INFO, "User Option is :"+iBrType+" ,So Invoking IE Browser");
			break;
		case 4:
			
			System.out.println("User Option is :"+iBrType+" ,So Invoking Headless Browser");
			driver = new HtmlUnitDriver();
			break;

		default:
			System.err.println("User Option is Wrong :"+iBrType+" ,So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Selenium_Software\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.log(LogStatus.INFO, "User Option is Wrong :"+iBrType+" ,So Invoking Default Chrome Browser");
			break;
		}
		logger.endTest();
	}
	
	

  public static void browserProperty(){
	  logger.startTest("Browser Settings", "User Can change the Browser Settings");
		if(iBrType==2){
			driver.manage().deleteAllCookies();
			logger.log(LogStatus.INFO, "System Deleted all the Cookies");
		}else{
			driver.manage().window().maximize();
			logger.log(LogStatus.INFO, "Maximize the Browser");
			driver.manage().deleteAllCookies();
			logger.log(LogStatus.INFO, "System Deleted all the Cookies");
		}
		logger.endTest();
	}
  

  public static void navigatePage(){
	    logger.startTest("Naviagte URL", "User can navigate to the respective pages");
		driver.get(sURL);
		logger.log(LogStatus.INFO, "Navigated URL is : "+sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.endTest();
	}

  public static void getPageInfo() throws Exception{
	  logger.startTest("Get Page Info", "User can get the Page Information");
		System.out.println("Page Title is : " +driver.getTitle());
		String sTitle = driver.getTitle();
		logger.log(LogStatus.INFO, "Page Title is : "+sTitle);
		System.out.println("Page URL is : " +driver.getCurrentUrl());
		System.out.println("Page Title Validated");
		logger.log(LogStatus.INFO, "Page URL is : "+driver.getCurrentUrl());
		if(sTitle.equals("Ebay")){
			logger.log(LogStatus.PASS, "User in Right Page");
		}else{
			logger.log(LogStatus.FAIL, "User Not in Right Page");
			getscreenshot("Ebay_Title");
			Thread.sleep(3000);
			logger.attachScreenshot("D:\\Ebay_Title.png", "Page Title Not Matches");
		}
		
		logger.endTest();
	}

  public static void searchProduct(){
		WebElement oText,oDropDown,oBtn;
		logger.startTest("Search Product", "User Can Search any Product");
		oText = driver.findElement(By.xpath("//*[@id='gh-ac']"));
		oText.sendKeys("iPhone 7");
		logger.log(LogStatus.INFO, "User Typed the Search Item");
		oDropDown = driver.findElement(By.xpath("//*[@id='gh-cat']"));
		Select oSelect = new Select(oDropDown);
		oSelect.selectByVisibleText("Mobile Phones");
		logger.log(LogStatus.INFO, "User Selected the Catagory");
		oBtn = driver.findElement(By.xpath("//*[@id='gh-btn']"));
		oBtn.click();
		logger.log(LogStatus.INFO, "User Clicked on the Search Button");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.endTest();
	}
  
  public static void ScrollPageto(int x,int y){
		JavascriptExecutor oJs;
		String sCmd;
		oJs = (JavascriptExecutor) driver;
		sCmd = String.format("window.scrollTo(%d,%d)",x,y);
		oJs.executeScript(sCmd);
			
	}

  public static void getList() throws Exception{
	  logger.startTest("Get the Search Result", "User Can Get the Result from the UI");
		WebElement oText,oElement;
		try{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oText = driver.findElement(By.xpath("//*[@class='listingscnt']"));
		String sText = oText.getText();
		logger.log(LogStatus.INFO, "Search Result is : "+sText);
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
			String sName = oElement.findElement(By.className("vip")).getText();
			int x = oElement.getLocation().x;
			int y = oElement.getLocation().y;
			ScrollPageto(x, y);
			logger.log(LogStatus.PASS, "Phone Name is : "+sName);
		}
		ScrollPageto(0, 0);
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Test Case Failed , Take the Screen Shot");
			getscreenshot("eBay");
		}
		logger.endTest();
	}
  
  public static void getscreenshot(String sName) throws Exception 
  {
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("D:\\"+sName+".png"));
  }
	

  public static void closeBrowser(){
		driver.close();
	}
}