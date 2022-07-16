package selenium;

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

public class RelativeLocatorConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		// To select the WebElement that is nearby a particular element.
		// New feature in Selenium
		// Selenium 4.x
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://aqi.in/dashboard/canada");

		WebElement element = driver.findElement(By.linkText("Dorval, Canada"));

		String text = driver.findElement(with(By.tagName("p")).toRightOf(element)).getText();
		System.out.println(text);

		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(element)).getText();
		System.out.println(rank);

		String below = driver.findElement(with(By.tagName("p")).below(element).below(element)).getText();
		System.out.println(below);

		String above = driver.findElement(with(By.tagName("p")).near(element)).getText();
		System.out.println(above);

		// This will give the nearest element and most probably the parent element of
		// the child.
		String near = driver.findElement(with(By.tagName("p")).near(element)).getText();
		System.out.println(near);

		// It will give the list of the WebElement above the particular element with tag
		// name(anchor tag)
		List<WebElement> aboveList = driver.findElements(with(By.tagName("a")).above(element));

		for (WebElement e : aboveList) {
			System.out.println(e.getText());
		}

	}

}
