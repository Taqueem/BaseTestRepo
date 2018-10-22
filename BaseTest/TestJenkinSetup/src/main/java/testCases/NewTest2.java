package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewTest2 {

	WebDriver driver;

	@Test
	public void testSample() {

		System.out.println("Inside the test");
		System.setProperty("webdriver.gecko.driver",
				"D:\\Selenium\\Driver\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		/*		FirefoxOptions options = new FirefoxOptions();
				options.setBinary(
						"C:\\Program Files\\Mozilla Version\\55.0\\firefox.exe");
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setAcceptInsecureCerts(true);*/
		driver = new FirefoxDriver();
		driver.get("https://www.yahoo.in");
	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("Inside the beforeTest");
	}

	@AfterTest
	public void afterTest() {

		System.out.println("Inside the afterTest");
	}
}
