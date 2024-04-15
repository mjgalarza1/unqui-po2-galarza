package tp4.supermercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp4.supermercado.ProductoPrimeraNecesidad;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	private ProductoPrimeraNecesidad off;
	private ProductoPrimeraNecesidad raid;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false);
		off = new ProductoPrimeraNecesidad("Off", 100d, 50);
		raid = new ProductoPrimeraNecesidad("Raid", 100d, 10);
	}
	
	@Test
	public void testCalcularPrecio() {
		//assertEquals(new Double(7.2), leche.getPrecio());
		assertEquals(7.2d, leche.getPrecio());
		assertEquals(50d, off.getPrecio());
		assertEquals(90d, raid.getPrecio());
	}
}
