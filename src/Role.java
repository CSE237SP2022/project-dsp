package src;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Role {
	
	private Company company;
	private String title;
	private boolean activeRole;
	private LocalDate dateStarted;
	private LocalDate dateEnded;
	
	
	public Role(Company setCompany, String setTitle, LocalDate setDateStarted, LocalDate setDateEnded) {
		if(setCompany == null)
			throw new IllegalArgumentException("Company can't be null");
		if(setTitle == null)
			throw new IllegalArgumentException("Title can't be null");
		if(setDateStarted == null)
			throw new IllegalArgumentException("Date started can't be null");
		
		this.company = setCompany;
		this.title = setTitle;
		this.activeRole = false;
		this.dateStarted = setDateStarted;
		this.dateEnded = setDateEnded;
	}
	
	public Role(Company setCompany, String setTitle, LocalDate setDateStarted) {
		if(setCompany == null)
			throw new IllegalArgumentException("Company can't be null");
		if(setTitle == null)
			throw new IllegalArgumentException("Title can't be null");
		if(setDateStarted == null)
			throw new IllegalArgumentException("Date started can't be null");
		
		this.company = setCompany;
		this.title = setTitle;
		this.activeRole = true;
		this.dateStarted = setDateStarted;
	}
	
	public Role(Company setCompany, String setTitle, boolean setActiveRole, LocalDate setDateStarted) {
		if(setCompany == null)
			throw new IllegalArgumentException("Company can't be null");
		if(setTitle == null)
			throw new IllegalArgumentException("Title can't be null");
		if(setDateStarted == null)
			throw new IllegalArgumentException("Date started can't be null");
		
		this.company = setCompany;
		this.title = setTitle;
		this.activeRole = setActiveRole;
		this.dateStarted = setDateStarted;
	}
	
//	Get company
	public Company getCompany() {
		return this.company;
	}
	
//	Get title
	public String getTitle() {
		return this.title;
	}
	
//	Get if active
	public boolean getActive() {
		return this.activeRole;
	}
	
// Get start date
	public LocalDate getStartDate() {
		return this.dateStarted;
	}
	
//	Get end date
	public LocalDate getEndDate() {
		return this.dateEnded;
	}
	
//	get time spent in a role
	public long getTimeSpent() {
		if(this.dateEnded == null || this.dateStarted == null)
			return 0;

		long daysBetween = ChronoUnit.DAYS.between(this.dateStarted, this.dateEnded);
		return daysBetween;
	}

//	Update the title of the role
//	TODO: Make this so only the student (and admin can change)
	public String updateTitle(String newTitle) {
		this.title = newTitle;
		return this.title;
	}
	
	public void endRoll(LocalDate endDate) {
		this.dateEnded = endDate;
		this.activeRole = false;
	}
}
