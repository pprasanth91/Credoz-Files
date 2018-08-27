package selenium.com.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SeleniumHQ_Child2 extends Google_Child1{
	//WebDriver driver;
	
	//@BeforeClass
	public void setDriver(){
	driver = getDriver();	
	}
	
  @Test(priority=4)
  public void seleniumHQ() {
	  logger.startTest("Selenium HQ Test Started"); 
	  driver.findElement(By.xpath("//*[text()='previous releases']")).click();
	  logger.log(LogStatus.INFO, "Previous Releases Link Clicked");
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Assert.assertTrue(true);
	  logger.endTest();
  }
}
