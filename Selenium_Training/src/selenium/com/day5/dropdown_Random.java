package selenium.com.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown_Random {

			
		
		public static WebDriver driver;
		public static int iBroType = 1;
		public static String brurl = "https:\\www.amazon.in";
		public static String temp;
		public static List <String> olist1 = new ArrayList <String>();
		public static WebElement scategory;
		
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
			System.out.println("The List Values are ");	
			for (int i=0 ; i<olist.size(); i++){
			temp = olist.get(i).getText();
			olist1.add(temp);
			}
			System.out.println(olist1);
			int OlistS = olist1.size();
		}
		
		public static void set_dropdown()
		{
			String temp = null;
			
			for (int i=0 ; i<olist1.size();i++){
				
					temp = olist1.get(i).toString();
				//System.out.println(temp);	
				if (temp.matches("Electronics")){
					break;
					}
				
			System.out.println(temp);
			//oselect.selectByVisibleText(temp);	
			}
			System.out.println(temp);
			Select oselect = new Select(scategory);
			oselect.selectByVisibleText(temp);	
		}
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			
			browser_Invoke();
			navigate_url();
			get_dropdown_values();
			set_dropdown();

		}

	}
