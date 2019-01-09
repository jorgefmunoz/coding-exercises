package com.exercise.strings;

/* Program to check if two strings are anagrams of each other
 * Author: jmunoz 
 * 
 */
public class Anagrams {

	public static void main(String[] args) {
		System.out.println(isAnagram("Mary","army"));
		System.out.println(isAnagram("J.,@#A*&v[]a","avaj"));

	}
	
	public static boolean isAnagram(String str1, String str2) {
		
		// first do some string cleanup
		str1 = str1.replaceAll("\\s|[^a-zA-Z0-9]+", "").toLowerCase();
		str2 = str2.replaceAll("\\s|[^a-zA-Z0-9]+", "").toLowerCase();
		
		char[] characters = str1.toCharArray();
		StringBuilder sb = new StringBuilder(str2);
		
		for (char character : characters) {
			int index = sb.indexOf(Character.toString(character));
			if (index != -1) {
				sb.deleteCharAt(index);
			}
			else {
				return false;
			}
		}		
		return sb.length() == 0;
	}

}
