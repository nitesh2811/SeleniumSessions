package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	//We can create a dependency between test cases in TestNG.
	//If login test is getting failed the other dependent test will be skipped.
	//We can have multiple dependencies also but depends on methods is bad practise
	//Avoid dependency in test cases. They should be independent. 
	//Test cases--should be independent to each other
	//Standard says test case should be independent of each other.
	//Result is affected mostly in parallel execution.
	//It will create the Maintainence issues as well when we have large number of test cases.
	
	
	
	
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		//int i=9/0; //Beacuse of this the dependent test cases will be skipped.
			
	}

	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("HomePage Test");
	int i=9/0;
	}

	//dependsOnMethods can take the multiple test cases as an array.
	@Test(dependsOnMethods = { "loginTest","homePageTest"})
	public void searchPageTest() {
		System.out.println("HomePage Test");
	}
}
