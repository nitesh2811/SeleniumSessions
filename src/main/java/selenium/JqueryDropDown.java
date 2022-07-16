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

public class JqueryDropDown {

	// Static data members have to declared at Class level only.
	// JVM binds the static members with the Classes.
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		// Select tag is not present

		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(5000);
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		for (WebElement e : choiceList) {
			String text=e.getText();
			System.out.println(e.getText());
			if(text.equals("choice 1")) {
				e.click();
				break;
			}
		}
	}

	
	public static void selectChoice(By locator,String value) {
		
		
		
		
		
		
		
		
		
	}
	
}
