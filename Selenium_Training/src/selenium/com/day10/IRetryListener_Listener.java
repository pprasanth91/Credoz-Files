package selenium.com.day10;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryListener_Listener implements IRetryAnalyzer{
	int iRetry=5;
	int iCount=0;
	@Override
	public boolean retry(ITestResult result) {
		
				if(iCount<iRetry){
					iCount++;
					return true;
				}
		return false;
	}

}
