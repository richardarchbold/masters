/**
 * 
 */

/**
 * @author richarda@fb.com
 *
 */
public class Checkout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int initialAmount = 390;
		
		int twoEuro, oneEuro, fiftyCent, twentyCent;
		int tenCent, fiveCent, twoCent, oneCent;
		int remainder;
		
		twoEuro = initialAmount / 200;
		remainder = initialAmount % 200;
		
		oneEuro = remainder / 100;
		remainder = remainder % 100;
		
		fiftyCent = remainder / 50;
		remainder = remainder % 50;
		
		twentyCent = remainder / 20;
		remainder = remainder % 20;
		
		tenCent = remainder / 10;
		remainder = remainder % 10;
		
		fiveCent = remainder / 5;
		remainder = remainder % 5;
		
		twoCent = remainder / 2;
		remainder = remainder % 2;
		
		oneCent = remainder / 1;
		remainder = remainder % 1;
		
		System.out.println("num of 2 euro coins:  " + twoEuro);
		System.out.println("num of 1 euro coins:  " + oneEuro);
		System.out.println("num of 50 cent coins: " + fiftyCent);	
		System.out.println("num of 20 cent coins: " + twentyCent);
		System.out.println("num of 10 cent coins: " + tenCent);
		System.out.println("num of 5 cent coins:  " + fiveCent);
		System.out.println("num of 2 cent coins:  " + twoCent);
		System.out.println("num of 1 cent coins:  " + oneCent);
		
	}

}
