package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
	
	// VARIABLES
	private String name;
	private LocalDate birthday;
	private int age;
	
	// CONSTRUCTORS
	public Persona(String nameToSet, LocalDate birthdayToSet) {
		name = nameToSet;
		birthday = birthdayToSet;
		age = Long.valueOf(ChronoUnit.YEARS.between(birthday, LocalDate.now())).intValue();
	}
	
	// GETTERs & SETTERs
	public String getName() {
		return name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public int getAge() {
		return age;
	}
	
	// METHODS
	public Boolean smallerThan(Persona persona) {
		return (age < persona.getAge());
	}
}
