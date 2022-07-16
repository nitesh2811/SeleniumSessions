package selenium;

/**
 * @author Nitesh Agrawal
 */


import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	/**
	 * @param browser name- Name of the browser
	 * @return the driver reference after the browser is initialized.
	 */
	public WebDriver launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nitesh
			// Agrawal\\eclipse-workspace\\"
			// + "selenium-sessions\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nitesh
			// Agrawal\\eclipse-workspace\\"
			// + "selenium-sessions\\geckodriver-v0.30.0-win64\\geckodriver.exe");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct brower :" + browserName);
		}
		return driver;
	}

	public void launchURL(String url) {

		if (url == null) {
			System.out.println("Please pass the correct URL");
		}

		else if ((url.contains("https")) || (url.contains("http"))) {
			driver.get(url);
		} else {
			driver.close();
			try {
				throw new Exception("Invalid URL Exception - please pass the right URL");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					throw new Exception("Browser is closed");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// If some one uses URL format then we can use URL url.
	public void launchUrl(URL url) {
		driver.navigate().to(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
