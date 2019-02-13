package testCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.KeywordUtil;
@Listeners(listeners.TestListener.class)
public class TestLogin extends KeywordUtil {

	@Test
	public void testLogin() {

		getapHomePage().clickSignInLink();
		getapLoginPage().setEmailAddressTextField("taqueem_toolsqa@outlook.com").setPasswordTextField("Learn123$").clickSignInButton();
	}
}
