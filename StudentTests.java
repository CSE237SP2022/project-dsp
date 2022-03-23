import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class StudentTests {
	
	private Student s;
	
	@BeforeEach
	public void setup() {
			s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
		}

	@Test
	void testName() {
		String name = s.getName();
		assertEquals("Gavin Frank", name);
	}
	
	@Test
	void testGradYear() {
		int gradYear = this.getGradYear();
		assertEquals(2024, gradYear);
	}
	
	@Test
	void testChangeGradYear() {
		int gradYear = this.getGradYear();
		assertEquals(2024, gradYear);
		gradYear = this.testChangeGradYear(2025);
		assertEquals(2025, gradYear);
	}
	
	@Test
	void testinitYear() {
		int initYear = this.getinitYear();
		assertEquals(10, initYear);
	}

	@Test
	void testIsActive() {
		boolean isActive = this.getIsActive();
		assertEquals(true, isActive);
	}
	
	//checks to see whether the member joined in the Fall
	@Test
	void testisFall() {
		boolean isFall = this.getIsFall();
		assertEquals(true, isFall);
	}
	
	@Test
	void testVoteEligible() {
		boolean voteEligible = this.getIsEligible();
		assertEquals(true, voteEligible);
	}
	
	@Test
	void testSchoolName() {
		String school = this.getSchool();
		assertEquals("Olin", school);
	}
	
	@Test
	void testChangeSchool() {
		String school = this.getSchool();
		assertEquals("Olin", school);
		school = this.changeSchool("Artsci");
		assertEquals("Artsci", school);
	}
	
	@Test void testMajorsAndMinors() {
		String[] fieldOfStudy = this.getMajorsMinors();
		assertEquals([Business, CS, Psychology, NA], fieldOfStudy);
	}

}
