package selenium;
/**
 * @author Nitesh Agrawal
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	// We need a driver for the WebElement.
	// To create WebElement we need a driver.
	// Element Util is not responsible for creating the driver.
	// Never Create Webdriver as static because we cannot achieve Parallel execution in such a scenario
	// Threads will be in the wait condition because the static is stored in CMA and they are the same for all the Objects 
	// Threads will be in wait condition and hence not recommended.
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue){
		By locator = null;
		switch (locatorType.toLowerCase().trim()){
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.tagName(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagName":
			locator=By.tagName(locatorValue);
			break;
		default:
			break;
		}
		return locator;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public boolean getIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public boolean getIsEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	public boolean getIsSelected(By locator) {
		return driver.findElement(locator).isSelected();
	}


	public  boolean isElementPresent(By locator) {
		if (getElements(locator).size() > 0) {
			return true;
		}
		return false;
	}
	public List<String> getElementsLinkText(By locator) {
		List<String> text = new ArrayList<String>();
		List<WebElement> linkList = getElements(locator);
		for (WebElement e : linkList) {
			text.add(e.getText());
		}
		return text;
	}

	public List<String> getElementAttributeList(By locator,String attribute){
		List<String> attributeValueList=new ArrayList<String>();
		List<WebElement> linkList=getElements(locator);
		for(WebElement e : linkList) {
			String attriVal=e.getAttribute(attribute);
			System.out.println(attriVal);
			attributeValueList.add(attriVal);
		}
		return attributeValueList;
		}
	
	
	// *****************************************Drop Down Utils**************************//

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	// Index is used where values are always static.
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public List<String> doGetDropDownOptions(By locator) {
		List<String> optionsValue = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValue.add(text);
		}
		return optionsValue;
	}

	public void doSelectDropDownValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	// ***********************************Action Class Utils***************************************************//
	public void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();

	}

	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu1, By subChildMenu2)
			throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(subChildMenu1)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu2).click();
	}

	public void doContextClick(By locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(locator)).perform();
	}

	public List<String> getRightClickOptionsList(By rightClickBtn, By rightClickOptions) {
		doContextClick(rightClickBtn);
		List<String> rightOptionsList = new ArrayList<String>();
		List<WebElement> webElementsList = getElements(rightClickOptions);
		for (WebElement e : webElementsList) {
			String text = e.getText();
			System.out.println(text);
			rightOptionsList.add(text);
		}
		return rightOptionsList;
	}

	public void selectRightClickMenu(By rightClickBtn, By rightClickOptions, String value) {
		doContextClick(rightClickBtn);
		List<WebElement> webElementList = getElements(rightClickOptions);
		System.out.println(webElementList.size());
		for (WebElement e : webElementList) {
			System.out.println(e.getText());
			if (value.equals(e.getText())) {
				e.click();
				break;
			}

		}

	}
	
	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	// ************************************Wait Utils****************************************//
	/**
	 * An expectation for checking that an element is prethe the the the sent on the DOM of a page.
	 * This does not necessarily mean that the elMaybeibecausele.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	// Possible that element is present inside the DOM and not Visible on the Page
	// May be beacuse of the loading issue and other DOM API issue.
	// We will not prefer this because Selenium is finding the element inside the
	// DOM
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.are are are are are  Visibility means that the element is not only displayed but also
	 * has a height and width that isgreater than 0.
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	// This is more preferrable compared to the presenceOfElementLocated

	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
