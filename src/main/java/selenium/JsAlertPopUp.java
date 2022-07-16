package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUp {

	private static WebDriver driver;

	public static void main(String[] args) {

		// Example SignIn page of rediffmail.com
		// alert(): method in JS gives the alert pop up
		// It is not part of WebElement and we cannot inspect anything.
		// prompt():it ask for some value to be entered.
		// We have to switch the driver to the pop-up window.

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		Alert alert = driver.switchTo().alert(); // JS popup, prompt, alert
		String text = alert.getText();
		System.out.println(text);

		// alert.sendKeys("testing"); If there is text box on the alert.
		alert.accept(); // Click on OK button
		// alert.dismiss();// Click on Cancel button // ESC button
		// If there is no alert we get NoAlertPresentException.
	}
}
