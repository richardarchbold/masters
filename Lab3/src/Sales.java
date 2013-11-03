import javax.swing.JOptionPane;

/**
 * If (car_engine >= 1500cc) {
 * 	then millage allowance = 75c/L
 * } else {
 * 	then mileage allowance = 104c/L
 * }
 */

/**
 * @author richarda@fb.com
 *
 */
public class Sales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Input engine size
		String userInput = JOptionPane.showInputDialog("Enter engine size: ");
		int engineSize = Integer.parseInt(userInput);
		
		userInput = JOptionPane.showInputDialog("Enter miles travelled: ");
		int milesTraveled = Integer.parseInt(userInput);
		
		double allowance1 = 0.75;
		double allowance2 = 0.75 + 0.3;
		double totalAllowance;
		
		if (engineSize <= 1500) {
			totalAllowance = milesTraveled * allowance1;
		} else {
			totalAllowance = milesTraveled * allowance2;
		}
		
		JOptionPane.showMessageDialog(null, "Your allowance is: " 
											+ totalAllowance);
	}

}
