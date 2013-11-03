import java.util.Scanner;

/**
 * A simple Java application to perform some basic actions on a Triangle.
 * 
 *  * @author Richard Archbold richarda@fb.com D04107657
 */
public class Triangle {	
	double[] sides = new double[3];
	
	/**
	 * Constructor the sum of any two sides must be greater than the third side
	 * @param sides is an array of doubles containing the lengths of the 
	 * 		  3 sides of the triangle.
	 */
	Triangle(double[] sides) {
		this.sides = sides;
	}
	
	
	/**
	 * Method to calculate of the 3 sides provided do actually form a triangle.
	 * 
	 * This is validated by leveraging that fact that the sum of any two sides 
	 * must be greater than the third side
	 * 
	 * @return boolean true or false.
	 */
	public boolean isTriangle() {

		// the sum of any two sides must be greater than the third side
		if (
			(sides[0] + sides[1] > sides[2]) 			
			&&
			(sides[1] + sides[2] > sides[0]) 
			&& 
			(sides[0] + sides[2] > sides[1]) 
		   ) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Method that determines the perimeter of the triangle. 
	 * 
	 * This is represented by the sum of the 3 sides.
	 * 
	 * @return perimeter 
	 */
	public double perimeter() {
		return this.sides[0] + this.sides[1] + this.sides[2];
	}
	
	/**
	 * Method to calculate the area of the triangle. 
	 * 
	 * Uses Herons formula to calculate the area. 
	 * Area = sqrt( s(s-a)(s-b)(s- c) ) where s = (a + b + c) / 2.
	 * 
	 * @return area
	 * @throws Exception 
	 */
	public double area() {		
		// If it's not a trianlge, it has zero area.
		if (! this.isTriangle()) {
			return 0;
		}
		
		double s = (sides[0] + sides[1] + sides[2]) / 2;
		double area = Math.sqrt( s*(s - sides[0])*
								   (s - sides[1])*
								   (s - sides[2]) );
		return area;
	}
	
	/** 
	 * Determine the type of triangle. The triangle is:
	 * Equilateral, if all 3 sides are equal, 
	 * Isosceles if two sides are equal and 
	 * Scalene if no sides are equal.
	 * 
	 * @return trigType the type of triangle
	 */
	public String determineType() {
		String trigType = "None";
		
		// Don't calculate the type unless we have a confirmed triangle
		if (! this.isTriangle()) {
			return trigType;
		}
		
		if ((this.sides[0] == this.sides[1]) && 
			(this.sides[0] == this.sides[2])) {
			trigType = "Equilateral";
		} else if ( (this.sides[0] == this.sides[1]) || 
				    (this.sides[1] == this.sides[2]) ||
				    (this.sides[0] == this.sides[2])
				  ) {
			trigType = "Isosceles";
		} else {
			trigType = "Scalene";
		}
		
		return trigType;
	}
	
	/**
	 * Simple method to redisplay back the the user the trianlge they entered.
	 * 
	 * @param entries, the array containing the triangle sides
	 */
	public static void redisplayUserInput(double[] entries) {
		System.out.println("\nYou entered:  " + entries[0] + ", " + 
							+ entries[1] + ", " + entries[2]);
	}
	
	
	/**
	 * Main method, prompts the use to enter the sides of the triangle to be
	 * acted upon, then calls all necessary methods and displays the output to 
	 * the user.
	 * 
	 * @param args command line args
	 */
	public static void main (String args[]) {
		
		// Set up some initial variables.
		double[] myTriangleSides = new double[3];
		Scanner userInput = new Scanner (System.in);
		
		// Prompt user to input the triangle sides.
		System.out.print("Please enter side 1 of the triangle: ");
		myTriangleSides[0] = userInput.nextDouble();
		
		System.out.print("Please enter side 2 of the triangle: ");
		myTriangleSides[1] = userInput.nextDouble();
		
		System.out.print("Please enter side 3 of the triangle: ");
		myTriangleSides[2] = userInput.nextDouble();
		
		userInput.close();
		
		// repeat back the users input to them.
		redisplayUserInput(myTriangleSides);
		
		// instantiate my Triangle object
		Triangle myTriangle = new Triangle(myTriangleSides);
		
		// validate if it is indeed a triangle
		if (myTriangle.isTriangle()) {
			// output the type of triangle, 
			System.out.println("Triange Type: " + myTriangle.determineType());
			// output the area
			System.out.printf("Area:         %.2f\n", myTriangle.area());
			// output the perimeter
			System.out.printf("Perimeter:    %.2f\n", myTriangle.perimeter());
			
		} else {
			System.out.println("Not a triangle");
		}
	}
}
