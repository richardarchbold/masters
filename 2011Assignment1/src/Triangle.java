public class Triangle {
	
	double[] theTriangleSides = new double[3];
	
	// Contstructor
	Triangle(double[] theTriangleSides) {
		this.theTriangleSides = theTriangleSides;
	}
	
	// the sum of any two sides must be greater than the third side
	public boolean isTriangle() {
		boolean answer = false;
		// the sum of any two sides must be greater than the third side
		
		if (
			(theTriangleSides[0] + theTriangleSides[1] > theTriangleSides[2]) 			
			&&
			(theTriangleSides[1] + theTriangleSides[2] > theTriangleSides[0]) 
			&& 
			(theTriangleSides[0] + theTriangleSides[2] > theTriangleSides[1]) 
		   ) {
			answer = true;
		}
		
		return answer;
		
	}
		
	public double perimeter() {
		double perimeter = 0.0;
		
		return perimeter;
	}
		
	public double area() {
		double area = 0.0;
		
		return area;
	}
}
