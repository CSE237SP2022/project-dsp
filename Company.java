public class Company {

	private String name;
	private String industry;
	private String description;
	private int numStudents;
	
	public Company(String setName, String setIndustry, String setDescription, int setNumStudents) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = setDescription;
		this.numStudents = setNumStudents;	
	}
	
	public Company(String setName, String setIndustry, int setNumStudents) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = "This is a very impressive company!";
		this.numStudents = setNumStudents;	
	}
	
	public Company(String setName, String setIndustry, String setDescription) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = setDescription;
		this.numStudents = 0;	
	}
	
	public Company(String setName, String setIndustry) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = "This is a very impressive company!";
		this.numStudents = 0;	
	}
	
	public Company(String setName) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = "N/A";
		this.description = "This is a very impressive company!";
		this.numStudents = 0;	
	}
	
//	Get Name
	public String getName() {
		return this.name;
	}
	
//	Get Industry
	public String getIndustry() {
		return this.industry;
	}
	
//	Get Description
	public String getDescription() {
		return this.description;
	}
	
//	Get Student Number
	public int getNumStudents() {
		return this.numStudents;
	}
	
//	Update company name
//	TODO: Make this an admin-only function
	public String updateName(String newName) {
		this.name = newName;
		return this.name;
	}
	
//	Update company industry
//	TODO: Make this an admin-only function
	public String updateIndustry(String newIndustry) {
		this.industry = newIndustry;
		return this.industry; 
	}
	
//	Update company description
//	TODO: Make this an admin-only function
	public String updateDescription(String newDescription) {
		this.description = newDescription;
		return this.description;
	}
	
//	Add 1 to student count
	public int joinCompany() {
		this.numStudents++;
		return this.numStudents;
	}
	
//	Remove 1 from the student count
	public int leaveCompany() {
		this.numStudents--;
		return this.numStudents;
	}

}
