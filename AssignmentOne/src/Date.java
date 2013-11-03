import java.util.Scanner;

/**
 * SimpleCalendar application
 * <p>
 * The SimpleCalendar application takes a date in the form DD/MM/YYYY as an
 * input and, using Zellers congruence, first prints out a simple calendar
 * for the given month
 * <p>
 * @author Richard Archbold richarda@fb.com D04107657
 */
public class Date {

	static boolean DEBUG = true;
	int day, month, year;
	
	final String[] WEEKDAYS  = {"Sunday", "Monday", "Tuesday", "Wednesday",
			 				    "Thursday", "Friday", "Saturday", "Sunday"};
	final String[] MONTHS = {"January", "February", "March", "April", "May", 
			               "June", "July", "August", "September", "October", 
			               "November", "December"};
	
	/**
	 * Constructor class, requires an initial date string as an argument.
	 * 
	 * No validation on the date string yet. 
	 * 
	 * @param initialDate user prompted date STRING in format DD/YY/MMMM
	 */
	Date(String initialDate) {
		@SuppressWarnings("resource")
		// use Scanner to split the initial date into fields.
		Scanner tokens = new Scanner(initialDate).useDelimiter("/");
		
		// parse each field, no error checking yet :/
		this.day   = tokens.nextInt();
		this.month = tokens.nextInt();
		this.year  = tokens.nextInt();
		tokens.close();
		String weekday = this.getWeekday(this.day, this.month, this.year);
		
		if (DEBUG) {
			System.out.println("DEBUG: day     = " + day); 
			System.out.println("DEBUG: month   = " + month); 
			System.out.println("DEBUG: year    = " + year); 
			System.out.println("DEBUG: weekday = " + weekday);
		}	
	}
	
	/**
	 * Prints to console a calendar for the month of the date entered by user.
	 * 
	 * The logic & flow of the method is explained below ...
	 * 
	 * get zellers number for 1st of the month - this will give us the starting 
	 * position of the month
	 *  
	 * then get the total number of days in the month
	 * 
	 * figure out the total number of days in the matrix we need to print. this 
	 * will be equal to zellers number for the first day + the amount of days 
	 * in the month, rounded up to the nearest multiple of 7. 
	 * (we need to round up because we want to print out the full grid) 
	 * 
	 * iterate through the whole array size, using "i"
	 *
	 *	i < Z, print "|     "
	 *  i > Z, i <= Z + daysInMonth, printf "|%-5d"
	 */
	void calendar() {		
		int firstZeller = this.getZeller(1, this.month, this.year);
		int daysInMonth = this.getDaysInMonth(this.month, this.year);
		// creating an array size that is a multiple of 7 for clear printing
		int totalArraySize = firstZeller + daysInMonth + 
							 (7 - ((firstZeller + daysInMonth) % 7));
		
		if (DEBUG) System.out.println("DEBUG: firstZ  = " + firstZeller);
		
		System.out.println(this.getMonthString(this.month) + " " + this.year);
		System.out.println("-------------------------------------------");
		System.out.println("| Sun | Mon | Tue | Wed | Thu | Fri | Sat |");
		
		String theLine = "";
		for (int i = 1; i <= totalArraySize; i++) {
			if (i <= firstZeller) {
				// if less than first day of month, the box is blank
				theLine += "|     ";
			} else if ( (i > firstZeller) && (i <= firstZeller + daysInMonth)) {
				// if between first and last day, print a formatted number
				String temp = String.format("|%5d", (i - firstZeller));
				theLine += temp;
			} else {
				// this is the last few empty boxes to fill out the matrix
				theLine += "|     ";
			}	
			if (i % 7 == 0) {
				// if it's a multiple of 7, it's at the end of a line, so print
				theLine += "|";
				System.out.println(theLine);
				theLine = "";
			}
		}
		System.out.println("-------------------------------------------");
	}
	
	/**
	 * Takes in a date string of the format DD/MM/YYY and returns a String that 
	 * represents that day of the week.
	 *
	 * @param dayx int that represents day of the momth
	 * @param monthx int that represents the month
	 * @param yearx int that represents year in 4 digit format
	 * @return weekday in string format
	 */
	public String getWeekday(int dayx, int monthx, int yearx) {
		int Z = this.getZeller(dayx, monthx, yearx);
		return WEEKDAYS[Z];
	}
	
	/**
	 * Takes in a date string already stored in the object and returns a String 
	 * that represents that day of the week.
	 * @return weekday in string format
	 */
	String getWeekday() {
		return this.getWeekday(this.day, this.month, this.year);
	}

	/**
	 * Using Zellers Congruence, returns the weekday of the date supplied.
	 * 
	 * @param dayx int that represents day of the momth
	 * @param monthx int that represents the month
	 * @param yearx int that represents year in 4 digit format
	 * @return an integer that represents the day of the week for the date
	 */
	public int getZeller (int dayx, int monthx, int yearx) {
		int D = dayx;
		
		// M = month number. January and February are taken as months 11 and 12 
		// respectively of the preceding year. March is then month 1, April is 
		// 2, ..., December is 10.
		if (monthx == 1 || monthx == 2) {
            monthx += 10;
            yearx--;
        } else {
        	monthx -= 2;
        }
		int M = monthx;
		int Y = yearx % 100;
		int C = (yearx - Y) / 100;
		int Z = (int) ((Math.floor(2.6*M - 0.2) + D + Y + Math.floor(Y/4) + 
				        Math.floor(C/4) - 2*C) % 7);
		return Z;
	}
	
	/**
	 * Using Zellers Congruence, return the weekday of the date stored in the 
	 * object.
	 * 
	 * @return an integer that represents the day of the week for the date
	 */
	int getZeller () {
		return this.getZeller(this.day, this.month, this.year);
	}
	
	/**
	 * Returns the month string, based off the month integer passed to it.
	 * 
	 * @param monthx int that represents the month
	 * @return A string containing the month name 
	 */
	public String getMonthString (int monthx) {
		return MONTHS[monthx-1];
	}
	
	String getMonthString () {
		return this.getMonthString(this.month);
	}
	
	/**
	 * Returns the number of days in the specificed month in particular year.
	 * 
	 * @param monthx int, represents the month
	 * @param yearx int, represents year in 4 digit format
	 * @return days int, the number of days in the month
	 */
	public int getDaysInMonth (int monthx, int yearx) {
		int days = 31;
		if ((monthx == 9) || (monthx == 4) || (monthx == 6) || (monthx == 11)) {
			days= 30;
		} else if (monthx == 2 ) {
			if (yearx % 4 == 0) {
				days = 29;
			} else {
				days= 28;
			}
		}
		return days;
	}
	
	/**
	 * Returns the number of days in the month already stored in the object.
	 * 
	 * @return days int, the number of days in the month
	 */
	int getDaysInMonth() {
		return this.getDaysInMonth(this.month, this.year);
	}
	
	
	/**
	 * Convert date from format DD/MM/YYYY to one like "Monday 17th October 2011"
	 * 
	 * @param dayx int, day of the momth
	 * @param monthx int, the month
	 * @param yearx int year in 4 digit format
	 * @return datestring String  like "Monday 17th October 2011"
	 */
	public String dateString (int dayx, int monthx, int yearx) {
		String weekday = this.getWeekday(dayx, monthx, yearx);
		String dayDecorator = this.getDayFollower(dayx);
		
		String dateString = weekday + " " + dayx + dayDecorator + " " + 
						    MONTHS[monthx-1] +	" " + yearx;
		return dateString;
	}
	
	/**
	 * Convert date in the object to one like "Monday 17th October 2011"
	 * 
	 * @return datestring String  like "Monday 17th October 2011"
	 */
	String dateString () {
		return this.dateString(this.day, this.month, this.year);
	}
	
	/**
	 * Get the appropriate "follower decorator" to the day number in a month.
	 * 
	 * @param dayx int day of the month
	 * @return follower string that is on of "th", "st", "nd", "rd".
	 */
	String getDayFollower (int dayx) {		
		String follower;
		
		if ((dayx == 1) || (dayx == 21) || (dayx == 31)) {
			follower = "st";
		} else if ((dayx == 2) || (dayx == 22)) {
			follower = "nd";
		} else if ((dayx == 3) || (dayx == 23)) {
			follower = "rd";
		} else {
			follower = "th";
		}
		
		return follower;
	}
	
	/**
	 * Creates a Date objects with a harcoded date and executes the dateString()
	 * and calendar() methods.
	 * 
	 * @param args optional command line arguments
	 */
	public static void main(String[] args) {
		Date myCal = new Date("29/2/2016");
		String myDateString = myCal.dateString();
		if (DEBUG) {System.out.println(myDateString);}
		myCal.calendar();
	}

}