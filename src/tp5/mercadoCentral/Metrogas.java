package tp5.mercadoCentral;

import java.util.ArrayList;

public class Metrogas implements Agencia {

	// VARIABLES
	private ArrayList<Factura> pagosRegistrados = new ArrayList<Factura>();
	private double tasaDelServicio = 700.0;
	
	// MÉTODOS
	public void registrarPago(Factura factura) {
		pagosRegistrados.add(factura);
	}
	
	public double tasaDelServicio() {
		return tasaDelServicio;
	}
	
	public int cantidadDePagosRealizados() {
		return pagosRegistrados.size();
	}
}
