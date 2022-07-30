package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class CustomCssSelector {

	static WebDriver driver;

	public static void main(String[] args) {

		
		  // CSS Selector 
		  // id --> #id 
		  // class-->.class
		  // For Example
		  // #input-email
		  
		  // We can also write
		  // tag#id
		 
		  // Class name
		  // .form-control
		  // tag.class
		  // input.form-control
		  
		  // Combination of class name and id
		  // We can write corresponding tag name also in the css selector.
		  // input.form-control#input-email
		  // #input-email.form-control
		  // We can reverse the order also i.e. first Class then Id.
		  // .form-control#input-email

		  // If particular element is having multiple classes
		  // .c1.c2.c3....cn
		  // class name is seperated by space in the DOM.
		  // .btn.btn-primary
	  	  // a.btn-orange.contact-ohrm

		  // By.className("btn-orange contact-ohrm");// not a valid locator
		  // By.xpath("//a[@class='btn-orange contact-ohrm']");// correct
		  // By.cssSelector("a.btn-orange.contact-ohrm");// correct
		  // By.className("contact-ohrm"); // valid
		   
		  // Note:Always pass one single class in By.className and not multiple class
		  // By.className accepts only one and single class. We cannot pass multiple class.
		  
		  // By.className(".contact-ohrm");// not valid
		  // We cannot pass multiple class in By.className
		  
		  // By.cssSelector("input.form-control.login-password");
		  
		  // Try to find the unique class from the group of the classes. It will help us to select the element easily.
		  // button[@class='login-submit'] // this is invalid - full class name is needed. It is not the exact value of the class.
		  // button[contains(@class,'login-submit')] //valid. This is valid We are putting a contains check.
		  // In Xpath we have to pass complete value. If complete value is not present we have to use contains.
		
		  // CSS selector for other attributes.(Other attributes means that does not have class and id)
		  // We dont need to write @. In Xpath we use @ but not in the CSS selector.
		  // htmltag[attr1='value']
		  // input[type='submit']--> CSS selector
		  // If we have to write Multiple attributes then we have to use [] seperately.
		  // In Xpath we use to have and keyword.
		  // htmltag[attr1='value'][attr2='value'][attr3='value']
		
		  // //input[@type='submit' and @value='login']
		  // input[type=submit][value=login]

		  // Dynamic id concept
		  // input[id*='email'] id contains email.We dont have contains keyword 
		  // input[id^='input'] id starts with input.
		  // button[class*='login-submit'] contains login-submit. Generally class name is fixed value
		  // We dont have ends with Xpath but we have in CSS.
		  // button[data-test-id$='button'] ends with
		  
		  
		  
		  // Parent to Child:
		  // div.private-form_input-wrapper > input#username //direct child
		  // div.private-form_input-wrapper input#username //direct+indirect child element
		  // u.footer-nav >
		  // For direct and indirect association we have to use space but only for direct association we have to use >
		  // The indirect association always give more values as compare to direct association
		
		  // Child to Parent:
		  // Not possible in CSS selector-Not Available.
		  // Backward Traversing is not allowed
		  // We cannot handle the Webtable correctly with the CSS.
		
		  // Forward Sibling
		  // we can go forward sibling by using +
		  // label.control-label+input#input-email

	      // Preceding Sibling
		  // This is not possible.
		  // Backward traversing not possible

		  // Not In css:
		  // Application HubSpot
		  // Mainly used with id and Classname.
		  // form-control private-form_control login-email
		  // form-control private-form_control login-password m-bottom-3
		  // input.form-control private-form_control:not(#username) // This will represent the password element.

		  // Comma in css:
		  // We have to include multiple elments but they are having different tags.
		  // We can group multiple elements without any common tags. Its useful feature in CSS selector.
		  // input#username,input#password,button#loginBtn,button#ssoBtn,input#remember
		  // We can add number of elements of different tag as per the requirment.
		  // By locator = By.cssSelector("input#username,input#password,button#loginBtn,button#ssoBtn,input#remember");

		  // No text support in the CSS selectors
		  // We dont have functions concept in CSS. 
		  // We cannot use CSS selectors for text like contains function.
		
		
		  // Indexing concept
		  // nth-of-type
		  // ul.footer-nav li:nth-of-type(5)>a
		  // ul.footer-nav li:nth-of-type(n)

		
		  // Differences between CSS and Xpath
		  
/**							xpath 			|			    CSS

1.Syntax					hard 							simple

2.Backward      			possibe 						NA	

3.Performance 				same 							same	

4.Comma						NA								Available

5.Text						Available 						NA

6.Sibling 					Available 						Only forward-sibling

7.Index						Better functions   				Available--but not simple

8.Dynamic element 			Yes 							Yes 


		 
		 */
	}

}

// On browser DOM will be loaded first. Browser will have DOM API and it will display element on the Page.
// Various Xpath engine available on the browser. 
// Xpath speeds depends on the engine

// Performance depends mainly on the browsers
// Chrome has very fast Xpath engine. IE has small Xpath engine.
// Depends on browser we are executing.
// Sometimes CSS selector is very much straigth forward.
// We use combination of Xpath and CSS.
// What matters is compatibilty. 