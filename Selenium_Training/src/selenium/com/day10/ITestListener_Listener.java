package selenium.com.day10;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListener_Listener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started and Its Name is : "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Successed and Its Name is : "+result.getName());
		System.out.println("Status is : "+result.getStatus());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed and Its Name is : "+result.getName());
		System.out.println("Status is : "+result.getStatus());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped and Its Name is : "+result.getName());
		System.out.println("Status is : "+result.getStatus());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started and its Name is : "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finished and its Name is : "+context.getName());
		
	}

}
