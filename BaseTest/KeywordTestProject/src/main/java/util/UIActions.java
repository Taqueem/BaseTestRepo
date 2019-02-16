package util;
import org.openqa.selenium.WebElement;

import utility.CommonTest;
public class UIActions extends CommonTest {

	public static void sendKeys(String argumnets, WebElement element) {

		element.sendKeys(argumnets);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void navigateTo(String url) {

		driver.get(url);
	}
}
