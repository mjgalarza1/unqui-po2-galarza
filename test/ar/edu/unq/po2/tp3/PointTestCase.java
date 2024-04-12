package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTestCase {

	private Point point1;
	private Point point2;
	
	@BeforeEach
	public void setUp() throws Exception {
		point1 = new Point();
		point2 = new Point();
		point1.setXY(2,2);
		point2.setXY(2,2);
	}
	
	@Test
	public void testAddPointToPoint() {
		point1.addToPoint(point2);
		assertEquals(point1.getX(), 4);
		assertEquals(point1.getY(), 4);
	}
}
