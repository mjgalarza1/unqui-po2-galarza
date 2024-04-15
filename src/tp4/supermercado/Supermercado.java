package tp4.supermercado;

import java.util.ArrayList;

public class Supermercado {

	private String nombre;
	private String direccion;
	private ArrayList<Producto> productos;
	
	// CONSTRUCTORES
	public Supermercado(String unNombre, String unaDireccion) {
		nombre = unNombre;
		direccion = unaDireccion;
		productos = new ArrayList<Producto>();
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public void agregarProducto(Producto unProducto) {
		productos.add(unProducto);
	}

	public double getPrecioTotal() {
		double precioTotal = 0;
		for(Producto unProducto:productos) {
			precioTotal += unProducto.getPrecio();
		}
		return precioTotal;
	}
	
}
