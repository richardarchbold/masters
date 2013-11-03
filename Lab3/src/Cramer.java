/**
 * 
 * x = (ed - bf) / (ad -bc)
 * y = (af - ec) / (ad -bc)
 * 
 */

import java.util.Scanner;

/**
 * @author richarda@fb.com
 *
 */
public class Cramer {

	public static void main(String[] args) {
		
		// create a new input scanner for the command line
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Plz enter values for quadratic eq's ... ");
		System.out.println("   ax + by = e\n");
		
		System.out.print("Enter value for a: ");
		double a = userInput.nextDouble();
		
		System.out.print("Enter value for b: ");
		double b = userInput.nextDouble();
	
		System.out.print("Enter value for e: ");
		double e = userInput.nextDouble();
	
		System.out.println("\n   cx + dy = f\n");
		
		System.out.print("Enter value for c: ");
		double c = userInput.nextDouble();
		
		System.out.print("Enter value for d: ");
		double d = userInput.nextDouble();
	
		System.out.print("Enter value for f: ");
		double f = userInput.nextDouble();
	
		double numeratorX = e*d - b*f;
		double denominator = a*d - b*c;
		double numeratorY = a*f - e*c;
		
		if (denominator == 0) {
			System.out.println("The equation has no solution!");
		} else {
			double x = numeratorX / denominator;
			double y = numeratorY / denominator;
			System.out.println("x is " + x + " and y is " + y);
		}
		
		userInput.close();
	}
}
