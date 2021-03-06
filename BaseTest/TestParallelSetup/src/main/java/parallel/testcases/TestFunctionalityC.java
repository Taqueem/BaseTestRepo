package parallel.testcases;
import org.testng.annotations.Test;

import utility.CommonTest;
import utility.ConfigFile;
public class TestFunctionalityC extends CommonTest {

	@Test
	public void testC_One() {

		System.out.println("inside testC_One" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.googleURL);
	}

	@Test
	public void testC_two() {

		System.out.println("inside testC_two" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.googleURL);
	}

	@Test
	public void testC_three() {

		System.out.println("inside testC_three" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.googleURL);
	}

	@Test
	public void testC_four() {

		System.out.println("inside testC_four" + "on thread" + Thread.currentThread().getId());
		System.out.println("Running on the driver: " + getBrowserName());
		driver.get(ConfigFile.googleURL);
	}
}
