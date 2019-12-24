package com.leetcode.medium.dec201913;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLength {

	public static void main(String[] args) {

		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		System.out.println(findLength(A,B));
	}

	public static int findLength(int[] A, int[] B) {

		int ans = 0;
		
		int m = A.length;
		int n = B.length;
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = m-1; i >= 0; i--)
			for(int j = n-1; j >= 0; j--)
				if(A[i] == B[j])
				{
					dp[i][j] = dp[i+1][j+1] + 1;
					if(ans < dp[i][j]) ans = dp[i][j];
				}
		
		return ans;
    }
}
