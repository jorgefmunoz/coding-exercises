package com.exercise.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* Print duplicate characters in a given string
 * Author: jmunoz 
 * 
 */

public class FindDuplicateCharacters {

	public static void main(String[] args) {
		printDuplicateCharacters("java");
		printDuplicateCharacters("programming");
		printDuplicateCharacters("");
	}
	
	public static void printDuplicateCharacters(String str) {
		
		System.out.println("Finding duplicates in string: " + str);
		if (str == null || str.isEmpty()) {
			System.out.println("Empty string, nothing to do here.");
			return;
		}
		
		char[] characters = str.toCharArray();
		
		// create map to hold characters (keys) and the number of times they repeat (value)
		Map<Character, Integer> charCount = new HashMap<>();
		
		for (char c : characters) {
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			}
			else {
				charCount.put(c, 1);
			}
		}
		
		// iterate through our map 
		Set<Map.Entry<Character, Integer>> entrySet = charCount.entrySet();
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " repeated " + entry.getValue() + " times");
			}
		}
	}

}
