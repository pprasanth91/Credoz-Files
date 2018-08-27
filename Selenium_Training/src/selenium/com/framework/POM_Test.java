package selenium.com.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
 
public class POM_Test {
 
	/**
	 * @param args
	 */
	Container oCon;
	
	private static WebDriver driver;
	
	public POM_Test(WebDriver driver){
		this.driver = driver;
	}
	
	public void Test(){ 
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oCon = new Container(driver);
		oCon.Web_Link("REGISTER").click();
		oCon.Web_Edit("firstName").sendKeys("Mathan");
		oCon.Web_Edit("lastName").sendKeys("Chandrasekaran");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		POM_Test oBj = new POM_Test(driver);
		oBj.Test();
 
 
	}
 
}

