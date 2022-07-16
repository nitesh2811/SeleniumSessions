package selenium;

/**@author Nitesh Agrawal
 * 
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// Selenium will not wait for the element
		// and its expect that element is appeared on Page and it will work on that
		// element
		// Thread.sleep is a hard wait or the static wait.
		// We have to avoid thread.sleep
		// Thread.sleep- constant wait- script will be paused.

		// we have to use dynamin wait concept
		// timeout=10 sec --->element found in 2 sec -->then 8 sec ignored and moved on
		// implicit wait work as dynamic wait
		// It is also a global wait- applicable for all the WebElement on the DOM.
		// FE(Find Element): Implicit wait will be applied.
		// Should not use the implicit wait- It is applied for all the WebElements
		// unnecessary
		// Works only for WebElements and does not work for non WebElements: alerts, url
		// We avoid implicit wait in framework design.

		/**
		 * Specifies the amount of time the driver should wait when searching for an
		 * element if it is not immediately present. When searching for a single
		 * element, the driver should poll the page until the element has been found, or
		 * this timeout expires before throwing a NoSuchElementException. When searching
		 * for multiple elements, the driver should poll the page until at least one
		 * elementhas been found or this timeout has expired. Increasing the implicit
		 * wait timeout should be used judiciously as it will have an adverse effect on
		 * test run time, especially when used with slower location strategies like
		 * XPath.
		 */

		// Duration of Seconds has been introduced from Selenium 4.X
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		driver.findElement(By.id("input-email")).sendKeys("nagrawal512@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("panasonic@123");
		// For all the elements 10 secs of implicit wait will be applied
		// If element is not found after 10 secs it will throw the Exception

		// home page:
		// e5 e6
		// We can override out implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// login page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// click on register:
		// register page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// product page:0 secs --nullify imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		// Implicit wait will be called again and again for all the WebElements
		// We dont want to call that method for all the WebElements.

	}
}
