package utility;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReporter {

	private static ExtentReports					extent;

	private static ExtentHtmlReporter				htmlReporter;

	private static ExtentTestInterruptedException	testexception;

	public static ExtentTest						suiteTest;

	public static ExtentTest						classTest;

	public static ExtentTest						methodTest;

	public static void initializeExtentReport(String SuiteName) {

		extent = new ExtentReports();
		/*File file2 = new File(ConstantPath.pathExtentReports + "abcd_" +
				"extent.html");
		File file = new File(ConstantPath.pathExtentReports +
				"extent.html");*/
		htmlReporter = new ExtentHtmlReporter(
				ConstantPath.pathExtentReports + SuiteName + new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date()) +
						"_extent.html");
		// htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") +
		// "\\Extent-Config.xml"));
		// make the charts visible on report open
		htmlReporter.config().setChartVisibilityOnOpen(true);
		// create offline report (pro-only)
		// htmlReporter.config().setCreateOfflineReport(true);
		// automatic screenshot management (pro-only)
		// htmlReporter.config().setAutoCreateRelativePathMedia(true);
		// report title
		htmlReporter.config().setDocumentTitle("aventstack - ExtentReports");
		// encoding, default = UTF-8
		htmlReporter.config().setEncoding("UTF-8");
		// protocol (http, https)
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		// report or build name
		htmlReporter.config().setReportName("Build-1224");
		// chart location - top, bottom
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		// theme - standard, dark
		htmlReporter.config().setTheme(Theme.STANDARD);
		// set timeStamp format
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
		// add custom css
		htmlReporter.config().setCSS("css-string");
		// add custom javascript
		htmlReporter.config().setJS("js-string");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "QA-Sanity");
		System.out.println("inside initialize extent report");
	}

	/*	public static void startReporting(String methodName) {
	
			test = extent.createTest(
					this.getClass().getSimpleName() + "::" + method.getName());
			childTest = extent.createTest(methodName);
			System.out
					.println("inside start reporting for the method" + methodName);
		}*/
	public static void startTestMethod(String methodName) {

		methodTest = classTest.createNode(methodName);
	}

	/*public static void startTestClass(String className) {
	
		parentTest = extent.createTest(className);
		parentTest.assignAuthor("Taqueem Jawed");
	}*/
	public static void startTestClass(String className) {

		classTest = suiteTest.createNode(className);
	}

	public static void startSuiteTest(String TestName) {

		suiteTest = extent.createTest(TestName);
		suiteTest.assignAuthor("Taqueem Jawed");
	}

	public static void endReporting() {

		extent.flush();
		System.out.println("inside end reporting");
	}
}
