package src;
public class Company {

	private String name;
	private String industry;
	private String description;
	
	public Company(String setName, String setIndustry, String setDescription) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = setDescription;	
	}
	
	public Company(String setName, String setIndustry) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = setIndustry;
		this.description = "This is a very impressive company!";
	}
	
	
	public Company(String setName) {
		if (setName == null)
            throw new IllegalArgumentException("Company title can't be null");
		
		this.name = setName;
		this.industry = "N/A";
		this.description = "This is a very impressive company!";	
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

	@Override
	public String toString() {
		return "Company Name: " + this.getName() + "\nIndustry: " + this.getIndustry() + "\nDescription: " + this.getDescription();
	}

}
