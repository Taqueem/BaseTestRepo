package automationPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AutoPracticeLoginPage {

	public AutoPracticeLoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement	inputEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement	inputPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']//span[1]")
	private WebElement	buttonSignIn;

	/**
	 * Set default value to Email Address Text field.
	 *
	 * @return the AutoPracticeLoginPage class instance.
	 */
	public AutoPracticeLoginPage setEmailAddressTextField(String emailAddress) {

		inputEmail.sendKeys(emailAddress);
		return this;
	}

	public AutoPracticeLoginPage setPasswordTextField(String password) {

		inputPassword.sendKeys(password);
		return this;
	}

	/**
	 * Click on Sign In Button.
	 *
	 * @return the AutoPracticeLoginPage class instance.
	 */
	public AutoPracticeLoginPage clickSignInButton() {

		buttonSignIn.click();
		return this;
	}
}
