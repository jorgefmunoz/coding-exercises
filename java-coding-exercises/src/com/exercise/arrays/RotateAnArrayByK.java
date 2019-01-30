package com.exercise.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* Program that rotates an array by k elements
 * Author: jmunoz 
 * 
 */
public class RotateAnArrayByK {

	public static String[] rotate(String[] a, int k) {
		System.out.println("rotating array: " + Arrays.toString(a));
		if ((a.length < 1) || (k % a.length == 0)) {
			return a;
		}
		
		k = k % a.length;
		Queue<String> queue = new ArrayDeque(Arrays.asList(a));
		while (k > 0) {
			queue.offer(queue.poll());
			k--;
		}		
		return queue.toArray(a);
	}
	
	public static void main(String[] args) {
		String[] s_array = {"a","b","c","d","e","f","g"};
		System.out.println("rotated by 2: " + Arrays.toString(rotate(s_array, 2)));
		System.out.println("rotated by 6: " + Arrays.toString(rotate(s_array, 6)));
		System.out.println("rotated by 7: " + Arrays.toString(rotate(s_array, 7)));
		System.out.println("rotated by 9: " + Arrays.toString(rotate(s_array, 9)));
	}

}
