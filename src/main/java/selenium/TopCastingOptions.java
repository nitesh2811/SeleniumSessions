package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

@SuppressWarnings("unused")
public class TopCastingOptions {

	public static void main(String[] args) {

		// WebDriver driver=new ChromeDriver();

		/*
		 * //1. Valid WebDriver driver = new ChromeDriver();
		 * 
		 * //2. Valid WebDriver driver = new FirefoxDriver();
		 * 
		 * URL - Selenium grid is running that url we have to give. //3. valid Remote
		 * Execution WebDriver driver = new RemoteWebDriver(url, caps);
		 * 
		 * //4. Not useful SearchContext driver = new ChromeDriver(); We will get only
		 * few merhods/APIs and hence it is not useful.
		 * 
		 * //5. Not useful SearchContext driver = new RemoteWebDriver(remoteAddress,
		 * capabilities);
		 * 
		 * //6. Valid RemoteWebDriver driver = new ChromeDriver(); Cross brower logic
		 * can be used but as per the industry standards we use WebDriver driver=new
		 * ChromeDriver(); Java recommends to do top casting with the parent interface.
		 * 
		 * //7. We cannot create the Object of the Chromium driver class as the
		 * constructor to create the Object is protected WebDriver driver=new
		 * ChromiumDriver(); Above instruction is invalid.
		 * 
		 */

	}
}
