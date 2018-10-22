package parallel.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
import utility.DriverFactory;
public class TestFunctionalityC extends CommonTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = DriverFactory.getDriver();
	}

	@Test
	public void testC_One() {

		System.out.println("inside testC_One" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testC_two() {

		System.out.println("inside testC_two" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testC_three() {

		System.out.println("inside testC_three" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testC_four() {

		System.out.println("inside testC_four" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}
}
