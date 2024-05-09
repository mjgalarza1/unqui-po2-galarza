package tp6.Poquer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PoquerStatusMockitoTest {

	PoquerStatus poquer;
	
	Carta c1;
	Carta c2;
	Carta c3;
	Carta c4;
	Carta c5;
	
	@BeforeEach
	public void setUp() {
		// DOC
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		
		// SUT
		poquer = new PoquerStatus();
	}
	
	@Test
	public void testVerificarSiHayPoquer() {
		// Setup
		when(c1.getValor()).thenReturn(2);
		when(c2.getValor()).thenReturn(2);
		when(c3.getValor()).thenReturn(2);
		when(c4.getValor()).thenReturn(2);
		when(c5.getValor()).thenReturn(5);
		
		// Exercise
		poquer.verificar(c1, c2, c3, c4, c5);
		
		// Verify
		verify(c1).getValor();
		verify(c2).getValor();
		verify(c3).getValor();
		verify(c4).getValor();
		verify(c5).getValor();
		assertEquals(poquer.verificar(c1, c2, c3, c4, c5), "Poquer");
	}
	
	@Test
	public void testVerificarSiHayColor() {
		// Setup
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.PICA);
		when(c3.getPalo()).thenReturn(Palo.PICA);
		when(c4.getPalo()).thenReturn(Palo.PICA);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// Exercise
		poquer.verificar(c1, c2, c3, c4, c5);
		
		// Verify
		verify(c1).getPalo();
		verify(c2).getPalo();
		verify(c3).getPalo();
		verify(c4).getPalo();
		verify(c5).getPalo();
		assertEquals(poquer.verificar(c1, c2, c3, c4, c5), "Color");
	}
	
	@Test
	public void testVerificarSiHayTrio() {
		// Setup
		when(c1.getValor()).thenReturn(5);
		when(c2.getValor()).thenReturn(7);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(11);
		when(c5.getValor()).thenReturn(7);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.CORAZON);
		when(c4.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c5.getPalo()).thenReturn(Palo.TREBOL);
		
		// Exercise
		poquer.verificar(c1, c2, c3, c4, c5);
		
		// Verify
		verify(c1, times(2)).getValor(); // Se verifica dos veces por como está diseñado PoquerStatus.
		verify(c2, times(2)).getValor(); // Es decir, analiza todos los casos posibles, y solo corta si da
		verify(c3, times(2)).getValor(); // true alguno de esos casos.
		verify(c4, times(2)).getValor(); // Entonces primero verifica si hay poquer, y después
		verify(c5, times(2)).getValor(); // verifica si hay trio (ambos casos envían el mensaje getValor).
		verify(c1).getPalo();
		verify(c2).getPalo();
		verify(c3).getPalo();
		verify(c4).getPalo();
		verify(c5).getPalo();
		assertEquals(poquer.verificar(c1, c2, c3, c4, c5), "Trio");
	}
	
	@Test
	public void testVerificarQueNoHayNada() {
		// Setup
		when(c1.getValor()).thenReturn(3);
		when(c2.getValor()).thenReturn(5);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(11);
		when(c5.getValor()).thenReturn(13);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.CORAZON);
		when(c4.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c5.getPalo()).thenReturn(Palo.TREBOL);
		
		// Exercise
		poquer.verificar(c1, c2, c3, c4, c5);
		
		// Verify
		verify(c1, times(2)).getValor();
		verify(c2, times(2)).getValor();
		verify(c3, times(2)).getValor();
		verify(c4, times(2)).getValor();
		verify(c5, times(2)).getValor();
		verify(c1).getPalo();
		verify(c2).getPalo();
		verify(c3).getPalo();
		verify(c4).getPalo();
		verify(c5).getPalo();
		assertEquals(poquer.verificar(c1, c2, c3, c4, c5), "Nada");
	}
	
}
