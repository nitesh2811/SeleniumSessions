package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class DifferentLocators {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil el = new ElementUtil(driver);

		// First
		// 1. id- It is unique on the WebPage for the WebElements

		// Second
		// 2. name
		// driver.findElement((By.name("email"))).sendKeys("test@gmail.com");
		// By emailId=By.name("email");
		// el.doSendKeys(emailID,"test@gmail.com");

		// Not recommended
		// 3.className : Can be same for the different element
		// One element can have multiple classes also.
		// By ele = By.className("form-control");
		// driver.findElement(ele).sendKeys("test@gmail.com");
		// It will check from top to bottom and moment it find first element with the
		// class name
		// It will enter the value
		// Class name should not be used if not required.
		// Class helps to maintain the same UI for different elements

		// 4.xpath :It is not an attribute.
		// This is the address of the Element in HTML DOM.
		// When we don't have unique locator
		// driver.findElement(By.xpath(null)).sendKeys("test@gmail.com");
		// driver.findElement(By.xpath(null)).sendKeys("panasonic@123");
		// By loginBtn=By.xpath(null);
		// el.doClick(loginBtn);

		// 5. css selector: is not an attribute
		// driver.findElement(By.cssSelector(null)).sendKeys("");

		// 6. link text: only for links
		// html tag:<a>
		// By registerLink=By.linkText("Register");
		// el.doClick(registerLink);

		// 7. Partial link text: only for links
		// By forgotPwdLink=By.partialLinkText("Forgotten");
		// el.doClick(forgotPwdLink);

		// Special use cases.
		// 8. tag name : not an attribute
		// Not frequently used.
		// String text=driver.findElement(By.tagName("h2")).getText();
		// System.out.println(text);
		// By header=By.tagName("h2");
		// String text=el.doElementGetText(header);
		// System.out.println(text);

	}

}
