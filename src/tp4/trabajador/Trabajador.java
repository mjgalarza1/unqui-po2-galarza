package tp4.trabajador;

import java.util.ArrayList;

public class Trabajador {
	
	// VARIABLES
	private ArrayList<Ingreso> ingresosPercibidos;
	
	// CONSTRUCTORES
	public Trabajador() {
		ingresosPercibidos = new ArrayList<Ingreso>();
	}
	
	public Trabajador(ArrayList<Ingreso> unosIngresos) {
		ingresosPercibidos = new ArrayList<Ingreso>();
		ingresosPercibidos = unosIngresos;
	}
	
	// MÉTODOS
	public double getTotalPercibido() {
		double montoPercibido = 0;
		for(Ingreso ingreso:ingresosPercibidos) {
			montoPercibido += ingreso.montoPercibido();
		}
		return montoPercibido - getImpuestoAPagar(); 
	}

	public double getMontoImponible() {
		double montoImponible = 0;
		for(Ingreso ingreso:ingresosPercibidos) {
			montoImponible += ingreso.montoImponible();
		}
		return montoImponible; 
	}
	
	public double getImpuestoAPagar() {
		return getMontoImponible() * 0.02d;
	}
	
	public void agregarIngreso(Ingreso unIngreso) {
		ingresosPercibidos.add(unIngreso);
	}
	
}
