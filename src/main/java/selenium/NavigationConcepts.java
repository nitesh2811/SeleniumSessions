package selenium;
/**
 * @author Nitesh Agrawal
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationConcepts {
	static WebDriver driver;
	
	/**
	 *Simulate the back, forward and refresh actions on the browser.
	 *It is the browser feature and we can simulate this using selenium.
	 *
	 *There is no difference between get and navigate().to() method. 
	 *Both the methods will launch the URL.
	 *Internally the navigate().to() method call get() method only.
	 *Navigate().to() is synonym to driver.get() and there is no difference.
	 * @throws MalformedURLException 
	 */

	public static void main(String[] args) throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();

		driver.get("https://www.google.com");
		
		driver.navigate().to("https://www.amazon.com");
		driver.navigate().to(new URL("https://www.google.com"));
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();

		driver.quit();

	}
}
