import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTests {

	@Test
	public void test_true_isTriangle() {
		double[] temp = {5.0, 5.0, 5.0};
		Triangle myTriangle = new Triangle (temp);
		boolean result = myTriangle.isTriangle();
		assertTrue(result);		
	}

	@Test
	public void test_false_isTriangle() {
		double[] temp = {5.0, 5.0, 5000.0};
		Triangle myTriangle = new Triangle (temp);
		boolean result = myTriangle.isTriangle();
		assertFalse(result);		
	}
	
	
}
