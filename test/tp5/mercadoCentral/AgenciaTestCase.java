package tp5.mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgenciaTestCase {
	// VARIABLES (mercado)
	private CajaMercadoCentral caja;
	private MercadoCentral mercadoCentral;
	
	// VARIABLES (servicios)
	private Servicio servicio1;
	private Servicio servicio2;
	private Impuesto impuesto1;
	private Impuesto impuesto2;
	
	// VARIABLES (agencias)
	private Edesur edesur;
	private Metrogas metrogas;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Se inicializa el mercado central y su caja
		mercadoCentral = new MercadoCentral();
		caja = new CajaMercadoCentral(mercadoCentral);
		
		// Inicialización de los SERVICIOS y AGENCIAS
		edesur = new Edesur();
		metrogas = new Metrogas();
		servicio1 = new Servicio(edesur, 10000.0, 3);
		servicio2 = new Servicio(metrogas, 8000.0, 2);
		impuesto1 = new Impuesto(edesur);
		impuesto2 = new Impuesto(metrogas);
	}
	
	@Test
	public void testMontoTotalFacturas() {
		caja.registrarPago(servicio1);
		caja.registrarPago(impuesto1);
		assertEquals(caja.getMontoTotal(),31050,0);
		assertTrue(edesur.cantidadDePagosRealizados() == 2);
	}
	
	@Test
	public void testMontoTotalFacturasEImpuestos() {
		caja.registrarPago(servicio1);
		caja.registrarPago(servicio1);
		caja.registrarPago(impuesto1);
		caja.registrarPago(servicio2);
		caja.registrarPago(impuesto2);
		assertEquals(caja.getMontoTotal(),77750,0);
		assertTrue(edesur.cantidadDePagosRealizados() == 3);
		assertTrue(metrogas.cantidadDePagosRealizados() == 2);
	}
}

