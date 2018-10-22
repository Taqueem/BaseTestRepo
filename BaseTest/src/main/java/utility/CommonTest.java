package utility;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class CommonTest {

	public static String selectedDriver;

	@BeforeTest
	@Parameters(value = {"browser"})
	public void setupTest(@Optional("chrome") String browser) {

		System.out.println("Inside @BeforeTest of CommonTest class");
		selectedDriver = DriverFactory.getBrowserName();
		if (selectedDriver == null) {
			DriverFactory.setDriver(browser);
			// driver = DriverFactory.getDriver();
		} else if (!browser.contentEquals(selectedDriver)) {
			DriverFactory.setDriver(browser);
			// driver = DriverFactory.getDriver();
		}
	}

	@AfterTest
	public void afterTest() {

		System.out.println("Inside @AfterTest of CommonTest class for the thread " + Thread.currentThread().getId());
		DriverFactory.closeBrowser();
	}
}
