package selenium.com.day5;



import java.sql.Array;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class close_tab {
	
	public static WebDriver driver;
	public static String brurl = "https://www.hdfcbank.com/";
	public static int iBroType=1;
	public static int wincount;
	static By oGoldloan = By.linkText("Gold Loan Calculator");
	static By oRD = By.xpath("//*[text()=' RD Calculator']");
	static By oFD = By.xpath("//*[text()=' FD Calculator']");
	static By oploan = By.xpath("(//*[text()='Personal Loan EMI Calculator'])[2]");
	public static int upperbound = 0;
	
	public static void Invoke_Browser(){
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+", So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+", So Invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "./Driver/chromedriver.exe");
			driver = new FirefoxDriver();
			break;
				}	
	}
	
	public static void navigate_url(){
		driver.manage().window().maximize();
		driver.get(brurl);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void Open_multiple_windows() throws Exception{
	WebElement ogold = driver.findElement(oGoldloan);
	WebElement ofdeposit = driver.findElement(oFD);
	WebElement ordeposit = driver.findElement(oRD);
	WebElement operloan = driver.findElement(oploan);
	Actions oaction = new Actions(driver);
	oaction.moveToElement(ogold).click().build().perform();
	Thread.sleep(10000);
	oaction.moveToElement(ofdeposit).click().build().perform();
	Thread.sleep(10000);
	oaction.moveToElement(ordeposit).click().build().perform();
	Thread.sleep(10000);
	oaction.moveToElement(operloan).click().build().perform();
	Thread.sleep(10000);
	wincount = driver.getWindowHandles().size();
	System.out.println(wincount);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	Thread.sleep(20000);
	String pageurl = driver.getCurrentUrl();
	System.out.println(pageurl);
	Thread.sleep(10000);
	/*driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	Thread.sleep(5000);
	String url = driver.getCurrentUrl();
	System.out.println(url);*/
	}
	
	public static void Page_locations(){
		wincount = driver.getWindowHandles().size();
		for (int i=0 ; i<wincount ; i++){
		driver.switchTo().window(driver.getWindowHandles().toArray()[i].toString());	
		String url = driver.getCurrentUrl();
		System.out.println("Page " + i +" url= " + url);
		upperbound = i;
		}
	}
	
	public static void close_Page() throws Exception{
	if (upperbound == 1)
	{
	driver.switchTo().window(driver.getWindowHandles().toArray()[upperbound-1].toString());	
	Thread.sleep(5000);	
	driver.close();
	}
	
	else {
		if (upperbound == 0){
			System.out.println("Last Child Window is alone Open");
					}
		else{
	driver.switchTo().window(driver.getWindowHandles().toArray()[upperbound].toString());	
	Thread.sleep(5000);
	driver.close();
			}
		}
	}
	
	/*public static void Close_Inactive_windows() throws Exception{
		for (int i=0 ; i<=wincount-1 ; i++){
		int temp = driver.getWindowHandles().size();
		System.out.println("Window Size is " + temp);
		if (i!=0){
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		Thread.sleep(5000);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Thread.sleep(5000);
		String url2 = driver.getCurrentUrl();
		driver.close();
		System.out.println("Window" + url2 + "is being closed");
			}*/	
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Invoke_Browser();
		navigate_url();
		Open_multiple_windows();
		while (wincount!=1){
		Page_locations();
		close_Page();
		}
		//Close_Inactive_windows();
		
	}

}


