package tp6.Poquer;

public class Carta {

	// ATRIBUTOS
	private int valor;
	private Palo palo;
	
	// CONSTRUCTORES
	public Carta(Valor valor, Palo palo) {
		this.valor = valor.getValor();
		this.palo = palo;
	}
	
	// GETTERs & SETTERs
	public int getValor() {
		return valor;
	}
	
	public Palo getPalo() {
		return palo;
	}

	// MÉTODOS
	public boolean esMayorQueLaCarta(Carta carta) {
		return valor >= carta.getValor();
	}

	public boolean tieneElMismoPaloQueLaCarta(Carta carta) {
		return palo == carta.getPalo();
	}
}
