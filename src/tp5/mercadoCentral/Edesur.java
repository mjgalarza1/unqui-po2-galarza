package tp5.mercadoCentral;

import java.util.ArrayList;

public class Edesur implements Agencia {

	// VARIABLES
	private ArrayList<Factura> pagosRegistrados = new ArrayList<Factura>();
	private double tasaDelServicio = 1050.0;
	
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
