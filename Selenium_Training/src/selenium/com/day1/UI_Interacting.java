package selenium.com.day1;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.htmlunit.HtmlUnitDriver;
	 
	public class UI_Interacting {
		
		public static WebDriver driver; 
		public static int iBroType = 1; // 1 - chrome, 2 - FF, 3 - IE,4 - HTMLUnitDriver
		public static String sURL = "https://www.google.co.in/";
		

		public static void main(String[] args) {
			browserInvoke();
			browsercustomization();
			navigateURL();
			getPageInfo();
			uiInteract("Selenium HQ");
			getPageInfo();
		//	closeBrowser();
			

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
			driver.findElement(By.id("lst-ib")).sendKeys(sSearch);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className("lsb")).click();
			//driver.findElement(By.className("lsb")).sendKeys(Keys.ENTER);
			driver.findElement(By.linkText("Downloads - Selenium")).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}

	}