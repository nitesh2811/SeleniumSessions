package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		WebDriver driver;
		
		/**
		 * Third Party Library manages the Executable file like chrome.exe It will check
		 * the browser version and then check the compatible version If not present then
		 * it will place the version in local and helps to run the cases. It helps to
		 * handle the executable file
		 * Web Driver Manager is not part of the Selenium.
		 * It is an open-source Java library.
		 * It will manage in .m2 directory.
		 */

		WebDriverManager.chromedriver().setup();
	
	//	WebDriverManager.chromedriver().browserVersion("89.0");
		
	//	WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();

		System.out.println(title);

		driver.quit();

	}

}
