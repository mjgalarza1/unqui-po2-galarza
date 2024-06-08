package tp6.Poquer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

/*Jugadas de Póquer
Nuevamente, es necesario agregar funcionalidad para que las jugadas puedan compararse y saber cual puede ser el
ganador de una mano. El orden de importancia entre jugadas es el siguiente: Póquer le gana a Color y Color le gana a
Trio. La relación es transitiva. Por su parte, si las jugadas son iguales se desempata por el valor de las cartas que la
componen. El orden de las cartas es el siguiente: A, K, Q, J, 10, ..., 2. En orden de importancia descendente. Es decir,
un trio con tres ases le gana a un trio con tres K.
. 1) Identifique los casos a testear.
. 2) Defina los test para el modelado de jugadas. Recuerde seguir la metodología TDD y la POO!.
. 3) Identifique en sus tests los setup, excercise, verify, teardown y doc. ¿Qué tipo de Test Doubles usó?
. 4) Actualice los test programados anteriormente para que el verificar ahora retorne instancias de jugadas*/

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
	
	@Test
	public void testVerificarGanadorConTrio() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Trio
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(7);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(7);
		when(c5.getValor()).thenReturn(6);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c4.getPalo()).thenReturn(Palo.TREBOL);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Nada
		when(c6.getValor()).thenReturn(5);
		when(c7.getValor()).thenReturn(4);
		when(c8.getValor()).thenReturn(2);
		when(c9.getValor()).thenReturn(9);
		when(c10.getValor()).thenReturn(3);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.CORAZON);
		when(c8.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c9.getPalo()).thenReturn(Palo.TREBOL);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador1);
	}
	
	@Test
	public void testVerificarDesempateConTrio() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Trio
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(7);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(7);
		when(c5.getValor()).thenReturn(6);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c4.getPalo()).thenReturn(Palo.TREBOL);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Trio
		when(c6.getValor()).thenReturn(2);
		when(c7.getValor()).thenReturn(10);
		when(c8.getValor()).thenReturn(8);
		when(c9.getValor()).thenReturn(8);
		when(c10.getValor()).thenReturn(8);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.CORAZON);
		when(c8.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c9.getPalo()).thenReturn(Palo.TREBOL);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador2);
	}
	
	@Test
	public void testVerificarGanadorConColor() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Color
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(8);
		when(c3.getValor()).thenReturn(4);
		when(c4.getValor()).thenReturn(2);
		when(c5.getValor()).thenReturn(6);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.PICA);
		when(c3.getPalo()).thenReturn(Palo.PICA);
		when(c4.getPalo()).thenReturn(Palo.PICA);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Trio
		when(c6.getValor()).thenReturn(5);
		when(c7.getValor()).thenReturn(7);
		when(c8.getValor()).thenReturn(7);
		when(c9.getValor()).thenReturn(3);
		when(c10.getValor()).thenReturn(7);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.CORAZON);
		when(c8.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c9.getPalo()).thenReturn(Palo.TREBOL);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador1);
	}
	
	@Test
	public void testVerificarDesempateConColor() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Color
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(8);
		when(c3.getValor()).thenReturn(4);
		when(c4.getValor()).thenReturn(2);
		when(c5.getValor()).thenReturn(6);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.PICA);
		when(c3.getPalo()).thenReturn(Palo.PICA);
		when(c4.getPalo()).thenReturn(Palo.PICA);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Trio
		when(c6.getValor()).thenReturn(9);
		when(c7.getValor()).thenReturn(8);
		when(c8.getValor()).thenReturn(4);
		when(c9.getValor()).thenReturn(9);
		when(c10.getValor()).thenReturn(6);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.PICA);
		when(c8.getPalo()).thenReturn(Palo.PICA);
		when(c9.getPalo()).thenReturn(Palo.PICA);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador2);
	}
	
	@Test
	public void testVerificarGanadorConPoquer() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Trio
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(7);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(7);
		when(c5.getValor()).thenReturn(7);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c4.getPalo()).thenReturn(Palo.TREBOL);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Nada
		when(c6.getValor()).thenReturn(5);
		when(c7.getValor()).thenReturn(4);
		when(c8.getValor()).thenReturn(2);
		when(c9.getValor()).thenReturn(9);
		when(c10.getValor()).thenReturn(3);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.PICA);
		when(c8.getPalo()).thenReturn(Palo.PICA);
		when(c9.getPalo()).thenReturn(Palo.PICA);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador1);
	}
	
	@Test
	public void testVerificarDesempateConPoquer() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Trio
		when(c1.getValor()).thenReturn(9);
		when(c2.getValor()).thenReturn(7);
		when(c3.getValor()).thenReturn(7);
		when(c4.getValor()).thenReturn(7);
		when(c5.getValor()).thenReturn(7);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c4.getPalo()).thenReturn(Palo.TREBOL);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Trio
		when(c6.getValor()).thenReturn(8);
		when(c7.getValor()).thenReturn(8);
		when(c8.getValor()).thenReturn(8);
		when(c9.getValor()).thenReturn(8);
		when(c10.getValor()).thenReturn(13);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.CORAZON);
		when(c8.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c9.getPalo()).thenReturn(Palo.TREBOL);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador2);
	}
	
	@Test
	public void testVerificarDesempateConNada() {
		// Setup (para el segundo jugador)
		Carta c6 = mock(Carta.class);
		Carta c7 = mock(Carta.class);
		Carta c8 = mock(Carta.class);
		Carta c9 = mock(Carta.class);
		Carta c10 = mock(Carta.class);
		
		// JUGADOR 1: Trio
		when(c1.getValor()).thenReturn(2);
		when(c2.getValor()).thenReturn(3);
		when(c3.getValor()).thenReturn(4);
		when(c4.getValor()).thenReturn(5);
		when(c5.getValor()).thenReturn(6);
		
		when(c1.getPalo()).thenReturn(Palo.PICA);
		when(c2.getPalo()).thenReturn(Palo.CORAZON);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c4.getPalo()).thenReturn(Palo.TREBOL);
		when(c5.getPalo()).thenReturn(Palo.PICA);
		
		// JUGADOR 2: Nada
		when(c6.getValor()).thenReturn(7);
		when(c7.getValor()).thenReturn(8);
		when(c8.getValor()).thenReturn(9);
		when(c9.getValor()).thenReturn(10);
		when(c10.getValor()).thenReturn(11);
		
		when(c6.getPalo()).thenReturn(Palo.PICA);
		when(c7.getPalo()).thenReturn(Palo.CORAZON);
		when(c8.getPalo()).thenReturn(Palo.DIAMANTE);
		when(c9.getPalo()).thenReturn(Palo.TREBOL);
		when(c10.getPalo()).thenReturn(Palo.PICA);
		
		List<Carta> manoJugador1 = List.of(c1,c2,c3,c4,c5);
		List<Carta> manoJugador2 = List.of(c6,c7,c8,c9,c10);
		
		// Verify
		assertEquals(poquer.verificarGanadorEntreLasManos(manoJugador1, manoJugador2), manoJugador2);
	}
	
}
