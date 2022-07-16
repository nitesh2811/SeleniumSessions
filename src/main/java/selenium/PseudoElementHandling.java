package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElementHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//String script="return window.getComputedStyle(document.queryselector())"
		//System.out.println(script);
		
		
		
	}

}
