package selenium.com.day9;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ebay_TestNG_DataProvider {
	
	public static WebDriver driver; 
	public static int iBroType = 1; // 1 - chrome, 2 - FF, 3 - IE,4 - HTMLUnitDriver
	public static String sURL = "https://www.ebay.in/";

@BeforeTest
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
			System.out.println("User Option is : "+iBroType+" , So Invoking Edge Browser");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
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
	
	@Test(priority=1)
	public static void browsercustomization() {
		if(iBroType==2) {
			driver.manage().deleteAllCookies();
		}else {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	}
	
	@Test(priority=2)
	public static void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public static void getPageInfo() {
		System.out.println("Page Tile is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
		String sTitle = driver.getTitle();
		Assert.assertEquals(sTitle, "eBay");
	}
	
	@AfterClass
	public static void closeBrowser() {
		int iSize = 	driver.getWindowHandles().size();
		System.out.println("Total Window Opened is : "+iSize);
		if(iSize==1) {
			driver.close();
		}else {
			driver.quit();
		}
		
	}
	
	@DataProvider(name="Search")
	public static Object[][] sendValue(){
		
		Object[][] oBj = new Object[][] {{"iPhone","Mobile Phones"},{"Nokia","Mobile Phones"},{"Motorola","Mobile Phones"}};
		return oBj;
	}
	
	
	@Test(priority=4,dataProvider="Search")
	public static void ebaySearch(String sSearch,String sCat) {
		WebElement oTxt,oDropDown,oBtn;
		oTxt = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		boolean result = oTxt.isDisplayed();
		Assert.assertEquals(result, true);
		oTxt.clear();
		oTxt.sendKeys(sSearch);
		
		oDropDown = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oDropDown);
		oSelect.selectByVisibleText(sCat);
		
		oBtn = driver.findElement(By.xpath("//input[@id='gh-btn']"));
		oBtn.submit();
		getSearchResult();
	}
	
	//@Test(priority=5)
	public static void getSearchResult() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement oResultText,oElement;
		oResultText = driver.findElement(By.xpath("//span[@class='listingscnt']"));
		String sText = oResultText.getText();
		System.out.println("Search Result is : "+sText);
		sText = sText.replaceAll("[^0-9]", "").trim();
		int iText = Integer.parseInt(sText);
		if(iText>0) {
			System.out.println("Search Result is Available");
			List<WebElement> oList = driver.findElements(By.xpath("//ul[@id='ListViewInner']/li"));
			for(int i=0;i<oList.size();i++) {
				oElement = oList.get(i);
				System.out.println(oElement.findElement(By.className("vip")).getText());
				int x = oElement.getLocation().x;
				int y = oElement.getLocation().y;
				ScrollPageto(x, y);
			}
			ScrollPageto(0, 0);
		}else {
			System.out.println("Search Result is 0");
		}
	}
	
	public static void ScrollPageto(int x,int y){
		JavascriptExecutor oJs;
		String sCmd;
		oJs = (JavascriptExecutor) driver;
		sCmd = String.format("window.scrollTo(%d,%d)",x,y);
		oJs.executeScript(sCmd);
			
	}
}
