package parallel.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
import utility.DriverFactory;
public class TestFunctionalityB extends CommonTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = DriverFactory.getDriver();
	}

	@Test
	public void testB_One() {

		System.out.println("inside testB_One" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_two() {

		System.out.println("inside testB_two" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_three() {

		System.out.println("inside testB_three" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_four() {

		System.out.println("inside testB_four" + "on thread" + Thread.currentThread().getId());
		driver.get(ConfigFile.bingUrl);
	}
}
