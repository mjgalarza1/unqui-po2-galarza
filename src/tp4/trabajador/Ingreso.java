package tp4.trabajador;

import java.time.Month;

public class Ingreso {

	// VARIABLES
	private Month mesDePercepcion;
	private String concepto;
	private double montoPercibido;
	
	// CONSTRUCTORES
	public Ingreso(Month unMes, String unConcepto, double unMontoPercibido) {
		mesDePercepcion = unMes;
		concepto = unConcepto;
		montoPercibido = unMontoPercibido;
	}
	
	// MÉTODOS
	public double montoImponible() {
		return montoPercibido;
	}
	
	public double montoPercibido() {
		return montoPercibido;
	}
	
}
