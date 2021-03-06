package utility;
import java.net.InetAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DriverFactory {

	private static OptionsManager			optionsManager	= new OptionsManager();

	private static ThreadLocal<WebDriver>	driver			= new ThreadLocal<>();

	private static ThreadLocal<String>		selectedBrowser	= new ThreadLocal<String>();

	public static synchronized void setDrivers(String browser) {

		try {
			System.out.println("The adress is " + InetAddress.getLocalHost().toString().trim());
			if (InetAddress.getLocalHost().toString().trim().contains(ConfigFile.hubIpAdress)) {
				System.out.println("Setting up driver for Grid");
				setDriverforGrid(browser);
			} else {
				System.out.println("Setting up driver for Local");
				setDriver(browser);
			}
		} catch (Exception e) {
			System.out.println("Exception Happened in Hub node configuration");
			e.printStackTrace();
		}
	}

	public static synchronized void setDriverforGrid(String browser) {

		try {
			if (browser.equalsIgnoreCase("firefox")) {
				driver.set(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), optionsManager.getFirefoxOptions()));
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver.set(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), optionsManager.getChromeOptions()));
			} else if (browser.equalsIgnoreCase("ie")) {
				driver.set(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), optionsManager.getIEOptions()));
			} else if (browser.equalsIgnoreCase("edge")) {
				driver.set(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), optionsManager.getEdgeOptions()));
			}
		} catch (Exception e) {
			System.out.println("Exception Happened in Hub node configuration");
			// e.printStackTrace();
			setDriver(browser);
		}
	}

	public static synchronized void setDriver(String browser) {

		if (browser.equals("firefox")) {
			// For Local Usage
			System.out.println("Inside firefox setDriver in DriverFactory class ");
			System.out.println("the user directory is" + System.getProperty("user.home"));
			System.setProperty("webdriver.gecko.driver",
					ConstantPath.pathGeckoDriver);
			// driver = ThreadLocal.withInitial(() -> new FirefoxDriver(
			// optionsManager.getFirefoxOptions()));
			driver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			selectedBrowser.set(browser);
			setTimeOuts();
			// For Grid Usage
			/*try {
			    tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getFirefoxOptions()));
			} catch (MalformedURLException e) {
			    e.printStackTrace();
			}*/
		} else if (browser.equals("chrome")) {
			// For Local Usage
			System.out.println("Inside chrome setDriver in DriverFactory class");
			System.setProperty("webdriver.chrome.driver",
					ConstantPath.pathChromeDriver);
			/*driver = ThreadLocal.withInitial(() -> new ChromeDriver(
					optionsManager.getChromeOptions()));*/
			driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			selectedBrowser.set(browser);
			setTimeOuts();
			/*//For Grid Usage
			try {
			    tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getChromeOptions()));
			} catch (MalformedURLException e) {
			    e.printStackTrace();
			}*/
		} else if (browser.equals("ie")) {
			System.out.println("Inside ie setDriver in DriverFactory class ");
			System.setProperty("webdriver.ie.driver",
					ConstantPath.pathIEDriver);
			/*driver = ThreadLocal.withInitial(() -> new InternetExplorerDriver(
					optionsManager.getIEOptions()));*/
			driver.set(new InternetExplorerDriver(optionsManager.getIEOptions()));
			selectedBrowser.set(browser);
			setTimeOuts();
		} else if (browser.equals("edge")) {
			System.out.println("Inside edge setDriver in DriverFactory class ");
			System.setProperty("webdriver.edge.driver",
					ConstantPath.pathEdgeDriver);
			/*driver = ThreadLocal.withInitial(() -> new EdgeDriver(
					optionsManager.getEdgeOptions()));*/
			driver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			selectedBrowser.set(browser);
			setTimeOuts();
		} else {
			System.out.println("No browser is mentioned ");
		}
	}

	public static synchronized WebDriverWait getWait(WebDriver driver) {

		return new WebDriverWait(driver, 20);
	}

	public static synchronized WebDriver getDriver() {

		return driver.get();
	}

	public static synchronized String getBrowserName() {

		return selectedBrowser.get();
	}

	public static synchronized void closeBrowser() {

		getDriver().quit();
		selectedBrowser.set(null);
	}

	public static synchronized void setTimeOuts() {

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
}
