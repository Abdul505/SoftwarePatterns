package assessment3;
/*
 * 

 * This class is for accessing, creating and modifying records in a file
 * 
 * */

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class RandomFile implements IRandomFile {
	private RandomAccessFile output;
	private RandomAccessFile input;

	// Create new file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#createFile(java.lang.String)
	 */
	@Override
	public void createFile(String fileName) {
		RandomAccessFile file = null;

		try // open file for reading and writing
		{
			file = new RandomAccessFile(fileName, "rw");

		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error processing file!");
			System.exit(1);
		} // end catch

		finally {
			try {
				if (file != null)
					file.close(); // close file
			} // end try
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null, "Error closing file!");
				System.exit(1);
			} // end catch
		} // end finally
	} // end createFile

	// Open file for adding or changing records
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#openWriteFile(java.lang.String)
	 */
	@Override
	public void openWriteFile(String fileName) {
		try // open file
		{
			output = new RandomAccessFile(fileName, "rw");
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "File does not exist!");
		} // end catch
	} // end method openFile

	// Close file for adding or changing records
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#closeWriteFile()
	 */
	@Override
	public void closeWriteFile() {
		try // close file and exit
		{
			if (output != null)
				output.close();
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error closing file!");
			System.exit(1);
		} // end catch
	} // end closeFile

	// Add records to file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#addRecords(assessment3.Employee)
	 */
	@Override
	public long addRecords(IEmployee employeeToAdd) {
		IEmployee newEmployee = employeeToAdd;
		long currentRecordStart = 0;

		// object to be written to file
		IRandomAccessEmployeeRecord record;

		try // output values to file
		{
			record = new RandomAccessEmployeeRecord(newEmployee.getEmployeeId(), newEmployee.getPps(),
					newEmployee.getSurname(), newEmployee.getFirstName(), newEmployee.getGender(),
					newEmployee.getDepartment(), newEmployee.getSalary(), newEmployee.getFullTime());

			output.seek(output.length());// Look for proper position
			record.write(output);// Write object to file
			currentRecordStart = output.length();
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} // end catch

		return currentRecordStart - IRandomAccessEmployeeRecord.SIZE;// Return
																	// position
																	// where
																	// object
																	// starts in
																	// the file
	}// end addRecords

	// Change details for existing object
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#changeRecords(assessment3.Employee, long)
	 */
	@Override
	public void changeRecords(IEmployee newDetails, long byteToStart) {
		long currentRecordStart = byteToStart;
		// object to be written to file
		IRandomAccessEmployeeRecord record;
		IEmployee oldDetails = newDetails;
		try // output values to file
		{
			record = new RandomAccessEmployeeRecord(oldDetails.getEmployeeId(), oldDetails.getPps(),
					oldDetails.getSurname(), oldDetails.getFirstName(), oldDetails.getGender(),
					oldDetails.getDepartment(), oldDetails.getSalary(), oldDetails.getFullTime());

			output.seek(currentRecordStart);// Look for proper position
			record.write(output);// Write object to file
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} // end catch
	}// end changeRecors

	// Delete existing object
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#deleteRecords(long)
	 */
	@Override
	public void deleteRecords(long byteToStart) {
		long currentRecordStart = byteToStart;

		// object to be written to file
		IRandomAccessEmployeeRecord record;
		;

		try // output values to file
		{
			record = new RandomAccessEmployeeRecord();// Create empty object
			output.seek(currentRecordStart);// Look for proper position
			record.write(output);// Replace existing object with empty object
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error writing to file!");
		} // end catch
	}// end deleteRecords

	// Open file for reading
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#openReadFile(java.lang.String)
	 */
	@Override
	public void openReadFile(String fileName) {
		try // open file
		{
			input = new RandomAccessFile(fileName, "r");
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "File is not suported!");
		} // end catch
	} // end method openFile

	// Close file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#closeReadFile()
	 */
	@Override
	public void closeReadFile() {
		try // close file and exit
		{
			if (input != null)
				input.close();
		} // end try
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error closing file!");
			System.exit(1);
		} // end catch
	} // end method closeFile

	// Get position of first record in file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#getFirst()
	 */
	@Override
	public long getFirst() {
		long byteToStart = 0;

		try {// try to get file
			input.length();
		} // end try
		catch (IOException e) {
		}// end catch
		
		return byteToStart;
	}// end getFirst

	// Get position of last record in file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#getLast()
	 */
	@Override
	public long getLast() {
		long byteToStart = 0;

		try {// try to get position of last record
			byteToStart = input.length() - IRandomAccessEmployeeRecord.SIZE;
		}// end try 
		catch (IOException e) {
		}// end catch

		return byteToStart;
	}// end getFirst

	// Get position of next record in file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#getNext(long)
	 */
	@Override
	public long getNext(long readFrom) {
		long byteToStart = readFrom;

		try {// try to read from file
			input.seek(byteToStart);// Look for proper position in file
			// if next position is end of file go to start of file, else get next position
			if (byteToStart + IRandomAccessEmployeeRecord.SIZE == input.length())
				byteToStart = 0;
			else
				byteToStart = byteToStart + IRandomAccessEmployeeRecord.SIZE;
		} // end try
		catch (NumberFormatException e) {
		} // end catch
		catch (IOException e) {
		}// end catch
		return byteToStart;
	}// end getFirst

	// Get position of previous record in file
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#getPrevious(long)
	 */
	@Override
	public long getPrevious(long readFrom) {
		long byteToStart = readFrom;

		try {// try to read from file
			input.seek(byteToStart);// Look for proper position in file
			// if previous position is start of file go to end of file, else get previous position
			if (byteToStart == 0)
				byteToStart = input.length() - IRandomAccessEmployeeRecord.SIZE;
			else
				byteToStart = byteToStart - IRandomAccessEmployeeRecord.SIZE;
		} // end try
		catch (NumberFormatException e) {
		} // end catch
		catch (IOException e) {
		}// end catch
		return byteToStart;
	}// end getPrevious

	// Get object from file in specified position
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#readRecords(long)
	 */
	@Override
	public IEmployee readRecords(long byteToStart) {
		IEmployee thisEmp = null;
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();

		try {// try to read file and get record
			input.seek(byteToStart);// Look for proper position in file
			record.read(input);// Read record from file
		} // end try
		catch (IOException e) {
		}// end catch
		
		thisEmp = record;

		return thisEmp;
	}// end readRecords

	// Check if PPS Number already in use
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#isPpsExist(java.lang.String, long)
	 */
	@Override
	public boolean isPpsExist(String pps, long currentByteStart) {
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();
		boolean ppsExist = false;
		long oldByteStart = currentByteStart;
		long currentByte = 0;

		try {// try to read from file and look for PPS Number
			// Start from start of file and loop until PPS Number is found or search returned to start position
			while (currentByte != input.length() && !ppsExist) {
				//if PPS Number is in position of current object - skip comparison
				if (currentByte != oldByteStart) {
					input.seek(currentByte);// Look for proper position in file
					record.read(input);// Get record from file
					// If PPS Number already exist in other record display message and stop search
					if (record.getPps().trim().equalsIgnoreCase(pps)) {
						ppsExist = true;
						JOptionPane.showMessageDialog(null, "PPS number already exist!");
					}// end if
				}// end if
				currentByte = currentByte + IRandomAccessEmployeeRecord.SIZE;
			}// end while
		} // end try
		catch (IOException e) {
		}// end catch

		return ppsExist;
	}// end isPpsExist

	// Check if any record contains valid ID - greater than 0
	/* (non-Javadoc)
	 * @see assessment3.IRandomFile#isSomeoneToDisplay()
	 */
	@Override
	public boolean isSomeoneToDisplay() {
		boolean someoneToDisplay = false;
		long currentByte = 0;
		RandomAccessEmployeeRecord record = new RandomAccessEmployeeRecord();

		try {// try to read from file and look for ID
			// Start from start of file and loop until valid ID is found or search returned to start position
			while (currentByte != input.length() && !someoneToDisplay) {
				input.seek(currentByte);// Look for proper position in file
				record.read(input);// Get record from file
				// If valid ID exist in stop search
				if (record.getEmployeeId() > 0)
					someoneToDisplay = true;
				currentByte = currentByte + IRandomAccessEmployeeRecord.SIZE;
			}// end while
		}// end try
		catch (IOException e) {
		}// end catch

		return someoneToDisplay;
	}// end isSomeoneToDisplay
}// end class RandomFile
