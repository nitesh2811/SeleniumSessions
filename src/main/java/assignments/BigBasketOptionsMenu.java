package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketOptionsMenu {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.bigbasket.com/");
		
		Actions action=new Actions(driver);
		
		By shopByCategory=By.xpath("//a[contains(text(),'Shop')]");
		By shopMain=By.xpath("//ul[@id='navBarMegaNav']//a");
		By shopSubMenu=By.xpath("(//ul[contains(@class,'nav nav-pills nav-stacked')])[1]//a");
		action.moveToElement(driver.findElement(shopByCategory)).perform();
		Thread.sleep(3000);
		
		
		List<WebElement> shopMainList=driver.findElements(shopMain);
		
		for(WebElement e : shopMainList)
		{
			
			action.moveToElement(e).perform();
			System.out.println(e.getText());
			List<WebElement> shopSubList=driver.findElements(shopSubMenu);
			System.out.println(shopSubList.size());
			
			for(WebElement e1 : shopSubList)
			{	
				action.moveToElement(e1).perform();
				System.out.println(e1.getText());
			
			}
		}
		
		
		
	}
}



