package selenium;

/**
 * @author Nitesh Agrawal
 */

import java.net.MalformedURLException;
import java.net.URL;

public class AmazonTest {

	public static void main(String[] args) throws MalformedURLException {

		// Create the object of the browser until class to instantiate the browser.
		// Main Class is the client and it should not handle any exception.
		// Util class should handle all the exceptions.
		// This is called the client Script.
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.launchURL("https://www.amazon.in");
		br.launchUrl(new URL("https://www.amazon.com"));
		String title = br.getPageTitle();	
		if (title.toLowerCase().contains("amazon")) {
			System.out.println("Correct title");
		}

		else {
			System.out.println("Incorrect title");
		}

		String url = br.getPageURL();
		System.out.println("The current page URL is " + url);

		br.closeBrowser();

	}

}
