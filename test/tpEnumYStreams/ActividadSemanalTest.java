package tpEnumYStreams;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActividadSemanalTest {
	
	private ActividadSemanal actividad1a;
	private ActividadSemanal actividad1b;
	private ActividadSemanal actividad2;
	private ActividadSemanal actividad3;
	private ActividadSemanal actividad4;
	private ActividadSemanal actividad5;
	
	private LocalTime laHoraDeInicio;
	
	@BeforeEach
	public void setUp() {
		laHoraDeInicio = LocalTime.now();
		
		actividad1a = new ActividadSemanal(DiaDeLaSemana.LUNES, laHoraDeInicio, 1, Deporte.FUTBOL);
		actividad1b = new ActividadSemanal(DiaDeLaSemana.JUEVES, laHoraDeInicio, 2, Deporte.FUTBOL);
		actividad2 = new ActividadSemanal(DiaDeLaSemana.MIERCOLES, laHoraDeInicio, 3, Deporte.BASKET);
		actividad3 = new ActividadSemanal(DiaDeLaSemana.SABADO, laHoraDeInicio, 5, Deporte.RUNNING);
		actividad4 = new ActividadSemanal(DiaDeLaSemana.DOMINGO, laHoraDeInicio, 2, Deporte.TENNIS);
		actividad5 = new ActividadSemanal(DiaDeLaSemana.VIERNES, laHoraDeInicio, 1, Deporte.JABALINA);

	}
	
	@Test
	public void testGetCostos() {
		assertEquals(actividad1a.getCosto(), 900);
		assertEquals(actividad1b.getCosto(), 2400);
		assertEquals(actividad2.getCosto(), 1900);
		assertEquals(actividad3.getCosto(), 5200);
		assertEquals(actividad4.getCosto(), 2600);
		assertEquals(actividad5.getCosto(), 1800);
	}
}
