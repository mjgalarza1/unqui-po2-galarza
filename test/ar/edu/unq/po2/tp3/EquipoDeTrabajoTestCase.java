package ar.edu.unq.po2.tp3;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipoDeTrabajoTestCase {
	
	private EquipoDeTrabajo equipo;
	private Persona persona1;
	private Persona persona2;
	private Persona persona3;
	private Persona persona4;
	private Persona persona5;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Inicialización del equipo 
		equipo = new EquipoDeTrabajo("Empresa de Prueba");
		
		// Inicialización de las personas
		persona1 = new Persona("Agente 1", LocalDate.of(1995, 10, 4));
		persona2 = new Persona("Agente 2", LocalDate.of(2000, 5, 25));
		persona3 = new Persona("Agente 3", LocalDate.of(1989, 2, 7));
		persona4 = new Persona("Agente 4", LocalDate.of(2002, 9, 10));
		persona5 = new Persona("Agente 5", LocalDate.of(1979, 12, 16));
		
		// Las personas son agregadas al equipo
		equipo.addMember(persona1);
		equipo.addMember(persona2);
		equipo.addMember(persona3);
		equipo.addMember(persona4);
		equipo.addMember(persona5);
	}
	
	@Test
	public void testAgeAverage() {
		int average = equipo.ageAverage();
		System.out.println("La edad promedio del equipo de trabajo es: " + average);
		// A la fecha actual del test (12/Abril/2024), el resultado debe ser 30.
	}
	
}