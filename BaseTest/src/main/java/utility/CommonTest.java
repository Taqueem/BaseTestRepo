package utility;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class CommonTest {

	public static String	selectedDriver;

	public static WebDriver	driver;

	@BeforeClass
	public void beforeClass() {

		System.out.println("Inside @BeforeClass with in  CommonTest");
		driver = DriverFactory.getDriver();
		System.out.println(this.getClass().getSimpleName());
		ExtentReporter.startTestClass(this.getClass().getSimpleName());
	}

	@BeforeTest
	@Parameters(value = {"browser"})
	public void setupTest(@Optional("firefox") String browser) {

		System.out.println("Inside @BeforeTest of CommonTest class");
		selectedDriver = DriverFactory.getBrowserName();
		if (selectedDriver == null) {
			// DriverFactory.setDriver(browser);
			DriverFactory.setDrivers(browser);
		} else if (!browser.contentEquals(selectedDriver)) {
			DriverFactory.setDrivers(browser);
		}
	}

	@AfterTest
	public void afterTest() {

		System.out.println("Inside @AfterTest of CommonTest class for the thread " + Thread.currentThread().getId());
		DriverFactory.closeBrowser();
	}

	public String getBrowserName() {

		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		return browserName;
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {

		ExtentReporter.endReporting();
	}
}
