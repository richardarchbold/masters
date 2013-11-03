import static org.junit.Assert.*;

import org.junit.Test;

public class DateTests {

	@Test
	public void test_true_weekday() {
		Date myCal = new Date("1/10/2013");
		assertEquals("Tuesday", myCal.getWeekday(myCal.day, myCal.month, 
												 myCal.year));		
	}
	
	@Test
	public void test_true2_weekday() {
		Date myCal = new Date("1/10/2013");
		assertEquals("Tuesday", myCal.getWeekday());		
	}
	
	@Test
	public void test_false_weekday() {
		Date myCal = new Date("1/10/2013");
		assertNotEquals("Wednesday", myCal.getWeekday(myCal.day, myCal.month, 
												 myCal.year));		
	}
	
	@Test
	public void test_false2_weekday() {
		Date myCal = new Date("1/10/2013");
		assertNotEquals("Wednesday", myCal.getWeekday());		
	}
	
	@Test
	public void test_true_getZeller() {
		Date myCal = new Date("1/10/2013");
		assertEquals(2, myCal.getZeller(1, 10, 2013));
	}
	
	@Test
	public void test_true2_getZeller() {
		Date myCal = new Date("1/10/2013");
		assertEquals(2, myCal.getZeller());
	}
	
	@Test
	public void test_false_getZeller() {
		Date myCal = new Date("1/10/2013");
		assertNotEquals(10, myCal.getZeller());
	}
	
	@Test
	public void test_true_getMonthString() {
		Date myCal = new Date("1/1/2013");
		assertEquals("January", myCal.getMonthString(1));
	}
	
	@Test
	public void test_false_getMonthString() {
		Date myCal = new Date("1/1/2013");
		assertNotEquals("February", myCal.getMonthString(1));
	}
	
	@Test
	public void test_true1_dateString() {
		Date myCal = new Date("28/10/2013");
		String myDateString = myCal.dateString();
		assertEquals("Monday 28th October 2013", myDateString);
	}
	
	@Test
	public void test_true2_dateString() {
		Date myCal = new Date("28/2/2013");
		String myDateString = myCal.dateString();
		assertEquals("Thursday 28th February 2013", myDateString);
	}
	
	@Test
	public void test_true3_dateString() {
		Date myCal = new Date("2/2/2013");
		String myDateString = myCal.dateString();
		assertEquals("Saturday 2nd February 2013", myDateString);
	}
	
	@Test
	public void test_true4_dateString() {
		Date myCal = new Date("29/2/2016");
		String myDateString = myCal.dateString();
		assertEquals("Monday 29th February 2016", myDateString);
	}
	
}
