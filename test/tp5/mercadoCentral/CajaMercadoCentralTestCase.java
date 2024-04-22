package tp5.mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaMercadoCentralTestCase {

	// VARIABLES (productos)
	private CajaMercadoCentral caja;
	private MercadoCentral mercadoCentral;
	private ArrayList<Producto> productos;
	private ProductoDeEmpresaTradicional arroz;
	private ProductoDeEmpresaTradicional detergente;
	private ProductoDeEmpresaTradicional fideos;
	private ProductoDeCooperativa cooperativa1;
	private ProductoDeCooperativa cooperativa2;
	
	// VARIABLES (servicios y agencias)
	private Servicio servicio1;
	private Impuesto impuesto1;
	private Edesur edesur;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Inicialización de las variables para los productos
		productos = new ArrayList<Producto>();
		arroz = new ProductoDeEmpresaTradicional("Arroz", 18.9d);
		detergente = new ProductoDeEmpresaTradicional("Detergente", 75d);
		fideos = new ProductoDeEmpresaTradicional("Fideos", 20.5d);
		cooperativa1 = new ProductoDeCooperativa("Producto cooperativa 1", 100d);
		cooperativa2 = new ProductoDeCooperativa("Producto cooperativa 2", 250d);
		// Se agregan los productos a la lista de productos
		productos.add(arroz);
		productos.add(arroz);
		productos.add(arroz);
		productos.add(detergente);
		productos.add(detergente);
		productos.add(detergente);
		productos.add(fideos);
		productos.add(fideos);
		productos.add(fideos);
		productos.add(cooperativa1);
		productos.add(cooperativa1);
		productos.add(cooperativa2);
		productos.add(cooperativa2);
		// Se inicializa el mercado agregando los productos a su stock
		mercadoCentral = new MercadoCentral(productos);
		// Asigno el mercado central a la caja
		caja = new CajaMercadoCentral(mercadoCentral);
		
		// Inicialización de los SERVICIOS y AGENCIAS
		edesur = new Edesur();
		servicio1 = new Servicio(edesur, 10000.0, 3);
		impuesto1 = new Impuesto(edesur);
	}
	
	@Test
	public void testMontoTotalSinCooperativos() {
		// Exercise
		caja.registrarPago(arroz);
		caja.registrarPago(detergente);
		caja.registrarPago(fideos);
		// Assert
		assertTrue(mercadoCentral.cantidadTotalDeStock() == 10);
		assertEquals(caja.getMontoTotal(),114,4);
	}
	
	@Test
	public void testMontoTotalConCooperativos() {
		// Exercise
		caja.registrarPago(cooperativa1);
		caja.registrarPago(cooperativa2);
		// Assert
		assertTrue(mercadoCentral.cantidadTotalDeStock() == 11);
		assertEquals(caja.getMontoTotal(),315);
	}
	
	@Test
	public void testMontoTotalVariado() {
		// Exercise
		caja.registrarPago(arroz);
		caja.registrarPago(detergente);
		caja.registrarPago(fideos);
		caja.registrarPago(cooperativa1);
		caja.registrarPago(cooperativa2);
		// Assert
		assertTrue(mercadoCentral.cantidadTotalDeStock() == 8);
		assertEquals(caja.getMontoTotal(),429,4);
	}
	
	@Test
	public void testMontoTotalServicios() {
		caja.registrarPago(cooperativa1);
		caja.registrarPago(servicio1);
		caja.registrarPago(impuesto1);
		assertEquals(caja.getMontoTotal(),31140,0);
	}
}
