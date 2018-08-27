package selenium.com.day10;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuitListener_Listener implements ISuiteListener{
	
	long startTime;
	long executionTime;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Suit Started : "+suite.getName());
		startTime = System.currentTimeMillis();
		System.out.println("Execution Started and Time in MS is : "+startTime);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suit Completed : "+suite.getName());
		executionTime = (System.currentTimeMillis()-startTime);
		System.out.println("Execution Completed and Time in MS is : "+executionTime);
		
	}

}
