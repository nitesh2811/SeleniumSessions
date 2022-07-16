package selenium;

/**
 * @author Nitesh Agrawal
 */

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	private static WebDriver driver;
	private static List<String> text;

	public static void main(String[] args) {

		// 1. Total link on the page
		// 2. Print the text of each link
		// 3. Exclude the blank text
		// 4. Capture the text in list and then return

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		// Whenever we have to interact with multiple elements we have to use
		// driver.FindElements
		// FindElements defined in Search Context Interface.
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links :" + links.size());

		// Iterate the Array List

		// for (WebElement e : links) {
		// String text = e.getText();
		// if (!text.isEmpty())
		// System.out.println(text);
		// }

		By locator = By.tagName("a");
		System.out.println("total links:" + getElements(locator).size());
		text = getElementsLinkText(locator);
		System.out.println(text.contains("sell"));
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getElementsLinkText(By locator) {
		List<String> text = new ArrayList<String>();
		List<WebElement> linkList = getElements(locator);
		for (WebElement e : linkList) {
			text.add(e.getText());
		}
		return text;
	}
}
