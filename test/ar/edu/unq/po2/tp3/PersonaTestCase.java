package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTestCase {
	
	private Persona matias;
	private Persona ariel;
	private Persona lucas;

	@BeforeEach
	public void setUp() throws Exception {
		matias = new Persona("Matias", LocalDate.of(1995, 10, 4));
		ariel = new Persona("Ariel", LocalDate.of(1992, 8, 18));
		lucas = new Persona("Lucas", LocalDate.of(2001, 2, 20));
	}
	
	@Test
	public void testSmallerThan() {
		assertTrue(lucas.smallerThan(matias));
		assertTrue(lucas.smallerThan(ariel));
		assertTrue(matias.smallerThan(ariel));
		assertFalse(ariel.smallerThan(lucas));
	}
}
