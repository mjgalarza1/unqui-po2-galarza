package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

/*La clase Multioperador permite aplicar las operaciones de suma, resta y multiplicación
sobre ArrayLists de enteros. Es decir, puede sumar todos los números que contiene, puede restar todos los
números que contiene y puede multiplicar a todos los números que contiene entré si.*/

public class Multioperador {
	
	// METHODS
	public int add(ArrayList<Integer> array) {
		int currentNumber = 0;
		for(int number:array) {
			currentNumber += number;
		}
		return currentNumber;
	}

	public int substract(ArrayList<Integer> array) {
		int currentNumber = array.get(0); 
		array.remove(0);
		for(int number:array) {
			currentNumber -= number;
		}
		return currentNumber;
	}

	public int multiply(ArrayList<Integer> array) {
		int currentNumber = 1;
		for(int number:array) {
			currentNumber *= number;
		}
		return currentNumber;
	}
	
}
