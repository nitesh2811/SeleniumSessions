package selenium;
/**
 * @author Nitesh Agrawal
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest{
	//Objects can have multiple references.
	
	private static WebDriver driver=null;
	public static void main(String[] args){

		BrowserUtil br=new BrowserUtil();
		driver=br.launchBrowser("chrome");
		br.launchURL("https://demo.opencart.com/index.php?route=account/login");
		String title=br.getPageTitle();
		System.out.println("The title of the Page is:"+title);
		System.out.println(br.getPageURL());
		
		ElementUtil eL=new ElementUtil(driver);
		By email=eL.getBy("id", "input-email");
		By pass=eL.getBy("id", "input-password");
		eL.doSendKeys(email, "nagrawal512@gmail.com");
		eL.doSendKeys(pass,"panasonic@123");
	
		br.quitBrowser();
	}
}
