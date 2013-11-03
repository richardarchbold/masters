/**
 * A class called Temperature is used to analyse temperatures for a week.
 * 
 *  It uses two arrays:
 *  1. to hold the highest temperature for each day of the week
 *  2. to hold the names of the corresponding days of the week
 *  
 *  Write methods for the following statistics:
 *  
 *  (a) avgTemp(): Average temperature
 *  (b) overAvgTemp(): the readings which are more than the average value
 *  (c) hottestDay(): return the name of the day that had the highest temp
 *  (d) coldestDay(): same as above, just coldest
 *  (e) getTemp(): Get the temperature for a particular day of the week. There
 *                 is one argument, an integer value representing the day, with
 *                 number 0 representing Monday.
 *  (f) displayTable(): Display a table listing the output of the tempreature 
 *                      for each day of the week.
 *                      
 *  temps = {14, -9.2, 9, 23, 4, -9, 12}
 *  
 *  days = {Mon, Tue, Wed, Thu, Fri, Sat, Sun}
 *                 
 *  
 *  */

/**
 * @author richarda@fb.com
 *
 */

public class Temperature {
	public static void main (String[] args) {
		
		// Define myTemps as an instance of my new TemperatureCals class 
		TemperatureCalcs myTemps;
		
		// Initialize/instantiate the class by calling its constructor
		myTemps = new TemperatureCalcs();
		
		// Call the avgTemps method
		double myAvgTemp = myTemps.avgTemp();
		System.out.println("Average Temp: " + myAvgTemp);
		
		myTemps.overAvgTemp();
		
		String myHottestDay = myTemps.hottestDay();
		System.out.println("HottestDay: " + myHottestDay);
	}
}

class TemperatureCalcs {
	
	final double temps[] = {14, -9.2, 9, 23, 4, -9, 12};
	final String days[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	
	// avgTemp(): Average temperature
	public double avgTemp() {
		double totalTemps = 0;
		
		// iterate over all temps and add them together.
		for (int i = 0; i < temps.length; i++) {
			totalTemps += temps[i];
		}	
		
		double avgTemp = totalTemps/temps.length;
		
		return avgTemp;
	}
	
	// overAvgTemp(): the readings which are more than the average value
	public void overAvgTemp() {
		double avgTemp = this.avgTemp();
		
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] >= avgTemp) {
				System.out.println("Temp is above average: " + temps[i]);
			}
		}
	}
	
	// hottestDay(): return the name of the day that had the highest temp
	public String hottestDay() {
				
		double hottestTemp = temps[0];
		String hottestDay = days[0];
		
		for (int i = 1; i < temps.length; i++) {
			if (temps[i] > hottestTemp ) { 
				hottestTemp = temps[i];
				hottestDay = days[i];
			}
		}
		
		return hottestDay;
	}
	
	// getTemp(): Get the temperature for a particular day of the week. There
	//            is one argument, an integer value representing the day, with
	//            number 0 representing Monday.
	public double getTemp(int day) {
		return temps[day];
	}
}
