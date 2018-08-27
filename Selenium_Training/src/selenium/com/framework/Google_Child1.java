package selenium.com.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Google_Child1 extends Driver_Instance{
  @Test(priority=1)
  public void navigateURL() {
	  logger.startTest("Open Window");
	  driver.manage().window().maximize();
	  logger.log(LogStatus.INFO, "Browser Maximize");
	  driver.get("https://www.google.co.in/");
	  logger.log(LogStatus.INFO, "Navigated to URL");
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Assert.assertTrue(true);
  }
  
  @Test(priority=2)
  public void interactUI(){
	  logger.startTest("Google Interaction");
	  WebElement oButton;
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("lst-ib")).sendKeys("Selenium HQ");
	  logger.log(LogStatus.INFO, "Entered Search Text");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  oButton = driver.findElement(By.className("lsb"));
	  if(oButton.isDisplayed()){
		  oButton.click();
	  }else{
		  driver.findElement(By.name("btnK")).click();  
	  }
	  
	  driver.findElement(By.xpath("//*[text()='Downloads']")).click();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Assert.assertTrue(false);
  }
  
 // @Test(priority=3)
 public WebDriver getDriver(){
  return driver;
  }
  
  
}








