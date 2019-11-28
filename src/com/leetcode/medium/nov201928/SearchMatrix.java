package com.leetcode.medium.nov201928;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 *  properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

 */
public class SearchMatrix {

	public static void main(String[] args) {

		
		  int[][] matrix1 = { {1,3,5,7}, {10,11,16,20}, {23,30,34,50} };
		  
		  System.out.println(searchMatrix(matrix1, 3));
		  
		  int[][] matrix2 = { {1,3,5,7}, {10,11,16,20}, {23,30,34,50} };
		  
		  System.out.println(searchMatrix(matrix2,13));
		 
		
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrirx[0].length == 0)
			return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int l = 0, r = m * n -1;
		
		while( l != r) 
		{
			int mid = (l + r -1)>>1;
			
			if(matrix[mid/n][mid%n] < target)
				l = mid + 1;
			else
				r = mid;
		}
		
		return matrix[r/n][r%n] == target;
    }
}
