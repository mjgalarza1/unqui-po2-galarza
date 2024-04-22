package tp5.mercadoCentral;

public class ProductoDeCooperativa extends Producto {
	
	// CONSTRUCTORES
		public ProductoDeCooperativa(String unNombre, Double unPrecio) {
			super(unNombre, unPrecio);
		}
	
	// MÉTODOS 	
	public double obtenerPorcentajeParaDescuento() {
		return 0.10;
	}
}
