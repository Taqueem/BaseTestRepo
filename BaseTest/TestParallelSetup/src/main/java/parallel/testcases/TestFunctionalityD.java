package parallel.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
import utility.DriverFactory;
public class TestFunctionalityD extends CommonTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = DriverFactory.getDriver();
	}

	@Test
	public void testD_One() {

		System.out.println("inside testD_One" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_two() {

		System.out.println("inside testD_two" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_three() {

		System.out.println("inside testD_three" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_four() {

		System.out.println("inside testD_four" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}
}
