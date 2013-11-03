import java.util.Scanner;

public class questionOne{

	public static void main(String[] args) {
		
		/////////////////////
		// start set up
		
		double[] myTriangleSides = new double[3];
		Scanner userInput = new Scanner (System.in);
		
		// get the user to input triangle sizes
		System.out.print("Please enter side 1 of the triangle: ");
		myTriangleSides[0] = userInput.nextDouble();
		
		System.out.print("Please enter side 2 of the triangle: ");
		myTriangleSides[1] = userInput.nextDouble();
		
		System.out.print("Please enter side 3 of the triangle: ");
		myTriangleSides[2] = userInput.nextDouble();
		
		userInput.close();
		
		// end set up
		/////////////////////
		
		// instantiate the Triangle 
		Triangle myTriangle = new Triangle(myTriangleSides);
		
		// call the isTrianlge method
		boolean temp = myTriangle.isTriangle();
		if (temp == true) {
			System.out.println("\nTriangle.isTriangle(): It's a triangle");
		} else {
			System.out.println("\nTriangle.isTriangle(): It's not a triangle");
		}
	}
}

