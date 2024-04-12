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
	public void testEjercicio3() {
		int number1 = counter.getTheBiggestMultipleNumberBetween_and_(3,9);
		int number2 = counter.getTheBiggestMultipleNumberBetween_and_(100,2);
		int number3 = counter.getTheBiggestMultipleNumberBetween_and_(1001,1);
		
		assertEquals(number1,999);
		assertEquals(number2,1000);
		assertEquals(number3,-1);
	}
	
	@Test
	public void testEjercicio4() {
		/*
		● s.length();
		● t.length();							ERROR: t no entiende el mensaje "length" (por ser vacio)
		● 1 + a;								ERROR: Son de diferentes tipos (Int + String)
		● a.toUpperCase();
		● "Libertad".indexOf("r");
		● "Universidad".lastIndexOf('i');
		● "Quilmes".substring(2,4);
		● (a.length() + a).startsWith("a");		ERROR: (3 + "abc") tira error
		● s == a;
		● a.substring(1,3).equals("bc")
		*/
		
		// SetUp
		String a = "abc";
		String s = a;
		String t;

		// Assert
		assertEquals(s.length(), 3);
		assertEquals(a.toUpperCase(), "ABC");
		assertEquals("Libertad".indexOf("r"), 4);
		assertEquals("Universidad".lastIndexOf('i'), 7);
		assertEquals("Quilmes".substring(2,4), "il"); 
		assertTrue((a).startsWith("a"));
		assertTrue(s == a);
		assertTrue(a.substring(1,3).equals("bc"));
	}
	
	@Test
	public void testEjercicio5() {
		/*3. ¿Si se define una variable de instancia de tipo int cual sería su valor predeterminado?
		 ¿Y si se define una de tipo Integer? Haga la prueba en Eclipse.
		  
		4. Responder la pregunta del punto anterior (3), pero ahora en lugar de definir una variable
		de instancia se define una variable de método. */
		
		int var1;
		Integer var2;
		
		/* RESPUESTA: No tienen valores predeterminados. Solo pueden tener valores al asignarles uno:
		  		int var1 	 = 1;	<< Instancia el valor de tipo int (primitivo) 1.
		  		Integer var2 = 2;	<< Instancia el valor de tipo Integer (clase) 2.
		  Es decir, deben ser instanciados para tener un valor.
		 */
	}
	
	// EJERCICIO 5: Punto 4)
	/*Responder la pregunta del punto anterior (3), pero ahora en lugar de definir una variable
		de instancia se define una variable de método.*/
	public int primitivo(int a) {
		return a;
	}
	
	public Integer integerClase(Integer a) {
		return a;
	}
	
	@Test
	public void testEjercicio5parte2() {
		// Assert
		assertEquals(primitivo(1), 1);
		assertEquals(integerClase(1), 1);
		// RESPUESTA: Igual que el caso anterior, pero en este caso lo recibe como parámetro.
		int[] arregloDeEnteros;
		int[][] matrizDeEnteros;
		arregloDeEnteros = new int[5];
		matrizDeEnteros = new int[6][4];
		
		int[] val = matrizDeEnteros[2];
		assertEquals(matrizDeEnteros[5][3], 0);
	}
}