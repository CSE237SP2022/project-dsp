package src.Tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import src.Company;
import src.Role;
import src.Student;

public class RoleTests {
	
	private Role currentRole;
	private Role previousRole;
	private Company Apple;
	
	@Before
	public void setup() {
			Apple = new Company("Apple", "Tech", "Makes iPhones");
			currentRole = new Role(Apple, "CEO", LocalDate.of(2020, 1, 8));
			previousRole = new Role(Apple, "CEO", LocalDate.of(2020, 1, 8), LocalDate.of(2021, 2, 10));
		}

	@Test
	public void testGetCompany() {
		Company retrieveCompany = currentRole.getCompany();
		assertEquals(retrieveCompany, Apple);
	}
	
	@Test
	public void testGetTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "CEO");
	}
	
	@Test
	public void testGetActive() {
		boolean checkCurrent = currentRole.getActive();
		boolean checkPrevious = previousRole.getActive();
		
		assertEquals(checkCurrent, true);
		assertEquals(checkPrevious, false);
		assertNotEquals(checkCurrent, checkPrevious);
	}
	
	@Test
	public void testGetStartDate() {
		LocalDate checkStart = currentRole.getStartDate();
		assertEquals(checkStart, LocalDate.of(2020, 1, 8));
	}
	
	@Test
	public void testGetEndDate() {
		LocalDate checkEndCurrent = currentRole.getEndDate();
		LocalDate checkEndPrev = previousRole.getEndDate();
		assertEquals(checkEndCurrent, null);
		assertEquals(checkEndPrev, LocalDate.of(2021, 2, 10));
	}
	
	@Test
	public void testTimeSpent() {
		long timeSpent = previousRole.getTimeSpent();
		assertEquals(timeSpent, 399);
	}
	
	@Test
	public void testUpdateTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "CEO");
		currentRole.updateTitle("COO");
		retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "COO");
	}
	
	@Test
	public void testEndRoll() {
		boolean checkCurrent = currentRole.getActive();
		LocalDate checkEnd = currentRole.getEndDate();
		assertEquals(checkCurrent, true);
		assertEquals(checkEnd, null);
		
		currentRole.endRoll(LocalDate.of(2022, 2, 10));
		
		checkCurrent = currentRole.getActive();
		checkEnd = currentRole.getEndDate();
		assertEquals(checkCurrent, false);
		assertEquals(checkEnd, LocalDate.of(2022, 2, 10));
		
	}
}
