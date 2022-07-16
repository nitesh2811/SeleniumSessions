package assignments;
/**
 * @author Nitesh Agrawal
 */

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		List<WebElement> elementList;
		WebElement next = driver.findElement(By.xpath("//a[text()='Next']"));

		while (true) {
			elementList = driver.findElements(By.xpath("//td[text()='Hyderabad']"));
			selectCity(elementList);
			Thread.sleep(2000);
			next.click();
			if (next.getAttribute("class").contains("disbaled")) {
				System.out.println("Pagination is Over...Record is not found...");
				break;
			}
		}

	}

	public static void selectCity(List<WebElement> elementList) {
		for (WebElement e : elementList)
			driver.findElement(with(By.tagName("input")).toLeftOf(e)).click();
	}
}
