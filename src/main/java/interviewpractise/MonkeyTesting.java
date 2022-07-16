package interviewpractise;

/**
 * @author Nitesh Agrawal
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonkeyTesting {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Monkey testing is performed to check the applications for the random values
		// of the Input.
		// We use the heat map to find out the most used part of the application and
		// based on this
		// elements are located out and testing is done.

		// Monkey testing of the Amazon.com application.

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		// Find the Elements from the most used part of the Application

		By locator = By.xpath(
				"//div[@class='navFooterVerticalRow navAccessibility']/child::div[@class='navFooterLinkCol navAccessibility']/child::ul//a");

		List<WebElement> eleList = driver.findElements(locator);
		int len = eleList.size();

		for (int i = 0; i < len; i++) {
			int randomNumber = (int) Math.floor(Math.random() * len);
			System.out.println(randomNumber);
			System.out.println(eleList.get(randomNumber).getText());
			try {
				eleList.get(randomNumber).click();
			} catch (ElementClickInterceptedException e) {
				e.printStackTrace();
			}
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(2000);

			eleList = driver.findElements(locator);

		}

	}

}
