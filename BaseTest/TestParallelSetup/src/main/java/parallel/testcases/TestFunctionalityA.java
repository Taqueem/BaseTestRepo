package parallel.testcases;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
public class TestFunctionalityA extends CommonTest {

	@Test
	public void testA_One() {

		System.out.println("inside testA_One" + " on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.bingUrl);
	}

	@Test
	public void testA_two() {

		System.out.println("inside testA_two" + " on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.googleURL);
	}

	@Test
	public void testA_three() {

		System.out.println("inside testA_three " + " on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.testUrl);
	}

	@Test
	public void testA_four() {

		System.out.println("inside testA_four" + " on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.varvyUrl);
	}
}
