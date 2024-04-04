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
	
	@Test
	public void testDismantleNumbers() {
		// SetUp (agrego nuevos counters para probar solo este test).
		Counter counter2;
		counter2 = new Counter();
		counter2.addNumber(10);
		counter2.addNumber(5);
		counter2.addNumber(40);
		counter2.addNumber(100);
		counter2.addNumber(224);
		counter2.addNumber(3148);
		
		Counter counter3 = new Counter();
		counter3.addNumber(1);
		
		// Exercise
		int amount = counter2.getNumberWithMostEvenDigitsFromArray(counter2.getCounters());
		int amount2 = counter3.getNumberWithMostEvenDigitsFromArray(counter3.getCounters());
		
		// Assert
		assertEquals(amount,224);
		assertEquals(amount2,0);
	}
	
	@Test
	public void testEjercicio3( ) {
		int number1 = counter.getTheBiggestMultipleNumberBetween_and_(3,9);
		int number2 = counter.getTheBiggestMultipleNumberBetween_and_(100,2);
		int number3 = counter.getTheBiggestMultipleNumberBetween_and_(1001,1);
		
		assertEquals(number1,999);
		assertEquals(number2,1000);
		assertEquals(number3,-1);
	}
}