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

public class DropDownHandling {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Whenever we have select tag with drop down
		// We have to use Select class of selenium.
		// We have to use the Select class only when select tag is present in the HTML DOM.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/#demoRequest");
		// WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		// Select select = new Select(country);
		// select.selectByIndex(5);
		// select.selectByVisibleText("India");// Visible text coming in the drop down.
		// select.selectByValue("Algeria"); // Value of the Option in the DOM of the
		// Website.

		// If select based is not present then we have to used different options.
		// Captcha we cannot automate by selenium

		// Thread.sleep(2000);
		
		// WebElement state = driver.findElement(By.id("Form_submitForm_State"));
		// Select select1 = new Select(state);
		// select1.selectByVisibleText("Goa");

		//	Selecting the element by using the Utilities created.
			By country = By.id("Form_submitForm_Country");
			Thread.sleep(2000);
			By state = By.id("Form_submitForm_State");
			doSelectByVisibleText(country, "India");
			doSelectByVisibleText(state, "Goa");

			Select select = new Select(getElement(country));
		//  It will work only when the select tag is present.
		//  Drop Down should support the deselect the value.
			select.deselectByVisibleText("India");
			
			select.isMultiple(); 
		//  Drop down is multi-Selection drop down or not.
		//  Gives the boolean value as the Output.
			
			select.getAllSelectedOptions();
	    //  Gives all the options which are already selected.
		//  Rarely used in real time scenarios.
			
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByVisibleText(By locator, String text){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	// Index is used where values are always static.
	// Starting position of Index is 0.
	// Mostly used in case of Calendar where data is fixed.
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static List<String> doGetDropDownOptions(By locator) {
		List<String> optionsValue = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValue.add(text);
		}
		return optionsValue;

	}

}
