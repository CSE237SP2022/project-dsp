import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class StudentTests {
	
	//private Student s;
	
	//@Before
	//public void setup() {
	//		s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
	//	}

	//@Test
	//void testName() {
	//	String name = s.getName();
	//	assertEquals("Gavin Frank", name);
	//}
	
	@Test
	 void testGradYear() {
		Student s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
	}
	
	@Test
	void testChangeGradYear() {
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
		gradYear = s.changeGradYear(2025);
		assertEquals(2025, gradYear);
	}
	
	@Test
	void testinitYear() {
		int initYear = s.getInitYear();
		assertEquals(10, initYear);
	}

	@Test
	void testIsActive() {
		boolean isActive = s.getIsActive();
		assertEquals(true, isActive);
	}
	
	//checks to see whether the member joined in the Fall
	@Test
	void testisFall() {
		boolean isFall = s.getIsFall();
		assertEquals(true, isFall);
	}
	
	@Test
	void testVoteEligible() {
		boolean voteEligible = s.getIsEligible();
		assertEquals(true, voteEligible);
	}
	
	@Test
	void testSchoolName() {
		String school = s.getSchool();
		assertEquals("Olin", school);
	}
	
	@Test
	void testChangeSchool() {
		String school = s.getSchool();
		assertEquals("Olin", school);
		school = s.changeSchool("Artsci");
		assertEquals("Artsci", school);
	}
	
	//@Test void testMajorsAndMinors() {
	//	String[] fieldOfStudy = s.getMajorsMinors();
	//	assertArrayEquals({"Business", "CS", "Psychology", "N"}, fieldOfStudy);
	//}

}
