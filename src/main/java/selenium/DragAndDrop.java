package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		// Selenium supports drag and drop from one element to another element.
		// It does not supports the drag and drop for the file from C drive or D drive
		// on the Windows.
		// Selenium cannot automate the Windows task.
		// It is very rare use case in UI Automation of the drag and drop.
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		Thread.sleep(5000);
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));

		// Actions Class is present in the Selenium.
		// It does not have the default constructor and takes driver as parameter.
		// Absence of default contructor prevents the unnecessary creation of the
		// Object.
		Actions act = new Actions(driver);
		act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		// It is mandatory is write .build and .perform otherwise this will not work.
		// It will not throw any exception. Its just that nothing will be performed on UI.
		// Actions needs .build and .perform methods.
		// .build method helps to build the multiple actions in sequence.
		// It will generate the composite actions.

		act.dragAndDrop(sourceEle, targetEle).perform();
		// If only one user action is needed we can write directly .perform and .build
		// is not required.
		act.dragAndDrop(sourceEle, targetEle).build();
		// Above will not work as .perform is not used here.
	}

}
