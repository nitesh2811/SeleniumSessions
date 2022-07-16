package selenium;

/**
 * 
 * @author Nitesh Agrawal
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		Thread.sleep(5000);

		By suggestionGoogle = By.xpath("//ul[@class='G43f7e']/li");
		System.out.println(getSuggestions(suggestionGoogle));
		clickSuggestion(suggestionGoogle,"interview questions");
	}

	public static List<String> getSuggestions(By locator) {
		List<WebElement> eleList = driver.findElements(locator);
		List<String> suggestionList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String suggestionText = e.getText();
			suggestionList.add(suggestionText);
		}
		return suggestionList;

	}

	public static void clickSuggestion(By locator, String value) {
		List<WebElement> eleList = driver.findElements(locator);
		for (WebElement e : eleList) {
			if (e.getText().contains(value)) {
				e.click();
				break;
			}
		}
	}
}

//return list<String>with all suggestions
