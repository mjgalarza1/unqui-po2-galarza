package tp6.Poquer;

public enum Palo {

	PICA("Pica"),
	CORAZON("Corazon"),
	TREBOL("Trebol"),
	DIAMANTE("Diamante");
	
	String palo;
	
	Palo(String palo){
		this.palo = palo;
	}
	
	public String getPalo() {
		return palo;
	}
}
