/**
 * Write a program to calculate wage. Input hours worked and rate of pay and 
 * output the resulting wage.
 * 
 * Do all this via command line input and output
 * 
 */

/**
 * @author richarda@fb.com
 *
 */

import java.util.Scanner;

public class WagesCmdLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a new input scanner for the command line
		Scanner userInput = new Scanner (System.in);
		
		System.out.print("Enter hours worked: ");
		int hoursWorked = userInput.nextInt();
		
		System.out.print("Enter hourly rate: ");
		double hourlyRate = userInput.nextInt();
		
		double wages = hourlyRate * hoursWorked;
		System.out.println("Wages: " + wages);
		
		userInput.close();
	}
}
