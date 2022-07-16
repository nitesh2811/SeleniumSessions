package selenium;

/**
 * @author Nitesh Agrawal
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
	/**
	 * The difference between Close and Quit is In Quit the session id is null once
	 * the driver.quit action is performed In Close the session Id is not null but
	 * still we cannot access the brower again In Quit we have
	 * NoSuchSessionIdException In Close we have Invalid SessionId Exception
	 * 
	 */

	public static void main(String[] args) {

		WebDriver driver;

		// Below code will start the Selenium Server.
		// Server will depend on the exe file we have given.
		// We cannot interact with the browser directly.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nitesh Agrawal\\eclipse-workspace\\"
				+ "selenium-sessions\\chromedriver_win32\\chromedriver.exe");
		// Quit
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("Title of the Page is :" + title);
		// driver.quit();

		// For below execution we will have -NoSuchSessionException- Session Id is null
		// Browesr is already closed so session id is null here.
		System.out.println(driver.getCurrentUrl());

		// Close
		// New Session Id will be created.
		// Re-intialization of the driver.
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		title = driver.getTitle();
		System.out.println("Title of the Page is:" + title);
		driver.close();

		// For below execution we will have NoSuchSessionException-Invalid
		// SessionId.(Session Id is expired)
		System.out.println(driver.getCurrentUrl());

	}

}
