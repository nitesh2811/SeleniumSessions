package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Nitesh Agrawal
 *
 */

public class FEAndFEsException {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		// FindElement: If element is not found in the HTML DOM.
		// No Such Element Exception: Defined in Selenium.
		// driver.findElement(By.linkText("Customers111"));
		// This will give NoSuchElementException.

		// FindElements
		// Exception is not thrown
		// In the case of driver.findElements it always gives an empty list
		// It will not throw any exception.
		// We return the empty collection is such scenarios.
		List<WebElement> eleList = driver.findElements(By.linkText("Customers111"));
		System.out.println(eleList.size());

		By footerLocator = By.xpath("//ul[@class='footer-nav']//a");
		boolean flag = isElementPresent(footerLocator);

		if (flag) {
			for (WebElement e : getElements(footerLocator)) {
				System.out.println(e.getText());
			}

		}

		// We can write driver.findElements for single element also
		// It will return only one element in the List.

		// isDisplayed();
		
		// FindElements method to get the Size.
		// isElementPresent(): Can be used to check Element is present or not.
	}

	public static boolean isElementPresent(By locator) {
		if (getElements(locator).size() > 0) {
			return true;
		}
		return false;
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
	// Exception in Selenium APIs
	
	// When xpath syntax is wrong selenium says invalid selector exception.
	// NoSuchElementException: Element not present.
	// Wrong Selector: InvalidSelectorException
	// System.setProperty is incorrect:IllegalStateException
	// StaleElementReferenceException
	// ElementNotInteractableException
	// ElementNotFoundException: Not present in the Selenium.
	// NoSuchSessionException
	// TimeOutException
	// NoAlertException
	// FindElements does not return any Exception. It will return list with size 0.
