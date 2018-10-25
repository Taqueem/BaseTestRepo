package listeners;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import utility.ExtentReporter;
import utility.Operations;
import utility.RetryFailedTests;
public class TestListener implements ITestListener, IAnnotationTransformer, ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {

		// run before every test method
		System.out.println("Inside onTestStart");
		String methodName = result.getName().toString();
		System.out
				.println("on test  start listener for the method" + methodName);
		ExtentReporter.startTestMethod(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getName().toString();
		ExtentReporter.methodTest.pass(methodName);
		System.out.println("After test passed listener");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getName().toString();
		String imagePath = Operations.takeScreenShot(methodName);
		ExtentReporter.methodTest.fail(methodName);
		try {
			ExtentReporter.methodTest.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		// ExtentReporter.initializeExtentReport(context.getStartDate().toString());
		System.out.println("Inside onStart with the context" + context.getName());
		System.out.println(context.getStartDate().toString());
		ExtentReporter.startSuiteTest(context.getName());
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

	@Override
	public void onStart(ISuite suite) {

		ExtentReporter.initializeExtentReport(suite.getName());
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ISuite suite) {

		// TODO Auto-generated method stub
	}
}
