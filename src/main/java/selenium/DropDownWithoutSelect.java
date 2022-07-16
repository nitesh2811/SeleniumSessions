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

public class DropDownWithoutSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		// Not a preferrable option
		// driver.findElement(By.id("Form_submitForm_Country")).sendKeys("India");
		// Xpath: For getting all the values from the HTML DOM.

		// //select[@id='Form_submitForm_Country']/option--232 options
		// Sinlge slash means the options directly associated with Select tag.

		// Without using select class in select based drop down.
		// Not allowed to use Select class methods also.
		// Important for the Interview POV.
		List<WebElement> countryList = driver.findElements(By.xpath("select[@id='Form_submitForm_Country']"));
		for (WebElement e : countryList) {
			String text = e.getText();
			if (text.equals("India")) {
				e.click();
				break;
			}
		}
	}
}
