import java.util.Scanner;

/**
 * @author richarda@fb.com
 *
 */
public class FutureDay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] week = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

		Scanner userInput = new Scanner (System.in);
		
		System.out.print("Enter today's day: ");
		int num1 = userInput.nextInt();
	
		System.out.print("Enter the number of days elapsed since today: ");
		int num2 = userInput.nextInt();
		
		System.out.println("\nToday is " + week[num1] + 
				" and the future day is " + week[((num1 + num2)%7)] );
		
		userInput.close();
	}
}
