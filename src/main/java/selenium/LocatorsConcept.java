package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account" + "/login");

		// Create WebElement+Perform Action(Click, sendkeys,isDisplayed,getText)

		// id is used to identify WebElements on the Page.

		// 1. Method
		// driver.findElement(By.id("input-email")).sendKeys("nagrawal512@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("panasonic@123");

		// 2. WebElement
		// Second approach is beneficial as compared to the first as we do have
		// to create the WebElement again and again.
		// WebElement email=driver.findElement(By.id("input-email"));
		// WebElement password=driver.findElement(By.id("input-password"));
		// email.sendKeys("nagrawal512@gmail.com");
		// password.sendKeys("panasonic@123");

		// 3. By Locator: OR
		// This is useful as we have not created WebElement unnecessarily.
		// We have created only By locators
		// Creation of WebElement happens only when we write driver.findElement();
		// Advantage is when maintaining the By locator we are maintaining an OR(Object Repository)
		// OR(Object Repository) is a term for By locator.
		// By email=By.id("input-email");
		// By password=By.id("input-password");
		// WebElement user=driver.findElement(email);
		// WebElement pass=driver.findElement(password);
		// user.sendKeys("nagrawal512@gmail.com");
		// pass.sendKeys("panasonic@123");

		// 4. By Locator:generic function
		// Benefits in the re-usability of the code.
		// Not needed to write drive.findElement multiple times
		// By email = By.id("input-email");
		// By password = By.id("input-password");
		// getElement(email).sendKeys("nagrawal512@gmail.com");
		// getElement(password).sendKeys("panasonic@123");

		// 5. By Locator:genric functions(GE,actions)
		// By email = By.id("input-email");
		// By password = By.id("input-password");
		// doSendKeys(email, "nagrawal512@gmail.com");
		// doSendKeys(password, "panasonic@123");

		// 6. By Locator:genric functions(GE,actions) in a Utility Class.
		// By email = By.id("input-email");
		// By password = By.id("input-password");
		// ElementUtil eUtil=new ElementUtil(driver);
		// eUtil.doSendKeys(email, "nagrawal512@gmail.com");
		// eUtil.doSendKeys(password, "panasonic@123");

		// 7. Using BrowserUtil and ElementUtil

		// 8. String locators: By locator
		// On the fly we are creating the By locators
		// We are maintaining the String locators instead of By locators.
		// String email_id="input-email";
		// String password_id="input-password";
		// ElementUtil el=new ElementUtil(driver);
		// By email=getBy("id",email_id);
		// By password=getBy("id",password_id);
		// el.doSendKeys(email, "nagrawal512@gmail.com");
		// el.doSendKeys(password, "panasonic@123");
	}
	
	public static WebElement getElement(By locator){
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static By getBy(String locatorType, String locatorValue){
		By locator = null;
		//Switch cannot take boolean values.
		switch (locatorType.toLowerCase().trim()){
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.tagName(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		default:
			break;
		}
		return locator;
	}
}
