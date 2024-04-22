package tp5.mercadoCentral;

public class Impuesto implements Factura {

	// VARIABLES
	private double tasaDelServicio;
	private Agencia agencia;
	
	// CONSTRUCTORES
	public Impuesto(Agencia unaAgencia) {
		agencia = unaAgencia;
		tasaDelServicio = unaAgencia.tasaDelServicio();
	}
	
	public Impuesto(Agencia unaAgencia, double unMontoFijo) {
		tasaDelServicio = unMontoFijo;
		agencia = unaAgencia;
	}
	
	public double montoAPagar() {
		return tasaDelServicio;
	}
	
	public void registrarPago() {
		agencia.registrarPago(this);
	}
}
