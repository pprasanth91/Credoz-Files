package selenium.com.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.AbstractParallelWorker.Arguments;

public class Random_dropdown {
	
	
	
	public static WebDriver driver;
	public static int iBroType = 1;
	public static String brurl = "https:\\www.amazon.in";
	public static String temp;
	//public static List <String> olist1 = new ArrayList <String>();
	public static WebElement scategory,Osearch,OBtn;
	
	public static void browser_Invoke() {
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+", So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+", So Invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\p.b.prabhakaran\\Downloads\\JDK Path\\Browser Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			}
		
	}
	
	public static void navigate_url(){
		driver.get(brurl);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void get_dropdown_values() throws Exception{
		
		scategory = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
		Select oselect = new Select(scategory);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		List <WebElement> olist = oselect.getOptions();
		int OlistS = olist.size();
		int randnMumber = ThreadLocalRandom.current().nextInt(0, OlistS);
		WebElement option = olist.get(randnMumber);
		String selectedoption =option.getText();
		option.click();
		System.out.println(selectedoption);
		Osearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Osearch.clear();
		String Str =UUID.randomUUID().toString();
		System.out.println(Str);
		String arr[]=UUID.randomUUID().toString().split("-");
		System.out.print(arr[0]);
		Osearch.sendKeys(arr[0]);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		OBtn=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		JavascriptExecutor ojs = (JavascriptExecutor)driver;
		ojs.executeScript("arguments[0].click;",OBtn);
		//OBtn.sendKeys(Keys.ENTER);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		browser_Invoke();
		navigate_url();
		get_dropdown_values();
		//set_dropdown();

	}

}

