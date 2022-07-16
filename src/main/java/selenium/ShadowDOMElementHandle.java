package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMElementHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		// If the shadow is closed then we cannot automate by using selenium
		// This is the limitation of selenium
		// For working with shadow(open) we have to use JavaScript to get the WebElement
		// Then we need to convert the JS WebElement to selenium WebElement

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		// driver.findElement(By.id("tea")).sendKeys("masala tea");

		// Br--page--iFrame--shadowDOM--input

		// We have frame present in the HTML DOM.
		driver.switchTo().frame("pact");

		// document.querySelector("#snacktime").shadowRoot.querySelector("#tea")

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement tea = (WebElement) js
				.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		tea.sendKeys("Masala Teas");

	}

}
