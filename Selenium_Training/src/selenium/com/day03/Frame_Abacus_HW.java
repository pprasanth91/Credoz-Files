package selenium.com.day03;


//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Frame_Abacus_HW {

	public static WebDriver driver;
	public static String SURL = "https://indaorm.ciostage.accenture.com/login.aspx";
	
	public static void Invoke_browser() 
	{
		System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.navigate().to(SURL);
		//Thread.sleep(50000);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	public static void Frame() 
	{
		WebElement Fcontents,FMain;
		Fcontents = driver.findElement(By.xpath("//frame[@id='frmContents']"));
		driver.switchTo().frame(Fcontents);
		 driver.findElement(By.xpath("//a[text()='Candidate']")).click();
		 //driver.switchTo().defaultContent();
		 //Thread.sleep(10000);
		//driver.switchTo().defaultContent();
		 //driver.switchTo().frame(Fcontents);
		 driver.findElement(By.id("TreeControl1_mtrvDsasListt4")).click();
		//driver.findElement(By.xpath("//div[@id='TreeControl1_mtrvDsasListn3Nodes']/table[1]")).click();
		driver.switchTo().defaultContent();
		FMain = driver.findElement(By.xpath("//frame[@id='frmMain']"));
		driver.switchTo().frame(FMain);
		//String PageTitle = driver.getTitle();
		//System.out.println(PageTitle);
		if (driver.getTitle().equalsIgnoreCase("Add Candidate"))
		{
			System.out.println("Navigated to Add candidate page");
			String CurrentTab = driver.findElement(By.xpath("//a[@id='__tab_tbAddCandidate_tbBasicDetails']")).getText();
			if(CurrentTab.equalsIgnoreCase("Basic Details"))
			{
				driver.findElement(By.xpath("//input[@id='ctl07_txtFName']")).sendKeys("Sri");
				driver.findElement(By.xpath("//input[@id='ctl07_txtLName']")).sendKeys("Kamatchi");
				//WebElement Gender = driver.findElement(By.xpath("//select[@id='ctl07_cboGender']"));
				Select Ogender = new Select (driver.findElement(By.xpath("//select[@id='ctl07_cboGender']")));
				Ogender.selectByVisibleText("Female");
				driver.findElement(By.xpath("//a[@id='ctl07_hypDOB']")).click();
				boolean FCalendar = driver.findElement(By.xpath("//title[text()='Calendar']")).isDisplayed();
				System.out.println(FCalendar);
						
							
			}
			
		}
		else
		{
			System.out.println("User not in Add candidate page");
		}
		
	}
	
	public static void CloseBrowser()
	{
		int iSize = driver.getWindowHandles().size();
		System.out.println("Total current active window:"+iSize);
		if (iSize ==1)
		{
			driver.close();
		}else {
			driver.quit();
		}
			
		}
		
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Invoke_browser();
		Frame();
		//CloseBrowser();
	}

}

