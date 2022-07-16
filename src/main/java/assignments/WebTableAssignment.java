package assignments;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// Xpath for the row elements
		// *[@id="customers"]/tbody/tr[1]/th[1]

		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String middleXpath = "]/td[";
		String afterXpath = "]";
		By rowCount = By.xpath("//table[@id='customers']//tr");
		By colCount = By.xpath("//table[@id='customers']//th");

		WebTableAssignment webTable = new WebTableAssignment();
		webTable.getTableData(beforeXpath, middleXpath, afterXpath, rowCount, colCount);
	}

	public void getTableData(String beforeXpath, String middleXpath, String afterXpath, By rowCount, By colCount) {

		for (int i = 2; i <= getRowCount(rowCount); i++) {

			for (int j = 1; j <= getColumnCount(colCount); j++) {
				String xpath = beforeXpath + i + middleXpath + j + afterXpath;
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + "   ");
			}
			System.out.println();
		}
	}

	public int getRowCount(By rowCount) {
		return driver.findElements(rowCount).size();
	}

	public int getColumnCount(By colCount) {
		return driver.findElements(colCount).size();
	}

}
