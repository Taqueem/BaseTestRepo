package googleStorePages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonTest;
public class GSHomePage {

	private static GSHomePage homePage;

	private GSHomePage() {

	}

	public static GSHomePage getHomePage() {

		if (homePage == null) {
			homePage = new GSHomePage();
			PageFactory.initElements(CommonTest.driver, homePage);
		}
		return homePage;
	}

	@FindBy(css = ".logo-bg")
	private WebElement	iconGoogle;

	@FindBy(xpath = "//div[@class='search-icon-wrap header-icon-wrap']")
	private WebElement	iconSearch;

	public void clickOnSearch() {

		iconSearch.click();
	}
}
