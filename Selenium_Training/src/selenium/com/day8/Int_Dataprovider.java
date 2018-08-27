package selenium.com.day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Int_Dataprovider {
	
	
	@DataProvider(name="input")
		public static Object[][] sendValue(){
		Object[][] obj = new  Object[][] {{2,3}};
		return obj;
		
	}
	
	@Test(dataProvider="input")
	public int Add(int a, int b)
	{
		int c= a+b;
		return c;
		
	}
}
