package assignments;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenUrlAmazon {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		List<WebElement> eleList = driver.findElements(By.tagName("a"));

		for (WebElement element : eleList) {

			String eleUrl = element.getAttribute("href");
			if (!(eleUrl == null))
				checkConnection(eleUrl);

		}

	}

	public static void checkConnection(String element) {

		URL url = null;
		try {
			url = new URL(element);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setConnectTimeout(5000);
			http.connect();

			if (http.getResponseCode() >= 400) {
				System.out.println("url is broken :" + element);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}


