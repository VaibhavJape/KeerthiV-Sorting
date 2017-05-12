package com.example.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.example.beans.Sorting;

public class NumberSorting {

	private int[] numbers;
	private int[] helper;
	private int number;
	private long swapCounter = 0;

	public NumberSorting(int[] inputNumbers) {
		numbers = inputNumbers;
		number = inputNumbers.length;
		helper = new int[number];
		mergeSorts(0, number - 1);
	}

	public NumberSorting() {
		// TODO Auto-generated constructor stub
	}

	private void mergeSorts(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSorts(low, middle);
			// Sort the right side of the array
			mergeSorts(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	public static final Random gen = new Random();

	public static int[] printRandomNumbers(int n, int maxRange) {
		assert n <= maxRange : "Cannot get more unique numbers than the size of the range";

		int[] result = new int[n];
		Set<Integer> used = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {

			int newRandom;
			do {
				newRandom = gen.nextInt(maxRange + 1);
			} while (used.contains(newRandom));
			result[i] = newRandom;
			used.add(newRandom);
		}
		return result;
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) { 
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		// Copy the smallest values from either the left or the right side back to the original array
		while (i <= middle && j <= high) { 

			if (helper[i] < helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				swapCounter += (j - k);
				j++;
			}
			k++;
		}

		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

	// Get the counter
	public long getCounter() {
		return this.swapCounter;
	}

	public Sorting sortingNumber(int randomGenSize) {		
		int[] sortList = printRandomNumbers(randomGenSize, 1000000);		
		String randomNumber = Arrays.toString(sortList);
		long startTime = System.currentTimeMillis();
		NumberSorting ms = new NumberSorting(sortList);	
		String sortingNumber = Arrays.toString(sortList);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		Sorting sorting = new Sorting();
		sorting.setActual(randomNumber);
		sorting.setResult(sortingNumber);
		sorting.setCount(ms.getCounter());
		sorting.setTime(totalTime);		
		return sorting;
	}
}