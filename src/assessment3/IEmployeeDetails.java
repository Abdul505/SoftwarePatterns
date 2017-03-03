package assessment3;

public interface IEmployeeDetails {
	
	// add Employee object to fail
	public void addRecord(IEmployee newEmployee);
	
	// check for correct PPS format and look if PPS already in use
	public boolean correctPps(String pps, long currentByte);
	
	// display current Employee details
	public void displayRecords(IEmployee thisEmployee);
	
	// get next free ID from Employees in the file
	public int getNextFreeId();
	
	// search Employee by ID
	public void searchEmployeeById();
	
	// search Employee by surname
	public void searchEmployeeBySurname();
	
	public void buttonActions();

}
