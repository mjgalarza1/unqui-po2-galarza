package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuadradoTestCase {

	private Cuadrado cuadrado;
	private Cuadrado rectanguloH;
	private Cuadrado rectanguloV;
	private Point punto0;
	private Point punto1;
	
	@BeforeEach
	public void setUp() throws Exception {
		punto0 = new Point();
		punto1 = new Point(2,2);
		cuadrado = new Cuadrado(punto0, 10, 10);
		rectanguloH = new Cuadrado(punto1, 20, 10);
		rectanguloV = new Cuadrado(punto1, 13, 27);
	}
	
	@Test
	public void testAltoYAnchoIncorrectos() {
		Exception widthError = assertThrows(Exception.class, () -> new Cuadrado(punto0, -3, 1));
		Exception heightError = assertThrows(Exception.class, () -> new Cuadrado(punto0, 1, -3));
		assertEquals("Could not create the square: WIDTH and HEIGHT must be greater than zero.", widthError.getMessage());
		assertEquals("Could not create the square: WIDTH and HEIGHT must be greater than zero.", heightError.getMessage());
	}
	
	@Test
	public void testCuadrado() {
		assertEquals(cuadrado.area(), 100);
		assertEquals(cuadrado.perimeter(), 40);
	}
	
	@Test
	public void testRectanguloH() {
		assertEquals(rectanguloH.area(), 200);
		assertEquals(rectanguloH.perimeter(), 60);
		assertTrue(rectanguloH.isHorizontal());
		assertFalse(rectanguloH.isVertical());
	}
	
	@Test
	public void testRectanguloV() {
		assertEquals(rectanguloV.area(), 351);
		assertEquals(rectanguloV.perimeter(), 80);
		assertTrue(rectanguloV.isVertical());
		assertFalse(rectanguloV.isHorizontal());
	}
}
