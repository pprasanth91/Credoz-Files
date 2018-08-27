package selenium.com.day10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class IAnnotationTransformer_Listener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		String sTestCase = testMethod.getName();
		switch (sTestCase) {
		case "browserProperty":
			annotation.setPriority(1);
			annotation.setEnabled(true);
			break;
		case "navigatePage":
			annotation.setPriority(2);
			annotation.setEnabled(true);
			break;
		case "getPageInfo":
			annotation.setPriority(3);
			annotation.setEnabled(true);
			break;
		case "searchProduct":
			annotation.setPriority(4);
			annotation.setEnabled(true);
			break;
		case "getList":
			annotation.setPriority(5);
			annotation.setEnabled(true);
			break;

		default:
			System.out.println("Wrong Test Case Name");
			break;
		}
		
	}

}
