package util;
import org.testng.annotations.BeforeTest;

import automationPractice.AutoPracticeHomePage;
import automationPractice.AutoPracticeLoginPage;
import utility.CommonTest;
public class KeywordUtil extends CommonTest {

	protected AutoPracticeHomePage	apHomePage;

	protected AutoPracticeLoginPage	apLoginPage;

	@BeforeTest
	public void beforeKeywordTest() {

		driver.get(ConstantsAP.AUTOPRACTICEURL);
	}

	public AutoPracticeHomePage getapHomePage() {

		return (apHomePage == null) ? apHomePage = new AutoPracticeHomePage(driver) : apHomePage;
	}

	public AutoPracticeLoginPage getapLoginPage() {

		return (apLoginPage == null) ? apLoginPage = new AutoPracticeLoginPage(driver) : apLoginPage;
	}
}
