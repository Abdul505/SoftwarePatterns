package assessment3;

import java.io.IOException;
import java.io.RandomAccessFile;

public interface IRandomAccessEmployeeRecord {

	int SIZE = 175; // Size of each RandomAccessEmployeeRecord object

	// Read a record from specified RandomAccessFile
	public void read(RandomAccessFile file) throws IOException; // end read

	// Write a record to specified RandomAccessFile
	public void write(RandomAccessFile file) throws IOException; // end write

}