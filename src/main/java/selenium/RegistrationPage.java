package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.launchURL("https://demo.opencart.com/index.php?route=account/register");
		String title = br.getPageTitle();
		System.out.println(title);

		String url = br.getPageURL();
		System.out.println(url);

		ElementUtil eUtil = new ElementUtil(driver);

		// Object Repository Creation

		// Locators
		// First Name
		By firstName = By.id("input-firstname");
		// Last Name
		By lastName = By.id("input-lastname");
		// Email
		By email = By.id("input-email");
		// Telephone
		By telephone = By.id("input-telephone");
		// Password
		By password = By.id("input-password");
		// Confirm Password
		By confirmPass = By.id("input-confirm");

		// WebElement Creation+Action

		eUtil.doSendKeys(firstName, "Nitesh");
		eUtil.doSendKeys(lastName, "Agrawal");
		eUtil.doSendKeys(email, "nagrawal512@gmail.com");
		eUtil.doSendKeys(telephone, "7897897890");
		eUtil.doSendKeys(password, "panasonic@123");
		eUtil.doSendKeys(confirmPass, "panasonic@123");

		//br.quit();

	}

}
