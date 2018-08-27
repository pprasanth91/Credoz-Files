package selenium.com.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CrizBuzz_Webtable_Hw {

	public static WebDriver driver;
	public static String sURL = "http://www.cricbuzz.com//";
	public static int iBroType =1 ;//(1 - chrome, 2 - FF, 3 - IE,4 - HTMLUnitDriver)
	
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
		
		public static void gettable() throws Exception
		{
			WebElement oTable,oRow,oCol,CurrentPage,Print;
			driver.findElement(By.xpath("//a[text()='Rankings']")).click();
			CurrentPage  = driver.findElement(By.xpath("//h1[text()='ICC Player and Team Rankings']"));
			CurrentPage.getCssValue(sURL);
			System.out.println(CurrentPage.getText().equalsIgnoreCase("ICC Player and Team Rankings"));
			driver.findElement(By.xpath("//a[@id='teams-tab']")).click();
			Thread.sleep(5000);
			oTable = driver.findElement(By.xpath("//div[@id='teams-tests']"));
			List<WebElement> oRow_List = oTable.findElements(By.xpath(".//div[@class='cb-col cb-col-100 cb-font-14 cb-brdr-thin-btm text-center']"));
			for(int i=0;i<oRow_List.size();i++) {
				oRow = oRow_List.get(i);
				List<WebElement> oCol_List = oRow.findElements(By.xpath(".//div"));
				//List<WebElement> oCol_List = oRow.findElements(By.tagName("div"));
				for(int j=0;j<oCol_List.size();j++) {
					oCol = oCol_List.get(j);
					System.out.print(oCol.getText()+"  ");
				}
				System.out.println();
			}
		}
		
		
		
			
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Invoke_Browser();
		browsercustomization();
		navigateURL();
		getPageInfo();
		//UI_Ineracting("Amazon");
		getPageInfo();
		//closeBrowser();
		gettable();
		
	}

}
