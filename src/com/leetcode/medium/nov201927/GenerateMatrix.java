package com.leetcode.medium.nov201927;

import java.util.Arrays;

public class GenerateMatrix {

	public static void main(String[] args) {
		int[][] result = generateMatrix(3);
		
		for(int[] num: result)
			System.out.println(Arrays.toString(num));
	}
	
	private static int[][] generateMatrix(int n) {
		
		if (n == 0)
			return null;
		
		if (n == 1)
			return new int[][] {{1}};

		int[][] result = new int[n][n];
		int rowBegin = 0, colBegin = 0;
		int rowEnd = n-1, colEnd = n-1;
		int ans = 1;
		 while(rowBegin <= rowEnd && colBegin <= colEnd)
	        {
			 for(int j = colBegin; j <= colEnd; j++)
				result[rowBegin][j] = ans++;
			 rowBegin++;
			
			 for(int j = rowBegin; j <= rowEnd; j++)
				result[j][colEnd] = ans++;
			 colEnd--;
			 
			 if(rowBegin <= rowEnd)
				 for(int i = colEnd; i >= colBegin; i-- )
					 result[rowEnd][i] = ans++;
			 rowEnd--;

			 if(colBegin <= colEnd)
				 for(int i = rowEnd; i >= rowBegin; i-- )
					 result[i][colBegin] = ans++;
			 colBegin++;
	        }
		 
		return result;
    }

}
