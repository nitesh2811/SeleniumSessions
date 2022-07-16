package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHandle {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");

		driver.findElement(By.name("search_query")).sendKeys("Dress");
		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//div[@class='ac_results']//li[contains(text(),'Summer Dresses > Printed Chiffon ')]"))
				.click();

	}

}
