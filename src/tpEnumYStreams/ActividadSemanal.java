package tpEnumYStreams;

import java.time.LocalTime;

public class ActividadSemanal {

	private DiaDeLaSemana dia;
	private LocalTime horaDeInicio;
	private int duracionEnHoras;
	private Deporte deporte;
	
	public ActividadSemanal(DiaDeLaSemana dia, LocalTime horaDeInicio, int duracionEnHoras, Deporte deporte) {
		this.dia = dia;
		this.horaDeInicio = horaDeInicio;
		this.duracionEnHoras = duracionEnHoras;
		this.deporte = deporte;
	}
	
	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}
	
	public int getDuracionEnHoras() {
		return duracionEnHoras;
	}
	
	public Deporte getDeporte() {
		return deporte;
	}
	
	public double getCosto() {
		double cantidadTotal;
		switch(dia) {
		case LUNES: case MARTES: case MIERCOLES:
			cantidadTotal = 500;
			break;
		default:
			cantidadTotal = 1000;
			break;
		}
		cantidadTotal = (cantidadTotal * duracionEnHoras) + (200 * deporte.getComplejidad());
		return cantidadTotal;
	}
	
	public String toString() {
		return "Deporte: "
				+ deporte
				+ ". Dia: "
				+ dia
				+ " A LAS: "
				+ horaDeInicio
				+ ". Duración: "
				+ duracionEnHoras
				+ " hora(s).\n";
	}
}
