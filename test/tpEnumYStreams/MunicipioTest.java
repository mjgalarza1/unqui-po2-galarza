package tpEnumYStreams;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MunicipioTest {
	
	private Municipio municipio;
	
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
		
		actividad1a = new ActividadSemanal(DiaDeLaSemana.LUNES, laHoraDeInicio, 1, Deporte.FUTBOL); // Más barato
		actividad1b = new ActividadSemanal(DiaDeLaSemana.LUNES, laHoraDeInicio, 2, Deporte.FUTBOL); // Más caro
		actividad2 = new ActividadSemanal(DiaDeLaSemana.MIERCOLES, laHoraDeInicio, 3, Deporte.BASKET);
		actividad3 = new ActividadSemanal(DiaDeLaSemana.SABADO, laHoraDeInicio, 5, Deporte.RUNNING);
		actividad4 = new ActividadSemanal(DiaDeLaSemana.DOMINGO, laHoraDeInicio, 2, Deporte.TENNIS);
		actividad5 = new ActividadSemanal(DiaDeLaSemana.VIERNES, laHoraDeInicio, 1, Deporte.JABALINA);
		
		municipio = new Municipio();
		
		municipio.agregarActividad(actividad1a);
		municipio.agregarActividad(actividad1b);
		municipio.agregarActividad(actividad2);
		municipio.agregarActividad(actividad3);
		municipio.agregarActividad(actividad4);
		municipio.agregarActividad(actividad5);
	}
	
	@Test
	public void testTodasLasActividadesDeFutbol() {
		assertTrue(municipio.todasLasActividadesDeFutbol().contains(actividad1a));
		assertTrue(municipio.todasLasActividadesDeFutbol().contains(actividad1b));
		assertFalse(municipio.todasLasActividadesDeFutbol().contains(actividad2));
		assertFalse(municipio.todasLasActividadesDeFutbol().contains(actividad3));
		assertFalse(municipio.todasLasActividadesDeFutbol().contains(actividad4));
		assertFalse(municipio.todasLasActividadesDeFutbol().contains(actividad5));
	}
	
	@Test
	public void testTodasLasActividadesDeComplejidad() {
		assertTrue(municipio.todasLasActividadesDeComplejidad(2).contains(actividad1a));
		assertTrue(municipio.todasLasActividadesDeComplejidad(2).contains(actividad1b));
		assertTrue(municipio.todasLasActividadesDeComplejidad(2).contains(actividad2));
		assertFalse(municipio.todasLasActividadesDeComplejidad(2).contains(actividad3));
		assertFalse(municipio.todasLasActividadesDeComplejidad(2).contains(actividad4));
		assertFalse(municipio.todasLasActividadesDeComplejidad(2).contains(actividad5));
	}
	
	@Test
	public void testCantidadDeHorasTotalesDeActividades() {
		assertEquals(municipio.cantidadDeHorasTotalesDeActividades(), 14);
	}
	
	@Test
	public void testLaActividadDeMenorCostoParaElDeporte() {
		assertEquals(municipio.laActividadDeMenorCostoParaElDeporte(Deporte.FUTBOL), actividad1a);
	}
	
	@Test
	public void testLaActividadSemanalMasEconomica() {
		assertTrue(municipio.laActividadMasEconomicaPorDeporte().containsValue(actividad1a)); 	// Futbol (barato)
		assertFalse(municipio.laActividadMasEconomicaPorDeporte().containsValue(actividad1b));	// Futbol (caro)
		System.out.print(municipio.laActividadMasEconomicaPorDeporte());
	}

}
