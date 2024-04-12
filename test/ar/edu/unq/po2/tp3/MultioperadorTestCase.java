package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultioperadorTestCase {

	private Multioperador multioperador;
	private ArrayList<Integer> list1 = new ArrayList<Integer>();
	
	@BeforeEach
	public void setUp() throws Exception {
		multioperador = new Multioperador();
		list1.add(2);
		list1.add(3);
		list1.add(5);
	}
	
	@Test
	public void testAddAllNumbersOfArrayList() {
		// Exercise
		int result = multioperador.add(list1);
		// Assert
		assertEquals(result,10);
	}

	@Test
	public void testSubstractAllNumbersOfArrayList() {
		// Exercise
		int result = multioperador.substract(list1);
		// Assert
		assertEquals(result,-6);
	}
	
	@Test
	public void testMulttiplyAllNumbersOfArrayList() {
		// Exercise
		int result = multioperador.multiply(list1);
		// Assert
		assertEquals(result,30);
	}
}
