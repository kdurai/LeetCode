package com.leetcode.contest.nov201924;

/*
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the 
 * left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed
 *  outside the array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after
 exactly steps steps.

Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:

Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
Example 2:

Input: steps = 2, arrLen = 4
Output: 2
Explanation: There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
Example 3:

Input: steps = 4, arrLen = 2
Output: 8
 

Constraints:

1 <= steps <= 500
1 <= arrLen <= 10^6

 */
public class NumWays {

	public static void main(String[] args) {

	}

	private static int numWays(int steps, int arrLen) {
		 	int mod = 1000000007;
	        int n = Math.min(arrLen, steps+1);
	        long[] dp = new long[n];
	        dp[0] = 1;
	        for(int i = 0;i < steps;i++){
	        	long[] ndp = new long[n];
	        	for(int j = 0;j < n;j++){
	        		for(int k = -1;k <= 1;k++){
	        			if(j+k >= 0 && j+k < n){
	        				ndp[j+k] += dp[j];
	        				if(ndp[j+k] >= mod)ndp[j+k] -= mod;
	        			}
	        		}
	        	}
	        	dp = ndp;
	        }
	        return (int)dp[0];
    }
}
