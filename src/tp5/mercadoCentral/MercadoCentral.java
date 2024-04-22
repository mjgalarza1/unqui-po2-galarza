package tp5.mercadoCentral;

import java.util.ArrayList;

public class MercadoCentral {

	private ArrayList<Producto> stock;
	
	// CONSTRUCTORES
	public MercadoCentral() {
		stock = new ArrayList<Producto>();
	}
	
	public MercadoCentral(ArrayList<Producto> productos) {
		stock = new ArrayList<Producto>();
		stock = productos;
	}
	
	// GETTERs & SETTERs
	public ArrayList<Producto> getStock() {
		return stock;
	}
	
	// MÉTODOS
	public void removerDelStock(Producto unProducto) {
		stock.remove(unProducto);
	}
	
	public int cantidadTotalDeStock() {
		return stock.size();
	}
}
