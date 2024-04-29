package tpEnumYStreams;

public enum LesionDermatologica { 

	// CONSTANTES
	ROJO("La descripción roja", "Muy grave", "Gris"),
	GRIS("La descripción gris", "Grave", "Amarillo"),
	AMARILLO("La descripción amarilla", "Moderado", "Miel"),
	MIEL("La descripción miel", "Leve", "Rojo");
	
	// ATRIBUTOS
	String descripcion;
	String nivelDeRiesgo;
	String siguienteColor;
	
	// CONSTRUCTORES
	LesionDermatologica(String descripcion, String nivelDeRiesgo, String color) {
		this.descripcion = descripcion;
		this.nivelDeRiesgo = nivelDeRiesgo;
		this.siguienteColor = color;
	}
	
	// GETTERs & SETTERs
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}
	
	public String getSiguienteColor() {
		return siguienteColor;
	}

}
