/**
 * Write a program to calculate wage. Input hours worked and rate of pay and 
 * output the resulting wage
 */

/**
 * @author richarda@fb.com
 *
 */

import javax.swing.JOptionPane;

public class WagesGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Input hours worked
		String userInput = JOptionPane.showInputDialog("Enter hours worked: ");
		
		// Convert hours worked from string to an int
		int hoursWorked = Integer.parseInt(userInput);

		// Input hourly rate 
		userInput = JOptionPane.showInputDialog("Enter hourly rate: ");
		
		// Convert hourly worked from string to an int
		double hourlyRate = Integer.parseInt(userInput);
		
		// Calcualte wages
		double wages = hoursWorked * hourlyRate;
		
		// Print it out
		JOptionPane.showMessageDialog(null, "Wages: " + wages);
		System.out.println("Wages: " + wages);
	}

}
