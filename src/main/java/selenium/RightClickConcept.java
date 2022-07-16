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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

		// Right click on the Element and not on the browser.
		// We cannot do double click and we have to do a context click.
		// There is no right click method in Selenium.
		// Right click and Context click both are same thing.

public class RightClickConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		By rightClickBtn = By.xpath("//span[text()='right click me']");

		// For indirect element we have to use (//)
		By rightClickOptions = By.xpath("//ul[@class='context-menu-list context-menu-root']//span");

		// We dont have right click method in selenium
		// We have to do context click
		if (getRightClickOptionsCount(rightClickBtn, rightClickOptions) == 6) {
			System.out.println("Test Case is Pass");
		}
		selectRightClickMenu(rightClickBtn, rightClickOptions, "Cut");
	}

	public static int getRightClickOptionsCount(By rightClickBtn, By rightClickOptions) {
		return getRightClickOptionsList(rightClickBtn, rightClickOptions).size();
	}

	public static List<String> getRightClickOptionsList(By rightClickBtn, By rightClickOptions) {

		List<WebElement> webElementsList;
		List<String> rightOptionsList = new ArrayList<String>();

		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(rightClickBtn)).perform();

		webElementsList = driver.findElements(rightClickOptions);
		for (WebElement e : webElementsList) {
			String text = e.getText();
			System.out.println(text);
			rightOptionsList.add(text);
		}
		return rightOptionsList;

	}

	public static void selectRightClickMenu(By rightClickBtn, By rightClickOptions, String value) {
		WebElement rightClick = driver.findElement(rightClickBtn);
		Actions action = new Actions(driver);
		action.contextClick(rightClick);

		List<WebElement> webElementList = driver.findElements(rightClickOptions);
		System.out.println(webElementList.size());
		for (WebElement e : webElementList) {
			System.out.println(e.getText());
			if (value.equals(e.getText())) {
				e.click();
				break;
			}

		}

	}
}

// link text works only for the anchor tag i.e (a)
// It does not work for the other html attributes.

