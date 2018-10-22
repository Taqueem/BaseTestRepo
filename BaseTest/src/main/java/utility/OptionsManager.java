package utility;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.CapabilityType;
public class OptionsManager {

	// Get Chrome Options
	public ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		// options.addArguments("--incognito");
		return options;
		/*ChromeDriverService service = new ChromeDriverService.Builder()
		        .usingAnyFreePort()
		        .build();
		ChromeDriver driver = new ChromeDriver(service, options);*/
	}

	// Get Firefox Options
	public FirefoxOptions getFirefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		// Accept Untrusted Certificates
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		// Use No Proxy Settings
		profile.setPreference("network.proxy.type", 0);
		// Set Firefox profile to capabilities
		options.setCapability(FirefoxDriver.PROFILE, profile);
		return options;
	}

	public InternetExplorerOptions getIEOptions() {

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("ignoreZoomSetting", true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		return options;
	}

	// Get Firefox Options
	public EdgeOptions getEdgeOptions() {

		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR,
				ElementScrollBehavior.BOTTOM);
		return options;
	}
}
