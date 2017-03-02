package assessment3;

public interface IEmployee {

	// Getter methods
	public int getEmployeeId();

	public String getPps();

	public String getSurname();

	public String getFirstName();

	public char getGender();

	public String getDepartment();

	public double getSalary();

	public boolean getFullTime();

	// Setter methods
	public void setEmployeeId(int employeeId);

	public void setPps(String pps);

	public void setSurname(String surname);

	public void setFirstName(String firstName);

	public void setGender(char gender);

	public void setDepartment(String department);

	public void setSalary(double salary);

	public void setFullTime(boolean fullTime);

	// Display Employee details
	String toString();// end toString

}