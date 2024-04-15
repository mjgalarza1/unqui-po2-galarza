package tp4.trabajador;

import java.time.Month;

public class IngresoPorHorasExtras extends Ingreso {
	
	public IngresoPorHorasExtras(Month unMes, String unConcepto, double unMontoPercibido) {
		super(unMes, unConcepto, unMontoPercibido);
	}
	
	@Override
	public double montoImponible() {
		return 0;
	}
}
