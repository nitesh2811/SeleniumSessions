package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {

	// Default - Test cases are run on alphabetical order.
	// We can excute the test cases based on priority also.
	// Priority can take integer values but not fraction values.
	// We can have negative priority and same priority also.
	// If same priority then it will take on bases of alphabetical order

	// Non priority based test cases will be executed first and then priority test
	// cases.
	// If priority is given in form of single characters then it will take the ASCII
	// values

	@Test(priority = 4)
	public void a_test() {
		System.out.println("a test");
	}

	@Test(priority = 1)
	public void b_test() {
		System.out.println("b test");
	}

	@Test(priority = 4)
	public void c_test() {
		System.out.println("c test");
	}

	@Test(priority = 3)
	public void d_test() {
		System.out.println("d test");
	}

	@Test(priority = 2)
	public void e_test() {
		System.out.println("e test");
	}

	@Test(priority = 1)
	public void f_test() {
		System.out.println("f test");
	}

}
