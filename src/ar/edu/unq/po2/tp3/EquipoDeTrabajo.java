package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class EquipoDeTrabajo {

	// VARIABLES
	private String name;
	private ArrayList<Persona> members = new ArrayList<Persona>();
	
	// CONSTRUCTORS
	public EquipoDeTrabajo(String nameToSet) {
		name = nameToSet;
	}
	
	public EquipoDeTrabajo(String nameToSet, ArrayList<Persona> membersToSet) {
		name = nameToSet;
		members = membersToSet;
	}
	
	// GETTERs & SETTERs
	public String getName() {
		return name;
	}
	
	public ArrayList<Persona> getMembers() {
		return members;
	}
	
	// METHODS
	public void addMember(Persona persona) {
		members.add(persona);
	}
	
	public void removeMember(Persona persona) {
		members.remove(persona);
	}
	
	public int ageAverage() {
		int amount = members.size();
		int sumOfAges = 0; 
		for(int number:ageOfAllMembers()) {
			sumOfAges += number;
		}
		return (sumOfAges / amount);
	}
	
	public ArrayList<Integer> ageOfAllMembers() {
		ArrayList<Integer> listOfAges = new ArrayList<Integer>();
		for(Persona member:members) {
			listOfAges.add(member.getAge());
		}
		return listOfAges;
	}
}
