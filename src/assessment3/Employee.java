package assessment3;
/*
 * 
 * This is the definition of the Employee object
 * 
 * */

public class Employee implements IEmployee{
	private int employeeId;
	private String pps;
	private String surname;
	private String firstName;
	private char gender;
	private String department;
	private double salary;
	private boolean fullTime;

	// Create Employee with no details
	public Employee() {
		this.employeeId = 0;
		this.pps = "";
		this.surname = "";
		this.firstName = "";
		this.gender = '\0';
		this.department = "";
		this.salary = 0;
		this.fullTime = false;
	}//end Employee with no details

	// Create Employee with details
	public Employee(int employeeId, String pps, String surname, String firstName, char gender, String department, double salary,
			boolean fullTime) {
		this.employeeId = employeeId;
		this.pps = pps;
		this.surname = surname;
		this.firstName = firstName;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.fullTime = fullTime;
	}// end Employee with details

	// Getter methods
	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getEmployeeId()
	 */
	@Override
	public int getEmployeeId() {
		return this.employeeId;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getPps()
	 */
	@Override
	public String getPps() {
		return pps;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getSurname()
	 */
	@Override
	public String getSurname() {
		return this.surname;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return this.firstName;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getGender()
	 */
	@Override
	public char getGender() {
		return this.gender;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getDepartment()
	 */
	@Override
	public String getDepartment() {
		return this.department;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getSalary()
	 */
	@Override
	public double getSalary() {
		return this.salary;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#getFullTime()
	 */
	@Override
	public boolean getFullTime() {
		return this.fullTime;
	}

	// Setter methods
	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setEmployeeId(int)
	 */
	@Override
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setPps(java.lang.String)
	 */
	@Override
	public void setPps(String pps) {
		this.pps = pps;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setSurname(java.lang.String)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setGender(char)
	 */
	@Override
	public void setGender(char gender) {
		this.gender = gender;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setDepartment(java.lang.String)
	 */
	@Override
	public void setDepartment(String department) {
		this.department = department;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setSalary(double)
	 */
	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/* (non-Javadoc)
	 * @see assessment3.IEmployee#setFullTime(boolean)
	 */
	@Override
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	// Display Employee details
	/* (non-Javadoc)
	 * @see assessment3.IEmployee#toString()
	 */
	@Override
	public String toString() {
		String bool = "";
		if (fullTime)
			bool = "Yes";
		else
			bool = "No";

		return "Employee ID: " + this.employeeId + "\nPPS Number: " + this.pps + "\nSurname: " + this.surname
				+ "\nFirst Name: " + this.firstName + "\nGender: " + this.gender + "\nDepartment: " + this.department + "\nSalary: " + this.salary
				+ "\nFull Time: " + bool;
	}// end toString
}// end class Employee
