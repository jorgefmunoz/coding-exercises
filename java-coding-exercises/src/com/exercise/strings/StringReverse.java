package com.exercise.strings;

/* Program to reverse a string in different ways
 * Author: jmunoz 
 * 
 */
public class StringReverse {

	public static void main(String[] args) {

		System.out.println(reverseWithRecursion("Please reverse this"));
		System.out.println(reverseWithSwapping("Please reverse this"));

	}
	
	public static String reverseWithSwapping(String str) {
		
		char[] characters = str.toCharArray();
		int midIndex = (int) Math.floor(str.length()/2);
		int lastIndex = str.length() - 1;
		char temp;
		
		for (int i = 0; i < midIndex; i++) {
			temp = characters[i];
			characters[i] = characters[lastIndex - i];
			characters[lastIndex - i] = temp;
		}
		
		return String.valueOf(characters);
	}
	
	public static String reverseWithRecursion(String str) {
		
		if (str.length() < 1) {
			return str;
		}		
		
		return reverseWithRecursion(str.substring(1)) + str.charAt(0);
	}

}
