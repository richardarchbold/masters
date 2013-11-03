/**
 * If an amount of money p earns r% interest over a period of n years then at
 * the end of that time the sum will be a = p(1 + r/100)n (power of n)
 * 
 * Input values for p,r and n and output the resulting sum.
 */

/**
 * @author richarda@fb.com
 *
 */

import java.util.Scanner;
import java.lang.Math;

public class Investment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a new input scanner for the command line
		Scanner userInput = new Scanner (System.in);

		System.out.print("Enter principal: ");
		float principal = userInput.nextFloat();
		
		System.out.print("Enter interest rate: ");
		float interestRate = userInput.nextFloat();
		
		System.out.print("Enter number of years: ");
		int numYears = userInput.nextInt();
		
		double temp = Math.pow(1 + interestRate/100, numYears);
		double moneyEarned = principal * temp;
		
		// max 20 digits, left justified, comma delimited, 2 decimal precision
		System.out.printf("Money Earned: %20.2f \n", moneyEarned);
		System.out.print("Money Earned: " + moneyEarned);
		
		userInput.close();
	}

}
