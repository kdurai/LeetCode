package com.leetcode.medium.nov201928;

import java.util.Arrays;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

 */
public class SetZeroes {

	public static void main(String[] args) {
		
		/*
		 * int[][] matrix1 = { {1,1,1}, {1,0,1}, {1,1,1} };
		 * 
		 * for(int[] num: matrix1) System.out.println(Arrays.toString(num));
		 * 
		 * setZeroes(matrix1);
		 * 
		 * System.out.println(); for(int[] num: matrix1)
		 * System.out.println(Arrays.toString(num));
		 * 
		 * int[][] matrix2 = { {0,1,2,0}, {3,4,5,2}, {1,3,1,5} };
		 * 
		 * for(int[] num: matrix2) System.out.println(Arrays.toString(num));
		 * 
		 * setZeroes(matrix2); System.out.println(); for(int[] num: matrix2)
		 * System.out.println(Arrays.toString(num));
		 */
		
		int[][] matrix3 = {
				{1,1,1},
				{0,1,2}
		};
		
		for(int[] num: matrix3)
			System.out.println(Arrays.toString(num));
		
		setZeroes(matrix3);
		System.out.println();
		for(int[] num: matrix3)
			System.out.println(Arrays.toString(num));
	}

	private static void setZeroes(int[][] matrix) {
		
		boolean isCol = false;
		int m = matrix.length;
		int n = matrix[0].length;
		
		for(int i = 0; i < m; i++)
		{
			if(matrix[i][0] == 0)
				isCol = true;
			for(int j = 1; j < n; j++)
				if(matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}
		
		for(int i = m-1; i >= 0; i--)
		{
			for(int j = n-1; j >= 1; j--)
				if( (matrix[i][0] == 0) || (matrix[0][j] == 0) )
					matrix[i][j] = 0;
			
			if(isCol)
				matrix[i][0] = 0;
		}
		
    }
}
