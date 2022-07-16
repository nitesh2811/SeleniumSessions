package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTest {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		int pageCount = 1;
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='Samsun']")).size() > 0) {
				selectCity("Samsun");
				System.out.println("pageCount:" + pageCount);
				break;
			} else {
				// pagination logic
				WebElement next = driver.findElement(By.linkText("Next"));
				if (next.getAttribute("class").contains("disbaled")) {
					System.out.println("Pagination is Over...Record is not found...");
					break;
				}
				next.click();
				pageCount++;
			}

		}

	}

	public static void selectCity(String cityName) {
		driver.findElement(
				By.xpath("//td[text()='" + cityName + "']//preceding-" + "sibling::td/child::input[@type='checkbox']"))
				.click();

	}

	public static void selectCity1(String cityName) {
		WebElement element = driver.findElement(By.xpath("//td[text()='" + cityName + "']"));
		driver.findElement(with(By.xpath("//input[@type='checkbox']")).toLeftOf(element)).click();

	}
}