package assessment3;

import java.awt.Container;
import java.awt.event.ActionEvent;

public interface IEmployeeSummaryDialog {

	// initialise container
	public Container summaryPane();// end summaryPane

	public void actionPerformed(ActionEvent e);

}