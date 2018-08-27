package selenium.com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class Container {
	
	private WebDriver driver;
	private WebElement oLink;
	private WebElement oEdit;
	SearchContext oText;
	public Container(WebDriver driver){
		this.driver = driver;
		
	}
	
	public WebElement Web_Link(String sLink){
		oLink = driver.findElement(By.linkText(sLink));
		return oLink;
	}
	
	public WebElement Web_Edit(String sName){
		oEdit = driver.findElement(By.xpath("//*[@name='"+sName+"']"));
		return oEdit;
	}

}
