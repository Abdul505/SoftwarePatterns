package assessment3;

import java.awt.Container;
import java.awt.event.ActionEvent;

public interface ISearchBySurnameDialog {

	// initialize search container
	public Container searchPane();// end searchPane

	// action listener for save and cancel button
	public void actionPerformed(ActionEvent e);// end actionPerformed

}