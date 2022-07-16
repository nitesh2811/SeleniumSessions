package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {
	// Actions class can also be used to click and sendKeys functions on WebElement.
	// ElementNotInteractableException--Important
	// When one Element is overlap by next Element and normal click does not work
	// Actions class click will work as it click on the center of the button.(WebElement)
	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		// With the actions class we can pass the send keys and also click on logging
		// button
		// There is difference between actions class click and normal click
		// Actions click always click in the middle of the element and hence we minimize
		// ElementNotInteractableException.

		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(email), "nagrawal512@gmail.com").perform();
		action.sendKeys(driver.findElement(password), "panasonic@123").perform();
		action.click(driver.findElement(loginBtn)).perform();

		// ElementNotInteractableException-One case is when elements are overlapped
		// If normal send keys and click does not work we can use actions class click
		// and send keys
		// When Element is not there it says NoSuchElementException.
		// If the window is not maximize then element may get cut. In that case selenium
		// will not be able to perform action.
		// Simple click does not click on the middle of the Element.

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Clicks in the middle of the given element. Equivalent to:
	 * Actions.moveToElement(onElement).click()
	 * 
	 * @param locator
	 */

	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	/**
	 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend). This
	 * method is different from WebElement.sendKeys(CharSequence)
	 * 
	 * @param locator
	 * @param value
	 */

	public static void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

}
