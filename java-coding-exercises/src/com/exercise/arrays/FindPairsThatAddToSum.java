package com.exercise.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Program that finds pairs in an array that sum up to a given number
 * Author: jmunoz 
 * 
 */
public class FindPairsThatAddToSum {
	
	public static void findPairs(int[] array, int sum) {
		System.out.println("Finding pairs in array: " + Arrays.toString(array));
		
		if (array.length < 2) {
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		for (int value : array) {
			int complement = sum - value;
			if (set.contains(complement)) {
				System.out.println("(" + value + ", " + complement + ")");
				set.add(value);
			}
			else {
				set.add(value);
			}
		}		
	}

	public static void main(String[] args) {
		
		int[] array = {-1,7,2,6,3,-2,4,2,8};
		findPairs(array, 6);

	}

}
