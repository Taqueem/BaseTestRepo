package parallel.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
import utility.DriverFactory;
public class TestFunctionalityA extends CommonTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = DriverFactory.getDriver();
	}

	@Test
	public void testA_One() {

		System.out.println("inside testA_One" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testA_two() {

		System.out.println("inside testA_two" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.googleURL);
	}

	@Test
	public void testA_three() {

		System.out.println("inside testA_three " + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.testUrl);
	}

	@Test
	public void testA_four() {

		System.out.println("inside testA_four" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.varvyUrl);
	}
}
