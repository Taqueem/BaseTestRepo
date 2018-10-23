package parallel.testcases;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
public class TestFunctionalityD extends CommonTest {

	@Test
	public void testD_One() {

		System.out.println("inside testD_One" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_two() {

		System.out.println("inside testD_two" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_three() {

		System.out.println("inside testD_three" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testD_four() {

		System.out.println("inside testD_four" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}
}
