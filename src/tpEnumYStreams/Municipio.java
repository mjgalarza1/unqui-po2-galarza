package tpEnumYStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Municipio {

	private List<ActividadSemanal> actividadesSemanales;
	
	public Municipio() {
		actividadesSemanales = new ArrayList<ActividadSemanal>();
	}
	
	public Municipio(List<ActividadSemanal> actividades) {
		actividadesSemanales = new ArrayList<ActividadSemanal>();
		actividadesSemanales = actividades;
	}
	
	public void agregarActividad(ActividadSemanal actividad) {
		actividadesSemanales.add(actividad);
	}
	
	public List<ActividadSemanal> todasLasActividadesDeFutbol() {
		return actividadesSemanales.stream()
				.filter(a -> a.getDeporte().equals(Deporte.FUTBOL))
				.toList();
	}
	
	public List<ActividadSemanal> todasLasActividadesDeComplejidad(int unNumero) {
		return actividadesSemanales.stream()
				.filter(a -> a.getDeporte().getComplejidad() == unNumero)
				.toList();
	}
	
	public int cantidadDeHorasTotalesDeActividades() {
		return actividadesSemanales.stream()
				.map(a -> a.getDuracionEnHoras())
				.reduce(0, (acumulado, nuevo) -> acumulado + nuevo);
	}
	
	public ActividadSemanal laActividadDeMenorCostoParaElDeporte(Deporte unDeporte) {
		return actividadesSemanales.stream()
				.filter(a -> a.getDeporte().equals(unDeporte))
				.min(Comparator.comparing(ActividadSemanal::getCosto))
				.get(); 
	}
	
	public Map<Deporte, ActividadSemanal> laActividadMasEconomicaPorDeporte() {
		List<Deporte> deportes = Arrays.asList(Deporte.values());
		return deportes.stream()
			.map(d -> laActividadDeMenorCostoParaElDeporte(d))
			.collect(Collectors.toMap(ActividadSemanal::getDeporte, Function.identity(),(a,b)->a));
	}

	public void imprimirTodasLasActividades() {
		actividadesSemanales.stream().forEach(a -> System.out.print(a.toString()));
	}
	
}
