package util;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import automationPractice.AutoPracticeHomePage;
import automationPractice.AutoPracticeLoginPage;
import automationPractice.AutoPracticeMyAccount;
import utility.CommonTest;
public class KeywordUtil extends CommonTest {

	protected static AutoPracticeHomePage	apHomePage;

	private static WebDriverWait			explicitWait;

	protected static AutoPracticeLoginPage	apLoginPage;

	protected static AutoPracticeMyAccount	apMyAccount;

	protected ExcelUtil						excelutil	= new ExcelUtil();

	protected HashMap<Integer, String>		testcaseMap	= new HashMap<Integer, String>();

	Set<Integer>							keySet;

	@BeforeTest
	public void beforeKeywordTest() {

		setExcelFile();
		initializePage();
		// driver.get(ConstantsAP.AUTOPRACTICEURL);
	}

	protected void setExcelFile() {

		String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);
	}

	public void initializePage() {

		getapHomePage();
		getapLoginPage();
		getapMyAccount();
	}

	public AutoPracticeHomePage getapHomePage() {

		return (apHomePage == null) ? apHomePage = new AutoPracticeHomePage(driver) : apHomePage;
	}

	public AutoPracticeLoginPage getapLoginPage() {

		return (apLoginPage == null) ? apLoginPage = new AutoPracticeLoginPage(driver) : apLoginPage;
	}

	public AutoPracticeMyAccount getapMyAccount() {

		return (apMyAccount == null) ? apMyAccount = new AutoPracticeMyAccount(driver) : apMyAccount;
	}

	protected void performAction(int rowNum, String action) {

		switch (action) {
			case "navigateTo" :
				UIActions.navigateTo(excelutil.getCellData(rowNum, TestCaseMapper.Value));
				break;
			case "clickOn" :
				UIActions.click(getElement(rowNum));
				break;
			case "sendKeys" :
				UIActions.sendKeys(excelutil.getCellData(rowNum, TestCaseMapper.Value), getElement(rowNum));
				break;
			case "explicitWait" :
				explicitWait(30, excelutil.getCellData(rowNum, TestCaseMapper.Object), excelutil.getCellData(rowNum, TestCaseMapper.Value));
				break;
			default :
				break;
		}
	}

	protected void explicitWait(int seconds, String condition, String generic) {

		explicitWait = new WebDriverWait(driver, seconds);
		System.out.println("Value passed:" + generic);
		switch (condition) {
			case "titleContains" :
				String title = generic;
				explicitWait.until(ExpectedConditions.titleContains(title));
				break;
			/*case "visibilityOf" :
				WebElement element = (WebElement) generic;
				explicitWait.until(ExpectedConditions.visibilityOf(element));
				break;*/
			default :
				break;
		}
	}

	public WebElement getElement(int rowNum) {

		String page = excelutil.getCellData(rowNum, TestCaseMapper.Page);
		String object = excelutil.getCellData(rowNum, TestCaseMapper.Object);
		if (page.equalsIgnoreCase("apLoginPage"))
			return apLoginPage.getAutoPracticeLoginPageElements(object);
		else if (page.equalsIgnoreCase("aphomePage"))
			return apHomePage.getAutoPracticeHomePageElements(object);
		else if (page.equalsIgnoreCase("apMyAccount"))
			return apMyAccount.getAutoPracticeMyAccountElements(object);
		return null;
	}

	@DataProvider(name = "noOfTests")
	protected Object[][] getNoOfTests() {

		/*String sheet = this.getClass().getSimpleName();
		System.out.println(sheet);
		excelutil.createWorkBook(TestCaseMapper.excelPath);
		excelutil.setSheet(sheet);*/
		Object[][] testData = null;
		testcaseMap = excelutil.getTestCaseMap(0);
		keySet = testcaseMap.keySet();
		int timesOfRepeat = keySet.size();
		int numOfParameter = 1;
		testData = new Object[timesOfRepeat][numOfParameter];
		int i = 0, j = 0;
		for (Integer key : keySet) {
			testData[i][j] = key;
			i++;
		}
		return testData;
	}
}
