package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	private static WebDriver driver;

	public static void main(String[] args) {

		// Internal Application using in Company
		// Configuring router and modem.
		// It is not a JS popUp

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Inside the URL we have to pass the authentication.
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		// Hack given by Selenium.
		// If the User/Password has @ then it will not work.

		// CDP-auth-Selennium 4.X
		// CDP- Chrome Dev Protocols.
	}

}
