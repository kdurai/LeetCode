package com.leetcode.medium.dec201921;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
 *  only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

 */
public class MaximalSquare {

	public static void main(String[] args) {

		char[][] matrix = {
				{'0','1','1','1','0'},
				{'1','1','1','1','0'},
				{'0','1','1','1','1'},
				{'0','1','1','1','1'},
				{'0','0','1','1','1'}
		};
		
		System.out.println(maximalSquare1D(matrix));
	}

	public static int maximalSquare(char[][] matrix) {
        
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int result = 0;
		
		int[][] dp = new int[rows+1][cols+1];
		
		for(int i = 1; i <= rows; i++)
			for(int j = 1; j <= cols; j++)
				if(matrix[i-1][j-1] == '1')
				{
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j])+1;
					System.out.println("i = " + i + " j= " + j + " dp[" + i + "]["+j+"]= " + dp[i][j]);
					result = Math.max(result, dp[i][j]);
				}
		
		return result * result;
    }
	
	public static int maximalSquare1D(char[][] matrix) {
        
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int result = 0,prev = 0;
		
		int[] dp = new int[cols+1];
		
		for(int i = 1; i <= rows; i++)
			for(int j = 1; j <= cols; j++)
			{
				int temp = dp[j];
				
				if(matrix[i-1][j-1] == '1')
				{
					
					dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j])+1;
					System.out.println("i = " + i + " j= " + j + " dp["+j+"]= " + dp[j] + " prev= " + prev);
					result = Math.max(result, dp[j]);
				}
				else
				{
					dp[j] = 0;
				}
				
				prev = temp;
			}
		return result * result;
    }
}
