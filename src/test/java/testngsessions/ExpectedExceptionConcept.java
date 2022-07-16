package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	// We can write the expected exception which says when the exception is
	// generated
	// please ignore the exception and make the test case as pass.
	// We can write Exception.class which is parent of the all the exception.
	// We can give multiple exception as list of Array for the expected exception.
	// This is mainly used as a hack to impress the client when we have some exceptions in the code.
	// Rarely used in real time scenario.
	
	String name;

	@SuppressWarnings({ "null", "unused" })
	@Test(expectedExceptions = { ArithmeticException.class, NullPointerException.class })
	public void loginTest() {
		System.out.println("Login Test");
		int i = 9 / 0;
		ExpectedExceptionConcept obj = null;
		obj.name = "tom";
	}
}
