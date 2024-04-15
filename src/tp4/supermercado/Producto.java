package tp4.supermercado;

public class Producto {

	// VARIABLES
	private String nombre;
	protected Double precio;
	private Boolean precioCuidado = false;
	
	
	// CONSTRUCTORES
	public Producto(String unNombre, Double unPrecio) {
		nombre = unNombre;
		precio = unPrecio;
	}
	
	public Producto(String unNombre, Double unPrecio, Boolean unBooleano) {
		nombre = unNombre;
		precio = unPrecio;
		precioCuidado = unBooleano;
	}
	
	// GETTERs & SETTERs
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	// MÉTODOS
	public Boolean esPrecioCuidado() {
		return precioCuidado;
	}
	
	public void aumentarPrecio(Double unMonto) {
		precio += unMonto;
	}
}
