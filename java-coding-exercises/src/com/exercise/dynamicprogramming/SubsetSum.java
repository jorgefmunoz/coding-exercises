package com.exercise.dynamicprogramming;

/* Given a set of non-negative integers {s1, ..., sn}, and a target value T, 
 * determine if there is a subset of the given set with sum equal to given T. 
 * Author: jmunoz 
 * 
 */
public class SubsetSum {
	
	public static boolean subsetExists(int[] set, int target) {
		
		int n = set.length;
		// declare matrix to store answers	
		boolean[][] solution = new boolean[n + 1][target + 1];
		
		// base cases
		for (int i = 0; i <= n; i++) {
			solution[i][0] = true;
		}
		for (int t = 1; t <= target; t++) {
			solution[0][t] = false;
		}
		
		// compute table row by row
		for (int i = 1; i <= n; i++) {
			for (int t = 1; t <= target; t++) {
				solution[i][t] = solution[i-1][t];
				// check if element si can actually be considered 
				if (t >= set[i-1]) {
					solution[i][t] = solution[i][t] || solution[i-1][t - set[i-1]];
				}
			}
		}
		return solution[n][target];
	}


	public static void main(String[] args) {
		int [] arr = {1, 2, 5, 10, 7, 8, 100, 11};	// Enter your set
		int target = 4;	// enter your target sum
		System.out.println("Given set: ");
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println("\nThere is a subset with sum equal to " + target + ": " + subsetExists(arr, target));
		target = 31;
		System.out.println("\nThere is a subset with sum equal to " + target + ": " + subsetExists(arr, target));

		
	}

}