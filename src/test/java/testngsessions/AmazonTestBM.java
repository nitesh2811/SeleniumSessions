package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestBM {
	
	
	//Here browser will be open 3 times 
	//Amazon test with BM is preferred.
	//It ensures the excution coverage or execution percentage of test cases 100% 
	//when we have large number of test cases.
	//when using BT annotation approach browser will be excuted only once 
	//and if broswer is crashed due to any issue then exection coverage will decrease.
	
	//BM is more time taking as compared to BT but we have the benefit of the execution coverage.
	
	//BT can be used for the sanity test cases or small applications.
	//BM is used for the regression test cases.
	
	//During interview we have to justify with scenario
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
	}

	@Test
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);

		// without assertion there is no testing.
		// We should never write test without assertion.
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	@Test
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("amazon"));
	}

	@Test
	public void searchTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}


