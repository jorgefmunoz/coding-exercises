package com.exercise.dynamicprogramming;

/* Given an M x N matrix of 0s and 1s, find the square sub-matrix with all 1s that has maximum size 
 * Author: jmunoz 
 * 
 */
public class MaxSubMatrixofOnes {

	public static void findMaxSubMatrix (int[][] A) {
		// subproblem definition: Let Sub[][] be am auxiliary matrix, where Sub[i][j] is the size of the square
		// sub-matrix with all 1s which includes A[i][j] as its rightmost and bottommost entry
		int M = A.length;
		int N = A[0].length;
		int[][] Sub = new int[M][N];
		
		// Base Cases
		for (int i = 0; i < M; i++) {
		 	Sub[i][0] = A[i][0];
		}
		for (int j = 0; j < N; j++) {
			Sub[0][j] = A[0][j];
		}
		
		// Recurrence for problem
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (A[i][j] == 0) {
					Sub[i][j] = 0;
				} else {
					Sub[i][j] = 1 + Math.min(Sub[i-1][j], Math.min(Sub[i][j-1], Sub[i-1][j-1]));
				}
			}
		}
		
		System.out.println("Size of the maximum square sub-matrix with all 1s: ");
		int curr_max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (Sub[i][j] > curr_max) {
					curr_max = Sub[i][j];
				}
			}
		}
		System.out.println(curr_max);
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 0, 0, 1, 1}, 
						   {1, 0, 1, 1, 1}, 
						   {0, 0, 1, 1, 1}, 
						   {0, 1, 1, 1, 1}, 
						   {1, 1, 0, 1, 0}, 
						   {0, 0, 0, 0, 0}};
		
		findMaxSubMatrix(matrix);

	}

}
