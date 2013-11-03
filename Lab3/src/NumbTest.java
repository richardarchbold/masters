import java.util.Scanner;

/**
 * @author richarda@fb.com
 *
 */
public class NumbTest {

	public static void main(String[] args) {
		Scanner userInput = new Scanner (System.in);
		
		System.out.print("Enter two numbers: ");
		
		double num1 = userInput.nextDouble();
		double num2 = userInput.nextDouble();
		
		if (num1 == num2) {
			if (num1 == 0) {
				System.out.println("Both numbers are zero");
			} else {
				System.out.println("num1 = num2");
			}
		} else if (num1 < num2) {
			System.out.println("num1 < num2");
		} else {
			System.out.println("num1 > num2");
		}
		userInput.close();
	}

}
