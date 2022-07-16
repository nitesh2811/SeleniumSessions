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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");

		// Select select = new Select(getElement(country));
		// List<WebElement> countryList = select.getOptions();
		// System.out.println("Total Options available are:"+countryList.getSize());
		// for (WebElement e : countryList) {
		// if (e.getText().equals("India")) {
		// e.click();
		// break;
		// }
		// }

		doSelectDropDownValue(country, "India");
		Thread.sleep(3000);
		doSelectDropDownValue(state, "Goa");

		// Select select=new Select(driver.findElement(country));
		// List<WebElement> selectOptions=select.getOptions();
		// System.out.println(selectOptions.size());
		// for(WebElement e: selectOptions){
		// String text=e.getText();
		// System.out.println(text);
		// }

		// Check if the value is present in the Options or not.
		// System.out.println(doGetDropDownOptions(country).contains("India"));
		// Once the value is present we can select that option.
		// doSelectByVisibleText(country, "India");
		// Thread.sleep(2000);
		// System.out.println(doGetDropDownOptions(state).contains("Goa"));
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public static List<String> doGetDropDownOptions(By locator) {
		List<String> optionsValue = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			// System.out.println(text);
			optionsValue.add(text);
		}
		return optionsValue;
	}

	// Important for interviews: How to select the value without using the methods.
	// Will work only for Select based HTML tag.
	public static void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

}
