package selenium.com.day4;


	import java.util.List;
	import java.util.concurrent.TimeUnit;

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


	public class Alert_Actions_Ex {

		
		public static WebDriver driver;
		public static int iBroType = 1; //1-Chrome,2-FF,3-IE,4-HTML Unit Driver
		public static String sURL = "https://jqueryui.com/droppable/";

		public static void main(String[] args) throws Exception {
			
			browserInvoke();
			browserSettings();
			navigateURL();
			getPageInfo();
			Mouse_Move();
			//closeBrowser();

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
		
	
		public static void Mouse_Move(){
			Actions oMouse = new Actions(driver);
			WebElement oScr,oTrg;
			driver.switchTo().frame(0);
			oScr = driver.findElement(By.id("draggable"));
			oTrg = driver.findElement(By.id("droppable"));
			//oMouse.dragAndDrop(oScr, oTrg).build().perform();
			//oMouse.clickAndHold(oScr).moveToElement(oTrg).release().build().perform();
			oMouse.clickAndHold(oScr).moveByOffset(50,50).release().build().perform();
			
		}
		
		public static void closeBrowser() {
			//driver.close();
			driver.quit();
		}	
		
		
	}


