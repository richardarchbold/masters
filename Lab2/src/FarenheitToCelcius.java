/**
 * Write a program to convert Farenheit to Celcius. 
 */

/**
 * @author richarda@fb.com
 *
 */

import java.util.Scanner;


public class FarenheitToCelcius {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a new input scanner for the command line
		Scanner userInput = new Scanner (System.in);

		System.out.print("Enter temp in Farenheit: ");
		float tempFarenheit = userInput.nextFloat();
		
		float tempCelcius = ((float)5/9) * (tempFarenheit - 32);
		
		System.out.print("Temperature in Celcius: " + tempCelcius);
		
		userInput.close();
	}

}
