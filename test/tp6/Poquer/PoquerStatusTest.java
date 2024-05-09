package tp6.Poquer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoquerStatusTest {

	PoquerStatus poquer;
	
	// Atribuyo (de forma innecesaria) el mazo completo de cartas de Poker en variables:
	Carta p2 = new Carta(Valor.DOS, Palo.PICA);
	Carta p3 = new Carta(Valor.TRES, Palo.PICA);
	Carta p4 = new Carta(Valor.CUATRO, Palo.PICA);
	Carta p5 = new Carta(Valor.CINCO, Palo.PICA);
	Carta p6 = new Carta(Valor.SEIS, Palo.PICA);
	Carta p7 = new Carta(Valor.SIETE, Palo.PICA);
	Carta p8 = new Carta(Valor.OCHO, Palo.PICA);
	Carta p9 = new Carta(Valor.NUEVE, Palo.PICA);
	Carta p10= new Carta(Valor.DIEZ, Palo.PICA);
	Carta pJ = new Carta(Valor.J, Palo.PICA);
	Carta pQ = new Carta(Valor.Q, Palo.PICA);
	Carta pK = new Carta(Valor.K, Palo.PICA);
	Carta pA = new Carta(Valor.A, Palo.PICA);
		
	Carta d2 = new Carta(Valor.DOS, Palo.DIAMANTE);
	Carta d3 = new Carta(Valor.TRES, Palo.DIAMANTE);
	Carta d4 = new Carta(Valor.CUATRO, Palo.DIAMANTE);
	Carta d5 = new Carta(Valor.CINCO, Palo.DIAMANTE);
	Carta d6 = new Carta(Valor.SEIS, Palo.DIAMANTE);
	Carta d7 = new Carta(Valor.SIETE, Palo.DIAMANTE);
	Carta d8 = new Carta(Valor.OCHO, Palo.DIAMANTE);
	Carta d9 = new Carta(Valor.NUEVE, Palo.DIAMANTE);
	Carta d10= new Carta(Valor.DIEZ, Palo.DIAMANTE);
	Carta dJ = new Carta(Valor.J, Palo.DIAMANTE);
	Carta dQ = new Carta(Valor.Q, Palo.DIAMANTE);
	Carta dK = new Carta(Valor.K, Palo.DIAMANTE);
	Carta dA = new Carta(Valor.A, Palo.DIAMANTE);
		
	Carta t2 = new Carta(Valor.DOS, Palo.TREBOL);
	Carta t3 = new Carta(Valor.TRES, Palo.TREBOL);
	Carta t4 = new Carta(Valor.CUATRO, Palo.TREBOL);
	Carta t5 = new Carta(Valor.CINCO, Palo.TREBOL);
	Carta t6 = new Carta(Valor.SEIS, Palo.TREBOL);
	Carta t7 = new Carta(Valor.SIETE, Palo.TREBOL);
	Carta t8 = new Carta(Valor.OCHO, Palo.TREBOL);
	Carta t9 = new Carta(Valor.NUEVE, Palo.TREBOL);
	Carta t10= new Carta(Valor.DIEZ, Palo.TREBOL);
	Carta tJ = new Carta(Valor.J, Palo.TREBOL);
	Carta tQ = new Carta(Valor.Q, Palo.TREBOL);
	Carta tK = new Carta(Valor.K, Palo.TREBOL);
	Carta tA = new Carta(Valor.A, Palo.TREBOL);
		
	Carta c2 = new Carta(Valor.DOS, Palo.CORAZON);
	Carta c3 = new Carta(Valor.TRES, Palo.CORAZON);
	Carta c4 = new Carta(Valor.CUATRO, Palo.CORAZON);
	Carta c5 = new Carta(Valor.CINCO, Palo.CORAZON);
	Carta c6 = new Carta(Valor.SEIS, Palo.CORAZON);
	Carta c7 = new Carta(Valor.SIETE, Palo.CORAZON);
	Carta c8 = new Carta(Valor.OCHO, Palo.CORAZON);
	Carta c9 = new Carta(Valor.NUEVE, Palo.CORAZON);
	Carta c10= new Carta(Valor.DIEZ, Palo.CORAZON);
	Carta cJ = new Carta(Valor.J, Palo.CORAZON);
	Carta cQ = new Carta(Valor.Q, Palo.CORAZON);
	Carta cK = new Carta(Valor.K, Palo.CORAZON);
	Carta cA = new Carta(Valor.A, Palo.CORAZON);
	
	@BeforeEach
	public void setUp() {
		// Setup
		poquer = new PoquerStatus();
	}
	
	@Test
	public void testVerificarSiHayPoquer() {
		// Assert (Verify)
		assertEquals(poquer.verificar(p2, dQ, d2, c2, t2), "Poquer");
		assertEquals(poquer.verificar(tJ, p10, d10, c10, t10), "Poquer");
		assertEquals(poquer.verificar(d10, dQ, pQ, tQ, cQ), "Poquer");
		assertEquals(poquer.verificar(t4, d4, p4, c4, t9), "Poquer");
		assertEquals(poquer.verificar(tA, dA, pA, cA, tQ), "Poquer");
	}
	
	@Test
	public void testVerificarSiHayColor() {
		// Assert (Verify)
		assertEquals(poquer.verificar(p2, pQ, p8, pA, p10), "Color");
		assertEquals(poquer.verificar(tJ, t10, tK, t5, tA), "Color");
		assertEquals(poquer.verificar(c10, cQ, cJ, cK, c2), "Color");
		assertEquals(poquer.verificar(d4, d9, dA, d2, dQ), "Color");
	}
	
	@Test
	public void testVerificarSiHayTrio() {
		// Assert (Verify)
		assertEquals(poquer.verificar(p2, dQ, d2, c2, cJ), "Trio");
		assertEquals(poquer.verificar(tJ, p10, d10, p8, t10), "Trio");
		assertEquals(poquer.verificar(d7, dA, pQ, tQ, cQ), "Trio");
		assertEquals(poquer.verificar(tA, dA, pA, c5, t8), "Trio");
	}
	
	@Test
	public void testVerificarQueNoHayNada() {
		// Assert (Verify)
		assertEquals(poquer.verificar(p2, d2, tA, pA, c10), "Nada");
		assertEquals(poquer.verificar(cJ, t10, dJ, c4, pK), "Nada");
		assertEquals(poquer.verificar(dQ, pA, t7, d10, dJ), "Nada");
	}
}
