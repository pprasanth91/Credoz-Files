package selenium.com.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Product_Select_Webelement_Hw {
	
	public static WebDriver driver;
	public static String sURL = "https://www.amazon.in/";
	public static int iBroType =2 ;//(1 - chrome, 2 - FF, 3 - IE,4 - HTMLUnitDriver)
	
	public static void Invoke_Browser()
	{
		switch (iBroType)
		{
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
		
		public static void UI_Ineracting(String sSearch)
		{
			WebElement oSearch,oBtn,oLink;
			oSearch = driver.findElement(By.xpath("//input[@id='lst-ib']"));
			boolean Displayed = oSearch.isDisplayed();
			//System.out.println("jjjn"+Displayed);
			if (Displayed = true)
			{
				System.out.println("Text field is Visible");
			}
			else
			{
				System.out.println("Text field is Not Visible");
			}
			oSearch.sendKeys(sSearch);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			oBtn = driver.findElement(By.xpath("//input[@value='Google Search']"));
			boolean Enabled = oSearch.isEnabled();
			//System.out.println("jjjn"+Displayed);
			if (Enabled = true)
			{
				System.out.println("Text field is Enabled");
			}
			else
			{
				System.out.println("Text field is Disabled");
			}
			oBtn.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			oLink = driver.findElement(By.xpath("//a[@id='vn1s0p1c0']"));
			oLink.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
		}

		
			public static void Amazon_Product_Search(String sSearch, String OSearchList)
			{
					WebElement Osearch,ODropdown,OBtn;
					Osearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
					Osearch.clear();
					Osearch.sendKeys(sSearch);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					
					ODropdown =	driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
					//ODropdown =	driver.findElement(By.xpath("//div[@class='nav-search-facade']"));
					Select OSList = new Select(ODropdown);
					OSList.selectByVisibleText(OSearchList);
			
					
					OBtn=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
					OBtn.sendKeys(Keys.ENTER);
					
					
			}
			
			public static void SearchResult()
			{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement oResultText,OProductName,oElement;
				oResultText = driver.findElement(By.xpath("//span[@id='s-result-count']"));
				String sText = oResultText.getText();
				System.out.println("Before Trim:"+sText);
				System.out.println("Search Result is : "+sText);
				sText = sText.substring(0, 1);
				System.out.println("After Trim:"+sText);
				int iText = Integer.parseInt(sText);
				if(iText>0) {
					System.out.println("Search Result is Available");
					List<WebElement> oList = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
					for(int i=0;i<oList.size();i++) 
				{
						oElement = oList.get(i);
						System.out.println("dsd"+oElement);
						System.out.println(oElement.findElement(By.xpath(".//div[@class='a-row a-spacing-mini']/a")).getText());
								//className("a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal")).getText());
						//OProductName = driver.findElement(By.xpath("//div[@class='a-row a-spacing-mini']/a"));
						//System.out.println("Product name:"+OProductName.getText()); ;
						
					}
				}else {
					System.out.println("Search Result is 0");
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Invoke_Browser();
		browsercustomization();
		navigateURL();
		getPageInfo();
		//UI_Ineracting("Amazon");
		getPageInfo();
		Amazon_Product_Search("T-Shirt","Clothing & Accessories");
		getPageInfo();
		SearchResult();
	//	closeBrowser();
		
	}

}
