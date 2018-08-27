package selenium.com.day2;

	import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


	 
	public class list_Webelement_HW {
		
		public static WebDriver driver; 
		public static int iBroType = 1; // 1 - chrome, 2 - FF, 3 - IE,4 - HTMLUnitDriver
		public static String sURL = "https://www.google.co.in/";
		

		public static void main(String[] args) {
			browserInvoke();
			browsercustomization();
			navigateURL();
			getPageInfo();
			uiInteract("newtour demo");
			getPageInfo();
			Register();
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
		
		public static void uiInteract(String sSearch) {
			WebElement oSearch,obtn,olink;
			oSearch = driver.findElement(By.xpath("//input[@id='lst-ib']"));
			oSearch.sendKeys(sSearch);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			obtn = driver.findElement(By.xpath("//input[@value='Google Search']"));
			obtn.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.findElement(By.className("lsb")).sendKeys(Keys.ENTER);
			
			olink = driver.findElement(By.xpath("//a[text()='Newtours - 974636 www.demoaut.com']"));
			olink.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		public static void Register() 
		{
			WebElement oRegisterlist,oCountry,oOption;
			//List<WebElement> SelectedValue;
			oRegisterlist = driver.findElement(By.xpath("//a[text()='REGISTER']"));
			oRegisterlist.click();
			
			oCountry = driver.findElement(By.xpath("//select[@name='country']"));
			Select objCountry =  new Select (oCountry);
			objCountry.selectByVisibleText("INDIA");
			//SelectedValue= objCountry.getFirstSelectedOption();
			//SelectedValue = objCountry.getOptions();
			//String SelectedValue = oCountry.getText();//valid option
			//System.out.println("Current visible Text:"+SelectedValue);//valid option
			System.out.println("Current visible Text:"+oCountry.getText());
			//oCountry.clear();
			
			List<WebElement> oList  = driver.findElements(By.xpath("//Select[@name='country']/option"));
			//Set<WebElement> hash_Set = new HashSet<WebElement>(oList);
			for(int i=0;i<oList.size();i++)
			{
				oOption =oList.get(i);
				System.out.println("Country value:"+oOption.getText());
			}
			
		}
	
	}