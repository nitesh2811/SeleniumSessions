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

		/**
		  CSS Selector 
		  id --> #id 
		  class-->.class
		  For Example
		  #input-email
		  
		  We can also write
		  tag#id
		 
		  Class name
		  .form-control
		  tag.class
		  input.form-control
		  
		  Combination of class name and id
		  input.form-control#input-email
		  #input-email.form-control
		  .form-control#input-email

		  If particular element is having multiple classes
		  .c1.c2.c3....cn
		  class name is seperated by space in the DOM.
		  .btn.btn-primary
	  	  a.btn-orange.contact-ohrm

		  By.className("btn-orange contact-ohrm");// not a valid locator
		  By.xpath("//a[@class='btn-orange contact-ohrm']");// correct
		  By.cssSelector("a.btn-orange.contact-ohrm");// correct
		  By.className("contact-ohrm"); // valid
		   
		  Note:Always pass one single class in By.className and not multiple class
		  
		  By.className(".contact-ohrm");// not valid
		  We cannot pass multiple class in By.className
		  
		  By.cssSelector("input.form-control.login-password");
		  
		  Try to find the unique class from the group of the classes
		  button[@class='login-submit'] // this is invalid - full class name is needed
		  button[contains(@class,'login-submit')] //valid

		  CSS selector for other attributes.
		  htmltag[attr1='value']
		  input[type='submit']--> CSS selector
		  Multiple attributes
		  htmltag[attr1='value'][attr2='value'][attr3='value']

		  Dynamic id concept
		  input[id*='email'] id contains email
		  input[id^='input'] id starts with input
		  button[class*='login-submit'] starts with
		  button[data-test-id$='button'] ends with
		  
		  
		  
		  parent to child:
		  div.private-form_input-wrapper > input#username //direct child
		  div.private-form_input-wrapper input#username //direct+indirect child element

		  child to parent
		  Not possible in CSS selector- Not available
		  backward traversing not allowed

		  forward sibling
		  we can go forward sibling by using +
		  label.control-label+input#input-email

	      preceding sibling
		  This is not possible. Backward traversin not possible

		  Not In css:Mainly used with id and classname.
		  form-control private-form_control
		  form-control

		  comma in css:
		  input#username,input#password,button#loginBtn,button#ssoBtn,input#remember
		  We can add number of elements of different tag as per the requirment

		  
		  By locator = By.cssSelector("input#username,input#password,button#loginBtn,button#ssoBtn,input#remember");
		  
		  No text support in the CSS selectors
		  Indexing concept
		  nth-of-type
		  ul.footer-nav li:nth-of-type(5)>a
		  ul.footer-nav li:nth-of-type(n)
		  
		  Differences between CSS and Xpath
		  
		  					xpath 			|			    CSS

1.Syntax					hard 							simple

2.Backward      			possibe 						NA	

3.Performance 				same 							same	

4.Comma,Not in 				NA								Available

5.Text						Available 						NA

6.Sibling 					Available 						Only forward-sibling

7.Index						Better functions   				Available--but not simple

8.Dynamic ele  				Yes 							Yes 


		 * 
		 */
	}

}
