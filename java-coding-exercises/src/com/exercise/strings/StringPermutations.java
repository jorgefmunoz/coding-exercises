package com.exercise.strings;

/* Program prints all permutations of a given string
 * Author: jmunoz 
 * 
 */
public class StringPermutations {

	public static void main(String[] args) {
		printPermutations("", "xyz");
		printPermutations("", "abcd");
	}
	
	public static void printPermutations(String fixed, String permute) {
		
		if (permute.length() <= 1) {
			System.out.println(fixed + permute);
			return;
		}
		for (int i = 0; i < permute.length(); i++) {
			printPermutations(fixed + permute.charAt(i),
					permute.substring(0, i) + permute.substring(i+1));
		}
		
	}
}
