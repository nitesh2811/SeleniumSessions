package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFox {

	public static void main(String[] args) {

		// In below instruction we have to pass the location of gecko driver.
		// System.setProperty("webdriver.firefox.driver", "");

		WebDriver driver;

		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();

		System.out.println("The title of the Webpage is :" + title);

		driver.quit();

	}

}
