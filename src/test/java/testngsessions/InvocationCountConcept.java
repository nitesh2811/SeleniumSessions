package testngsessions;
/**
 * @author Nitesh Agrawal
 */

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	//Invocation count is used to run same test cases multiple times
	//We can combine mutiple features with the @Test annotation
	//This can be done as comma seperated value.
	

	@SuppressWarnings({ "null", "unused" })
	@Test(invocationCount=10,priority=2)
	public void loginTest() {
		System.out.println("Login Test");
		int i=9/0;
		ExpectedExceptionConcept obj=null;
		obj.name="tom";
	}
	
	@Test(invocationCount=5,priority=1)
	public void homePage() {
		System.out.println("HomePage Test");
	}

}
