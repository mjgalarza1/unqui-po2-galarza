package tp4.trabajador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrabajadorTestCase {

	private Trabajador trabajador;
	private Ingreso ingreso1;
	private Ingreso ingreso2;
	private Ingreso ingreso3;
	private Ingreso ingreso4;
	private IngresoPorHorasExtras ingresoA;
	private IngresoPorHorasExtras ingresoB;
	private IngresoPorHorasExtras ingresoC;
	
	@BeforeEach
	public void setUp() throws Exception {
		trabajador = new Trabajador();
		// Inicializo los ingresos normales
		ingreso1 = new Ingreso(Month.APRIL, "ingreso 1", 100);
		ingreso2 = new Ingreso(Month.FEBRUARY, "ingreso 2", 500);
		ingreso3 = new Ingreso(Month.OCTOBER, "ingreso 3", 700);
		ingreso4 = new Ingreso(Month.SEPTEMBER, "ingreso 4", 50);
		// Inicializo los ingresos por horas extras
		ingresoA = new IngresoPorHorasExtras(Month.FEBRUARY, "ingreso A", 500);
		ingresoB = new IngresoPorHorasExtras(Month.OCTOBER, "ingreso B", 700);
		ingresoC = new IngresoPorHorasExtras(Month.SEPTEMBER, "ingreso C", 50);
		// Agrego los ingresos al trabajador
		trabajador.agregarIngreso(ingreso1);
		trabajador.agregarIngreso(ingreso2);
		trabajador.agregarIngreso(ingreso3);
		trabajador.agregarIngreso(ingreso4);
		trabajador.agregarIngreso(ingresoA);
		trabajador.agregarIngreso(ingresoB);
		trabajador.agregarIngreso(ingresoC);
	}
	
	@Test
	public void testGetImpuestoAPagar() {
		double impuestoAPagar = trabajador.getImpuestoAPagar();
		assertEquals(impuestoAPagar,27);
	}
	
	@Test
	public void testGetMontoImponible() {
		double montoImponible = trabajador.getMontoImponible();
		assertEquals(montoImponible,1350);
	}
	
	@Test
	public void testGetTotalPercibido() {
		double totalPercibido = trabajador.getTotalPercibido();
		assertEquals(totalPercibido,2573);
	}
}
