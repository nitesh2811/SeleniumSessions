package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementHandle {
	// Scalar Vector Graph

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> stateList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*"
				+ "[name()='g'and @id='states']//*[name()='g']//*[name()='path']"));
		System.out.println(stateList.size());

		Actions action = new Actions(driver);
		for (WebElement e : stateList) {
			action.moveToElement(e).perform();
			String name = e.getAttribute("name");
			System.out.println(name);
			if (name.equals("Maryland")) {
				action.click(e).perform();
				break;
			}
		}

	}



	
	

}
