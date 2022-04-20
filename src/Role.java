package src;

public class Role {
	
	private Company company;
	private String title;
	private boolean activeRole;
	private int yearStarted;
	private int yearEnded;
	
	
	public Role(Company setCompany, String setTitle, int setyearStarted, int setyearEnded) {
		if(setCompany == null)
			throw new IllegalArgumentException("Company can't be null");
		if(setTitle == null)
			throw new IllegalArgumentException("Title can't be null");
		
		this.company = setCompany;
		this.title = setTitle;
		this.activeRole = false;
		this.yearStarted = setyearStarted;
		this.yearEnded = setyearEnded;
	}
	
	public Role(Company setCompany, String setTitle, int setyearStarted) {
		if(setCompany == null)
			throw new IllegalArgumentException("Company can't be null");
		if(setTitle == null)
			throw new IllegalArgumentException("Title can't be null");
		
		this.company = setCompany;
		this.title = setTitle;
		this.activeRole = true;
		this.yearStarted = setyearStarted;
		this.yearEnded = 0;
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
	public int getStartDate() {
		return this.yearStarted;
	}
	
//	Get end date
	public int getEndDate() {
		return this.yearEnded;
	}
	
//	get time spent in a role
	public long getTimeSpent() {
		if(this.yearStarted == 0 || this.yearEnded == 0)
			return 0;

		long daysBetween = this.yearEnded - this.yearStarted;
		return daysBetween;
	}

//	Update the title of the role
//	TODO: Make this so only the student (and admin can change)
	public String updateTitle(String newTitle) {
		this.title = newTitle;
		return this.title;
	}
	
	public void endRoll(int endDate) {
		this.yearEnded = endDate;
		this.activeRole = false;
	}
	
	 @Override
	 public String toString() {
		 if(this.activeRole) {
			 return "Company: " + this.getCompany().getName() + "\nTitle: " + this.getTitle() + "\nStarted: " + this.getStartDate();
		 }
		return "Company: " + this.getCompany().getName() + "\nTitle: " + this.getTitle() + "\nStarted: " + this.getStartDate() + "\nEnded: " + this.getEndDate() + "\nYears Spent: " + this.getTimeSpent();
	 }
}
