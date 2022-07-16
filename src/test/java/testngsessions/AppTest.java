package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 * @author Nitesh Agrawal
 *
 */

public class AppTest {

	// Global pre conditions
	// Pre Conditions
	// Test steps=>Assertions (actual vs exp results)
	// Post steps
	// TestNG we have to add seperately.It does not come with selenium.
	// src/test/java is mainly for writng the test cases.
	// TestNG does not have the main method like other Java applications
	// We have annotations in TestNG jar files.We can automate with help of annotations
	
	//Test Cases are picked up on the basis of alphabetcial order if priority is not assigned
	
	//@Before Method creates pair with @Test annotations.
	/**
	 *  BS-connectWith DB
		BT-Create User
		BC-launchBrowser
		
			BM-login to App
				page header test
			AM-logout
			
			BM-login to App
				User is logged in
			AM-logout
			
			BM-login to App
				page title test
			AM-logout
			
		AC-Close the Brower
		AT-deleteUser
		AS-Disconnect the dB.
		
		It creates a pair for BeforeMethod Test and AfterMethod annotation.
		No of test cases is same as number of @Test annotations.
	 	
	 	It is not mandatory to use all the annotations in the Test class.
	 	
	 	@BeforeTest is executed before at the @BeforeClass
	 	
	 */

	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS-connectWith DB");

	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT-Create User");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC-launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM-login to App");
	}

	@Test
	public void titleTest() {
		System.out.println("page title test");
	}

	@Test
	public void headerTest() {
		System.out.println("page header test");
	}

	@Test
	public void isUserLoggedInTest() {
		System.out.println("User is logged in");
	}

	@AfterMethod
	public void logOut() {
		System.out.println("AM-logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC-Close the Brower");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT-deleteUser");
	}

	@AfterSuite
	public void disconnectDb() {
		System.out.println("AS-Disconnect the dB.");
	}

}
