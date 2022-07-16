package selenium;
/**
 * 
 * @author Nitesh Agrawal
 *
 */

public class CustomXpath_1 {

	public static void main(String[] args) {
		// Xpath: Address of the element inside DOM-Document Object Model
		// Xpath is not an attribute: It is address of an element.

		// htmltag[@attr = 'value'] //Any html tag can we used.
		// input[@id='input-email']
		// *[@id='input-email'] 
		// Above all elements for which id=input-email.
		// This is not recommended as its slow.
		// Specific tag is faster than other tags

		// input[@id]
		// input[@type='submit']
		
		// When we have two attributes in the Xpath use "and" seperated.
		// We can use both and or in the Xpath.
		// htmltag[@attr1 = 'value' and @attr2 = 'value']
		// input[@type='submit' and @value = 'Login']
		// input[@type='text' and @name='email']
		// input[@placeholder = 'E-Mail Address']

		// Dynamic ids:
		// When the id is getting changed and is not constant.
		// id is getting changed on every refresh.
		// <input id = "test_123">
		// <input id = "test_456">
		// <input id = "test_908">

		// contains(): It is the function for finding elements on the DOM.
		// This function is provided by Xpath. Used for dynamic ids.
		// htmltag[contains(@attr,'value')]
		// input[contains(@id,'test_')]

		// contains() with multiple attributes:
		// htmltag[contains(@attr1,'value') and contains(@attr2='value')]
		// input[contains(@id,'email') and contains(@name,'email')]
		// input[contains(@id,'email') and contains(@name,'email') and contains(@placeholder,'E-Mail')]

		// One attribute with contains and One attribute without contains
		// input[contains(@id,'email') and @type='text']
		// input[@type='text' and contains(@id,'email')]

		// text():
		// It is mainly used for the span ,links and headers that consist of text in the WebElement.
		// linktext works only for the anchor tag elements <a>
		// It applies to the text of the Element.
		// htmltag[text()='value']
		// a[text()='My Account']
		// h2[text()='Returning Customer']

		// text() and @attribute.
		// htmltag[text()='value' and @attr='value']
		// a[text()='Buy Again' and @data-csa-c-content-id='nav_cs_buy_again']

		// contains() with text() or contains with other attribute:
		// htmltag[contains(text(),'value')]
		// span[contains(text(),'internationally')]
		// a[contains(text(),'Gift') and contains(@href,'gift-cards')]

		// starts-with:
		// It is case sensitive.
		// It helps with attribute also.
		// a[starts-with(text(),'Gift')]
		// a[starts-with(text(),'Amazon')]
		// input[starts-with(@class,'form-')]
		
		// We dont have ends-with is deprecated and not supported.
		

		// Indexing: when we have more than one element that follows the Xpath
		// Here Indexing does not start from 0.
		
		// If we get two elements we have to capture based on index.
		// First put inside the capture group and then give the index.
		// Index starts from 1 in capture group.
		// These are DOM elements and we dont have a list here.
		// (//input[@class='form-control'])[2]
		// By emailid = By.xpath("(//input[@class='form-control'])[1]");
		// By password = By.xpath("(//input[@class='form-control'])[2]");
		
		// We can also write position function instead of index [].
		// (//input[@class='form-control'])[position()=1]
		// (//div[@class='navFooterLinkCol navAccessibility'])[1]//a
		// (//div[@class='navFooterLinkCol navAccessibility'])[4]//a

		// last():
		// Instead of writing the hard coded values we can use last function.
		// With the help of Selenium we can also achieve this.
		// (//input[@type='text' or @type='email' or @type='tel' or @type='password'])[last()]
		// (//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		// Gives all the links starting with Amazon and we can find the last value or the second last value.
		// (//a[starts-with(text(),'Amazon')])[last()-1]

		// Parent to Child concept:
		// (//div[@class='form-group'])[1]/input[contains(@id,'email')]
		// //ul[@class='footer-nav']//a
		// (/) --> direct child elements (only direct child elements)
		// (//) --> direct + indirect child elements(will give the direct+indirect both)
		// form[@id='hs-login']/div -- 8
		// form[@id='hs-login']//div --20
		
		// We can also use child keyword in the Xpath when we go from the parent to child.
		// div[@class='private-form__input-wrapper']/child::input
		// form[@id='hs-login']//child::div

		// child to parent:
		// input[@id='username']/../../../../../../../../../..  
		// This is called child to parent backward traversing
		// We can go back up to the root node.
		
		// Below will give the immediate parent.
		// input[@id='username']/parent::div
		// input[@id='username']/..
		// Ancestor is not that important.
		// input[@id='username']/ancestor::div 
		// ancestor is the keyword used for the grandparent
		// ancestor will give all the grandparents of the element.
		
		// Regex can also be used for finding the Elements in the HTML DOM.
		// Need to learn Regex functionality use for Xpath.
		
		// Absolute Xpath: This the Xpath from the root node to the Element.
		// Relative Xpath: This takes directly to the Element 

	}

}
