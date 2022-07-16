package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		// driver.switchTo().frame(2);
		driver.switchTo().frame("main");
		// Frame is also a WebElement on the page.
		// Frame has its own HTML DOM:#Document
		// htmls tags:frame, iframe
		// Frame is overloaded method.
		// Frame is not W3C recommended.
		// Need of frame is security: Used by banking application.
		// We can have frame inside the frame also.

		// driver.switchTo().frame(driver.findElement(By.name("main")));
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);

		// driver.switchTo().parentFrame(); //Part of Selenium 4.X

		// Come back to the main page
		driver.switchTo().defaultContent(); // main page
		// Salesforce UI : It is full of frames.
		// If NoSuchElementException then it might be frame is present inside the
		// application.
		// If frame is not present and then also we are switching then
		// NoSuchFrameException.
	}

}

// Can we handle random pop-up ?
// We cannot hanlde the random pop-up and disable the advertisement pop-up
// Random pop-up behaviour can be disbale in the QA environment
