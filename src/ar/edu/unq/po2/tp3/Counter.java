package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {
	
	private ArrayList<Integer> counters = new ArrayList<Integer>();
	
	public void addNumber(int x) {
		counters.add(x);
	}
	
	public int getEvenOcurrences() {
		ArrayList<Integer> arrayOfEvenNumbers = new ArrayList<Integer>();
		for (int number:counters) {
			if (number % 2 == 0) {
				arrayOfEvenNumbers.add(number);
			}
		}
		return arrayOfEvenNumbers.size();
	}
	
	public int getOddOcurrences() {
		ArrayList<Integer> arrayOfOddNumbers = new ArrayList<Integer>();
		for (int number:counters) {
			if (number % 2 != 0) {
				arrayOfOddNumbers.add(number);
			}
		}
		return arrayOfOddNumbers.size();
	}
	
	public int getMultiplesOf(int number) {
		ArrayList<Integer> arrayOfMultiples = new ArrayList<Integer>();
		for (int multiple:counters) {
			if (multiple % number == 0) {
				arrayOfMultiples.add(number);
			}
		}
		return arrayOfMultiples.size();
	}
}
