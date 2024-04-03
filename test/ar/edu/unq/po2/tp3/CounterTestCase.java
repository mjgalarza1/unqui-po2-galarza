package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTestCase {
	
	private Counter counter;

	@BeforeEach
	public void setUp() throws Exception {
		// SetUp
		counter = new Counter();

		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
		counter.addNumber(6);
	}

	@Test
	public void testEvenNumbers() {
		// Exercise
		int amount = counter.getEvenOcurrences();
		
		// Assert
		assertEquals(amount, 2);
	}
	
	@Test
	public void testOddNumbers() {
		// Exercise
		int amount = counter.getOddOcurrences();
		
		// Assert
		assertEquals(amount, 9);
	}
	
	@Test
	public void testMultiples() {
		// Exercise
		int amount1 = counter.getMultiplesOf(3);
		int amount2 = counter.getMultiplesOf(2);
		
		// Assert
		assertEquals(amount1, 3);
		assertEquals(amount2, 2);
	}
}