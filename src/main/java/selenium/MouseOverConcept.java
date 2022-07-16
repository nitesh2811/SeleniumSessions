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

public class MouseOverConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		
		// Selenium will work on what is visible on the page and not what is in DOM
		// WebElement contentEle = driver.findElement(By.xpath("//a[@class='menulink']"));
		// In Select Class we have to pass the WebElement
		// In Actions Class we have to pass the driver
		// Actions action = new Actions(driver);
		// action.moveToElement(contentEle).perform();
		// Sometimes it is possible that what is written inside the DOM is not visible on the WebPage.
		// If this happens in that case we have to pass what is actually visible to capture that Element.
		// Thread.sleep(2000);
		// Once the option is visible from mouse over we can click on that option.
		driver.findElement(By.linkText("COURSES")).click();
		By parentMenu = By.className("menulink");
		By childMenu = By.linkText("COURSES");
		selectSubMenu(parentMenu, childMenu);
		// We have to pass the By locator mostly to the Utilities.
		// It is not good practise to pass the WebElement.

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// We have use the Concept of the Method Overloading
	// Same method name with different input parameters.
	public static void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();

	}

	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu1, By subChildMenu2)
			throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(subChildMenu1)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu2).click();
	}
}
