package tp5.mercadoCentral;

public abstract class Producto {

	// VARIABLES
	private String nombre;
	protected Double precio;
	
	
	// CONSTRUCTORES
	public Producto(String unNombre, Double unPrecio) {
		nombre = unNombre;
		precio = unPrecio;
	}
	
	// GETTERs & SETTERs
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		double precioConDescuento = precio - (precio * obtenerPorcentajeParaDescuento()); 
		return precioConDescuento;
	}
	
	public abstract double obtenerPorcentajeParaDescuento();
}
