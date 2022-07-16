package interviewpractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGConceptPracticse {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/search?q=covid+cases+in+india&oq=covid"
				+ "+cases+&aqs=chrome.1.69i57j0i433i512l3j0i512j0i433i457i512j0i402l2j0i512j0i10i433.3352j0j15&sourceid=chrome&ie=UTF-8");

		// SVG Element
		// SVG xpath will be different.

		List<WebElement> eleList = driver
				.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));

		Actions action = new Actions(driver);

		for (WebElement element : eleList) {

			action.moveToElement(element).perform();
			String text = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(text);
		}

	}

}
