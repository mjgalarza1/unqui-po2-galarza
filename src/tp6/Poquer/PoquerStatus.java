package tp6.Poquer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PoquerStatus {

	public String verificar(String c1, String c2, String c3, String c4, String c5) {
		String resultado = "Nada";
		List<String> manoDeCartas = List.of(c1,c2,c3,c4,c5);
		
		if (hayPoquerPara(manoDeCartas)) {
			resultado = "Poquer";
		} else if (hayColorPara(manoDeCartas)) {
			resultado = "Color";
		} else if (hayTrioPara(manoDeCartas)) {
			resultado = "Trio";
		}
		return resultado;
	}

	private boolean hayPoquerPara(List<String> manoDeCartas) {
		// El poquer se da cuando cuatro cartas poseen el mismo valor.
		List<String> valores = valoresDeLasCartas(manoDeCartas);
		Map<String, Long> ocurrencias = valores.stream()
				.collect(Collectors.groupingBy(valor -> valor, Collectors.counting()));
		return (ocurrencias.values().stream().anyMatch(valor -> valor == 4));
	}
	
	private boolean hayColorPara(List<String> manoDeCartas) {
		// El color se da cuando las cinco cartas son del mismo palo.
		List<Character> palos = palosDeLasCartas(manoDeCartas);
		char primerPalo = palos.get(0);
		return (palos.stream().allMatch(p -> p.equals(primerPalo)));
	}

	private boolean hayTrioPara(List<String> manoDeCartas) {
		// El trio se da cuando tres cartas poseen el mismo valor.
		List<String> valores = valoresDeLasCartas(manoDeCartas);
		Map<String, Long> ocurrencias = valores.stream()
				.collect(Collectors.groupingBy(valor -> valor, Collectors.counting()));
		return (ocurrencias.values().stream().anyMatch(valor -> valor == 3));
	}

	// MÉTODOS AUXILIARES
	private List<String> valoresDeLasCartas(List<String> manoDeCartas) {
		return manoDeCartas.stream().map(carta -> valorDeLaCarta(carta)).toList();
	}
	
	private List<Character> palosDeLasCartas(List<String> manoDeCartas) {
		return manoDeCartas.stream().map(carta -> paloDeLaCarta(carta)).toList();
	}
	
	// Retorna el valor de la carta, es decir, sin el palo de la carta.
	private String valorDeLaCarta(String s) {
		String valor;
		if (s.length() == 2) {
			valor = Character.toString(s.charAt(0));
		}
		else {
			valor = s.substring(0, 1);
		}
		return valor;
	}
	
	// Retorna el palo de la carta, es decir, sin el valor de la carta.
	private char paloDeLaCarta(String s) {
		char palo;
		if (s.length() == 2) {
			palo = s.charAt(1);
		}
		else {
			palo = s.charAt(2);
		}
		return palo;
	}

}
