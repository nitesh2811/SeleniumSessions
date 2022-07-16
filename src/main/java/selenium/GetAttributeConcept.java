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

public class GetAttributeConcept {
	private static WebDriver driver;
	
	//We can get the attribute value of any Element
	//First we have to create the WebElement 
	//then we can get the attribute.
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		By locator=By.tagName("a");
		By image=By.tagName("img");
		System.out.println("Total Element in the list :"+getElements(locator).size());
		System.out.println("Total Images :"+getElements(image).size());
		List<String> srcList=getElementAttributeList(image,"src");
		List<String> altList=getElementAttributeList(image,"alt");
		List<String> attriValList=getElementAttributeList(locator, "href");
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static List<String> getElementAttributeList(By locator,String attribute){
		List<String> attributeValueList=new ArrayList<String>();
		List<WebElement> linkList=getElements(locator);
		for(WebElement e : linkList) {
			String attriVal=e.getAttribute(attribute);
			System.out.println(attriVal);
			attributeValueList.add(attriVal);
		}
		return attributeValueList;
		}
	}