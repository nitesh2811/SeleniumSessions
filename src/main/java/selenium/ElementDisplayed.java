package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil = new ElementUtil(driver);

		By emailId = By.id("input-email");

		// boolean flag=driver.findElement(emailId).isDisplayed();
		// System.out.println(flag);

		if (elUtil.getIsDisplayed(emailId)) {
			elUtil.doSendKeys(emailId, "Nagrawal512@gmail.com");
		}

		// Element is displayed on page but is element enabled
		// driver.findElement(emailId).isEnabled();

		// If element is not found on Webpage by driver
		// then we have NoSuchElementException.
		// There is no ElementNotFoundException is not present in Selenium.
		// It is not a Selenium Exception.
		// capthcha cannot be automated with selenium
	}

}
