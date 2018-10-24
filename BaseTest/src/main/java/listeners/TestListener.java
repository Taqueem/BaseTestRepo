package listeners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import utility.ExtentReporter;
import utility.Operations;
import utility.RetryFailedTests;
public class TestListener implements ITestListener, IAnnotationTransformer {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Inside onTestStart");
		String methodName = result.getTestClass() + "::"
				+ result.getName().toString();
		System.out
				.println("on test  start listener for the method" + methodName);
		ExtentReporter.startReporting(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getName().toString();
		ExtentReporter.test.pass(methodName);
		System.out.println("After test passed listener");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString();
		Operations.takeScreenShot(methodName);
		ExtentReporter.test.fail(methodName);
		System.out.println("After test Failed listener");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {

		ExtentReporter.initializeExtentReport(context.getStartDate().toString());
		System.out.println("Inside onStart with the context" + context.getName());
		System.out.println(context.getStartDate().toString());
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Inside on Finish");
		// TODO Auto-generated method stub
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {

		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}
}
