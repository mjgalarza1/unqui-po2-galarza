package tpEnumYStreams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LesionDermatologicaTest {
	
	@Test
	public void testDescripcionesDeLesiones() {
		assertEquals(LesionDermatologica.ROJO.getDescripcion(), "La descripción roja");
		assertEquals(LesionDermatologica.GRIS.getDescripcion(), "La descripción gris");
		assertEquals(LesionDermatologica.AMARILLO.getDescripcion(), "La descripción amarilla");
		assertEquals(LesionDermatologica.MIEL.getDescripcion(), "La descripción miel");
	}
	
	@Test
	public void testNivelesDeRiesgo() {
		assertEquals(LesionDermatologica.ROJO.getNivelDeRiesgo(), "Muy grave");
		assertEquals(LesionDermatologica.GRIS.getNivelDeRiesgo(), "Grave");
		assertEquals(LesionDermatologica.AMARILLO.getNivelDeRiesgo(), "Moderado");
		assertEquals(LesionDermatologica.MIEL.getNivelDeRiesgo(), "Leve");
	}
	
	@Test
	public void testLosSiguientesColores() {
		assertEquals(LesionDermatologica.ROJO.getSiguienteColor(), "Gris");
		assertEquals(LesionDermatologica.GRIS.getSiguienteColor(), "Amarillo");
		assertEquals(LesionDermatologica.AMARILLO.getSiguienteColor(), "Miel");
		assertEquals(LesionDermatologica.MIEL.getSiguienteColor(), "Rojo");
	}
	
}
