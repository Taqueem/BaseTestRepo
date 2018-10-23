package parallel.testcases;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
public class TestFunctionalityB extends CommonTest {

	@Test
	public void testB_One() {

		System.out.println("inside testB_One" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_two() {

		System.out.println("inside testB_two" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_three() {

		System.out.println("inside testB_three" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testB_four() {

		System.out.println("inside testB_four" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}
}
