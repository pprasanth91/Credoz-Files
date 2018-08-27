package selenium.com.day4;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.JCommander.Builder;

public class Amazon_Switch_Browser_HW {

	
	public static WebDriver driver;
	public static int iBroType=1;
	public static String SURL = "https://www.amazon.in/";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Invoke_Browser();
		Browser_customization();
		NavigateURL();
		//GetPageInfo();
		Amazon_SwitchBrowser("iphone", "Electronics");
		closeBrowser();
		
	}

	public static void Invoke_Browser()
	{
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
	
	public static void Browser_customization()
	{
		if(iBroType==2) {
			driver.manage().deleteAllCookies();
		}else {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	}
	
	public static void NavigateURL() {
		
		driver.navigate().to(SURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void GetPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page URL is : "+driver.getCurrentUrl());
	}
	public static void Amazon_SwitchBrowser(String sSearch, String OSearchList) throws Exception
	{
		WebElement oSign,Oorders,Osearch,ODropdown,OBtn,SelectedProduct,BuyProduct,Ocart,oSignout;
		
		Oorders = driver.findElement(By.xpath("//span[contains(text(),'Hello.')]"));
		WebDriverWait owait = new WebDriverWait(driver,30);
		owait.until(ExpectedConditions.elementToBeClickable(Oorders));
		oSign = driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
		Actions oMouse = new Actions(driver);
		oMouse.clickAndHold(Oorders).build().perform();
		//owait.until(ExpectedConditions.elementToBeClickable(oSign));
		//oMouse.moveToElement(oSign).build().perform();
		oSign.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("9944170165");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Devosri11!");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).submit();
		String LoggedinUser = driver.findElement(By.xpath("//span[contains(text() ,'Hello')]")).getText();
		System.out.println("Logged Username  :" +LoggedinUser);
		//String LoggedinUserTrim = LoggedinUser.substring(7);
		String LoggedinUserTrim = LoggedinUser.replace("Hello,", "").trim();
		System.out.println("Trimmed Logged Username  :" +LoggedinUserTrim);
		LoggedinUserTrim.equalsIgnoreCase("Sri");
		System.out.println("Sri Logged in Successfully");
		Ocart= driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
		String Ocart1 =Ocart.getText();
		int OcartValue = Integer.parseInt(Ocart1);
		System.out.println(OcartValue);
		
		//search product
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
		
		//select product
		System.out.println("Before Selecting Product : "+driver.getWindowHandles().size());
		 SelectedProduct = driver.findElement(By.xpath("(//ul[@id='s-results-list-atf']//li//div[@class='a-row a-spacing-mini']//h2)[1]"));
		 String SelectedProduct1 = SelectedProduct.getText();
		 System.out.println(SelectedProduct1);
		 SelectedProduct.click();
		System.out.println(" After Selecting Product : "+driver.getWindowHandles().size());
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		BuyProduct = driver.findElement(By.xpath("//span[@id='productTitle']"));
		 String BuyProduct1 = BuyProduct.getText();
		 System.out.println(BuyProduct1);
		 boolean Compare = SelectedProduct1.equals(BuyProduct1);
		 if (Compare ==true)
		 {
			 System.out.println("Selected and viewed product are same");
			 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).submit();
			 Ocart= driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
			 String Ocart2 =Ocart.getText();
			 int OcartValue2 = Integer.parseInt(Ocart2);
			 System.out.println(OcartValue2);
			 if(OcartValue2 > OcartValue)
			 {
				 System.out.println("New item added to cart");
			 }
			 else
			 {
				 System.out.println("New item not added to cart");
			 }
			 
		}
		 
		 else
		 {
			 System.out.println("Selected and viewed product are not the same");
		 }
		
		 driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		 Thread.sleep(3000);
		 Oorders = driver.findElement(By.xpath("//span[contains(text() ,'Hello,')]"));
		 oMouse.clickAndHold(Oorders).build().perform();
		 Thread.sleep(3000);
		 oSignout = driver.findElement(By.xpath("//span[text()='Sign Out']"));
		 oSignout.click();
		 //driver.close();
}
	
	public static void closeBrowser() {
		//driver.close();
		//driver.quit();
		int iSize = driver.getWindowHandles().size();
		System.out.println(iSize);
		if (iSize==1)
		{
			driver.close();
		}
		else if(iSize>1)
		{
			for(int i=iSize;i>1;i--)
			{
				//int sSize = iSize--;
				//String sSize1 = Integer.toString(sSize);
				driver.switchTo().window(driver.getWindowHandles().toArray()[i-1].toString());
				driver.close();
				
			}
		}
	}
	
	
}
