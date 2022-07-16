package selenium;

/**
 * @author Nitesh Agrawal
 */

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUp {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// First Window is called the Parent Window and new window is called Child
		// Window.
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		// Child Window

		// Switch the driver from one Window to other Window.
		// Set is a collection in Java and never holds duplicate values.
		// Set is Non-Order based collection unlike Array List.
		// Set will have two segments: Parent Window Id and Child Window Id.
		Set<String> handles = driver.getWindowHandles();
		// Iterator helps to Iterate Non-Order based collection.
		// Iterator points just above handles object.
		Iterator<String> it = handles.iterator();
		// Moving Iterator to next position.
		String parentWindowId = it.next();
		System.out.println("Parent window Id: " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("Child window Id: " + childWindowId);
		driver.switchTo().window(childWindowId);

		String childWindowTitle = driver.getTitle();
		System.out.println("Child Window Title :" + childWindowTitle);

		// We have to use close not quit as quit will close both the browser
		// Close will close the child window only.

		driver.close();

		driver.switchTo().window(parentWindowId);
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent Window Title :" + parentWindowTitle);

		// NoSuchWindowException
		// If without switching we are interacting with parent window.
		// Driver is lost , without switching we are interacting with parent window
		// We have switch back to the parent window
		// If we quit like driver.quit() then we have NoSuchSessionException.
	}
}

// We can have two cases 
// Case 1: Open all links together. 
// Case 2: Open links one by one at a time.
// Case 2 is most preferred as compare to Case 1 as driver is not lost when window is close.




