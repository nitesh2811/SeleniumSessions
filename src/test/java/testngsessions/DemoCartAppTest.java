package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartAppTest extends BaseTest {

	@Test(description="Verifying title test of Demo Cart Application")
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		// without assertion there is no testing.
		// We should never write test without assertion.
		Assert.assertEquals(title, "Account Login");
	}

	@Test(description="Url test...")
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("account/login"));
	}

	@Test(description="search test...")
	public void searchTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		boolean flag = driver.findElement(By.id("search")).isDisplayed();
		Assert.assertTrue(flag);

	}

}
