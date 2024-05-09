package tp6.Poquer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PoquerStatus {

	public String verificar(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
		String resultado = "Nada";
		List<Carta> manoDeCartas = List.of(c1,c2,c3,c4,c5);
		
		if (hayPoquerPara(manoDeCartas)) {
			resultado = "Poquer";
		} else if (hayColorPara(manoDeCartas)) {
			resultado = "Color";
		} else if (hayTrioPara(manoDeCartas)) {
			resultado = "Trio";
		}
		return resultado;
	}

	private boolean hayPoquerPara(List<Carta> manoDeCartas) {
		// El poquer se da cuando cuatro cartas poseen el mismo valor.
		List<Integer> valores = valoresDeLasCartas(manoDeCartas);
		Map<Integer, Long> ocurrencias = valores.stream()
				.collect(Collectors.groupingBy(valor -> valor, Collectors.counting()));
		return (ocurrencias.values().stream().anyMatch(valor -> valor == 4));
	}
	
	private boolean hayColorPara(List<Carta> manoDeCartas) {
		// El color se da cuando las cinco cartas son del mismo palo.
		List<Palo> palos = palosDeLasCartas(manoDeCartas);
		Palo primerPalo = palos.get(0);
		return (palos.stream().allMatch(p -> p.equals(primerPalo)));
	}

	private boolean hayTrioPara(List<Carta> manoDeCartas) {
		// El trio se da cuando tres cartas poseen el mismo valor.
		List<Integer> valores = valoresDeLasCartas(manoDeCartas);
		Map<Integer, Long> ocurrencias = valores.stream()
				.collect(Collectors.groupingBy(valor -> valor, Collectors.counting()));
		return (ocurrencias.values().stream().anyMatch(valor -> valor == 3));
	}

	// MÉTODOS AUXILIARES
	private List<Integer> valoresDeLasCartas(List<Carta> manoDeCartas) {
		return manoDeCartas.stream().map(carta -> carta.getValor()).toList();
	}
	
	private List<Palo> palosDeLasCartas(List<Carta> manoDeCartas) {
		return manoDeCartas.stream().map(carta -> carta.getPalo()).toList();
	}

}
