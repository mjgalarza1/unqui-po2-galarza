package tp5.mercadoCentral;

public class CajaMercadoCentral {

	// VARIABLES
	private double montoTotal;
	private MercadoCentral mercadoCentral;
	
	// CONSTRUCTORES
	public CajaMercadoCentral(MercadoCentral unMercadoCentral) {
		mercadoCentral = unMercadoCentral;
	}

	// GETTERs & SETTERs
	public MercadoCentral getMercadoCentral() {
		return mercadoCentral;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	
	// MÉTODOS
	public void registrarPago(Producto unProducto) {
		mercadoCentral.removerDelStock(unProducto);
		montoTotal += unProducto.getPrecio();
	}
	
	public void registrarPago(Factura unaFactura) {
		montoTotal += unaFactura.montoAPagar();
		unaFactura.registrarPago();
	}
}
