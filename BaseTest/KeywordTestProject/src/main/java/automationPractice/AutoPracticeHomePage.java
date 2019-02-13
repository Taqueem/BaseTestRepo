package automationPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AutoPracticeHomePage {

	public AutoPracticeHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.login")
	@CacheLookup
	private WebElement signIn;

	/**
	 * Click on Sign In Link.
	 *
	 * @return the AutoPracticeHomePage class instance.
	 */
	public AutoPracticeHomePage clickSignInLink() {

		signIn.click();
		return this;
	}
}
