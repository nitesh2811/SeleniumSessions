package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessConcept {

	public static void main(String[] args) {
	
		//Use for small Sanity test cases mostly.
		//Not recommended mostly for the framework 
		//PopUps will not work in headless mode.
		//Application is simple then run in headless mode.
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co=new ChromeOptions();
		//co.setHeadless(true); Will run the test in headless mode
		co.addArguments("--headless");//Will run the test in headless mode.
		
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
		
		

	}

}
