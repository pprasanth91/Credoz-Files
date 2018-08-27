package selenium.com.day1;


import java.util.concurrent.TimeUnit;

//import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Newtour_Register {
	
	public static WebDriver driver; 
	
	public static void Invoke_browser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Selenium Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//String actualTitle = driver.getTitle();
		//String expectedTitle = "Google";
		if (driver.getTitle().equalsIgnoreCase("GOOGLE"))
		{			
			System.out.println("Reached Google Page Succesfully");
		}
		else
		{
			System.out.println("User not in  Google page");
		}
		
	}
	public static void Newtour_Browser(String sSearch)
	{
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(sSearch);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		//driver.findElement(By.className("lsb")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Newtours - 974636 www.demoaut.com']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String ExpectedTitle = "Welcome: Mercury Tours";
		String ActualTitle = driver.getTitle();
		System.out.println("Page name:"+ExpectedTitle);
		int Value = ExpectedTitle.compareToIgnoreCase(ActualTitle);
		if (Value==0)
		{			
			System.out.println("Reached NewTour Demo Page Succesfully");
		}
		else
		{
			System.out.println("User not in  NewTour Demo Page page");
		}
	}
	public static void Register()
	{
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click() ;
		//if (driver.getTitle().contains((CharSequence) driver.findElement(By.xpath("(//a[text()='REGISTER']/../following::td)[7])"))))
		String ExpectedName = "Register: Mercury Tours";
		System.out.println("Page name:"+ExpectedName);
		//if (driver.getTitle().contains(ExpectedName))
			if (driver.getTitle().contentEquals(ExpectedName))
		{			
			System.out.println("Reached Register Page Succesfully");
		}
		else
		{
			System.out.println("User not in  Registeration page");
		}
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("SriKamatchii");
		String Username = driver.findElement(By.name("firstName")).getText();
		System.out.println("Username of Registering"+Username);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("V");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9944170164");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("sriKamatchi.balu1@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Plot 4bc,Nehru Street");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Gowrivakkam");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("TamilNadu");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600073");
		Select objCountry =  new Select (driver.findElement(By.xpath("//select[@name='country']")));
		objCountry.selectByVisibleText("INDIA");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sriKamatchi.balu1@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Devosri11");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Devosri11");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//b[contains(text() , 'Sri')]"));
		String RegistredUserName = driver.findElement(By.xpath("//b[contains(text() ,'Sri')]")).getText();
		System.out.println("Username of  Registered :" +RegistredUserName);
		String RegistredUserName1 = RegistredUserName.substring(5);
		System.out.println("Trimmed Username of  Registered :" +RegistredUserName1);
		if(RegistredUserName.contains(Username))
		{
			System.out.println("User got Registered succesfully");
		}
		else
		{
			System.out.println("User not Registered ");
		}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Invoke_browser();
		Newtour_Browser("newtour demo");
		Register();
		closeBrowser();
	}

}
