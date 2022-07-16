package selenium;

/**
 * @author Nitesh Agrawal
 */

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {

	private static WebDriver driver;

	public static void main(String[] args) {

		// following-sibling
		// This is use in Xpath to get the sibling elements from the HTML DOM.
		// Mainly used for the concept of the Dynamic table.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/afghanistan-in-bangladesh-2021-22-1299826/bangladesh-vs-afghanistan-2nd-t20i-1299833/full-scorecard");

		// span[contains(text(),'Shakib Al
		// Hasan')])[1]/parent::span/parent::a/parent::span/parent::td/following-sibling::td/span
		By locator = By.xpath(
				"(//span[contains(text(),'Shakib Al Hasan')])[1]/parent::span/parent::a/parent::span/parent::td/following-sibling::td/span");
		// Old Xpath and now its not working //a[contains(text(),'Shakib Al
		// Hasan')]/parent::td/following-sibling::td/span
		System.out.println(driver.findElement(locator).getText());
		String name = getWicketTakerName("Shakib Al Hasan");
		System.out.println(name);
		System.out.println(getScoreCardList("Shakib Al Hasan"));

	}

	public static String getWicketTakerName(String playerName) {
		return driver
				.findElement(
						By.xpath("(//span[contains(text(),'Shakib Al Hasan')])[1]/parent::span/parent::a/parent::span/parent::td/following-sibling::td/span"))
				.getText();
	}

	public static List<String> getScoreCardList(String playerName) {
		List<String> scoreList = new ArrayList<String>();
		List<WebElement> scoreCardList;
		scoreCardList = driver
				.findElements(By.xpath("(//span[contains(text(),'"+playerName+"')])[1]/parent::span/parent::a/parent::span/parent::td/following-sibling::td"));
		//(//span[contains(text(),'Shakib Al Hasan')])[1]/parent::span/parent::a/parent::span/parent::td/following-sibling::td
		for (WebElement e : scoreCardList) {
			if (e.getText().contains(getWicketTakerName(playerName))) {
				continue;
			}
			scoreList.add(e.getText());
		}
		return scoreList;
	}

}
