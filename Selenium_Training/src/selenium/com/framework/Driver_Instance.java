package selenium.com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Driver_Instance {
	
	public WebDriver driver;
	public ExtentReports logger;
  @BeforeTest
  public void driverInvoke() {
	  logger = new ExtentReports();
	  System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  logger.init("./Report/Instance.html",true);
  }
  
  @AfterMethod
  public void getTestResult(ITestResult result){
	  if(result.getStatus()==ITestResult.FAILURE){
		  logger.log(LogStatus.FAIL, result.getName()+" Test case FAILED due to below issues:"+result.getThrowable());
	  }else{
		  logger.log(LogStatus.PASS,result.getName()+" Test case PASSED");
	  }
	  logger.endTest();
  }
 @AfterTest
  public void closeDriver(){
	  driver.close();
	 
  }
  
}