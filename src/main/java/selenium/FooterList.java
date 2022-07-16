package selenium;
/**
 * @author Nitesh Agrawal
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		By footerList = By.xpath("//ul[@class='footer-nav']/li");
		List<WebElement> elementList = driver.findElements(footerList);

		for (WebElement e : elementList) {
			String text = e.getText();
			System.out.println(text);
		}

	}

}


