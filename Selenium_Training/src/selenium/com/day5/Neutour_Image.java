package selenium.com.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Neutour_Image {

	public static WebDriver driver;
	public static String URL ="http://newtours.demoaut.com/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	 driver.get(URL);
	 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("//img[@src='/images/nav/logo.gif']")).click();
	 System.out.println("Image clicked successfully");
	}

}
