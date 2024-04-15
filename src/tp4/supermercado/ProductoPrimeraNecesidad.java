package tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto {

	private int descuento = 10;
	
	// CONSTRUCTORES
	public ProductoPrimeraNecesidad(String unNombre, Double unPrecio) {
		super(unNombre, unPrecio);
	}
	
	public ProductoPrimeraNecesidad(String unNombre, Double unPrecio, Boolean unBooleano) {
		super(unNombre, unPrecio, unBooleano);
	}
	
	public ProductoPrimeraNecesidad(String unNombre, Double unPrecio, int unDescuento) {
		super(unNombre, unPrecio);
		descuento = unDescuento;
	}
	
	public ProductoPrimeraNecesidad(String unNombre, Double unPrecio, Boolean unBooleano, int unDescuento) {
		super(unNombre, unPrecio, unBooleano);
		descuento = unDescuento;
	}
	
	// MÉTODOS
	@Override
	public double getPrecio() {
		double nuevoDescuento = descuento;
		double precioRebajado = precio - (precio * (nuevoDescuento /= 100));
		return (precioRebajado);
	}
}
