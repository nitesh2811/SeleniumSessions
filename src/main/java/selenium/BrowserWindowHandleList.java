package selenium;

/**
 * 
 * @author Nitesh Agrawal
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList {

	private static WebDriver driver;

	public static void main(String[] args) {
		
		// We cannot do this without window handles
		// We are using List instead of Set API to switch between Windows.
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();

		Set<String> handles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(handles);
		for (String e : handleList) {
			System.out.println(e);
		}

		String parentWindowId = handleList.get(0);
		String childWindowId = handleList.get(1);

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
