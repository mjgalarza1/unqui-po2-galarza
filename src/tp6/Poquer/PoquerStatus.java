package tp6.Poquer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

	public List<Carta> verificarGanadorEntreLasManos(List<Carta> mano1, List<Carta> mano2) {
		int puntaje1 = puntajeDeMano(mano1);
		int puntaje2 = puntajeDeMano(mano2);
		List<Carta> ganador;
		
		if (puntaje1 > puntaje2) {
			ganador = mano1;
		} else if (puntaje1 < puntaje2) {
			ganador = mano2;
		} else {
			ganador = verificarDesempateParaLasManos(mano1, mano2);
		}
		return ganador;
	}

	private String verificarParaMano(List<Carta> m) {
		return verificar(m.get(0), m.get(1), m.get(2), m.get(3), m.get(4));
	}

	private List<Carta> verificarDesempateParaLasManos(List<Carta> mano1, List<Carta> mano2) {
		String jugada1 = verificarParaMano(mano1);
		String jugada2 = verificarParaMano(mano2);
		List<Carta> ganador = mano1;
		
		if (jugada1 == "Poquer" && jugada2 == "Poquer") {
			ganador = verificarGanadorDeJugadasPoquerOTrioParaLasManos(mano1, mano2, 4);
		} else if (jugada1 == "Color" && jugada2 == "Color") {
			ganador = verificarGanadorDeJugadasColorONadaParaLasManos(mano1, mano2);
		} else if (jugada1 == "Trio" && jugada2 == "Trio") {
			ganador = verificarGanadorDeJugadasPoquerOTrioParaLasManos(mano1, mano2, 3);
		} else {
			ganador = verificarGanadorDeJugadasColorONadaParaLasManos(mano1, mano2);
		}
		return ganador;
	}

	// ======================================================================================================
	// SEGURO QUE ESTO ES MEJORABLE!!!
	// ======================================================================================================
	
	private List<Carta> verificarGanadorDeJugadasColorONadaParaLasManos(List<Carta> mano1, List<Carta> mano2) {
		List<Carta> ganador = mano1;
		int puntajeJ1 = 0;
		int puntajeJ2 = 0;
		for(Carta c:mano1) {
			puntajeJ1 += c.getValor();
		}
		for(Carta c:mano2) {
			puntajeJ2 += c.getValor();
		}
		if (puntajeJ1 >= puntajeJ2) {
			ganador = mano1;
		} else {
			ganador = mano2;
		}
		return ganador;
	}

	private List<Carta> verificarGanadorDeJugadasPoquerOTrioParaLasManos(List<Carta> mano1, List<Carta> mano2, int cantidad) {
		List<Carta> ganador;
		
		int unaCartaDeLaJugada1 = valoresDeLasCartas(mano1).stream()
			.filter(v -> ocurrencias(v, mano1, cantidad))
			.findFirst()
			.get();
			
		int unaCartaDeLaJugada2 = valoresDeLasCartas(mano2).stream()
			.filter(v -> ocurrencias(v, mano2, cantidad))
			.findFirst()
			.get();
			
		unaCartaDeLaJugada1 *= cantidad;
		unaCartaDeLaJugada2 *= cantidad;
		
		if (unaCartaDeLaJugada1 >= unaCartaDeLaJugada2) {
			ganador = mano1;
		} else {
			ganador = mano2;
		}
		return ganador;
	}

	private boolean ocurrencias(int valor, List<Carta> mano, long cantidad) {
		List<Integer> valores = valoresDeLasCartas(mano);
		Map<Integer, Long> ocurrencias = valores.stream()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		return ocurrencias.get(valor).equals(cantidad);
	}

	private int puntajeDeMano(List<Carta> mano) {
		int resultado = 0;
		
		if (hayPoquerPara(mano)) {
			resultado = 3;
		} else if (hayColorPara(mano)) {
			resultado = 2;
		} else if (hayTrioPara(mano)) {
			resultado = 1;
		}
		return resultado;
	}

}
