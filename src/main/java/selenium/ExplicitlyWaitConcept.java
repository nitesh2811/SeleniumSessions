package selenium;

/**
 * 
 * @author Nitesh Agrawal
 *
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. Implicitly wait
		// 2. Explicitly wait: for a specific Web-Element, custom wait non WebElement
		// also
			// a. WebDriverWait
			// b. FluentWait

		// WebDriverWait(C) extends FluentWait(C) implements Interface Wait(I)
		// WebDriver is not different from the FluentWait. They are not different from
		// each other.

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailid = By.id("input-email11");
		By password = By.id("input-password");

		By loginBtn = By.xpath("//input[@value='Login']");

		// Duration is Selenium 4.0 feature
		// TimeUnit is the Selenium 3 feature and now its changed to Duration
		waitForElementToBeVisible(emailid, 10).sendKeys("Nitesh512@gmail.com");
		getElement(password).sendKeys("Panasonic@123");
		getElement(loginBtn).click();

		// For the email WebElement only we have applied the wait for 10 secs
		driver.findElement(password).sendKeys("panasonic@123");
		driver.findElement(loginBtn).click();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	//Possible that element is present inside the DOM and not Visible on the Page
	//May be beacuse of the loading issue and other DOM API issue.
	//We will not prefer this because Selenium is finding the element inside the DOM 
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	//This is more preferrable compared to the presenceOfElementLocated
	
	public static WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
