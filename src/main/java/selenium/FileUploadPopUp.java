package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		// We cannot handle file upload popup
		// type="file" is mandatory for Selenium to Work.

		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Nitesh Agrawal\\Desktop\\Aadhar.pdf");
		// Most of the cases type="file" will always be present.
		// If not present we can ask for developers to provide them for selenium.
		// autoit-- only for windows OS and not other OS.
	
		
	
	}

}
