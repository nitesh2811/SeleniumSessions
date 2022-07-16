package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test method name should end with Test. Its a good practise.

//Sample test cases written below.Method will be pick based on alphabetical order
//Here browser will be launched one time and not three times
//We should have all test cases of one feature in one class
//priority is the keyword and it is used to define the sequence in which test case is executed.

public class AmazonTest extends BaseTest{

	
	
	@Test(priority=3)
	public void titleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		
		//without assertion there is no testing.
		//We should never write test without assertion.
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	//We can disable the test cases also 
	//Commenting is not advised.
	//By default all the test cases are desinged with enable=true.
	@Test(priority=2,enabled=false)
	public void urlTest() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("amazon11"));
	}
	
	@Test(priority=1)
	public void searchTest() {
		driver.get("https://www.amazon.com/");
		boolean flag=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
		
	}
	
	
}
