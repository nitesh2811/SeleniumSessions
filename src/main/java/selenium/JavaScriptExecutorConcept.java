package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {

		// execute js
		// JavaScriptExecutor will help to execute the JS

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);

		jsUtil.generateAlert("Hi this is my Alert");
		String pageText = jsUtil.getPageInnerTextByJs();
		System.out.println(pageText);
		System.out.println(pageText.contains("Marketing Campaigns"));

		// String title=jsUtil.getTitlebyJS();

		// This will give no output as the find Elements help to find the value from the
		// body and
		// not header.
		String title = driver.findElement(By.id("title")).getText();
		System.out.println(title);

		jsUtil.refreshBrowserbyJS();
		WebElement loginForm = driver.findElement(By.id("loginForm"));
		jsUtil.drawBorder(loginForm);

		WebElement email = driver.findElement(By.id("input-email"));
		jsUtil.flashElement(email);
		email.sendKeys("nagrawal512@gmail.com");

		WebElement pwd = driver.findElement(By.id("input-password"));
		jsUtil.flashElement(pwd);
		pwd.sendKeys("nitesh@512");

		jsUtil.scrollPageDown();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsUtil.scrollPageUp();

		jsUtil.scrollDown("500");
		WebElement element = driver.findElement(By.xpath("//span[text()='Popular products in PC internationally'']"));
		jsUtil.scrollIntoView(element);

		// infinite loading //lazy loading

		WebElement reg = driver.findElement(By.linkText("Registry"));
		jsUtil.clickElementByJS(reg);

		// We have different ways to click
		// click method in the WebElement:Click is happening on the Element on the page
		// Actions Click
		// JS Click:clicking on the element by injecting the JS.

		
	}

}
