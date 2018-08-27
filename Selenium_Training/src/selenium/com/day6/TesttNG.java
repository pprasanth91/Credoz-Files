package selenium.com.day6;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TesttNG {
	
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("This is Before Suit Method");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("This is After Suit Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test Method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test Method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class Method");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
	}
	
	//Default priority 0 and priority also allow negative value
  @Test(priority=0,invocationCount=1)
  public void testcase1() {
	  System.out.println("This is Test Case 1");
  }
  
  @Test(priority=2,enabled=true,threadPoolSize  =6,timeOut=100,invocationCount =10)
  public void testcase2() {
	  System.out.println("This is Test Case 2");
	  System.out.println(Thread.currentThread().getId());
  }
  @Test(priority=3,enabled=true)
  public void testcase3() {
	  System.out.println("This is Test Case 3");
  }
  
  
  
}

