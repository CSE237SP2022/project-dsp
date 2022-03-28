package src;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class StudentTests {
	
	private Student s;
	
	@Before
	public void setup() {
			s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
		}

	//@Test
	//void testName() {
	//	String name = s.getName();
	//	assertEquals("Gavin Frank", name);
	//}
	
	@Test
	 public void testGradYear() {
		Student s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
	}
	
	@Test
	public void testChangeGradYear() {
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
		gradYear = s.changeGradYear(2025);
		assertEquals(2025, gradYear);
	}
	
	@Test
	public void testinitYear() {
		int initYear = s.getInitYear();
		assertEquals(10, initYear);
	}

	@Test
	public void testIsActive() {
		boolean isActive = s.getIsActive();
		assertEquals(true, isActive);
	}
	
	//checks to see whether the member joined in the Fall
	@Test
	public void testisFall() {
		boolean isFall = s.getIsFall();
		assertEquals(false, isFall);
	}
	
	@Test
	public void testVoteEligible() {
		boolean voteEligible = s.getIsEligible();
		assertEquals(false, voteEligible);
	}
	
	@Test
	public void testSchoolName() {
		String school = s.getSchool();
		assertEquals("Olin", school);
	}
	
	@Test
	public void testChangeSchool() {
		String school = s.getSchool();
		assertEquals("Olin", school);
		school = s.changeSchool("Artsci");
		assertEquals("Artsci", school);
	}
	
	@Test 
	public void testMajors() {
		List<String> fieldOfStudy = s.getMajors();
		String[] output = {"Business", "CS"};
		assertArrayEquals(output, fieldOfStudy.toArray());
	}
	
	@Test 
	public void testMinors() {
		List<String> fieldOfStudy = s.getMinors();
		String[] output = { "Psych", "NA"};
		assertArrayEquals(output, fieldOfStudy.toArray());
	}

}
