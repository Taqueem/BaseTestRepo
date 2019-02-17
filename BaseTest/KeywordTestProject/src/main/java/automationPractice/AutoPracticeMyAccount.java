package automationPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AutoPracticeMyAccount {

	public AutoPracticeMyAccount(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".logout")
	@CacheLookup
	private WebElement linkSignOut;

	/**
	 * Click on Sign In Link.
	 *
	 * @return the AutoPracticeHomePage class instance.
	 */
	public AutoPracticeMyAccount clickSignInLink() {

		linkSignOut.click();
		return this;
	}

	public WebElement getAutoPracticeMyAccountElements(String elementName) {

		switch (elementName) {
			case "linkSignOut" :
				return linkSignOut;
			default :
				return null;
		}
	}
}
