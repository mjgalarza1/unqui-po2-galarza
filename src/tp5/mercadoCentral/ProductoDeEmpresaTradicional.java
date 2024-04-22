package tp5.mercadoCentral;

public class ProductoDeEmpresaTradicional extends Producto {
	
	// CONSTRUCTORES
		public ProductoDeEmpresaTradicional(String unNombre, Double unPrecio) {
			super(unNombre, unPrecio);
		}
	
	// MÉTODOS
	public double obtenerPorcentajeParaDescuento() {
		return 0;
	}
}
