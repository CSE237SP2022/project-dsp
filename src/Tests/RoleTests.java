package src.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Company;
import src.Role;

public class RoleTests {
	
	private Role currentRole;
	private Role previousRole;
	private Company Apple;
	
	@Before
	public void setup() {
			Apple = new Company("Apple", "Tech", "Makes iPhones");
			currentRole = new Role(Apple, "CEO", 2020);
			previousRole = new Role(Apple, "CEO", 2020, 2022);
		}

	@Test
	public void testGetCompany() {
		Company retrieveCompany = currentRole.getCompany();
		assertEquals(Apple, retrieveCompany);
	}
	
	@Test
	public void testGetTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals("CEO", retrieveTitle);
	}
	
	@Test
	public void testGetActive() {
		boolean checkCurrent = currentRole.getActive();
		boolean checkPrevious = previousRole.getActive();
		
		assertEquals(true, checkCurrent);
		assertEquals(false, checkPrevious);
		assertNotEquals(checkPrevious, checkCurrent);
	}
	
	@Test
	public void testGetStartDate() {
		int checkStart = currentRole.getStartDate();
		assertEquals(2020, checkStart);
	}
	
	@Test
	public void testGetEndDate() {
		int checkEndCurrent = currentRole.getEndDate();
		int checkEndPrev = previousRole.getEndDate();
		assertEquals(0, checkEndCurrent);
		assertEquals(2022, checkEndPrev);
	}
	
	@Test
	public void testTimeSpent() {
		long timeSpent = previousRole.getTimeSpent();
		assertEquals(2, timeSpent);
	}
	
	@Test
	public void testUpdateTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals("CEO", retrieveTitle);
		currentRole.updateTitle("COO");
		retrieveTitle = currentRole.getTitle();
		assertEquals("COO", retrieveTitle);
	}
	
	@Test
	public void testEndRoll() {
		boolean checkCurrent = currentRole.getActive();
		int checkEnd = currentRole.getEndDate();
		assertEquals(true, checkCurrent);
		assertEquals(0, checkEnd);
		
		currentRole.endRoll(2022);
		
		checkCurrent = currentRole.getActive();
		checkEnd = currentRole.getEndDate();
		assertEquals(false, checkCurrent);
		assertEquals(2022, checkEnd);
	}
	
	@Test
	public void testToStringCurrent() {
		System.out.println(currentRole.toString());
		String output = currentRole.toString().replace("\n", "");
		String result = "Company: Apple"+ "Title: CEO" + "Started: 2020";
		assertEquals(output, result);
	}
}
