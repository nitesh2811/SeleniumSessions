 package selenium;
 /**
  * @author Nitesh Agrawal
  */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxTest {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getCurrentUrl());

	}

}
