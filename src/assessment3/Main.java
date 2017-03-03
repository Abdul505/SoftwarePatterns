package assessment3;

import javax.swing.JFrame;

public class Main {

	private static EmployeeDetails frame = new EmployeeDetails();

	// main method
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				createAndShowGUI();
			}
		});
	}// end main

	// create and show main dialog
	private static void createAndShowGUI() {
		//calling the function that have the action listeners for the buttons
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.createContentPane();// add content pane to frame
		frame.setSize(760, 600);
		frame.setLocation(250, 200);
		frame.setVisible(true);
		frame.buttonActions();
	}// end createAndShowGUI

}
