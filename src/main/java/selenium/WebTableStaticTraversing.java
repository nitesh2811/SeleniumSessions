package selenium;

/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//static webTable Traversing.
public class WebTableStaticTraversing {

	static WebDriver driver;

	// In selenium we dont have any method to interact directly with WebTable 
	// We can interact with move to elements or select elements but no direct interaction with WebTable
	// We have create out own concept for traversing a WebTable
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]

		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";

		// No of rows are getting changed
		By rowCount = By.xpath("//table[@id='customers']//tr");
		int rowValue = rowCount(rowCount);

		By colCount = By.xpath("//table[@id='customers']//th");
		int colValue = colCount(colCount);
		
		// We are creating a dynamic Xpath.
		// Breaking Xpath into parts and then concat both parts.
		getColumnData(beforeXpath,afterXpath,rowCount);
	}
	public static void getColumnData(String beforeXpath,String afterXpath,By rowCount) {
		for (int i = 2; i <= rowCount(rowCount); i++) {
			String xpath = beforeXpath + i + afterXpath;
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}

	}
	public static int rowCount(By rowCount) {
		return driver.findElements(rowCount).size();
	}

	public static int colCount(By colCount) {
		return driver.findElements(colCount).size();
	}
	
		// Printing all the values of rows and columns
		// This is to be done in matrix form.
	


}
