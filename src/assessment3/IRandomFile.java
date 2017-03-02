package assessment3;

public interface IRandomFile {

	// Create new file
	public void createFile(String fileName); // end createFile

	// Open file for adding or changing records
	public void openWriteFile(String fileName); // end method openFile

	// Close file for adding or changing records
	public void closeWriteFile(); // end closeFile

	// Add records to file
	public long addRecords(IEmployee employeeToAdd);// end addRecords

	// Change details for existing object
	public void changeRecords(IEmployee newDetails, long byteToStart);// end changeRecors

	// Delete existing object
	public void deleteRecords(long byteToStart);// end deleteRecords

	// Open file for reading
	public void openReadFile(String fileName); // end method openFile

	// Close file
	public void closeReadFile(); // end method closeFile

	// Get position of first record in file
	public long getFirst();// end getFirst

	// Get position of last record in file
	public long getLast();// end getFirst

	// Get position of next record in file
	public long getNext(long readFrom);// end getFirst

	// Get position of previous record in file
	public long getPrevious(long readFrom);// end getPrevious

	// Get object from file in specified position
	public IEmployee readRecords(long byteToStart);// end readRecords

	// Check if PPS Number already in use
	public boolean isPpsExist(String pps, long currentByteStart);// end isPpsExist

	// Check if any record contains valid ID - greater than 0
	public boolean isSomeoneToDisplay();// end isSomeoneToDisplay

}