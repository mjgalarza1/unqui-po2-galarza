package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {
	
	private ArrayList<Integer> counters = new ArrayList<Integer>();
	
	public ArrayList<Integer> getCounters() {
		return counters;
	}
	
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
	
	// EJERCICIO 2)
	// EJEMPLO: getNumberWithMostEvenDigitsFromArray([10, 5, 40, 100, 224, 3148])	<< Debe retornar: 224
	public int getNumberWithMostEvenDigitsFromArray(ArrayList<Integer> anArrayOfNumbers) {
		
		int currentNumber = anArrayOfNumbers.get(0);
		ArrayList<Integer> currentArray = getNumberAsArray(currentNumber);
		int biggestDigitsCounted = getAmountOfEvenOcurrencesFromArray(currentArray);
		int numberToReturn = 0;
		
		if (getAmountOfEvenOcurrencesFromArray(currentArray) > 0) {
			numberToReturn = anArrayOfNumbers.get(0);
			biggestDigitsCounted = getAmountOfEvenOcurrencesFromArray(currentArray);
		}
		
		
		int index = 1;
		while (index < anArrayOfNumbers.size()) {
			currentNumber = anArrayOfNumbers.get(index);
			currentArray = getNumberAsArray(currentNumber);
			
			if (getAmountOfEvenOcurrencesFromArray(currentArray) > biggestDigitsCounted) {
				numberToReturn = anArrayOfNumbers.get(index);
				biggestDigitsCounted = getAmountOfEvenOcurrencesFromArray(currentArray);
			}
			index += 1;
		}
		
		return numberToReturn;
	}
	
	public ArrayList<Integer> getNumberAsArray(int number) {
		ArrayList<Integer> numberArray = new ArrayList<Integer>();
		while (number > 0) {
			int digit = number % 10;
			number = number / 10;
			numberArray.add(digit);
		}
		return numberArray;
	}
	
	public int getAmountOfEvenOcurrencesFromArray(ArrayList<Integer> anArrayOfNumbers) {
		ArrayList<Integer> arrayOfEvenNumbers = new ArrayList<Integer>();
		for (int number:anArrayOfNumbers) {
			if (number % 2 == 0) {
				arrayOfEvenNumbers.add(number);
			}
		}
		return arrayOfEvenNumbers.size();
	}
	
	// EJERCICIO 3)
	// EJEMPLO: getTheBiggestMultipleNumberBetween_and_(3,9)	<< Debe retornar: 999
	public int getTheBiggestMultipleNumberBetween_and_(int x, int y) {
		if (isTheNumber_multipleOf_(x,y) || isTheNumber_multipleOf_(y,x)) {
			int biggestNumber = getBiggestNumberBetweenTwoNumbers(x,y);
			ArrayList<Integer> currentMultipleArray = getAllMultiplesBetween0and1000from(biggestNumber);
			return getBiggestNumberFrom(currentMultipleArray);
		}
		else {
			return -1;
		}
	}

	public boolean isTheNumber_multipleOf_(int number, int multiple) {
		return multiple % number == 0;
	}

	public ArrayList<Integer> getAllMultiplesBetween0and1000from(int x) {
		int indexMultiplier = 1;
		int y = x;
		ArrayList<Integer> currentMultipleArray = new ArrayList<Integer>();
		while (y >= 0 && y <= 1000) {
			currentMultipleArray.add(y);
			indexMultiplier += 1;
			y = x * indexMultiplier;
		}
		return currentMultipleArray;
	}

	public int getBiggestNumberFrom(ArrayList<Integer> sameMultiples) {
		if (sameMultiples.isEmpty()) {
			return -1;
		}
		else {
			int index = 0;
			int biggestNumber = sameMultiples.get(index);
			while (index < sameMultiples.size()) {
				biggestNumber = getBiggestNumberBetweenTwoNumbers(biggestNumber, sameMultiples.get(index));
				index += 1;
			}
			return biggestNumber;
		}
	}

	public int getBiggestNumberBetweenTwoNumbers(int x, int y) {
		int biggestNumber;
		if (x > y) {
			biggestNumber = x;
		}
		else {
			biggestNumber = y;
		}
		return biggestNumber;
	}
	
}
