package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nitesh Agrawal\\eclipse-workspace\\"
				+ "selenium-sessions\\chromedriver_win32\\chromedriver.exe");

		// Top Casting-
		// Chrome Driver class object can be referred by parent WebDriver reference
		// variables.
		// Interface reference variable.
		// WebDriver is an Interface in Selenium.
		// ChromeDriver is a class in Selenium API.
		driver = new ChromeDriver();
		// Http or Https protocol is important otherwise we will have Invalid Argument
		// Exception.
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);

		// validation point/checkpoint/act vs exp result/assertions

		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}

		System.out.println(driver.getCurrentUrl().contains("google"));
		System.out.println(driver.getPageSource());

		// Automation steps+//validation point/checkpoint/act vs expected result
		// Automation testing-Validation is important otherwise Automation testing is of
		// no use.

		driver.quit(); // close browser.

	}

}
