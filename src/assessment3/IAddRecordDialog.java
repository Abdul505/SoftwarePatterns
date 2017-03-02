package assessment3;

import java.awt.Container;

public interface IAddRecordDialog {

	// add record to file
	public void addRecord();

	// check for input in text fields
	public boolean checkInput();

	// initialize dialog container
	public Container dialogPane();

	// set text field to white colour
	public void setToWhite();

}
