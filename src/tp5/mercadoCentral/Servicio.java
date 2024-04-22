package tp5.mercadoCentral;

public class Servicio implements Factura {

	// VARIABLES
	private double costoPorUnidadConsumida;
	private int cantidadDeUnidadesConsumidas;
	private Agencia agencia;
	 
	// CONSTRUCTORES
	public Servicio(Agencia unaAgencia, double costoPorUnidad, int cantidadDeUnidades) {
		costoPorUnidadConsumida = costoPorUnidad;
		cantidadDeUnidadesConsumidas = cantidadDeUnidades;
		agencia = unaAgencia;
	}
	
	// MÉTODOS
	public double montoAPagar() {
		return costoPorUnidadConsumida * cantidadDeUnidadesConsumidas;
	}
	
	public void registrarPago() {
		agencia.registrarPago(this);
	}
}
