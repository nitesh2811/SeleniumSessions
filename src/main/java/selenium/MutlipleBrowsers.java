package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutlipleBrowsers {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		System.out.println("The title of the Page is :" + title);
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println("The title of the Parent Page is :" + driver.getTitle());
		driver.quit();

		// Within same domain use navigate().to() it is recommended.
		// This is used when we have to move between pages in the same domain
		// When we have to go different domain use driver.switchTo.newWindow()
	}

}

// Sometime the link is not present on application to open the another application in other domain.
// In this case we have to use driver.switchTo().newWindow();
// It will help us to open the new Window, Complete the Work and come back.

