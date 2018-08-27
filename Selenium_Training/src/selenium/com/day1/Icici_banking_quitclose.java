package selenium.com.day1;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Icici_banking_quitclose {
	
	public static WebDriver driver;
	
	 
			
			public static void Invoke_browser()
			{
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.navigate().to("http://www.google.com");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
				//String Actual = driver.getTitle();
				//Assert.assertEquals("condition true",Actual,"Google");
				//String Actual = 
				driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("icici");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@value='Google Search']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'ICICI Bank:')]")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//div[@id='push-modal-close']")).click();
				driver.findElement(By.xpath("//a[text()='Private']")).click();
				driver.findElement(By.xpath("//a[text()='Wealth']")).click();
				//driver.findElement(By.xpath("//a[text()='Privilege']")).click();
				//driver.close();
			}
			
			public static void Close_browser()
			
			{
				//List ActiveWindows = (List) driver.getWindowHandles();
				//String ActiveWindow = driver.getWindowHandle();
				//System.out.println("Curent Activewindows"+ActiveWindows);
				//System.out.println("Curent Activewindow"+ActiveWindow);
				
				int iSize = 	driver.getWindowHandles().size();;
				System.out.println("Total Window Opened is : "+iSize);
				if(iSize==1) {
					driver.close();
				}else {
					//driver.quit();
					String homeWindow = driver.getWindowHandle();
					Set<String> allWindows = driver.getWindowHandles();
					System.out.println(homeWindow);
					System.out.println(allWindows);
					//Use Iterator to iterate over windows
					Iterator<String> windowIterator =  allWindows.iterator();

					//Verify next window is available
					while(windowIterator.hasNext())
					{
					    //Store the Recruiter window id
					    String childWindow = windowIterator.next();
					}

					//Here we will compare if parent window is not equal to child window 
					/*if (homeWindow.equals(childWindow))
					{
					    driver.switchTo().window(childWindow);
					    driver.close();
					}*/
				}
			}
			

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				Invoke_browser();
				Close_browser();
			}

		
	}


