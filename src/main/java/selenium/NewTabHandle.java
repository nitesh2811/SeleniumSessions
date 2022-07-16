package selenium;

/**
 * 
 * @author Nitesh Agrawal
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String parentWindowId = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW); //Selenium 4.x feature

		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();

		//back to parent window.
		driver.switchTo().window(parentWindowId);

		System.out.println(driver.getTitle());

	}

}
