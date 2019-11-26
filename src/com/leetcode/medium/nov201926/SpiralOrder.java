package com.leetcode.medium.nov201926;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix 
 * in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {

		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		for(int[] num: arr)
			System.out.println(Arrays.toString(num));
		
		List<Integer> list = spiralOrder(arr);
		 
		System.out.println(list);
		
	}
	
	private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if(matrix.length == 0)
        	return result;
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd)
        {
        	for(int i = colBegin; i <= colEnd; i++)
        		result.add(matrix[rowBegin][i]);
        	rowBegin++;
        	
        	for(int j = rowBegin; j <= rowEnd; j++)
        		result.add(matrix[j][colEnd]);
        	
        	colEnd--;
        	
        	if(rowBegin <= rowEnd)
        		for(int i = colEnd; i >= colBegin; i--)
        			result.add(matrix[rowEnd][i]);
        	rowEnd--;
        	
        	if(colBegin <= colEnd)
        		for(int i = rowEnd; i >= rowBegin; i--)
        			result.add(matrix[i][colBegin]);
        	colBegin++;
        }
        
        return result;
    }

}
