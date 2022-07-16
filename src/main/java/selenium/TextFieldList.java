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

public class TextFieldList {
	
	private static WebDriver driver;

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");

		ElementUtil eleUtil=new ElementUtil(driver);
		
		By textFieldLocator=By.tagName("input");
		List<WebElement> eleList=eleUtil.getElements(textFieldLocator);
		System.out.println("Total Text Field:"+eleList.size());
		
		//Xpath for getting only the selective values from the DOM.
		//form//input[@type='text' or @type='email' or @type='password']
		
		By textLocator=By.xpath("//form//input[@type='text' or @type='email' or @type='password']");
		List<WebElement> elementList=eleUtil.getElements(textLocator);
		
		for(WebElement e:elementList) {
			e.sendKeys("testing");
		}
	}

}
