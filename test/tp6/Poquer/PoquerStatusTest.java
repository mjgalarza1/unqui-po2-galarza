package tp6.Poquer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoquerStatusTest {

	PoquerStatus poquer;
	
	@BeforeEach
	public void setUp() {
		// Setup
		poquer = new PoquerStatus();
	}
	
	@Test
	public void testVerificarSiHayPoquer() {
		// Assert (Verify)
		assertEquals(poquer.verificar("2P", "QD", "2D", "2C", "2T"), "Poquer");
		assertEquals(poquer.verificar("JT", "10P", "10D", "10C", "10T"), "Poquer");
		assertEquals(poquer.verificar("10D", "QD", "QP", "QT", "QC"), "Poquer");
		assertEquals(poquer.verificar("4T", "4D", "4P", "4C", "9T"), "Poquer");
		assertEquals(poquer.verificar("AT", "AD", "AP", "AC", "QT"), "Poquer");
	}
	
	@Test
	public void testVerificarSiHayColor() {
		// Assert (Verify)
		assertEquals(poquer.verificar("2P", "QP", "8P", "AP", "10P"), "Color");
		assertEquals(poquer.verificar("JT", "10T", "KT", "5T", "AT"), "Color");
		assertEquals(poquer.verificar("10C", "QC", "JC", "KC", "2C"), "Color");
		assertEquals(poquer.verificar("4D", "9D", "AD", "2D", "QD"), "Color");
	}
	
	@Test
	public void testVerificarSiHayTrio() {
		// Assert (Verify)
		assertEquals(poquer.verificar("2P", "QD", "2D", "2C", "JC"), "Trio");
		assertEquals(poquer.verificar("JT", "10P", "10D", "8P", "10T"), "Trio");
		assertEquals(poquer.verificar("7D", "1D", "QP", "QT", "QC"), "Trio");
		assertEquals(poquer.verificar("AT", "AD", "AP", "5C", "8T"), "Trio");
	}
	
	@Test
	public void testVerificarQueNoHayNada() {
		// Assert (Verify)
		assertEquals(poquer.verificar("2P", "2D", "1T", "AP", "10C"), "Nada");
		assertEquals(poquer.verificar("JC", "10T", "JD", "4C", "KP"), "Nada");
		assertEquals(poquer.verificar("QD", "AP", "7T", "10D", "JD"), "Nada");
	}
}
